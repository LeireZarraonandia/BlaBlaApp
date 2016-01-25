package es.tta.blablatrip.presentation;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import es.tta.blablatrip.model.ServerClient;

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

    public JSONArray getExpresiones () throws IOException, JSONException
    {
        JSONArray jsonArrayExpresion = rest.getExpresiones();
        return jsonArrayExpresion;
    }

    public void descargar() throws IOException, JSONException {
        rest.descargarExpresiones();
        rest.descargarTest();
    }
}