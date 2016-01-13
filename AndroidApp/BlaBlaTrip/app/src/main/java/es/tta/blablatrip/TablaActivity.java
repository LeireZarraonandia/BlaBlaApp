package es.tta.blablatrip;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import java.util.ArrayList;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.presentation.Data;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import es.tta.blablatrip.model.Test;
import es.tta.blablatrip.presentation.Data;


public class TablaActivity extends AppCompatActivity
{
    private Expresiones expresiones;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);

        Tabla tabla = new Tabla (this, (TableLayout)findViewById(R.id.tabla));

        Data data = new Data();
        
        try
        {
            for(int i=1; i<8; i++)
            {
                expresiones = data.getExpresiones(1);

                ArrayList<String> elementos = new ArrayList<String>();

                elementos.add(expresiones.getEspanol());
                elementos.add(expresiones.getIdioma());
                elementos.add(expresiones.getAudio());

                tabla.agregarFilaTabla(elementos);
            }
        }
        catch(Exception e)
        {
            Log.e("BlaBlaTrip", e.getMessage(), e);
        }
    }
}