package es.tta.blablatrip.presentation;

import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;

import es.tta.blablatrip.model.MemoryClient;
import es.tta.blablatrip.model.ServerClient;
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
        JSONArray jsonArrayExpresion = rest.getExpresiones();
        return jsonArrayExpresion;
    }

    public JSONArray descargar () throws IOException, JSONException {
        rest.descargarTest();
        JSONArray jsonArray = memory.leerTest();
        return jsonArray;
    }
}