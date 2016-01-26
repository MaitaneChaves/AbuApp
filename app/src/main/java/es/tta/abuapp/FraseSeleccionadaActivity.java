package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FraseSeleccionadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase_seleccionada);

        Intent intent = getIntent();
        String castellano = intent.getStringExtra(FrasesDiaADiaActivity.EXTRA_CASTELLANO);
        String euskera = intent.getStringExtra(FrasesDiaADiaActivity.EXTRA_EUSKERA);
        String audio = intent.getStringExtra(FrasesDiaADiaActivity.EXTRA_AUDIO);

        TextView castellanoView = (TextView)findViewById(R.id.fraseSeleccionada_castellano);
        TextView euskeraView = (TextView)findViewById(R.id.fraseSeleccionada_euskera);
        TextView audioView = (TextView)findViewById(R.id.fraseSeleccionada_audio);

        castellanoView.setText(castellano);
        euskeraView.setText(euskera);
        audioView.setText(audio);
    }

}
