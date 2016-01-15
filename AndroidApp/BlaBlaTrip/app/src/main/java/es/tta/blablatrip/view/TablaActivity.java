package es.tta.blablatrip.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
<<<<<<< HEAD:AndroidApp/BlaBlaTrip/app/src/main/java/es/tta/blablatrip/TablaActivity.java
import android.widget.LinearLayout;
import android.widget.RadioButton;
=======
>>>>>>> origin/master:AndroidApp/BlaBlaTrip/app/src/main/java/es/tta/blablatrip/view/TablaActivity.java
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import es.tta.blablatrip.R;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.model.Test;
import es.tta.blablatrip.presentation.Data;

import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;

public class TablaActivity extends AppCompatActivity
{

    private RelativeLayout layout;
    private View.OnClickListener listener;
    private JSONArray expresiones;
    private TableLayout tabla;
    public int longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);


        TextView cabeceraCol2 = (TextView)findViewById(R.id.cabeceraCol2);
        cabeceraCol2.setText(InicioActivity.pais);

        tabla = (TableLayout) findViewById(R.id.tabla);

        /*for (int i=0; i<8; i++)
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
            final ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            col3.setLayoutParams(params);
            //params.width = 100;
            //col3.setLayoutParams(params);
            //col3.setGravity(Gravity.CENTER_HORIZONTAL);
            col3.setId(400 + i);


            new Thread(new Runnable()
            {
                Data data = new Data();

                @Override
                public void run()
                {
                    try
                    {
                        expresiones = data.getExpresiones(0);
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

        layout = (RelativeLayout) findViewById(R.id.tabla_layout);*/


        new Thread(new Runnable()
        {
            Data data = new Data();

            @Override
            public void run()
            {
                try
                {
                    expresiones = data.getExpresiones();
                    JSONArray json = expresiones.getJSONArray(ExpresionesActivity.numExpre);
                    longitud = expresiones.getJSONArray(ExpresionesActivity.numExpre).length();

                    int ihgk= expresiones.getJSONArray(ExpresionesActivity.numExpre).length();
                    for (int i = 0; i < longitud; i++)
                    {
                        final Expresiones expresion = new Expresiones(expresiones.getJSONArray(ExpresionesActivity.numExpre).getJSONObject(i).getString("castellano"),
                                expresiones.getJSONArray(ExpresionesActivity.numExpre).getJSONObject(i).getString("idioma"),
                                expresiones.getJSONArray(ExpresionesActivity.numExpre).getJSONObject(i).getString("audio"));

                        final TableRow fila = new TableRow(getApplicationContext());
                        final TextView col1 = new TextView(getApplication());
                        final TextView col2 = new TextView(getApplication());
                        final Button col3 = new Button(getApplication());

                        col1.setText(expresion.getEspanol());
                        col2.setText(expresion.getIdioma());
                        col3.setText(R.string.cabeceraAudio);

                        fila.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                fila.addView(col1);
                                fila.addView(col2);
                                fila.addView(col3);
                            }
                        });

                        tabla.addView(fila);
                    }
                }
                catch (Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }
            }
        }).start();

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

    /*public void hearAudio(String nada) throws IOException
    {
        View view = new View(this);

        AudioPlayer audio = new AudioPlayer(view);
        RelativeLayout layoutRepro = (RelativeLayout)findViewById(R.id.tabla_layout);

        Uri uri = Uri.parse(nada);
        //Uri uri = Uri.parse("http://www.noiseaddicts.com/samples_1w72b820/55.mp3");
        audio.setAudioUri(uri);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);

        layoutRepro.addView(view);
        audio.start();
    }*/
}