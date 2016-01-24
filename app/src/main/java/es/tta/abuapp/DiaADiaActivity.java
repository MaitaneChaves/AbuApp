package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class DiaADiaActivity extends AppCompatActivity {

    public final static String EXTRA_TIPO = "es.tta.ejemplo1.tipo";

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
