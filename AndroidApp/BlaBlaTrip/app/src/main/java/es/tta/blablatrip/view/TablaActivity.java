package es.tta.blablatrip.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;

public class TablaActivity extends AppCompatActivity
{
    //private RelativeLayout layoutRelative;
    private LinearLayout layoutLinear;
    private JSONArray expresion;
    private TableLayout tabla;
    private int longitud;
    public String urlServer = "http://51.254.127.111/BlaBlaTrip/";
    public String audioRecogido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);

        //recoger nombre pais y hacer que sea la cabecera de la columna2
        TextView cabeceraCol2 = (TextView) findViewById(R.id.cabeceraCol2);
        cabeceraCol2.setText(InicioActivity.pais);
        cabeceraCol2.setGravity(Gravity.CENTER_HORIZONTAL);

        tabla = (TableLayout) findViewById(R.id.tabla);

        longitud = ExpresionesActivity.longitud;

        for (int i=0; i<longitud; i++)
        {
            try
            {
                expresion = ExpresionesActivity.expresion;
                if (expresion!=null) {


                    final Expresiones expresiones = new Expresiones(
                            expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("castellano"),
                            expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("idioma"),
                            expresion.getJSONObject(ExpresionesActivity.numExpre).getJSONArray(ExpresionesActivity.expre).getJSONObject(i).getString("audio"));

                    //crear fila de la tabla
                    final TableRow fila = new TableRow(getApplicationContext());

                    //crear columna1 de la fila creada
                    final TextView col1 = new TextView(getApplicationContext());
                    col1.setText(expresiones.getEspanol());
                    col1.setWidth(100);
                    col1.setHeight(170);
                    col1.setGravity(Gravity.CENTER);

                    //crear columna2 de la fila creada
                    final TextView col2 = new TextView(getApplicationContext());
                    col2.setText(expresiones.getIdioma());
                    col2.setWidth(100);
                    col2.setHeight(170);
                    col2.setGravity(Gravity.CENTER);

                    //crear columna3 de la fila creada
                    final Button col3 = new Button(getApplicationContext());
                    col3.setText(R.string.cabeceraAudio);
                    col3.setWidth(70);
                    //col3.setHeight(160);
                    col3.setGravity(Gravity.CENTER);
                    col3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Data data = new Data();
                                audioRecogido = expresiones.getAudio();
                                hearAudio(data.getUriAudio(audioRecogido));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    //añadir filas al view
                    fila.addView(col1);
                    fila.addView(col2);
                    fila.addView(col3);

                    tabla.addView(fila);

                    layoutLinear = (LinearLayout) findViewById(R.id.tabla_linear); //LinearLayout de dentro
                    //layoutRelative = (RelativeLayout)findViewById(R.id.tabla_layout); //RelativeLayout de fuera
                }else{
                    Toast.makeText(this, R.string.noconnected, Toast.LENGTH_LONG).show();
                    finish();
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void hearAudio(String audioRecogido) throws IOException
    {
        View view = new View(this);
        AudioPlayer audio = new AudioPlayer(view);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.tabla_layout);
        Uri uri = Uri.parse(audioRecogido);
        audio.setAudioUri(uri);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        layout.addView(view);
        audio.start();
    }

    /*public void hearAudio(String audioRecogido) throws IOException
    {
        View view = new View(this);
        AudioPlayer audio = new AudioPlayer(view);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.tabla_layout);

        Data data = new Data();

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        layout.addView(view);
        audio.start();
    }*/
}