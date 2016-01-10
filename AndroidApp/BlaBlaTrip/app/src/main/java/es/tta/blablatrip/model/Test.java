package es.tta.blablatrip.model;

import org.json.JSONArray;

public class Test
{
    private String pregunta;
    private JSONArray opciones;
    private int correcto;
    private int length;

    public Test (String pregunta, JSONArray opciones, int correcto, int length)
    {
        this.pregunta=pregunta;
        this.opciones=opciones;
        this.correcto=correcto;
        this.length=length;
    }

    public String getPregunta ()
    {
        return pregunta;
    }

    public JSONArray getOpciones ()
    {
        return opciones;
    }

    public int getCorrecto ()
    {
        return correcto;
    }

    public int getLength ()
    {
        return length;
    }
}