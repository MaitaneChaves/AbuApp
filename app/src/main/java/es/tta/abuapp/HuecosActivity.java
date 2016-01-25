package es.tta.abuapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import es.tta.abuapp.model.BusinessHuecos;
import es.tta.abuapp.model.Huecos;

public class HuecosActivity extends AppCompatActivity {

    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php= new Client(URL);
    private BusinessHuecos server;
    private Huecos hueco;

    private Bitmap imagen;
    private ImageView imgview;
    private String palabra_completa;
    private String palabra_incompleta;
    private TextView preguntaView;
    private TextView respuestaView;
    private int num_pag = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huecos);

        imgview = (ImageView)findViewById(R.id.foto_huecos);
        preguntaView = (TextView)findViewById(R.id.texto_huecos);
        respuestaView = (TextView)findViewById(R.id.respuesta_huecos);

        php = new Client(URL);
        server = new BusinessHuecos(php);

        //siguienteHueco(View view);
    }

    public void comprobar(View view)
    {
        String respuesta = respuestaView.getText().toString();
        boolean correcto = server.comprobar(hueco.getPalabra_completa(), respuesta);
        if(correcto)
        {
            Toast.makeText(this,"CORRECTO", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"INCORRECTO", Toast.LENGTH_SHORT).show();
        }
    }

    public void siguienteHueco(View view)
    {
        new ProgressTask<Huecos>(this)
        {
            @Override
            protected Huecos work() throws Exception {
                hueco = server.getHuecos(num_pag);
                palabra_completa = hueco.getPalabra_completa();
                palabra_incompleta = hueco.getPalabra_incompleta();
                return hueco;
            }

            @Override
            protected void onFinish(Huecos hueco) {
                preguntaView.setText(palabra_incompleta);
                respuestaView.setHint(palabra_incompleta);
            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                imagen = php.downloadImage(hueco.getImagen());
                return imagen;
            }

            @Override
            protected void onFinish(Bitmap imagen) {
                imgview.setImageBitmap(imagen);
            }
        }.execute();

        num_pag++;
    }
}
