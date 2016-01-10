package es.tta.blablatrip.model;

import org.json.JSONArray;

/**
 * Created by leire on 9/01/16.
 */
public class Test {

    private String pregunta;
    private JSONArray opciones;
    private int correcto;

    public Test (String pregunta, JSONArray opciones, int correcto){
        this.pregunta=pregunta;
        this.opciones=opciones;
        this.correcto=correcto;
    }

    public String getPregunta (){
        return pregunta;
    }

    public JSONArray getOpciones (){
        return opciones;
    }

    public int getCorrecto (){
        return correcto;
    }
}
