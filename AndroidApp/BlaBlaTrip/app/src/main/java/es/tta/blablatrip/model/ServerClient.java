package es.tta.blablatrip.model;


import org.json.JSONArray;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import es.tta.blablatrip.view.ExpresionesActivity;
import es.tta.blablatrip.view.InicioActivity;

public class ServerClient
{


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
        String pathTest = "http://51.254.127.111/BlaBlaTrip/test"+InicioActivity.pais+".json";
        return new JSONArray(getString(pathTest));

    }

    public JSONArray getExpresiones () throws IOException, JSONException
    {

   /*     String pathTest = "http://51.254.127.111/BlaBlaTrip/test"+InicioActivity.pais+".json";

        return new JSONArray(getString(pathTest));*/

        String pathExpresiones = "http://51.254.127.111/BlaBlaTrip/expresiones"+InicioActivity.pais+ExpresionesActivity.expre+".json";
        return new JSONArray(getString(pathExpresiones));

    }

    /*public void descargarTest ()
    {

    }*/

    /*public void descargarExpresiones ()
    {
        }*/
}