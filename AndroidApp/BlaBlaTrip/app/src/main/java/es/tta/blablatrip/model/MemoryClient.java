package es.tta.blablatrip.model;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import es.tta.blablatrip.view.InicioActivity;

/**
 * Created by leire on 26/01/16.
 */
public class MemoryClient {

    public String leerFrase (String path) throws IOException {
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta,path);
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        br.close();
        return new String (text.toString());
    }

    public JSONArray leerTest() throws IOException, JSONException {
        String pathTest = "test"+ InicioActivity.pais+".json";
        return new JSONArray(leerFrase(pathTest));
    }

    public JSONArray leerExpresiones() throws IOException, JSONException {
        String pathExpresiones = "expresiones"+InicioActivity.pais+".json";
        return new JSONArray(leerFrase(pathExpresiones));
    }
}
