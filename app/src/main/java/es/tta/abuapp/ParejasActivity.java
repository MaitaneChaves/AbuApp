package es.tta.abuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParejasActivity extends AppCompatActivity {

    private int palabra=0;
    private int imagen=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas);
    }

    public void guardarPareja(View view){
        int pulsado=view.getId();

        if(pulsado>=R.id.foto_parejas1&&pulsado<=R.id.foto_parejas6)
            imagen=pulsado;

        else if(pulsado>=R.id.palabra_parejas1&&pulsado<=R.id.palabra_parejas6)
            palabra=pulsado;

        if(imagen!=0&&palabra!=0)
            comprueba();
    }

    private void comprueba(){
        Map<Integer, Integer> parejas = new HashMap<Integer, Integer>();

        parejas.put(R.id.foto_parejas1,R.id.palabra_parejas1);
        parejas.put(R.id.foto_parejas2,R.id.palabra_parejas2);
        parejas.put(R.id.foto_parejas3,R.id.palabra_parejas3);
        parejas.put(R.id.foto_parejas4,R.id.palabra_parejas4);
        parejas.put(R.id.foto_parejas5,R.id.palabra_parejas5);
        parejas.put(R.id.foto_parejas6,R.id.palabra_parejas6);

        int pareja=parejas.get(imagen);
        if (pareja==palabra)
            Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Incorrecto",Toast.LENGTH_SHORT).show();
        imagen=0;
        palabra=0;
    }

}