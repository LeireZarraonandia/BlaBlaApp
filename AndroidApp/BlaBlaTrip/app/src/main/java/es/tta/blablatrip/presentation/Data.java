package es.tta.blablatrip.presentation;

import android.os.Environment;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.IOException;
import es.tta.blablatrip.model.MemoryClient;
import es.tta.blablatrip.model.ServerClient;
import es.tta.blablatrip.view.InicioActivity;
import es.tta.blablatrip.view.PaisActivity;

public class Data
{
    ServerClient rest = new ServerClient();
    MemoryClient memory = new MemoryClient();
    public String urlServer = "http://51.254.127.111/BlaBlaTrip/";

    public Data ()
    {
    }

    public JSONArray getTest () throws IOException, JSONException
    {
        String pathTest = "test"+ InicioActivity.pais+".json";
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,pathTest);
        JSONArray jsonArray = null;

        if (file.isFile())
        {
             jsonArray= memory.leerTest();

        }
        else
        {
            if(PaisActivity.conectado)
            {
                jsonArray = rest.getTest();
            }
        }
        return jsonArray;
    }

    public JSONArray getExpresiones () throws IOException, JSONException
    {
        String pathExpresiones = "expresiones"+InicioActivity.pais+".json";
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,pathExpresiones);
        JSONArray jsonArray = null;

        if (file.isFile())
        {
            jsonArray= memory.leerExpresiones();

        }
        else
        {
            if(PaisActivity.conectado)
            {
                jsonArray = rest.getExpresiones();
            }

        }
        return jsonArray;
    }

    public boolean descargar () throws IOException, JSONException
    {
        if(PaisActivity.conectado)
        {
            rest.descargarTest();
            rest.descargarExpresiones();
            String path = "";

            switch (InicioActivity.pais)
            {
                case "Alemania":
                {
                    path += "DE";
                    break;
                }
                case "Francia":
                {
                    path += "FR";
                    break;
                }
                case "Inglaterra":
                {
                    path += "EN";
                    break;
                }
                case "Italia":
                {
                    path += "IT";
                    break;
                }
                case "Portugal":
                {
                    path += "PT";
                    break;
                }
            }
            path += "-Que-0";

            for (int i = 1; i <= rest.getExpresiones().getJSONObject(7).getJSONArray("Quejas").length(); i++)
            {
                String pathDescargar = path.concat(Integer.toString(i)).concat(".mp3");
                rest.descargarAudios(pathDescargar);
            }

            return true;
        }
        else
        {
            return false;
        }

    }

    public String getUriAudio (String audioRecogido)
    {
        String uriAudio="";
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,InicioActivity.pais);
        File archivo = new File (file+"/"+audioRecogido);

        if (archivo.isFile())
        {
            uriAudio = archivo.toString();
        }
        else
        {
            if(PaisActivity.conectado)
            {
                uriAudio=urlServer+audioRecogido;
            }
        }

        return uriAudio;
    }
}