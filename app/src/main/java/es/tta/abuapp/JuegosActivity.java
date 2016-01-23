package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import es.tta.abuapp.ProgressTask;
import es.tta.abuapp.model.BusinessParejas;
import es.tta.abuapp.model.BusinessHuecos;
import es.tta.abuapp.model.Huecos;
import es.tta.abuapp.model.Parejas;
import es.tta.abuapp.presentation.DataParejas;
import es.tta.abuapp.presentation.DataHuecos;

public class JuegosActivity extends ModelActivity {

    private Parejas pareja;
    private Huecos hueco;
    private String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php;

    //HUECOS
    private BusinessHuecos server;
    private DataHuecos data;
    //

    //PAREJAS//
    private BusinessParejas serverParejas;
    private DataParejas dataParejas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        //HUECOS
        php = new Client(URL);
        server = new BusinessHuecos(php);
        data = new DataHuecos(getIntent().getExtras());
    }

    public void parejas(View view)
    {
        new ProgressTask<Parejas>(this) {
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
                intent.putExtras(data.getBundle());
                startActivity(intent);

            }
        }.execute();
        Intent intent = new Intent(this,ParejasActivity.class);
        startActivity(intent);


    }

    public void huecos(View view)
    {
        new ProgressTask<Huecos>(this)
        {
            @Override
            protected Huecos work() throws Exception {
                hueco = server.getHuecos(1);
                return hueco;
            }

            @Override
            protected void onFinish(Huecos hueco) {
                data.putHuecos(hueco);
                Intent intent=new Intent(getApplicationContext(), HuecosActivity.class);
                intent.putExtras(data.getBundle());
                startActivity(intent);
            }
        }.execute();
    }
}
