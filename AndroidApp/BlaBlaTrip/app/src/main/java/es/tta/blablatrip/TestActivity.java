package es.tta.blablatrip;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private Test test;
    private View.OnClickListener listener;
    private int correcto;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listener = this;
        final RadioGroup group = (RadioGroup) findViewById(R.id.respuesta);
        final TextView textWording = (TextView) findViewById(R.id.pregunta);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Data data = new Data();
                try {
                    test = data.getTest(1);
                    textWording.post(new Runnable() {
                        @Override
                        public void run() {
                            textWording.setText(test.getPregunta());
                        }
                    });

                    for (int i=0;i<test.getOpciones().length();i++) {
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
                    correcto=test.getCorrecto();
                    }
                }catch(Exception e){
                    Log.e("demo", e.getMessage(), e);
                }
            }
        }).start();
        layout = (LinearLayout) findViewById(R.id.test_layout);
    }

    @Override
    public void onClick(View u){
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void enviar (View v)
    {
        int correct=1;
        Color color=new Color();
        Button enviar = (Button)findViewById(R.id.button_send_test);

        RadioGroup grupo = (RadioGroup) findViewById(R.id.respuesta);
        int choices=grupo.getChildCount();

        for(int i=0;i<choices;i++)
        {
            grupo.getChildAt(i).setEnabled(false);
        }

        enviar.setVisibility(View.INVISIBLE);
        grupo.getChildAt(correcto).setBackgroundColor(color.GREEN);

        int selected=grupo.getCheckedRadioButtonId();
        if (selected!=correcto){
            grupo.getChildAt(selected).setBackgroundColor(color.RED);
            Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this, "Acierto", Toast.LENGTH_SHORT).show();
        }


    }



}
