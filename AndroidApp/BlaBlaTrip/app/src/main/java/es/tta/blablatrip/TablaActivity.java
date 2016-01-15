package es.tta.blablatrip;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import java.util.ArrayList;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.presentation.Data;
import android.widget.TableRow;
import android.widget.TextView;

public class TablaActivity extends AppCompatActivity
{

    private Expresiones expresiones;
    private RelativeLayout layout;
    private LinearLayout layoutRepro;

    private TableLayout tabla;
    private int id_fila, num_celda=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);

        tabla = (TableLayout) findViewById(R.id.tabla);


        final TextView it = (TextView) findViewById(R.id.text1);
        final TextView idim = (TextView) findViewById(R.id.text2);
        final TextView audi = (TextView) findViewById(R.id.text3);


        String [] espanol = new String[7];
        String [] idiom = new String[7];
        String [] audio = new String[7];

        Data data = new Data();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Data data = new Data();

                try
                {

                    expresiones = data.getExpresiones(0);

                    it.post(new Runnable() {
                        @Override
                        public void run() {
                            it.setText(expresiones.getEspanol());
                        }
                    });

                    idim.post(new Runnable() {
                        @Override
                        public void run() {
                            idim.setText(expresiones.getIdioma());
                        }
                    });

                    audi.post(new Runnable() {
                        @Override
                        public void run() {
                            audi.setText(expresiones.getAudio());
                        }
                    });
                }
                catch (Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }
            }
        }).start();

        layout = (RelativeLayout) findViewById(R.id.tabla_layout);

        /*for (int i=0; i<8; i++)
        {
            TableRow fila = new TableRow(this);
            fila.setId(100 + i);
            TextView col1 = new TextView(this);
            col1.setId(200 + i);
            TextView col2 = new TextView(this);
            col2.setId(300 + i);
            TextView col3 = new TextView(this);
            col3.setId(400 + i);

            try
            {
                expresiones = data.getExpresiones(i);

                espanol[i] =  expresiones.getEspanol();
                idiom [i] =  expresiones.getIdioma();
                audio [i] =  expresiones.getAudio();

                col1.setText(espanol[i]);
                col2.setText(idiom[i]);
                col3.setText(audio[i]);
            }
            catch (Exception e)
            {
                Log.e("MAAAAAAL", e.getMessage(), e);
            }

            fila.addView(col1);
            fila.addView(col2);
            fila.addView(col3);

            tabla.addView(fila);
        }*/


        //EJEMPLO
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


        /*final TextView it = (TextView) findViewById(R.id.textIt1);
        final TextView idim = (TextView) findViewById(R.id.textIdiom1);
        final Button audi = (Button) findViewById(R.id.bt_audio1);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Data data = new Data();

                try
                {

                    expresiones = data.getExpresiones(0);

                    it.post(new Runnable() {
                        @Override
                        public void run() {
                            it.setText(expresiones.getEspanol());
                        }
                    });

                    idim.post(new Runnable() {
                        @Override
                        public void run() {
                            idim.setText(expresiones.getIdioma());
                        }
                    });

                    audi.post(new Runnable() {
                        @Override
                        public void run() {
                            audi.setText(expresiones.getAudio());
                        }
                    });
                }
                catch (Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }
            }
        }).start();

        layout = (LinearLayout) findViewById(R.id.tabla_layout);
    }

    public void hearAudio() throws IOException
    {
        View view = new View(this);

        AudioPlayer audio = new AudioPlayer(view);
        LinearLayout layoutRepro = (LinearLayout)findViewById(R.id.tabla_layout);

        Uri uri = Uri.parse("http://www.noiseaddicts.com/samples_1w72b820/55.mp3");
        audio.setAudioUri(uri);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);

        layoutRepro.addView(view);
        audio.start();
    }*/

}