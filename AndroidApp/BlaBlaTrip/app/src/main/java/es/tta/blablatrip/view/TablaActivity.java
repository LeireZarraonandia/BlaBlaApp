package es.tta.blablatrip.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import es.tta.blablatrip.R;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.presentation.Data;

import android.widget.TableRow;
import android.widget.TextView;

public class TablaActivity extends AppCompatActivity
{

    private Expresiones expresiones;
    private RelativeLayout layout;

    private TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);

        TextView cabeceraCol2 = (TextView)findViewById(R.id.cabeceraCol2);
        cabeceraCol2.setText(InicioActivity.pais);

        tabla = (TableLayout) findViewById(R.id.tabla);

        for (int i=0; i<8; i++)
        {
            TableRow fila = new TableRow(this);
            fila.setId(100 + i);
            final TextView col1 = new TextView(this);
            col1.setWidth(150);
            col1.setHeight(150);
            col1.setId(200 + i);
            final TextView col2 = new TextView(this);
            col2.setWidth(150);
            col2.setHeight(150);
            col2.setId(300 + i);
            final Button col3 = new Button(this);
            //final ViewGroup.LayoutParams params = col3.getLayoutParams();
            //params.width = 100;
            //col3.setLayoutParams(params);
            //col3.setGravity(Gravity.CENTER_HORIZONTAL);
            col3.setId(400 + i);
            //col3.setOnClickListener(hearAudio());

            final int j=i;

            new Thread(new Runnable()
            {
                Data data = new Data();
                @Override
                public void run()
                {
                    try
                    {
                        expresiones = data.getExpresiones(j);
                        //expresiones = data.getExpresiones(0);

                        col1.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                col1.setText(expresiones.getEspanol());
                            }
                        });

                        col2.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                col2.setText(expresiones.getIdioma());
                            }
                        });

                        col3.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                col3.setText(R.string.cabeceraAudio);
                            }
                        });
                    }
                    catch (Exception e)
                    {
                        Log.e("BlaBlaTrip", e.getMessage(), e);
                    }
                }
            }).start();

            fila.addView(col1);
            fila.addView(col2);
            fila.addView(col3);

            tabla.addView(fila);
        }


        layout = (RelativeLayout) findViewById(R.id.tabla_layout);

        //EJEMPLO FUNCIONA
        /*for (int i=0; i<8; i++)
        {
            TableRow fila = new TableRow(this);
            fila.setId(100 + i);
            TextView col1 = new TextView(this);
            col1.setId(200 + i);
            col1.setText("Celda nº " + num_celda);

            TextView col2 = new TextView(this);
            col2.setId(300 + i);
            col2.setText("Celda nº " + (num_celda + 1));

            TextView col3 = new TextView(this);
            col3.setId(400 + i);
            col3.setText("Celda nº " + (num_celda + 2));

            fila.addView(col1);
            fila.addView(col2);
            fila.addView(col3);

            tabla.addView(fila);

            num_celda=num_celda+3;
        }*/

    }

    /*public void hearAudio(View v) throws IOException
    {
        View view = new View(this);

        AudioPlayer audio = new AudioPlayer(view);
        RelativeLayout layoutRepro = (RelativeLayout)findViewById(R.id.tabla_layout);

        Uri uri = Uri.parse("http://www.noiseaddicts.com/samples_1w72b820/55.mp3");
        audio.setAudioUri(uri);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);

        layoutRepro.addView(view);
        audio.start();
    }*/
}