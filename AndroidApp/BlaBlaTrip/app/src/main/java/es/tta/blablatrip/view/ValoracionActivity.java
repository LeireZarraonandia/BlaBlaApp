package es.tta.blablatrip.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import es.tta.blablatrip.R;

public class ValoracionActivity extends AppCompatActivity
{
    Spinner lista;
    String [] datos = {"Elija opción...", "Alemania", "Francia", "Inglaterra", "Italia", "Portugal", "App BlaBlaTrip"};
    //int longitud = datos.length;
    String pais;

    Button btMail;
    EditText valMail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_valoracion);

        btMail = (Button)findViewById(R.id.bt_enviarValoracion);
        valMail = (EditText)findViewById(R.id.valEmail);

        lista = (Spinner)findViewById(R.id.spinner_listaPaises);

        // adaptador que vincula los datos a visualizar con el spinner (lista desplegable) --> ArrayAdapter
        // se le pasan 3 parámetros (vista, recurso de la clase R (que será el que se encargue de colocar los datos de una forma visual), datos a visualizar)
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        // vincular lista con el adaptador
        lista.setAdapter(adaptador); // así ya se ve

        // método para cuando se pulse una opción
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // las opciones están viculadas al parámetro 'i'
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                    {
                        pais = datos[0];
                        //Toast.makeText(getApplicationContext(), "Número de opciones: "+Integer.toString(longitud), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        pais = datos[1];
                        //Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case 2: {
                        pais = datos[2];
                        //Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case 3: {
                        pais = datos[3];
                        //Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case 4: {
                        pais = datos[4];
                        //Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case 5: {
                        pais = datos[5];
                        //Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case 6: {
                        pais = datos[6];
                        //Toast.makeText(getApplicationContext(), pais, Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //El metodo getText() obtiene el dato escrito con el metodo toString() se convierte a String para poder manipularlo como tal
                String editMail = valMail.getText().toString();

                String[] to = { "amartinez194@ikasle.ehu.eus", "lzarraonandi001@ikasle.ehu.eus" };
                //String[] cc = { "otroEmail@ejemplo.com" }; // si se quiere poner cc

                if( (pais==datos[0]) || (editMail.equals("")))
                {
                    Toast.makeText(getApplicationContext(), R.string.toast_error, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    // (a quien/es, cc, asunto, cuerpo mail)
                    enviar(to, "BlaBlaTrip - Valoración " + pais, editMail);
                    //enviar(to, cc, "BlaBlaTrip - Valoración " + pais, editMail); //si se pone cc
                }
            }
        });
    }

    //private void enviar(String[] to, String[] cc, String asunto, String mensaje) // si se pone cc
    private void enviar(String[] to, String asunto, String mensaje)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        //emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}