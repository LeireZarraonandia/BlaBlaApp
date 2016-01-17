package es.tta.blablatrip.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import es.tta.blablatrip.R;

public class InicioActivity extends AppCompatActivity
{
    public static String pais = null;

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
    }

    public void traductor (View view)
    {
        Intent intent = new Intent(this, TraductorActivity.class);
        startActivity(intent);
    }

    public void valoracion (View view)
    {
        Intent intent = new Intent(this, ValoracionActivity.class);
        startActivity(intent);
    }

    public void alemania (View view)
    {
        pais="Alemania";
        Intent intent = new Intent(this, PaisActivity.class);
        startActivity(intent);
    }
    public void francia (View view)
    {
        pais="Francia";
        Intent intent = new Intent(this, PaisActivity.class);
        startActivity(intent);
    }
    public void inglaterra (View view)
    {
        pais="Inglaterra";
        Intent intent = new Intent(this, PaisActivity.class);
        startActivity(intent);
    }
    public void italia (View view)
    {
        pais="Italia";
        Intent intent = new Intent(this, PaisActivity.class);
        startActivity(intent);
    }
    public void portugal (View view)
    {
        pais="Portugal";
        Intent intent = new Intent(this, PaisActivity.class);
        startActivity(intent);
    }
}