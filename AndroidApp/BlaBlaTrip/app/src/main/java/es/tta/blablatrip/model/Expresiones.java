package es.tta.blablatrip.model;

import org.json.JSONArray;

public class Expresiones
{
    private String espanol;
    private String idioma;
    private String audio;

    public Expresiones (String espanol, String idioma, String audio)
    {
        this.espanol = espanol;
        this.idioma = idioma;
        this.audio = audio;
    }

    public String getEspanol ()
    {
        return espanol;
    }

    public String getIdioma ()
    {
        return idioma;
    }

    public String getAudio ()
    {
        return audio;
    }
}