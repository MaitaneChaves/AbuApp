package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import es.tta.abuapp.model.Audios;
import es.tta.abuapp.model.BusinessAudios;


public class HablandoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hablando);
    }

    public void palabras(View view) {
        Intent intent = new Intent(getApplicationContext(),PalabrasActivity.class);
        startActivity(intent);

    }

    public void canciones(View view) {
        Intent intent = new Intent(this,CancionesActivity.class);
        startActivity(intent);
    }

}
