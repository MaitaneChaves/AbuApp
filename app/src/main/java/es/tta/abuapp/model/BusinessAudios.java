package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;

public class BusinessAudios {

    private Client php;
    private Audios audios = new Audios();

    private final int MAX_PAG=29;

    private int pagina=1;

    public BusinessAudios(Client php)
    {
        this.php = php;
    }

    public Audios getAudios() throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("audios.php?indice=%d", pagina));
        audios.setTitulo(json.getString("palabra"));
        audios.setAudio(json.getString("file"));
        return audios;
    }

    public boolean finAudios()
    {
        pagina++;
        System.out.println("La pagina en la que estoy es: "+pagina);
        if(pagina>MAX_PAG)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
