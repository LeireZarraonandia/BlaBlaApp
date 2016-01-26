package es.tta.blablatrip.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import es.tta.blablatrip.R;

public class InicioActivity extends AppCompatActivity
{
    public static String pais = null;
    private boolean conectado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inicio);

        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.relativeLayout_inicio);
        Resources res = getResources();
        // está deprecado. Necesitaria API level 21 --> Android 5.0
        Drawable drawable = res.getDrawable(R.drawable.europa);
        rLayout.setBackground(drawable);

        conectado();
    }

    public void traductor (View view)
    {
        if(conectado == true)
        {
            Intent intent = new Intent(this, TraductorActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }

    public void valoracion (View view)
    {
        if(conectado == true)
        {
            Intent intent = new Intent(this, ValoracionActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }

    public void alemania (View view)
    {
        pais="Alemania";
        if(conectado == true)
        {
            Intent intent = new Intent(this, PaisActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }
    public void francia (View view)
    {
        pais="Francia";
        if(conectado == true)
        {
            Intent intent = new Intent(this, PaisActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }
    public void inglaterra (View view)
    {
        pais="Inglaterra";
        if(conectado == true)
        {
            Intent intent = new Intent(this, PaisActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }
    public void italia (View view)
    {
        pais="Italia";
        if(conectado == true)
        {
            Intent intent = new Intent(this, PaisActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
        }
    }
    public void portugal (View view)
    {
        pais="Portugal";
        if(conectado == true)
        {
            Intent intent = new Intent(this, PaisActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
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
                    Toast.makeText(this,R.string.connected, Toast.LENGTH_LONG).show();
                }
                else
                {
                    conectado = false;
                    Toast.makeText(this,R.string.noconnected, Toast.LENGTH_LONG).show();
                }
            }
        }

        return conectado;
    }
}