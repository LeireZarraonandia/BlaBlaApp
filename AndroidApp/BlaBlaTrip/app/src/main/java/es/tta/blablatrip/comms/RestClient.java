package es.tta.blablatrip.comms;

import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;


import es.tta.blablatrip.InicioActivity;
import android.util.Base64;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.InflaterOutputStream;

<<<<<<< HEAD
public class RestClient
{
    public RestClient()
    {
=======
public class RestClient {

    public RestClient() {
>>>>>>> origin/master
    }



 private HttpURLConnection getConnection ( String path) throws IOException
    {

<<<<<<< HEAD
        URL url = new URL(String.format("%s", path));
=======
        URL url = new URL("http://51.254.127.111/BlaBlaTrip/testPortugal.json");
>>>>>>> origin/master
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Connection", "Keep-Alive");
        return conn;
    }




 public String getString (String path) throws IOException{
    HttpURLConnection conn = null;
    String contents = new String();

    try {
        conn = getConnection(path);
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        contents += br.readLine();

    } catch (IOException i) {
        i.printStackTrace();
    } finally {
        if (conn != null) {

            conn.disconnect();

        }
        return contents;
    }


    }

    public JSONArray getTest () throws IOException, JSONException
    {
        String path="http://51.254.127.111/BlaBlaTrip/test"+ InicioActivity.pais+".txt";
        //return new JSONObject(getString(path));
        return new JSONArray(getString(path));
    }

  /*  public JSONObject getExpresiones () throws IOException, JSONException
    {
        String path="http://51.254.127.111/BlaBlaTrip/expresiones"+InicioActivity.pais+".txt";
        return new JSONObject(getString(path));
    }*/

    public void descargarTest ()
    {
        HttpURLConnection conn = null;
        String path="http://51.254.127.111/BlaBlaTrip/test"+InicioActivity.pais+".txt";
        try{
            conn = getConnection(path);
            File SDCardRoot = Environment.getExternalStorageDirectory();
            File file = new File(SDCardRoot,"test"+InicioActivity.pais+".txt");
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = conn.getInputStream();
            int totalSize = conn.getContentLength();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ( (bufferLength = inputStream.read(buffer)) > 0 )
            {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
            }

            fileOutput.close();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void descargarExpresiones ()
    {
        HttpURLConnection conn = null;
        String path="http://51.254.127.111/BlaBlaTrip/test"+InicioActivity.pais+".txt";

        try
        {
            conn = getConnection(path);
            File SDCardRoot = Environment.getExternalStorageDirectory();
            File file = new File(SDCardRoot,"expresiones"+InicioActivity.pais+".txt");
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = conn.getInputStream();
            int totalSize = conn.getContentLength();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ( (bufferLength = inputStream.read(buffer)) > 0 )
            {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
            }

            fileOutput.close();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}