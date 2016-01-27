package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;


public class BusinessCanciones
{
    private Client php;
    private Canciones cancion = new Canciones();
    private int max_canciones = 12; //Valor de bbdd
    private int num_pag = 1;

    public int getMax_canciones() {
        return max_canciones;
    }

    public BusinessCanciones (Client php){this.php=php;}


    public Canciones getCanciones() throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("canciones.php?indice=%d", num_pag));
        cancion.setTitulo(json.getString("palabra"));
        cancion.setVideo(json.getString("file"));
        num_pag++;
        return cancion;
    }

    public boolean finJuego()
    {
        if((num_pag-1)==max_canciones)
            return true;
        else
            return false;
    }
}
