package es.tta.blablatrip;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ExpresionesActivity extends AppCompatActivity
{
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_expresiones);

        LinearLayout relaLayout = (LinearLayout) findViewById(R.id.lineLayout_expresiones);
        Resources res = getResources();
        // está deprecado. Necesitaria API level 21 --> Android 5.0
        Drawable drawable = res.getDrawable(R.drawable.fondoblanco);
        relaLayout.setBackground(drawable);
    }

    public void basicas (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla básicas", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void salud (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla salud", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void numeros (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla números", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void viajar (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla viajar", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void comer (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla comer", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void compra (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla compras", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void coqueteo (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla coqueteo", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void hospedaje (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla hospedaje", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void quejas (View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(), "tabla quejas", Toast.LENGTH_SHORT);
        toast.show();
    }
}