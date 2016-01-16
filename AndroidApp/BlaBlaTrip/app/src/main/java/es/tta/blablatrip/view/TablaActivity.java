package es.tta.blablatrip.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import es.tta.blablatrip.R;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.presentation.Data;
import android.widget.TableRow;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;

public class TablaActivity extends AppCompatActivity
{
    private RelativeLayout layout;
    private View.OnClickListener listener;
    private JSONArray expresion;
    private JSONArray numeros;
    //private String json;
    private JSONArray json;
    //private JSONObject json;
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

        new Thread(new Runnable()
        {
            Data data = new Data();
            //final TableRow fila = (TableRow) findViewById(R.id.tableFila);

            @Override
            public void run()
            {
                try
                {
                    expresion = data.getExpresiones();

                    longitud = expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).length();



                }
                catch (Exception e)
                {
                    Log.e("BlaBlaTrip", e.getMessage(), e);
                }
            }
        }).start();


        for (int i=0; i<longitud; i++)
        {
            try
            {
                //json = expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre);

                final Expresiones expresiones = new Expresiones (
                        expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("castellano"),
                        expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("idioma"),
                        expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("audio"));

                final TableRow fila = new TableRow(getApplicationContext());

                final TextView col1 = new TextView(getApplicationContext());
                col1.setText(expresiones.getEspanol());

                final TextView col2 = new TextView(getApplicationContext());
                col2.setText(expresiones.getIdioma());

                final Button col3 = new Button(getApplicationContext());
                col3.setText(R.string.cabeceraAudio);

                fila.post(new Runnable() {
                    @Override
                    public void run() {
                        fila.addView(col1);
                        fila.addView(col2);
                        fila.addView(col3);
                        tabla.addView(fila);
                    }
                });

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

        //layout = (RelativeLayout) findViewById(R.id.tabla_layout);


        //EJEMPLO FUNCIONA
        /*for (int i=0; i<8; i++)
        {
            TableRow fila = new TableRow(this);
            fila.setId(100 + i);
            TextView col1 = new TextView(this);
            col1.setId(200 + i);
            col1.setText("Celda nº ");
            TextView col2 = new TextView(this);
            col2.setId(300 + i);
            col2.setText("Celda nº ");
            Button col3 = new Button(this);
            col3.setId(400 + i);
            col3.setText("Celda nº ");
            fila.addView(col1);
            fila.addView(col2);
            fila.addView(col3);
            tabla.addView(fila);
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