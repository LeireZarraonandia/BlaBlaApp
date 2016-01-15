package es.tta.blablatrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Toast toast = Toast.makeText(getApplicationContext(), "tabla básicas", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Basicas";
        numExpre = 0;
    }

    public void salud (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla salud", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Salud";
        numExpre = 1;
    }

    public void numeros (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla números", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Numeros";
        numExpre = 2;
    }

    public void viajar (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla viajar", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Viajar";
        numExpre = 3;
    }

    public void comer (View view)
    {
        //Toast toast = Toast.makeText(getApplicationContext(), "tabla comer", Toast.LENGTH_SHORT);
        //toast.show();
        expre = "Comer";
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
        numExpre = 4;
    }

    public void compra (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla compras", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Compra";
        numExpre =5;
    }

    public void coqueteo (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla coqueteo", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Coqueteo";
        numExpre = 6;
    }

    public void hospedaje (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla hospedaje", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Hospedaje";
        numExpre = 7;
    }

    public void quejas (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla quejas", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Quejas";
        numExpre = 8;
    }
}