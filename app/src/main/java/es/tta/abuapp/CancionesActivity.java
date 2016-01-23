package es.tta.abuapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import es.tta.abuapp.model.BusinessCanciones;
import es.tta.abuapp.model.BusinessHuecos;
import es.tta.abuapp.model.Canciones;
import es.tta.abuapp.presentation.DataHuecos;

public class CancionesActivity extends AppCompatActivity
{
    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php= new Client(URL);
    private BusinessCanciones server;
    private Canciones cancion;
    //private DataCanciones data;

    private int num_pag = 1;
    private TextView tituloView;
    private String urlCancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);

        tituloView = (TextView)findViewById(R.id.texto_canciones);

        php = new Client(URL);
        server = new BusinessCanciones(php);
        //data = new DataCanciones(getIntent().getExtras());

        //siguienteCancion(View view);
    }


    public void playVideo(View view)
    {
        VideoView video = new VideoView(this);
        String[] partes = urlCancion.split("\\/");
        Toast.makeText(this, URL + "/videos/" + partes[1], Toast.LENGTH_SHORT).show();
        video.setVideoURI(Uri.parse(URL + "/videos/" + partes[1]));
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


    public void siguienteCancion(View view)
    {
        new ProgressTask<Canciones>(this)
        {
            @Override
            protected Canciones work() throws Exception {
                cancion = server.getCanciones(num_pag);
                return cancion;
            }

            @Override
            protected void onFinish(Canciones cancion) {
                tituloView.setText(cancion.getTitulo());
                urlCancion = cancion.getVideo();

                //
                String[] partes = urlCancion.split("\\/");
                System.out.println(URL + "/videos/" + partes[1]);
                //
            }
        }.execute();

        num_pag++;

        playVideo(view);
    }

}
