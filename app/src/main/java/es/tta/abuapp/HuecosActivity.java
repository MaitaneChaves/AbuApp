package es.tta.abuapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import es.tta.abuapp.model.BusinessHuecos;
import es.tta.abuapp.model.Huecos;

public class HuecosActivity extends ModelActivity {

    private BusinessHuecos server;
    private Huecos hueco;

    private Bitmap imagen;
    private ImageView imgview;
    private String palabra_completa;
    private String palabra_incompleta;
    private TextView preguntaView;
    private TextView respuestaView;
    private int num_pag = 1;
    private int intentos_realizados = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huecos);

        imgview = (ImageView)findViewById(R.id.foto_huecos);
        preguntaView = (TextView)findViewById(R.id.texto_huecos);
        respuestaView = (TextView)findViewById(R.id.respuesta_huecos);

        server = new BusinessHuecos(php);

        siguienteHueco();
    }

    public void comprobar(View view)
    {
        intentos_realizados++;
        String respuesta = respuestaView.getText().toString();
        boolean correcto = server.comprobar(hueco.getPalabra_completa(), respuesta);
        if(correcto)
        {
            Toast.makeText(this,"CORRECTO", Toast.LENGTH_SHORT).show();
            intentos_realizados = 0;
            cargarHueco(view);
        }
        else
        {
            Toast.makeText(this,"INCORRECTO. Te quedan " + (server.getMax_intentos()-intentos_realizados) + "intentos", Toast.LENGTH_SHORT).show();
            if(!server.comprobarIntentosRestantes(intentos_realizados))
            {
                Toast.makeText(this,"Has llegado al máximo de intentos.", Toast.LENGTH_SHORT).show();
                intentos_realizados = 0;
                cargarHueco(view);
            }
        }

    }

    public void cargarHueco(View view)
    {
        siguienteHueco();
        respuestaView.setText("");
    }

    public void siguienteHueco()
    {
        if(num_pag<=server.getMax_huecos())
        {
            new ProgressTask<Huecos>(this)
            {
                @Override
                protected Huecos work() throws Exception {
                    hueco = server.getHuecos(num_pag);
                    num_pag++;
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
        }
        else
        {
            LinearLayout layoutEntero = (LinearLayout)findViewById(R.id.layout_huecos_entero);
            layoutEntero.removeAllViews();
            TextView txNuevo = new TextView(this);
            txNuevo.setText("AMAIERA");
            txNuevo.setGravity(Gravity.CENTER);
            txNuevo.setTextSize(70);
            layoutEntero.addView(txNuevo);
        }
    }
}
