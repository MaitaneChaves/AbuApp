package es.tta.abuapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
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
    private String palabra_incompleta;
    private TextView preguntaView;
    private EditText respuestaView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huecos);

        imgview = (ImageView)findViewById(R.id.foto_huecos);
        preguntaView = (TextView)findViewById(R.id.texto_huecos);
        respuestaView = (EditText)findViewById(R.id.respuesta_huecos);

        server = new BusinessHuecos(php);

        siguienteHueco();
    }

    public void comprobar(View view)
    {
        String respuesta = respuestaView.getText().toString();
        if(respuesta==null || respuesta.isEmpty())
        {
            Toast.makeText(this,"Debes introducir un valor", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int comp = server.comprobar(respuesta);
            if(comp==0) //respuesta correcta
            {
                cargarHueco(view);
            }
            else if(comp==1) //respuesta incorrecta
            {
                Toast.makeText(this,"INCORRECTO. Te quedan " + (server.getMax_intentos()-server.getIntentos_realizados()) + " intentos", Toast.LENGTH_SHORT).show();
            }
            else //llegado a maximo de intentos
            {
                Toast.makeText(this,"Has llegado al máximo de intentos", Toast.LENGTH_SHORT).show();
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
        if(!server.finJuego())
        {
            new ProgressTask<Huecos>(this)
            {
                @Override
                protected Huecos work() throws Exception {
                    hueco = server.getHuecos();
                    palabra_incompleta = hueco.getPalabra_incompleta();
                    imagen = hueco.getImagen();
                    return hueco;
                }

                @Override
                protected void onFinish(Huecos hueco) {
                    preguntaView.setText(palabra_incompleta);
                    respuestaView.setHint(palabra_incompleta);
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
            txNuevo.setTextColor(Color.WHITE);
            txNuevo.setGravity(Gravity.CENTER);
            txNuevo.setTextSize(70);
            layoutEntero.addView(txNuevo);
        }
    }
}
