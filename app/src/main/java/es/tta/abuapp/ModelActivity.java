package es.tta.abuapp;

import android.support.v7.app.AppCompatActivity;

public class ModelActivity extends AppCompatActivity
{
    public static final String URL = "http://vps213926.ovh.net/AbuApp";
    public Client php= new Client(URL);
}
