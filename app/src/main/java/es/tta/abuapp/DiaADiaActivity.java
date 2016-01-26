package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class DiaADiaActivity extends AppCompatActivity {

    public final static String EXTRA_TIPO = "es.tta.abuapp.tipo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_adia);
    }

    public void mostrarFrasesPan(View view)
    {
        Intent intent = new Intent(this,FrasesDiaADiaActivity.class);
        intent.putExtra(EXTRA_TIPO, "pan");
        startActivity(intent);
    }

    public void mostrarFrasesMedico(View view)
    {
        Intent intent = new Intent(this,FrasesDiaADiaActivity.class);
        intent.putExtra(EXTRA_TIPO, "medico");
        startActivity(intent);
    }

    public void mostrarFrasesBar(View view)
    {
        Intent intent = new Intent(this,FrasesDiaADiaActivity.class);
        intent.putExtra(EXTRA_TIPO, "bar");
        startActivity(intent);
    }
}
