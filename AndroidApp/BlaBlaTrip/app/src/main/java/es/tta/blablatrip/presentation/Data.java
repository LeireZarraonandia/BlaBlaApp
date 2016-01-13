package es.tta.blablatrip.presentation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.blablatrip.comms.RestClient;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.model.Test;

public class Data
{
    RestClient rest = new RestClient();

    public Data ()
    {
    }

    public Test getTest (int id) throws IOException, JSONException
    {
        JSONArray jsonArray = rest.getTest();
        JSONObject jsonChoice = jsonArray.getJSONObject(id);
        String pregunta = jsonChoice.getString("wording");
        JSONArray respuesta = jsonChoice.getJSONArray("answer");
        int correcto = Integer.parseInt(jsonChoice.getString("correct"));

        Test test = new Test(pregunta,respuesta,correcto);

        return test;
    }

    public Expresiones getExpresiones (int id) throws IOException, JSONException
    {
        JSONArray jsonArray = rest.getExpresiones();
        JSONObject jsonChoice = jsonArray.getJSONObject(id);
        String espanol = jsonChoice.getString("castellano");
        String idioma = jsonChoice.getString("idioma");
        String audio = jsonChoice.getString("audio");

        Expresiones expresiones = new Expresiones(espanol,idioma,audio);

        return expresiones;
    }
}