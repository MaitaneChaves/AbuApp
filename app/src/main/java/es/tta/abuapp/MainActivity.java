package es.tta.abuapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void juegos(View view)
    {
        Intent intent = new Intent(this,JuegosActivity.class);
        startActivity(intent);
    }

    public void diaadia(View view)
    {
        Intent intent = new Intent(this,DiaADiaActivity.class);
        startActivity(intent);
    }

    public void hablando(View view)
    {
        Intent intent = new Intent(this,HablandoActivity.class);
        startActivity(intent);
    }

    public void traductor(View view)
    {
        Uri uri =Uri.parse("https://translate.google.es/?hl=es#eu/es/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
