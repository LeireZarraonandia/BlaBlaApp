package es.tta.blablatrip.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.blablatrip.R;

public class PaisActivity extends AppCompatActivity
{
    String pais = InicioActivity.pais;
    String nombre = pais.toLowerCase();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pais);

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
        Intent intent = new Intent(this, ExpresionesActivity.class);
        startActivity(intent);
    }

    public void evaluacion (View view)
    {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void descargar (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), nombre, Toast.LENGTH_SHORT);
        toast.show();
    }
}