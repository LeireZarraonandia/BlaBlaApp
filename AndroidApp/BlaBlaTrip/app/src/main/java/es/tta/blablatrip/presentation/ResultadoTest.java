package es.tta.blablatrip.presentation;

public class ResultadoTest
{
    private int correctos;

    public ResultadoTest (int correctos)
    {
        this.correctos = correctos;
    }

    public int getCorrectos ()
    {
        return correctos;
    }

    public void actualizarResultado (boolean valor)
    {
       if (valor)
       {
           correctos++;
       }
    }
}