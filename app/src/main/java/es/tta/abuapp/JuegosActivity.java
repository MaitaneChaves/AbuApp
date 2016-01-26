package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class JuegosActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);
    }

    public void parejas(View view)
    {
        Intent intent=new Intent(this, ParejasActivity.class);
        startActivity(intent);
    }

    public void huecos(View view)
    {
        Intent intent = new Intent(this, HuecosActivity.class);
        startActivity(intent);
    }
}
