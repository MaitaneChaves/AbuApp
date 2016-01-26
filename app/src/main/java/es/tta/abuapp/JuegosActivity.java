package es.tta.abuapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import es.tta.abuapp.model.BusinessParejas;
import es.tta.abuapp.model.BusinessHuecos;
import es.tta.abuapp.model.Huecos;
import es.tta.abuapp.model.Parejas;

public class JuegosActivity extends AppCompatActivity {

    private Parejas pareja;
    private Huecos hueco;
    private String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php;

    //HUECOS
    private BusinessHuecos server;
    //private DataHuecos data;
    private Bitmap imagenHuecos;
    public Intent intentHuecos;
    //

    //PAREJAS//
    private BusinessParejas serverParejas;
    //private DataParejas dataParejas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        //HUECOS
        php = new Client(URL);
        server = new BusinessHuecos(php);
    }

    public void parejas(View view)
    {
        /*new ProgressTask<Parejas>(this) {
            @Override
            protected Parejas work() throws Exception {
                pareja = serverParejas.getParejas(1);
                return pareja;

            }

            @Override
            protected void onFinish(Parejas pareja) {
                //data.putStatus(s);
                dataParejas.putParejas(pareja);
                Intent intent=new Intent(getApplicationContext(), ParejasActivity.class);
                intent.putExtras(dataParejas.getBundle());
                System.out.println("LLAMO A START ACTIVITY");
                startActivity(intent);

            }
        }.execute();*/

        Intent intent = new Intent(this,ParejasActivity.class);
        startActivity(intent);
    }

    public void huecos(View view)
    {
        /*new ProgressTask<Huecos>(this)
        {
            @Override
            protected Huecos work() throws Exception {
                hueco = server.getHuecos(1);
                return hueco;
            }

            @Override
            protected void onFinish(Huecos hueco) {
                data.putHuecos(hueco);
                intentHuecos=new Intent(getApplicationContext(), HuecosActivity.class);
                //intentHuecos.putExtras(data.getBundle());
                //startActivity(intentHuecos);
            }
        }.execute();
        */
        Intent intent = new Intent(this,HuecosActivity.class);
        startActivity(intent);
    }
}
