package es.tta.blablatrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class InicioActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inicio);
    }

    public void traductor (View view)
    {
        Intent intent = new Intent(this, TraductorActivity.class);
        startActivity(intent);
    }
}
