package es.tta.abuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import es.tta.abuapp.model.Business;
import es.tta.abuapp.presentation.Data;


public abstract class ModelActivity extends AppCompatActivity {
    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    protected Client php;
    protected Business server;
    protected Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        data =new Data(getIntent().getExtras());
        php = new Client(URL);
        server=new Business(php);
    }

    protected <T> void startModelActivity(Class<T> cls){
        Intent intent=newIntent(cls);
        startActivity(intent);
    }

    protected <T> void startModelActivityForResult(Class<T> cls, int requestCode){
        Intent intent=newIntent(cls);
        startActivityForResult(intent, requestCode);
    }

    protected <T> Intent newIntent(Class<T> cls){
        Intent intent=new Intent(getApplicationContext(), cls);
        intent.putExtras(data.getBundle());
        return intent;

    }

}
