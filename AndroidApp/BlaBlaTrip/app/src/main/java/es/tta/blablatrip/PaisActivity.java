package es.tta.blablatrip;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PaisActivity extends AppCompatActivity
{
    String nombre_pais = InicioActivity.EXTRA_ID_INICIO;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pais);

        Intent intent = getIntent();

        // recoger nombre país de InicioActivity y ponerlo de título en PaisActivity
        TextView titulo = (TextView) findViewById(R.id.titulo_pais);
        titulo.setText(intent.getStringExtra(nombre_pais));

        // recoger nombre país
        String nombre = intent.getStringExtra(nombre_pais);

        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.relativeLayout_pais);
        Resources res = getResources();

        switch (nombre)
        {
            case "Alemania":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.alemania);
                rLayout.setBackground(drawable);
                break;
            }
            case "Francia":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.francia);
                rLayout.setBackground(drawable);
                break;
            }
            case "Inglaterra":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.inglaterra);
                rLayout.setBackground(drawable);
                break;
            }
            case "Italia":
            {
                // está deprecado. Necesitaría API level 21 (Android 5.0). Nuestros móviles Android 4.x
                Drawable drawable = res.getDrawable(R.drawable.italia);
                rLayout.setBackground(drawable);
                break;
            }
            case "Portugal":
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
    }
}