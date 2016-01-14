package es.tta.blablatrip;

import android.app.ActionBar;
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
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
//import android.media.session.MediaController;
import android.widget.MediaController;
import java.io.IOException;

public class TablaActivity extends AppCompatActivity
{

    private Expresiones expresiones;
    private LinearLayout layout;
    private LinearLayout layoutRepro;
    String spain;
    String ital;
    String sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabla);


        final TextView it = (TextView) findViewById(R.id.textIt);
        final TextView idim = (TextView) findViewById(R.id.textIdiom);
        final Button audi = (Button) findViewById(R.id.bt_audio);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Data data = new Data();

                try
                {
                    expresiones = data.getExpresiones(0);
                    spain = expresiones.getEspanol();
                    ital = expresiones.getIdioma();
                    sonido = expresiones.getAudio();

                    it.post(new Runnable() {
                        @Override
                        public void run() {
                            it.setText(spain);
                        }
                    });

                    idim.post(new Runnable() {
                        @Override
                        public void run() {
                            idim.setText(ital);
                        }
                    });

                    audi.post(new Runnable() {
                        @Override
                        public void run() {
                            audi.setText(sonido);
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
    }
}