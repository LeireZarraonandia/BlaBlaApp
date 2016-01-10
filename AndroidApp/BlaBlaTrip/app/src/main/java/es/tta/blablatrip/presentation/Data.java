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

    public Test getTest (int id) throws IOException, JSONException
    {
        JSONObject json = rest.getTest();

        int length  = Integer.parseInt(json.getString("total"));

        JSONArray jsonArray = json.getJSONArray("test");
        JSONObject jsonChoice = jsonArray.getJSONObject(id);
        String pregunta = jsonChoice.getString("question");
        JSONArray respuesta = jsonChoice.getJSONArray("resp");
        int correcto  = Integer.parseInt(json.getString("correct"));

        Test test = new Test(pregunta,respuesta,correcto, length);

        return test;

       /* String test_wording = json.getString("wording");
        JSONArray jsonArray = json.getJSONArray("choices");
        String [] choicesWording = new String[length];
        boolean [] choicesCorrect = new boolean[length];
        String [] choicesAdvise = new String[length];
        String [] choicesAdviseType = new String[length];
        int [] choicesId = new int[length];
        for(int i = 0;i<length;i++){
            JSONObject jsonChoice = jsonArray.getJSONObject(i);
            choicesId[i] = jsonChoice.getInt("id");
            choicesWording[i] = jsonChoice.getString("answer");
            choicesAdvise[i] = jsonChoice.getString("advise");
            choicesCorrect[i] = jsonChoice.getBoolean("correct");
        }
        Test test = new Test(test_wording,choicesId,choicesWording,choicesCorrect,choicesAdvise,choicesAdviseType);
        return test;*/
    }
}