package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;

public class BusinessAudios {

    private Client php;
    private Audios audios = new Audios();

    public int getMAX_PAG() {
        return MAX_PAG;
    }

    private final int MAX_PAG=29;

    public BusinessAudios(Client php) {
        this.php = php;
    }

    public Audios getAudios(int indice) throws IOException, JSONException {
        JSONObject json = php.getJson(String.format("audios.php?indice=%d", indice));
        audios.setTitulo(json.getString("palabra"));
        audios.setAudio(json.getString("file"));
        return audios;
    }
}
