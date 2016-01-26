package es.tta.abuapp;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by maitane on 26/01/16.
 */
public class ModelActivity extends AppCompatActivity {
    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    public Client php= new Client(URL);
}
