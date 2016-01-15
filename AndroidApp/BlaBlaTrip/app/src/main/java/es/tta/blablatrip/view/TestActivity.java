package es.tta.blablatrip.view;

import android.content.Intent;
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
import org.json.JSONArray;
import org.json.JSONException;

import es.tta.blablatrip.R;
import es.tta.blablatrip.model.Test;
import es.tta.blablatrip.presentation.Data;

public class TestActivity extends AppCompatActivity implements View.OnClickListener
{
    private JSONArray teses;
    private View.OnClickListener listener;
    private int correcto, nPregunta;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        final RadioGroup group = (RadioGroup) findViewById(R.id.respuesta);
        final TextView textWording = (TextView) findViewById(R.id.pregunta);

        nPregunta=0;

        listener = this;


        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                int nPregunta=0;
                Data data = new Data();

                try
                {
                    teses = data.getTest();

                 //   do {
                     /*   final Test test = new Test(teses.getJSONObject(nPregunta).getString("wording"), teses.getJSONObject(nPregunta).getJSONArray("answer"), teses.getJSONObject(nPregunta).getInt("correct"));
                        textWording.post(new Runnable() {
                            @Override
                            public void run() {
                                textWording.setText(test.getPregunta());
                            }
                        });
                        for (int i = 0; i < test.getOpciones().length(); i++) {
                            final RadioButton radio = new RadioButton(getApplicationContext());
                            radio.setText(test.getOpciones().getString(i));
                            radio.setOnClickListener(listener);
                            radio.setTextColor(Color.BLACK);
                            group.post(new Runnable() {
                                @Override
                                public void run() {
                                    group.addView(radio);
                                }
                            });
                        }
                        correcto = test.getCorrecto();*/
                   // }while (nPregunta<teses.length());

                }
                catch(Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }

            }
        }).start();
        findViewById(R.id.button_next_test).setVisibility(View.VISIBLE);
        nPregunta++;
        layout = (LinearLayout) findViewById(R.id.test_layout);

    }

    @Override
    public void onClick(View u)
    {
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);

    }

    public void comprobar (View v)
    {
        Color color = new Color();
        Button enviar = (Button)findViewById(R.id.button_send_test);
        RadioGroup grupo = (RadioGroup) findViewById(R.id.respuesta);
        int choices=grupo.getChildCount();

        for(int i=0; i<choices; i++)
        {
            grupo.getChildAt(i).setEnabled(false);
        }

        enviar.setVisibility(View.INVISIBLE);
        grupo.getChildAt(correcto).setBackgroundColor(color.GREEN);

        int selected=grupo.getCheckedRadioButtonId();
        View radioButton = grupo.findViewById(selected);
        final int elegido = grupo.indexOfChild(radioButton);

        if (elegido!=correcto)
        {
            grupo.getChildAt(elegido).setBackgroundColor(color.RED);
            Toast.makeText(this, R.string.toast_fallar, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, R.string.toast_aceptar, Toast.LENGTH_SHORT).show();
        }
        findViewById(R.id.button_next_test).setVisibility(View.VISIBLE);
    }

    public void teses (View v) throws JSONException {

        if(nPregunta<teses.length()) {
            final RadioGroup group = (RadioGroup) findViewById(R.id.respuesta);
            TextView textWording = (TextView) findViewById(R.id.pregunta);

            group
            findViewById(R.id.button_next_test).setVisibility(View.INVISIBLE);
            final Test test = new Test(teses.getJSONObject(nPregunta).getString("wording"), teses.getJSONObject(nPregunta).getJSONArray("answer"), teses.getJSONObject(nPregunta).getInt("correct"));
            textWording.setText(test.getPregunta());
            for (int i = 0; i < test.getOpciones().length(); i++) {
                final RadioButton radio = new RadioButton(getApplicationContext());
                radio.setText(test.getOpciones().getString(i));
                radio.setOnClickListener(listener);
                radio.setTextColor(Color.BLACK);
                group.post(new Runnable() {
                    @Override
                    public void run() {
                        group.addView(radio);
                    }
                });
            }
            correcto = test.getCorrecto();
            nPregunta++;
            findViewById(R.id.button_next_test).setVisibility(View.VISIBLE);

        }

        if (nPregunta==teses.length()){
            Toast.makeText(this, "has acabado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PaisActivity.class);
            startActivity(intent);
        }

    }
}


