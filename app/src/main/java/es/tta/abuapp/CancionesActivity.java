package es.tta.abuapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import es.tta.abuapp.model.BusinessCanciones;
import es.tta.abuapp.model.Canciones;

public class CancionesActivity extends ModelActivity
{
    private BusinessCanciones server;
    private Canciones cancion;
    private int num_pag = 1;
    private TextView tituloView;
    private VideoView video;
    private MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);

        tituloView = (TextView)findViewById(R.id.texto_canciones);

        server = new BusinessCanciones(php);

        //Creo videoview solo 1 vez
        video = new VideoView(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        video.setLayoutParams(params);
        controller = new MediaController(this)
        {
            /*@Override
            public void hide()
            {}*/

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

        //Cargo la primera cancion
        siguienteCancion();
    }


    public void playVideo(String urlCancion)
    {
        LinearLayout layout = (LinearLayout)findViewById(R.id.canciones_layout);
        layout.removeView(video);

        String urlCompleta = URL + "/" + urlCancion;
        video.setVideoURI(Uri.parse(urlCompleta));

        layout.addView(video);
        video.start();
    }

    public void cargarCancion(View view)
    {
        siguienteCancion();
    }

    public void siguienteCancion()
    {
        if(num_pag<=server.getMax_canciones())
        {
            new ProgressTask<Canciones>(this) {
                @Override
                protected Canciones work() throws Exception {
                    cancion = server.getCanciones(num_pag);
                    return cancion;
                }

                @Override
                protected void onFinish(Canciones cancion) {
                    tituloView.setText(cancion.getTitulo());
                    String urlCancion = cancion.getVideo();
                    playVideo(urlCancion);
                    num_pag++;
                }
            }.execute();
        }
        else
        {
            LinearLayout layoutEntero = (LinearLayout)findViewById(R.id.layout_canciones_entero);
            layoutEntero.removeAllViews();
            controller.hide();
            TextView txNuevo = new TextView(this);
            txNuevo.setText("AMAIERA");
            txNuevo.setGravity(Gravity.CENTER);
            txNuevo.setTextSize(70);
            layoutEntero.addView(txNuevo);
        }
    }
}
