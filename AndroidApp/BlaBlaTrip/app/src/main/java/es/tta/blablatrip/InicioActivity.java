package es.tta.blablatrip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class InicioActivity extends AppCompatActivity
{
    //public final static String EXTRA_ID_INICIO = "es.tta.blablatrip.id_inicio";
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
        Intent intent = new Intent(this, PaisActivity.class);
        Button bt_alemania = (Button) findViewById(R.id.bt_alemania);
        saveText(bt_alemania.getText().toString());
        //intent.putExtra(EXTRA_ID_INICIO, bt_alemania.getText().toString());
        pais="Alemania";
        startActivity(intent);
    }
    public void francia (View view)
    {
        Intent intent = new Intent(this, PaisActivity.class);
        Button bt_francia = (Button) findViewById(R.id.bt_francia);
        saveText(bt_francia.getText().toString());
        //intent.putExtra(EXTRA_ID_INICIO, bt_francia.getText().toString());
        pais="Francia";
        startActivity(intent);
    }
    public void inglaterra (View view)
    {
        Intent intent = new Intent(this, PaisActivity.class);
        Button bt_inglaterra = (Button) findViewById(R.id.bt_inglaterra);
        saveText(bt_inglaterra.getText().toString());
        //intent.putExtra(EXTRA_ID_INICIO, bt_inglaterra.getText().toString());
        pais="Inglaterra";
        startActivity(intent);
    }
    public void italia (View view)
    {
        Intent intent = new Intent(this, PaisActivity.class);
        Button bt_italia = (Button) findViewById(R.id.bt_italia);
        saveText(bt_italia.getText().toString());
        //intent.putExtra(EXTRA_ID_INICIO, bt_italia.getText().toString());
        pais="Italia";
        startActivity(intent);
    }
    public void portugal (View view)
    {
        Intent intent = new Intent(this, PaisActivity.class);
        Button bt_portugal = (Button) findViewById(R.id.bt_portugal);
        saveText(bt_portugal.getText().toString());
        //intent.putExtra(EXTRA_ID_INICIO, bt_portugal.getText().toString());
        pais="Portugal";
        startActivity(intent);
    }

    private void saveText(String pais)
    {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        //editor.putString(EXTRA_ID_INICIO, pais);
        editor.commit();
    }
}