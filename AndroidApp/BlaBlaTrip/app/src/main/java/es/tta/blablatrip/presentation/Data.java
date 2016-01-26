package es.tta.blablatrip.presentation;

import android.graphics.drawable.Drawable;
import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;

import es.tta.blablatrip.R;
import es.tta.blablatrip.model.MemoryClient;
import es.tta.blablatrip.model.ServerClient;
import es.tta.blablatrip.view.ExpresionesActivity;
import es.tta.blablatrip.view.InicioActivity;

public class Data
{
    ServerClient rest = new ServerClient();
    MemoryClient memory = new MemoryClient();

    public Data ()
    {
    }

    public JSONArray getTest () throws IOException, JSONException
    {
        String pathTest = "test"+ InicioActivity.pais+".json";
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,pathTest);
        JSONArray jsonArray = null;
        if (file.isFile()){
             jsonArray= memory.leerTest();

        }else {
            jsonArray = rest.getTest();

        }
        return jsonArray;
    }

    public JSONArray getExpresiones () throws IOException, JSONException
    {
        String pathExpresiones = "expresiones"+InicioActivity.pais+".json";
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,pathExpresiones);
        JSONArray jsonArray = null;
        if (file.isFile()){
            jsonArray= memory.leerTest();

        }else {
            jsonArray = rest.getExpresiones();

        }
        return jsonArray;
    }

    public void descargar () throws IOException, JSONException {
        rest.descargarTest();
        rest.descargarExpresiones();
        String path="";

        switch (InicioActivity.pais){
            case "Alemania":
            {
                path+="DE";
                break;
            }
            case "Francia":
            {
                path+="FR";
                break;
            }
            case "Inglaterra":
            {
                path+="EN";
                break;
            }
            case "Italia":
            {
                path+="IT";
                break;
            }
            case "Portugal":
            {
                path+="PT";
                break;
            }
        }
        path+="-Que-0";

        for (int i=1;i<=rest.getExpresiones().getJSONObject(7).getJSONArray("Quejas").length();i++)
        {
            String pathDescargar= path.concat(Integer.toString(i)).concat(".mp3");
            rest.descargarAudios(pathDescargar);
        }

    }
}