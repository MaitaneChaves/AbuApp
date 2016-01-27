package es.tta.abuapp.model;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;


public class BusinessHuecos
{
    private Client php;
    private Huecos hueco = new Huecos();
    private int max_huecos = 20; //Valor de bbdd
    private int max_intentos = 3;

    public int getMax_huecos() {
        return max_huecos;
    }
    public int getMax_intentos() {
        return max_intentos;
    }

    public BusinessHuecos (Client php){this.php=php;}


    public Huecos getHuecos(int indice) throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("devulHuecos.php?indice=%d", indice));
        hueco.setPalabra_completa(json.getString("com"));
        hueco.setPalabra_incompleta(json.getString("inc"));
        String urlImagen = json.getString("loc");
        Bitmap imagen = php.downloadImage(urlImagen);
        hueco.setImagen(imagen);
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

    public boolean comprobarIntentosRestantes(int intentos_realizados)
    {
        if(intentos_realizados<max_intentos)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
