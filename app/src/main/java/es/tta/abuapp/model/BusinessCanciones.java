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

    public int getMax_canciones() {
        return max_canciones;
    }

    public BusinessCanciones (Client php){this.php=php;}


    public Canciones getCanciones(int indice) throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("canciones.php?indice=%d", indice));
        cancion.setTitulo(json.getString("palabra"));
        cancion.setVideo(json.getString("file"));
        return cancion;
    }
}
