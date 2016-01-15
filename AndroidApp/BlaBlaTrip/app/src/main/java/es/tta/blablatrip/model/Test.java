package es.tta.blablatrip.model;

import org.json.JSONArray;

import java.lang.reflect.Array;

public class Test
{
    private String pregunta;
    private JSONArray opciones;
    private int correcto;
    private int correctos;

    public Test (String pregunta, JSONArray opciones, int correcto)
    {
        this.pregunta=pregunta;
        this.opciones=opciones;
        this.correcto=correcto;
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

    /*public int anadirCorrecto (int valor){

        if(valor==0)
        {
            correctos=0;
        }
        if (valor==1)
        {
            correctos++;
        }
        return correctos;

    }*/


}

