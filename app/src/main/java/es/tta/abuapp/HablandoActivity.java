package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import es.tta.abuapp.model.Audios;
import es.tta.abuapp.model.BusinessAudios;


public class HablandoActivity extends AppCompatActivity {
    private String URL = "http://vps213926.ovh.net/AbuApp";
    private Client php=new Client(URL);
    private BusinessAudios server=new BusinessAudios(php);
    private Audios audios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hablando);
    }

    public void palabras(View view) {
        new ProgressTask<Audios>(this) {
            @Override
            protected Audios work() throws Exception {
                audios = server.getAudios(1);
                return audios;

            }

            @Override
            protected void onFinish(Audios pareja) {

                Intent intent = new Intent(getApplicationContext(),PalabrasActivity.class);
                startActivity(intent);;

            }
        }.execute();

    }

    public void canciones(View view) {
        Intent intent = new Intent(this,CancionesActivity.class);
        startActivity(intent);
    }

}
