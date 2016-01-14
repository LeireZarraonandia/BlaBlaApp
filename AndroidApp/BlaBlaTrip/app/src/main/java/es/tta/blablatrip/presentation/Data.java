package es.tta.blablatrip.presentation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.blablatrip.comms.RestClient;
import es.tta.blablatrip.model.Test;

public class Data
{
    RestClient rest = new RestClient();

    public Data ()
    {
    }

    public JSONArray getTest () throws IOException, JSONException
    {
        JSONArray jsonArray = rest.getTest();


        return jsonArray;
    }

    /*public Test getExpresiones (int id) throws IOException, JSONException
    {
        JSONArray jsonArray = rest.getTest();
        JSONObject jsonChoice = jsonArray.getJSONObject(id);
        String pregunta = jsonChoice.getString("wording");
        JSONArray respuesta = jsonChoice.getJSONArray("answer");
        int correcto  = Integer.parseInt(jsonChoice.getString("correct"));

        Test test = new Test(pregunta,respuesta,correcto);

        return test;
    }*/
}