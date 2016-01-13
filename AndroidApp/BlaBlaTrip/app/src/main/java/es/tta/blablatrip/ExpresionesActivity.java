package es.tta.blablatrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ExpresionesActivity extends AppCompatActivity
{
    public static String expre = null;

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
    }

    public void salud (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla salud", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Salud";
    }

    public void numeros (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla números", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Numeros";
    }

    public void viajar (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla viajar", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Viajar";
    }

    public void comer (View view)
    {
        //Toast toast = Toast.makeText(getApplicationContext(), "tabla comer", Toast.LENGTH_SHORT);
        //toast.show();
        Intent intent = new Intent(this, TablaActivity.class);
        startActivity(intent);
        expre = "Comer";
    }

    public void compra (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla compras", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Compra";
    }

    public void coqueteo (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla coqueteo", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Coqueteo";
    }

    public void hospedaje (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla hospedaje", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Hospedaje";
    }

    public void quejas (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla quejas", Toast.LENGTH_SHORT);
        toast.show();
        expre = "Quejas";
    }
}