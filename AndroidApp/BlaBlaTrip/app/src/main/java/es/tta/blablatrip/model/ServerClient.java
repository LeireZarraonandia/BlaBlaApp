package es.tta.blablatrip.model;

import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import es.tta.blablatrip.presentation.Data;
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
        String pathTest = urlServer+"test"+InicioActivity.pais+".json";
        JSONArray jsonArray= new JSONArray(getString(pathTest));
        String contenido = jsonArray.toString();
        {
            File tarjeta = Environment.getExternalStorageDirectory();
            File file = new File(tarjeta.getAbsolutePath(), "test"+InicioActivity.pais+".json");
            OutputStreamWriter osw = new OutputStreamWriter( new FileOutputStream(file));
            osw.write(contenido);
            osw.flush();
            osw.close();
        }
    }

    public void descargarExpresiones () throws IOException, JSONException {
        String pathExpresiones = urlServer+"expresiones"+InicioActivity.pais+".json";
        JSONArray jsonArray= new JSONArray(getString(pathExpresiones));
        String contenido = jsonArray.toString();
        {
            File tarjeta = Environment.getExternalStorageDirectory();
            File file = new File(tarjeta.getAbsolutePath(), "expresiones"+InicioActivity.pais+".json");
            OutputStreamWriter osw = new OutputStreamWriter( new FileOutputStream(file));
            osw.write(contenido);
            osw.flush();
            osw.close();
        }
    }

    public void descargarAudios (String path) throws IOException {
        HttpURLConnection conn = null;
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,InicioActivity.pais);

        if (!file.isDirectory()) {
            file.mkdir();
        }

        int count;

        conn = getConnection(urlServer+path);
        conn.setRequestMethod("GET");

        InputStream input = new BufferedInputStream(conn.getInputStream());
        OutputStream output = new FileOutputStream(file+"/"+path);

        byte data[] = new byte[1024];

        long total = 0;

        while ((count = input.read(data)) != -1) {
            total += count;
            output.write(data, 0, count);
        }

        output.flush();
        output.close();
        input.close();
    }
}