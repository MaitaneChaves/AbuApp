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

import es.tta.abuapp.presentation.DataHuecos;

public class HuecosActivity extends AppCompatActivity {

    private String palabra_completa;
    private String palabra_incompleta;
    private String imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huecos);

        //NUEVO
        Intent intent = getIntent();
        palabra_incompleta = intent.getStringExtra(DataHuecos.EXTRA_HUECOS_PALABRA_INCOMPLETA);
        System.out.println("PALABRA ES " + palabra_completa);
        TextView texto_huecos = (TextView)findViewById(R.id.texto_huecos);
        texto_huecos.setText(palabra_incompleta);
        EditText respuesta_huecos = (EditText)findViewById(R.id.respuesta_huecos);
        respuesta_huecos.setHint(palabra_incompleta);
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
