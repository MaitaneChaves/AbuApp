package es.tta.abuapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import es.tta.abuapp.model.BusinessParejas;
import es.tta.abuapp.model.Parejas;

public class ParejasActivity extends ModelActivity {

    private int palabra=0;
    private int imagen=0;

    private BusinessParejas server=new BusinessParejas(php);

    private Bitmap foto1;

    private Parejas pareja;

    private ImageView imagen1;
    private ImageView imagen2;
    private ImageView imagen3;
    private ImageView imagen4;
    private ImageView imagen5;
    private ImageView imagen6;

    private TextView palabra1;
    private TextView palabra2;
    private TextView palabra3;
    private TextView palabra4;
    private TextView palabra5;
    private TextView palabra6;

    Map<Integer, String> comprobacion = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas);

        palabra1=(TextView)findViewById(R.id.palabra_parejas1);
        palabra2=(TextView)findViewById(R.id.palabra_parejas2);
        palabra3=(TextView)findViewById(R.id.palabra_parejas3);
        palabra4=(TextView)findViewById(R.id.palabra_parejas4);
        palabra5=(TextView)findViewById(R.id.palabra_parejas5);
        palabra6=(TextView)findViewById(R.id.palabra_parejas6);

        imagen1=(ImageView)findViewById(R.id.foto_parejas1);
        imagen2=(ImageView)findViewById(R.id.foto_parejas2);
        imagen3=(ImageView)findViewById(R.id.foto_parejas3);
        imagen4=(ImageView)findViewById(R.id.foto_parejas4);
        imagen5=(ImageView)findViewById(R.id.foto_parejas5);
        imagen6=(ImageView)findViewById(R.id.foto_parejas6);

        cargaJuego();
    }

    public void guardarPareja(View view)
    {
        int pulsado=view.getId();

        //si se ha pulsado la imagen se guarda en la variable imagen y si es un texto se guarda en palabra
        if(pulsado>=R.id.foto_parejas1&&pulsado<=R.id.foto_parejas6)
        {
            imagen = pulsado;
        }

        else if(pulsado>=R.id.palabra_parejas1&&pulsado<=R.id.palabra_parejas6)
        {
            palabra = pulsado;
        }

        //si se han pulsado las dos se llama a comprueba
        if(imagen!=0&&palabra!=0) {
            comprueba();
        }
    }

    private void comprueba()
    {
        TextView comp=(TextView)findViewById(palabra);
        ImageView im=(ImageView)findViewById(imagen);
        String pareja=comprobacion.get(imagen);

        //para comprobar se llama al modelo
        boolean correcto=server.comprueba(pareja,comp.getText().toString());

        if (correcto)
        {
            comp.setVisibility(View.INVISIBLE);
            im.setVisibility(View.INVISIBLE);
            if(server.juegoCompletado()==true)
            {
                cargaJuego();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
        }
        imagen=0;
        palabra=0;
    }

    public void cargaJuego()
    {
        if(server.finJuego()==false)
        {
            new ProgressTask<Parejas>(this)
            {
                @Override
                protected Parejas work() throws Exception
                {
                    pareja = server.getParejas();
                    return pareja;
                }

                @Override
                protected void onFinish(Parejas pareja)
                {
                    imagen1.setVisibility(View.VISIBLE);
                    imagen2.setVisibility(View.VISIBLE);
                    imagen3.setVisibility(View.VISIBLE);
                    imagen4.setVisibility(View.VISIBLE);
                    imagen5.setVisibility(View.VISIBLE);
                    imagen6.setVisibility(View.VISIBLE);

                    palabra1.setVisibility(View.VISIBLE);
                    palabra2.setVisibility(View.VISIBLE);
                    palabra3.setVisibility(View.VISIBLE);
                    palabra4.setVisibility(View.VISIBLE);
                    palabra5.setVisibility(View.VISIBLE);
                    palabra6.setVisibility(View.VISIBLE);

                    palabra1.setText(pareja.getPalabra1());
                    palabra2.setText(pareja.getPalabra2());
                    palabra3.setText(pareja.getPalabra3());
                    palabra4.setText(pareja.getPalabra4());
                    palabra5.setText(pareja.getPalabra5());
                    palabra6.setText(pareja.getPalabra6());

                    comprobacion.put(R.id.foto_parejas1, pareja.getComp1());
                    comprobacion.put(R.id.foto_parejas2, pareja.getComp2());
                    comprobacion.put(R.id.foto_parejas3, pareja.getComp3());
                    comprobacion.put(R.id.foto_parejas4, pareja.getComp4());
                    comprobacion.put(R.id.foto_parejas5, pareja.getComp5());
                    comprobacion.put(R.id.foto_parejas6, pareja.getComp6());
                }
            }.execute();

            new ProgressTask<Bitmap>(this)
            {
                @Override
                protected Bitmap work() throws Exception
                {
                    foto1 = php.downloadImage(pareja.getImagen1());
                    return foto1;
                }

                @Override
                protected void onFinish(Bitmap foto1)
                {
                    imagen1.setImageBitmap(foto1);
                }
            }.execute();

            new ProgressTask<Bitmap>(this)
            {
                @Override
                protected Bitmap work() throws Exception
                {
                    foto1 = php.downloadImage(pareja.getImagen2());
                    return foto1;
                }

                @Override
                protected void onFinish(Bitmap foto1)
                {
                    imagen2.setImageBitmap(foto1);
                }
            }.execute();

            new ProgressTask<Bitmap>(this)
            {
                @Override
                protected Bitmap work() throws Exception
                {
                    foto1 = php.downloadImage(pareja.getImagen3());
                    return foto1;
                }

                @Override
                protected void onFinish(Bitmap foto1)
                {
                    imagen3.setImageBitmap(foto1);
                }
            }.execute();

            new ProgressTask<Bitmap>(this)
            {
                @Override
                protected Bitmap work() throws Exception
                {
                    foto1 = php.downloadImage(pareja.getImagen4());
                    return foto1;
                }

                @Override
                protected void onFinish(Bitmap foto1)
                {
                    imagen4.setImageBitmap(foto1);
                }
            }.execute();

            new ProgressTask<Bitmap>(this)
            {
                @Override
                protected Bitmap work() throws Exception
                {
                    foto1 = php.downloadImage(pareja.getImagen5());
                    return foto1;
                }

                @Override
                protected void onFinish(Bitmap foto1)
                {
                    imagen5.setImageBitmap(foto1);
                }
            }.execute();

            new ProgressTask<Bitmap>(this)
            {
                @Override
                protected Bitmap work() throws Exception
                {
                    foto1 = php.downloadImage(pareja.getImagen6());
                    return foto1;
                }

                @Override
                protected void onFinish(Bitmap foto1)
                {
                    imagen6.setImageBitmap(foto1);
                }
            }.execute();
        }

        else
        {
            LinearLayout layout=(LinearLayout)findViewById(R.id.layout_parejas);
            layout.removeAllViews();
            TextView final_parejas=new TextView(this);
            final_parejas.setText("AMAIERA");
            final_parejas.setGravity(Gravity.CENTER);
            final_parejas.setTextSize(70);
            final_parejas.setTextColor(Color.WHITE);
            layout.addView(final_parejas);
        }

    }

}