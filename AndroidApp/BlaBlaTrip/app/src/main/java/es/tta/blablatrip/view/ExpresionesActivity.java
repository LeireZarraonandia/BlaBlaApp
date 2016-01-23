package es.tta.blablatrip.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import org.json.JSONArray;
import es.tta.blablatrip.R;
import es.tta.blablatrip.presentation.Data;

public class ExpresionesActivity extends AppCompatActivity
{
    public static String expre = null;
    public static int numExpre = 0;
    public static JSONArray expresion;
    public static int longitud;

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
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void salud (View view)
    {
        expre = "Salud";
        numExpre = 1;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void compra (View view)
    {
        expre = "Compras";
        numExpre = 2;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void comer (View view)
    {
        expre = "Comer";
        numExpre = 3;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void hospedaje (View view)
    {
        expre = "Hospedaje";
        numExpre = 4;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void numeros (View view)
    {
        expre = "Numeros";
        numExpre = 5;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void viajar (View view)
    {
        expre = "Viajar";
        numExpre = 6;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void quejas (View view)
    {
        expre = "Quejas";
        numExpre = 7;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void coqueteo (View view)
    {
        expre = "Coqueteo";
        numExpre = 8;
        //Intent intent = new Intent(this, TablaActivity.class);
        //startActivity(intent);
        expresiones(view);
    }

    public void expresiones(View view)
    {
        new ProgressTask<JSONArray>(this)
        {
            @Override
            protected JSONArray work() throws Exception
            {
                Data data = new Data();

                //obtienes el json completo
                expresion = data.getExpresiones();


                //del json seleccionas la opcion escogida
                    //expresion.getJSONObject(ExpresionesActivity.numExpre);
                //coges la opcion completa escogida
                    //expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre);
                //coges el primer objeto (0) de la opcion escogida
                    //expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(0);
                //de la opcion escogida y del primer objeto (0) de dicha opcion coges el string que se identifica como "castellano"
                    //expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(0).getString("castellano");


                //obtienes la longitud de la opcion escogida
                longitud = expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).length();

                return expresion;
            }

            @Override
            protected void onFinish(JSONArray spresion)
            {
                Intent intent = new Intent(getApplicationContext(), TablaActivity.class);
                startActivity(intent);
            }
        }.execute();
    }
}