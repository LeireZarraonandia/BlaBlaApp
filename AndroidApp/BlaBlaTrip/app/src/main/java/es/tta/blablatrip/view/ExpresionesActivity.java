package es.tta.blablatrip.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import es.tta.blablatrip.R;
import es.tta.blablatrip.presentation.Data;

public class ExpresionesActivity extends AppCompatActivity
{
    //nombre del array del json
    public static String expre = null;
    //num. del objeto del json
    public static int numExpre = 0;
    public static JSONArray expresion;
    public static int longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_expresiones);
    }

    public void basicas(View view)
    {
        expre = "Basicas";
        numExpre = 0;
        expresiones(view);
    }

    public void salud(View view) {
        expre = "Salud";
        numExpre = 1;
        expresiones(view);
    }

    public void compra(View view) {
        expre = "Compras";
        numExpre = 2;
        expresiones(view);
    }

    public void comer(View view) {
        expre = "Comer";
        numExpre = 3;
        expresiones(view);
    }

    public void hospedaje(View view) {
        expre = "Hospedaje";
        numExpre = 4;
        expresiones(view);
    }

    public void numeros(View view) {
        expre = "Numeros";
        numExpre = 5;
        expresiones(view);
    }

    public void viajar(View view) {
        expre = "Viajar";
        numExpre = 6;
        expresiones(view);
    }

    public void quejas(View view) {
        expre = "Quejas";
        numExpre = 7;
        expresiones(view);
    }

    public void coqueteo(View view) {
        expre = "Coqueteo";
        numExpre = 8;
        expresiones(view);
    }


    //hasta que no se descargue lo necesario no pasa al siguiente activity
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
            protected void onFinish(JSONArray spresion) {
                Intent intent = new Intent(getApplicationContext(), TablaActivity.class);
                startActivity(intent);
            }
        }.execute();
    }
}