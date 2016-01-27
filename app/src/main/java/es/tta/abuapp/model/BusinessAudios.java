package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;

public class BusinessAudios {

    private Client php;
    private Audios audios = new Audios();

    public BusinessAudios(Client php)
    {
        this.php = php;
    }

    public Audios getAudios() throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("audios.php?indice=%d", audios.getPagina()));
        audios.setTitulo(json.getString("palabra"));
        audios.setAudio(json.getString("file"));
        return audios;
    }

    public boolean finAudios()
    {
        int pagina=audios.getPagina();
        pagina++;
        System.out.println("La pagina en la que estoy es: "+pagina);
        if(pagina>audios.getMAX_PAG())
        {
            return true;
        }
        else{
            audios.setPagina(pagina);
            return false;
        }
    }}
