package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;

/**
 * Created by Naiara on 23/01/2016.
 */
public class BusinessAudios
{
    private Client php;
    private Audios audio = new Audios();

    public BusinessAudios (Client php){this.php=php;}


    public Audios getAudios(int indice) throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("audios.php?indice=%d", indice));
        audio.setTitulo(json.getString("palabra"));
        audio.setAudio(json.getString("file"));
        return audio;
    }



}
