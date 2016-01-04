package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DiaADiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_adia);
    }

    public void mostrarFrases(View view)
    {
        Intent intent = new Intent(this,FrasesDiaADiaActivity.class);
        startActivity(intent);
    }

}
