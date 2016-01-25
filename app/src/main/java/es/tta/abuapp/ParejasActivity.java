package es.tta.abuapp;

import android.graphics.Bitmap;
import android.net.Uri;
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

    /*public static final String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php= new Client(URL);

    private int palabra=0;
    private int imagen=0;
    private BusinessParejas business=new BusinessParejas(php);
    private DataParejas data;
    private Bitmap foto1;
    private Parejas pareja;
    ImageView imagen1;

    Map<Integer, String> comprobacion = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data=new DataParejas(getIntent().getExtras());
        setContentView(R.layout.activity_parejas);



        TextView palabra1= (TextView)findViewById(R.id.palabra_parejas1);
        TextView palabra2= (TextView)findViewById(R.id.palabra_parejas2);
        TextView palabra3= (TextView)findViewById(R.id.palabra_parejas3);
        TextView palabra4= (TextView)findViewById(R.id.palabra_parejas4);
        TextView palabra5= (TextView)findViewById(R.id.palabra_parejas5);
        TextView palabra6= (TextView)findViewById(R.id.palabra_parejas6);

         imagen1= (ImageView)findViewById(R.id.foto_parejas1);
        ImageView imagen2= (ImageView)findViewById(R.id.foto_parejas2);
        ImageView imagen3= (ImageView)findViewById(R.id.foto_parejas3);
        ImageView imagen4= (ImageView)findViewById(R.id.foto_parejas4);
        ImageView imagen5= (ImageView)findViewById(R.id.foto_parejas5);
        ImageView imagen6= (ImageView)findViewById(R.id.foto_parejas6);

        pareja=data.getParejas();
        palabra1.setText(pareja.getPalabra1());
        palabra2.setText(pareja.getPalabra2());
        palabra3.setText(pareja.getPalabra3());
        palabra4.setText(pareja.getPalabra4());
        palabra5.setText(pareja.getPalabra5());
        palabra6.setText(pareja.getPalabra6());


        new ProgressTask<Bitmap>(this) {
            @Override
            protected Bitmap work() throws Exception {
                foto1 = php.downloadImage("imagenes/katua.jpg");
                return foto1;

            }

            @Override
            protected void onFinish(Bitmap foto1) {
                imagen1.setImageBitmap(foto1);

            }
        }.execute();


        //imagen1.setImageBitmap(im1);

        //imagen1.setImageURI(Uri.parse(URL+"/"+pareja.getImagen1()));
        imagen2.setImageURI(Uri.parse(URL+"/"+pareja.getImagen2()));
        imagen3.setImageURI(Uri.parse(URL+"/"+pareja.getImagen3()));
        imagen4.setImageURI(Uri.parse(URL+"/"+pareja.getImagen4()));
        imagen5.setImageURI(Uri.parse(URL+"/"+pareja.getImagen5()));
        imagen6.setImageURI(Uri.parse(URL+"/"+pareja.getImagen6()));
        System.out.println(pareja.getImagen1());
        System.out.println(pareja.getImagen2());
        System.out.println(pareja.getImagen3());
        System.out.println(pareja.getImagen4());
        System.out.println(pareja.getImagen5());
        System.out.println(pareja.getImagen6());

        comprobacion.put(R.id.foto_parejas1, pareja.getComp1());
        comprobacion.put(R.id.foto_parejas2, pareja.getComp2());
        comprobacion.put(R.id.foto_parejas3, pareja.getComp3());
        comprobacion.put(R.id.foto_parejas4, pareja.getComp4());
        comprobacion.put(R.id.foto_parejas5, pareja.getComp5());
        comprobacion.put(R.id.foto_parejas6, pareja.getComp6());

    }

    public void guardarPareja(View view){
        int pulsado=view.getId();

        if(pulsado>=R.id.foto_parejas1&&pulsado<=R.id.foto_parejas6)
            imagen=pulsado;

        else if(pulsado>=R.id.palabra_parejas1&&pulsado<=R.id.palabra_parejas6)
            palabra=pulsado;

        if(imagen!=0&&palabra!=0)
            comprueba();
    }

    private void comprueba(){
        TextView comp=(TextView)findViewById(palabra);

        String pareja=comprobacion.get(imagen);
        if (pareja==comp.getText())
            Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Incorrecto",Toast.LENGTH_SHORT).show();
        imagen=0;
        palabra=0;
    }
*/
}