package es.tta.abuapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.abuapp.model.Audios;
import es.tta.abuapp.model.BusinessAudios;

public class PalabrasActivity extends ModelActivity
{
    private BusinessAudios server=new BusinessAudios(php);

    private Audios audio;

    private TextView texto_palabras;

    static final int AUDIO_REQUEST_CODE = 1;

    AudioPlayer ap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);

        texto_palabras=(TextView)findViewById(R.id.texto_palabras);
        cargaPalabras();
    }

    public void siguiente(View view)
    {
        if(server.finAudios()==false)
        {
            cargaPalabras();
        }
        else
        {
            LinearLayout layout=(LinearLayout)findViewById(R.id.layout_audio);
            layout.removeAllViews();
            System.out.println("FINAL");
            TextView final_palabras=new TextView(this);
            final_palabras.setText("AMAIERA");
            final_palabras.setGravity(Gravity.CENTER);
            final_palabras.setTextSize(70);
            final_palabras.setTextColor(Color.WHITE);
            layout.addView(final_palabras);
        }

    }

    public void cargaPalabras()
    {
        LinearLayout audio_view=(LinearLayout)findViewById(R.id.audio);
        if(ap!=null) {
            ap.removeController();
        }
        //audio_view.setVisibility(View.GONE);
        texto_palabras=(TextView)findViewById(R.id.texto_palabras);
        new ProgressTask<Audios>(this)
        {
            @Override
            protected Audios work() throws Exception
            {
                audio = server.getAudios();
                return audio;

            }
            @Override
            protected void onFinish(Audios audio) {
                texto_palabras.setText(audio.getTitulo());
            }

        }.execute();
    }

    //FUNCIONES DE GRABAR Y REPRODUCIR
    public void grabarAudio(View view)
    {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
        {
            Toast.makeText(this, R.string.no_micro, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if(intent.resolveActivity(getPackageManager())!=null)
            {
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            }
            else
            {
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode!= Activity.RESULT_OK)
        {
            Toast.makeText(this, "Error al grabar el audio", Toast.LENGTH_SHORT).show();
            return;
        }

        switch(requestCode)
        {
            case AUDIO_REQUEST_CODE:
                if(ap!=null) {
                    ap.removeController();
                }
                playAudio(data.getData());
                break;
        }
    }

    public void playAudio(Uri uri)
    {
        LinearLayout audio=(LinearLayout)findViewById(R.id.audio);
        if(ap!=null) {
            ap.removeController();
        }
         ap = new AudioPlayer(audio);
        try {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
            String pathAudio = cursor.getString(index);
            Uri uri_final = Uri.parse(pathAudio);
            ap.setAudioUri(uri_final);
        }
        catch(Exception e) {

        }
    }

    public void playAudio(View view)
    {
        LinearLayout audio_view=(LinearLayout)findViewById(R.id.audio);
        if(ap!=null){
            ap.removeController();
        }
        ap = new AudioPlayer(audio_view);

        try {
            ap.setAudioUri(Uri.parse(URL + "/" + audio.getAudio()));
        }
        catch(Exception e) {

        }
    }
}
