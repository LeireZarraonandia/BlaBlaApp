package es.tta.blablatrip.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import es.tta.blablatrip.R;

public class ExpresionesActivity extends AppCompatActivity
{
    public static String expre = null;
    public static int numExpre = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_expresiones);
    }

    public void basicas (View view)
    {
        expre = "Basicas";
        numExpre = 0;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void comer (View view)
    {
        expre = "Comer";
        numExpre = 1;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void compra (View view)
    {
        expre = "Compras";
        numExpre = 2;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void coqueteo (View view)
    {
        expre = "Coqueteo";
        numExpre = 3;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void hospedaje (View view)
    {
        expre = "Hospedaje";
        numExpre = 4;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void numeros (View view)
    {
        expre = "Numeros";
        numExpre = 5;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void quejas (View view)
    {
        expre = "Quejas";
        numExpre = 6;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void salud (View view)
    {
        expre = "Salud";
        numExpre = 7;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }

    public void viajar (View view)
    {
        expre = "Viajar";
        numExpre = 8;
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
    }
}