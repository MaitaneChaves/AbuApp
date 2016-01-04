package es.tta.abuapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class CancionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);
    }


    //private void showVideo(String advise)
    public void playVideo(View view)
    {
        VideoView video = new VideoView(this);
        //video.setVideoURI(Uri.parse(advise));
        video.setVideoURI(Uri.parse("http://www.semanticdevlab.com/abc.mp4"));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        video.setLayoutParams(params);

        MediaController controller = new MediaController(this)
        {
            @Override
            public void hide()
            {}

            @Override
            public boolean dispatchKeyEvent(KeyEvent event)
            {
                if(event.getKeyCode()==KeyEvent.KEYCODE_BACK)
                {
                    finish();
                }
                return super.dispatchKeyEvent(event);
            }
        };
        controller.setAnchorView(video);
        video.setMediaController(controller);

        LinearLayout layout = (LinearLayout)findViewById(R.id.canciones_layout);
        layout.addView(video);
        video.start();
    }

}
