package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent mainIntent = new Intent().setClass(PantallaInicio.this, MainActivity.class);
        startActivity(mainIntent);
        finish();

    }

}
