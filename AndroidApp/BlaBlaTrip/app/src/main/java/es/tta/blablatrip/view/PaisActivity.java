package es.tta.blablatrip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.blablatrip.R;
import es.tta.blablatrip.presentation.Data;

public class PaisActivity extends AppCompatActivity
{
    String pais = InicioActivity.pais;
    String nombre = pais.toLowerCase();
    public static boolean conectado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pais);
        conectado();

        Intent intent = getIntent();

        // recoger nombre país de InicioActivity y ponerlo de título en PaisActivity
        TextView titulo = (TextView) findViewById(R.id.titulo_pais);
        titulo.setText(intent.getStringExtra(InicioActivity.pais));

        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.relativeLayout_pais);
        Resources res = getResources();


        switch (nombre)
        {
            case "alemania":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.alemania);
                rLayout.setBackground(drawable);
                break;
            }
            case "francia":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.francia);
                rLayout.setBackground(drawable);
                break;
            }
            case "inglaterra":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.inglaterra);
                rLayout.setBackground(drawable);
                break;
            }
            case "italia":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.italia);
                rLayout.setBackground(drawable);
                break;
            }
            case "portugal":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.portugal);
                rLayout.setBackground(drawable);
                break;
            }
        }
    }

    public void expresiones (View view)
    {
        conectado();
        Intent intent = new Intent(this, ExpresionesActivity.class);
        startActivity(intent);
    }

    public void evaluacion (View view)
    {
        conectado();
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }


    public void descargar (View view)  {
        conectado();

        new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                Data data = new Data();

                try
                {
                        conectado = data.descargar();

                }
                catch(Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }
            }

        }).start();
        if(conectado) {
            Toast.makeText(this, R.string.descargado, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }

    protected boolean conectado()
    {
        conectado = false;
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null)
        {
            NetworkInfo infoWifi = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo infoNet = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((infoWifi != null) && (infoNet != null))
            {
                if ((infoWifi.isConnected()) || (infoNet.isConnected()))
                {
                    conectado = true;
                    //Toast.makeText(this,R.string.connected, Toast.LENGTH_LONG).show();
                }
                else
                {
                    conectado = false;
                    Toast.makeText(this, R.string.noconnected, Toast.LENGTH_LONG).show();
                }
            }
        }

        return conectado;
    }
}