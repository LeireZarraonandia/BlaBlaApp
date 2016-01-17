package es.tta.blablatrip.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import es.tta.blablatrip.R;
import es.tta.blablatrip.model.Expresiones;
import es.tta.blablatrip.presentation.Data;
import android.widget.TableRow;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;

public class TablaActivity extends AppCompatActivity
{
    private RelativeLayout layoutRelative;
    private LinearLayout layoutLinear;
    private View.OnClickListener listener;
    private JSONArray expresion;
    //private String json;
    //private JSONArray json;
    //private JSONObject json;
    private TableLayout tabla;
    private int longitud;
    public String urlServer = "http://51.254.127.111/BlaBlaTrip/";
    public String audioRecogido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);

        //para la cabecera de la columna2
        TextView cabeceraCol2 = (TextView)findViewById(R.id.cabeceraCol2);
        cabeceraCol2.setText(InicioActivity.pais);

        tabla = (TableLayout) findViewById(R.id.tabla);

        new Thread(new Runnable()
        {
            Data data = new Data();

            @Override
            public void run()
            {
                try
                {
                    //obtienes el json completo
                    expresion = data.getExpresiones();

                    //del json seleccionas la opcion escogida
                        //expresion.getJSONObject(ExpresionesActivity.numExpre);
                    //coges la opcion completa escogida
                        //expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre);
                    //coges el primer objeto (0) de la opcion escogida
                        //expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(0);
                    //de la opcion escogida y del primer objeto (0) de dicha opcion coges el string que se identifica como "castellano"
                        //expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(0).getString("castellano");

                    //obtienes la longitud de la opcion escogida
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
                  final Expresiones expresiones = new Expresiones (
                        expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("castellano"),
                        expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("idioma"),
                        expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("audio"));

                //crear fila de la tabla
                final TableRow fila = new TableRow(getApplicationContext());

                //crear columna1 de la fila creada
                final TextView col1 = new TextView(getApplicationContext());
                col1.setText(expresiones.getEspanol());

                //crear columna2 de la fila creada
                final TextView col2 = new TextView(getApplicationContext());
                col2.setText(expresiones.getIdioma());

                //crear columna3 de la fila creada
                final Button col3 = new Button(getApplicationContext());
                col3.setText(R.string.cabeceraAudio);
                col3.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        try
                        {
                            audioRecogido = expresiones.getAudio();
                            hearAudio(audioRecogido);
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

                fila.post(new Runnable() {
                    @Override
                    public void run() {
                        fila.addView(col1);
                        fila.addView(col2);
                        fila.addView(col3);
                        //tabla.addView(fila);
                    }
                });

                tabla.addView(fila);

                layoutLinear = (LinearLayout)findViewById(R.id.tabla_linear); //LinearLayout de dentro
                //layoutRelative = (RelativeLayout)findViewById(R.id.tabla_layout); //RelativeLayout de fuera
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

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

    public void hearAudio(String audioRecogido) throws IOException
    {
        View view = new View(this);
        AudioPlayer audio = new AudioPlayer(view);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.tabla_layout);
        Uri uri = Uri.parse(urlServer+audioRecogido);
        audio.setAudioUri(uri);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        layout.addView(view);
        audio.start();
    }
}