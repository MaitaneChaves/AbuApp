package es.tta.abuapp.model;

import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import es.tta.abuapp.Client;

/**
 * Created by Naiara on 15/01/2016.
 */
public class BusinessHuecos
{
    private Client php;
    private Huecos hueco = new Huecos();

    public BusinessHuecos (Client php){this.php=php;}


    public Huecos getHuecos(int indice) throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("devulHuecos.php?indice=%d", indice));
        hueco.setPalabra_completa(json.getString("com"));
        hueco.setPalabra_incompleta(json.getString("inc"));
        hueco.setImagen(json.getString("loc"));
        return hueco;
    }

    public boolean comprobar(String palabra_completa, String respuesta)
    {
        if(respuesta.toLowerCase().compareTo(palabra_completa)==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
