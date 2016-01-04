package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HuecosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huecos);
    }

    public void comprobar(View view)
    {
        EditText texto_huecos = (EditText)findViewById(R.id.respuesta_huecos);
        String respuesta = texto_huecos.getText().toString().toLowerCase();
        if(respuesta.compareTo("palabra")==0)
        {
            Toast.makeText(this,"CORRECTO", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"INCORRECTO", Toast.LENGTH_SHORT).show();
        }
    }

}
