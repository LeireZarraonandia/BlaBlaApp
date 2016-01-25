package es.tta.blablatrip.model;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import es.tta.blablatrip.view.InicioActivity;

public class ServerClient
{
    private String urlServer = "http://51.254.127.111/BlaBlaTrip/";
    public ServerClient()
    {
    }

    private HttpURLConnection getConnection (String path) throws IOException
    {
        URL url = new URL(String.format("%s", path));
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Connection", "Keep-Alive");
        return conn;
    }

    public String getString (String path) throws IOException
    {
        HttpURLConnection conn = null;
        String contents = new String();

        try
        {
            conn = getConnection(path);
            conn.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            contents += br.readLine();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
        finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }

            return contents;
        }
    }

    public JSONArray getTest () throws IOException, JSONException
    {
        String pathTest = urlServer+"test"+InicioActivity.pais+".json";
        return new JSONArray(getString(pathTest));
    }

    public JSONArray getExpresiones () throws IOException, JSONException
    {
        String pathExpresiones = urlServer+"expresiones"+InicioActivity.pais+".json";
        return new JSONArray(getString(pathExpresiones));

    }

    public void descargarTest () throws IOException, JSONException {
        JSONArray test = getTest();
        String contenido = test.toString();
        try {
            File tarjeta = Environment.getExternalStorageDirectory();
            File file = new File(tarjeta.getAbsolutePath(), "test"+InicioActivity.pais+".json");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write(contenido);
            osw.flush();
            osw.close();
        } catch (IOException ioe) {
        }
    }

    public void descargarExpresiones () throws IOException, JSONException {
        JSONArray expresiones = getExpresiones();
        String contenido = expresiones.toString();
        try {
            File tarjeta = Environment.getExternalStorageDirectory();
            File file = new File(tarjeta.getAbsolutePath(), "expresiones"+InicioActivity.pais+".json");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write(contenido);
            osw.flush();
            osw.close();
        } catch (IOException ioe) {
        }
    }
}