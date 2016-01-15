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


    /*public Expresiones getExpresiones (int id) throws IOException, JSONException
    {
        JSONArray jsonArray = rest.getExpresiones();
        JSONObject jsonChoice = jsonArray.getJSONObject(id);
        String espano = jsonChoice.getString("castellano");
        String idiom = jsonChoice.getString("idioma");
        String audi = jsonChoice.getString("audio");

        Expresiones expresiones = new Expresiones(espano,idiom,audi);

        return expresiones;
    }*/

    public JSONArray getExpresiones () throws IOException, JSONException
    {
        JSONArray jsonArrayExpresion = rest.getExpresiones();

        return jsonArrayExpresion;
    }
}