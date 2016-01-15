package es.tta.blablatrip.presentation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.blablatrip.model.ServerClient;
import es.tta.blablatrip.model.Expresiones;

public class Data
{
    ServerClient rest = new ServerClient();

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
<<<<<<< HEAD
        int correcto  = Integer.parseInt(jsonChoice.getString("correct"));
=======
        int correcto = Integer.parseInt(jsonChoice.getString("correct"));
>>>>>>> 8245fcc9cc88a75301a368c3020248ac6119f3d5

        Test test = new Test(pregunta,respuesta,correcto);

        return test;
<<<<<<< HEAD
    }*/



    public Expresiones getExpresiones (int id) throws IOException, JSONException
    {
        JSONArray jsonArray = rest.getExpresiones();
        JSONObject jsonChoice = jsonArray.getJSONObject(id);
        String espano = jsonChoice.getString("castellano");
        String idiom = jsonChoice.getString("idioma");
        String audi = jsonChoice.getString("audio");

        Expresiones expresiones = new Expresiones(espano,idiom,audi);

        return expresiones;
    }

}