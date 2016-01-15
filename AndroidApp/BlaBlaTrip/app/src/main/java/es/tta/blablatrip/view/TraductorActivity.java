package es.tta.blablatrip.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import es.tta.blablatrip.R;

public class TraductorActivity extends AppCompatActivity
{
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_traductor);

        mWebView = (WebView) findViewById(R.id.traductor_webview);
        // Activar Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Url del traductor
        mWebView.loadUrl("http://www.wordreference.com/es/");
        // Forzar el webview para que abra los enlaces internos dentro de la la APP
        mWebView.setWebViewClient(new WebViewClient());
        // Forzar el webview para que abra los enlaces externos en el navegador
        //mWebView.setWebViewClient(new MyAppWebViewClient());
    }

    @Override
    // Detectar cuando se presiona el botón de retroceso
    public void onBackPressed()
    {
        if(mWebView.canGoBack())
        {
            mWebView.goBack();
        } else
        {
            super.onBackPressed();
        }
    }
}