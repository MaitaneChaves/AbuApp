package es.tta.abuapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import es.tta.abuapp.model.BusinessParejas;
import es.tta.abuapp.model.Parejas;

public class ParejasActivity extends AppCompatActivity {

    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php= new Client(URL);

    private int palabra=0;
    private int imagen=0;
    private BusinessParejas server=new BusinessParejas(php);
    private Bitmap foto1;
    private Bitmap foto2;
    private Bitmap foto3;
    private Bitmap foto4;
    private Bitmap foto5;
    private Bitmap foto6;
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
    private int pagina=1;

    Map<Integer, String> comprobacion = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas);

        palabra1= (TextView)findViewById(R.id.palabra_parejas1);
        palabra2= (TextView)findViewById(R.id.palabra_parejas2);
        palabra3= (TextView)findViewById(R.id.palabra_parejas3);
        palabra4= (TextView)findViewById(R.id.palabra_parejas4);
        palabra5= (TextView)findViewById(R.id.palabra_parejas5);
        palabra6= (TextView)findViewById(R.id.palabra_parejas6);

        imagen1=(ImageView)findViewById(R.id.foto_parejas1);
        imagen2=(ImageView)findViewById(R.id.foto_parejas2);
        imagen3=(ImageView)findViewById(R.id.foto_parejas3);
        imagen4=(ImageView)findViewById(R.id.foto_parejas4);
        imagen5=(ImageView)findViewById(R.id.foto_parejas5);
        imagen6=(ImageView)findViewById(R.id.foto_parejas6);

        new ProgressTask<Parejas>(this) {
            @Override
            protected Parejas work() throws Exception {
                pareja = server.getParejas(1);
                return pareja;
            }

            @Override
            protected void onFinish(Parejas pareja) {
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



       new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen1());
                return foto1;
            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen1.setImageBitmap(foto1);
            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto2 = php.downloadImage(pareja.getImagen2());
                return foto2;
            }

            @Override
            protected void onFinish(Bitmap foto2) {
                imagen2.setImageBitmap(foto2);
            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto3 = php.downloadImage(pareja.getImagen3());
                return foto3;
            }

            @Override
            protected void onFinish(Bitmap foto3) {
                imagen3.setImageBitmap(foto3);
            }
        }.execute();
        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto4 = php.downloadImage(pareja.getImagen4());
                return foto4;
            }

            @Override
            protected void onFinish(Bitmap foto4) {
                imagen4.setImageBitmap(foto4);
            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto5 = php.downloadImage(pareja.getImagen5());
                return foto5;
            }

            @Override
            protected void onFinish(Bitmap foto5) {
                imagen5.setImageBitmap(foto5);
            }
        }.execute();
        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto6 = php.downloadImage(pareja.getImagen6());
                return foto6;
            }

            @Override
            protected void onFinish(Bitmap foto6) {
                imagen6.setImageBitmap(foto6);
            }
        }.execute();




    }

    public void guardarPareja(View view){
        int pulsado=view.getId();

        if(pulsado>=R.id.foto_parejas1&&pulsado<=R.id.foto_parejas6) {
            imagen = pulsado;
        }

        else if(pulsado>=R.id.palabra_parejas1&&pulsado<=R.id.palabra_parejas6) {
            palabra = pulsado;
        }

        if(imagen!=0&&palabra!=0){
            comprueba();
            //boolean comprobacion=comprueba();
        }

    }

    private void comprueba(){
        TextView comp=(TextView)findViewById(palabra);
        String pareja=comprobacion.get(imagen);
        System.out.println(pareja + "    " + comp.getText());
        if (pareja.contentEquals(comp.getText()))
            Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Incorrecto",Toast.LENGTH_SHORT).show();
        imagen=0;
        palabra=0;
    }




    public void siguiente_parejas(View view){
        pagina++;
        new ProgressTask<Parejas>(this) {
            @Override
            protected Parejas work() throws Exception {
                pareja = server.getParejas(pagina);
                return pareja;

            }

            @Override
            protected void onFinish(Parejas pareja) {
                palabra1.setText(pareja.getPalabra1());
                palabra2.setText(pareja.getPalabra2());
                palabra3.setText(pareja.getPalabra3());
                palabra4.setText(pareja.getPalabra4());
                palabra5.setText(pareja.getPalabra5());
                palabra6.setText(pareja.getPalabra6());


            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen1());
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen1.setImageBitmap(foto1);

            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen2());
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen2.setImageBitmap(foto1);

            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen3());
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen3.setImageBitmap(foto1);

            }
        }.execute();
        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen4());
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen4.setImageBitmap(foto1);

            }
        }.execute();

        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen5());
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen5.setImageBitmap(foto1);

            }
        }.execute();
        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage(pareja.getImagen6());
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen6.setImageBitmap(foto1);

            }
        }.execute();

        comprobacion.put(R.id.foto_parejas1, pareja.getComp1());
        comprobacion.put(R.id.foto_parejas2, pareja.getComp2());
        comprobacion.put(R.id.foto_parejas3, pareja.getComp3());
        comprobacion.put(R.id.foto_parejas4, pareja.getComp4());
        comprobacion.put(R.id.foto_parejas5, pareja.getComp5());
        comprobacion.put(R.id.foto_parejas6, pareja.getComp6());
    }



}