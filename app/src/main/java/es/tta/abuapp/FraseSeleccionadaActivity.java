package es.tta.abuapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FraseSeleccionadaActivity extends ModelActivity {

    private String urlAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase_seleccionada);

        Intent intent = getIntent();
        String castellano = intent.getStringExtra(FrasesDiaADiaActivity.EXTRA_CASTELLANO);
        String euskera = intent.getStringExtra(FrasesDiaADiaActivity.EXTRA_EUSKERA);
        urlAudio = intent.getStringExtra(FrasesDiaADiaActivity.EXTRA_AUDIO);

        TextView castellanoView = (TextView)findViewById(R.id.fraseSeleccionada_castellano);
        TextView euskeraView = (TextView)findViewById(R.id.fraseSeleccionada_euskera);

        castellanoView.setText(castellano);
        euskeraView.setText(euskera);
    }




    public void playAudio(View view)
    {
        LinearLayout layout_audio = (LinearLayout)findViewById(R.id.audio_frase);
        AudioPlayer ap = new AudioPlayer(layout_audio);
        try
        {
            ap.setAudioUri(Uri.parse(URL + "/" + urlAudio));
        }
        catch(Exception e)
        {
        }
    }
}
