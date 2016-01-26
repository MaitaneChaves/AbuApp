package es.tta.abuapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import es.tta.abuapp.model.BusinessParejas;
import es.tta.abuapp.model.BusinessHuecos;
import es.tta.abuapp.model.Huecos;
import es.tta.abuapp.model.Parejas;


public class JuegosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

    }

    public void parejas(View view)
    {
        Intent intent=new Intent(getApplicationContext(), ParejasActivity.class);
        startActivity(intent);
    }

    public void huecos(View view)
    {
        Intent intent = new Intent(this,HuecosActivity.class);
        startActivity(intent);
    }
}
