package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import es.tta.abuapp.ProgressTask;
import es.tta.abuapp.model.Business;
import es.tta.abuapp.model.Parejas;

public class JuegosActivity extends ModelActivity {

    private Parejas pareja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);
    }

    public void parejas(View view)
    {
        new ProgressTask<Parejas>(this) {
            @Override
            protected Parejas work() throws Exception {
                pareja = server.getParejas(1);
                return pareja;

            }

            @Override
            protected void onFinish(Parejas pareja) {
                //data.putStatus(s);
                data.putParejas(pareja);
                startModelActivity(ParejasActivity.class);

            }
        }.execute();
        Intent intent = new Intent(this,ParejasActivity.class);
        startActivity(intent);


    }

    public void huecos(View view)
    {
        Intent intent = new Intent(this,HuecosActivity.class);
        startActivity(intent);
    }


}
