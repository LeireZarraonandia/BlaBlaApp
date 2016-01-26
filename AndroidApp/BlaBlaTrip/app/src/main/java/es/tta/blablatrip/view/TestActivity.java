package es.tta.blablatrip.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import es.tta.blablatrip.R;
import es.tta.blablatrip.presentation.ResultadoTest;
import es.tta.blablatrip.model.Test;
import es.tta.blablatrip.presentation.Data;

public class TestActivity extends AppCompatActivity implements View.OnClickListener
{
    private JSONArray teses;
    private View.OnClickListener listener;
    private int correcto, nPregunta;
    private RelativeLayout layout;
    private ResultadoTest resultadoTest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        //findViewById(R.id.button_next_test).setVisibility(View.VISIBLE);

        resultadoTest = new ResultadoTest(0);
        final RadioGroup group = (RadioGroup) findViewById(R.id.respuesta); ///////////////////////////////
        final TextView textWording = (TextView) findViewById(R.id.pregunta); /////////////////////////////

        nPregunta=0;

        listener = this;

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int nPregunta = 0; ///////////////////////
                Data data = new Data();

                try
                {
                    teses = data.getTest();

                }
                catch(Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }
            }
        }).start();

        layout = (RelativeLayout) findViewById(R.id.test_layout);
    }

    @Override
    public void onClick(View u)
    {
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void comprobar (View v)
    {
        Data data = new Data(); ///////////////////////////////

        findViewById(R.id.button_next_test).setVisibility(View.VISIBLE);
        findViewById(R.id.button_send_test).setVisibility(View.INVISIBLE);
        findViewById(R.id.imageDiploma).setVisibility(View.INVISIBLE);

        Color color = new Color();

        RadioGroup grupo = (RadioGroup) findViewById(R.id.respuesta);
        TextView resultado = (TextView) findViewById(R.id.resultado);
        int choices = grupo.getChildCount();

        for(int i=0; i<choices; i++)
        {
            grupo.getChildAt(i).setEnabled(false);
        }

        grupo.getChildAt(correcto).setBackgroundColor(color.GREEN);

        int selected=grupo.getCheckedRadioButtonId();
        View radioButton = grupo.findViewById(selected);
        final int elegido = grupo.indexOfChild(radioButton);
        String prueba="El resultado es ";

        if (elegido == -1)
        {
            Toast.makeText(this, R.string.toast_norespuesta, Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (elegido!=correcto)
            {
                grupo.getChildAt(elegido).setBackgroundColor(color.RED);
                Toast.makeText(this, R.string.toast_fallar, Toast.LENGTH_SHORT).show();

            }
            else
            {
                resultadoTest.actualizarResultado(true);
                Toast.makeText(this, R.string.toast_aceptar, Toast.LENGTH_SHORT).show();
            }
        }
        resultado.setText(prueba+String.valueOf(resultadoTest.getCorrectos())+"/"+String.valueOf(nPregunta));
    }

    public void teses (View v) throws JSONException
    {
        findViewById(R.id.button_start_test).setVisibility(View.INVISIBLE);
        findViewById(R.id.inicio).setVisibility(View.INVISIBLE);
        findViewById(R.id.imageTest).setVisibility(View.INVISIBLE);
        findViewById(R.id.imageDiploma).setVisibility(View.INVISIBLE);

        final RadioGroup group = (RadioGroup) findViewById(R.id.respuesta);
        //int pregutnas = teses.length();
        if(nPregunta<teses.length())
        {
            group.removeAllViews();
            TextView textWording = (TextView) findViewById(R.id.pregunta);

            final Test test = new Test(
                    teses.getJSONObject(nPregunta).getString("wording"),
                    teses.getJSONObject(nPregunta).getJSONArray("answer"),
                    teses.getJSONObject(nPregunta).getInt("correct"));


            textWording.setText(test.getPregunta());
            for (int i = 0; i<test.getOpciones().length(); i++)
            {
                final RadioButton radio = new RadioButton(getApplicationContext());
                radio.setText(test.getOpciones().getString(i));
                radio.setOnClickListener(listener);
                radio.setTextColor(Color.BLACK);
                group.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        group.addView(radio);
                    }
                });
            }
            findViewById(R.id.button_next_test).setVisibility(View.INVISIBLE);
            findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
            correcto = test.getCorrecto();
            nPregunta++;
        }

        if (nPregunta == teses.length())
        {
            String frase_final = "Se ha acabado el test. El resultado es: ";
            findViewById(R.id.pregunta).setVisibility(View.INVISIBLE);
            findViewById(R.id.respuesta).setVisibility(View.INVISIBLE);
            findViewById(R.id.resultado).setVisibility(View.INVISIBLE);
            findViewById(R.id.imageTest).setVisibility(View.INVISIBLE);
            TextView finalizar = (TextView) findViewById(R.id.finalizar);
            finalizar.setText(frase_final+String.valueOf(resultadoTest.getCorrectos())+"/"+String.valueOf(nPregunta));
            findViewById(R.id.finalizar).setVisibility(View.VISIBLE);
            findViewById(R.id.button_finish_test).setVisibility(View.VISIBLE);
            findViewById(R.id.imageDiploma).setVisibility(View.VISIBLE);
            findViewById(R.id.button_next_test).setVisibility(View.INVISIBLE);
            findViewById(R.id.button_send_test).setVisibility(View.INVISIBLE);
        }
    }

    public void salir (View v)
    {
        Intent intent = new Intent(this, PaisActivity.class);
        startActivity(intent);
    }
}