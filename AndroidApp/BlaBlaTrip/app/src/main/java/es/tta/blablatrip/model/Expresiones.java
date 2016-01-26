package es.tta.blablatrip.model;

public class Expresiones
{
    private String espano;
    private String idiom;
    private String audi;

    public Expresiones (String espano, String idiom, String audi)
    {
        this.espano = espano;
        this.idiom = idiom;
        this.audi = audi;
    }

    public String getEspanol ()
    {
        return espano;
    }

    public String getIdioma ()
    {
        return idiom;
    }

    public String getAudio ()
    {
        return audi;
    }
}