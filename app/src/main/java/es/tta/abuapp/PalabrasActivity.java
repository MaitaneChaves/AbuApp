package es.tta.abuapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PalabrasActivity extends AppCompatActivity {

    static final int AUDIO_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);
    }

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
            Toast.makeText(this, "LLEGO HASTA RESULT", Toast.LENGTH_SHORT).show();
            return;
        }

        switch(requestCode)
        {
            case AUDIO_REQUEST_CODE:
                playAudio(data.getData());
                break;
        }
    }

    public void playAudio(Uri uri)
    {
        LinearLayout layout_audio = (LinearLayout)findViewById(R.id.audio_layout);
        AudioPlayer ap = new AudioPlayer(layout_audio);
        try
        {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
            String pathAudio = cursor.getString(index);
            Uri uri_final = Uri.parse(pathAudio);
            ap.setAudioUri(uri_final);
        }
        catch(Exception e)
        {

        }
    }

    public void playAudio(View view)
    {
        LinearLayout layout_audio = (LinearLayout)findViewById(R.id.audio_layout);
        AudioPlayer ap = new AudioPlayer(layout_audio);
        try
        {
            ap.setAudioUri(Settings.System.DEFAULT_RINGTONE_URI);
        }
        catch(Exception e)
        {

        }
    }
}
