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
    private int intentos_realizados = 0;
    private int num_pag = 1;

    public int getMax_intentos() {
        return max_intentos;
    }

    public int getIntentos_realizados() {
        return intentos_realizados;
    }

    public BusinessHuecos (Client php){this.php=php;}


    public Huecos getHuecos() throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("devulHuecos.php?indice=%d", num_pag));
        hueco.setPalabra_completa(json.getString("com"));
        hueco.setPalabra_incompleta(json.getString("inc"));
        String urlImagen = json.getString("loc");
        Bitmap imagen = php.downloadImage(urlImagen);
        hueco.setImagen(imagen);
        return hueco;
    }

    public int comprobar(String respuesta)
    {
        intentos_realizados++;
        if(intentos_realizados<max_intentos)
        {
            if(respuesta.toLowerCase().compareTo(hueco.getPalabra_completa())==0)
            {
                intentos_realizados = 0;
                num_pag++;
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            intentos_realizados = 0;
            num_pag++;
            return 2;
        }
    }

    public boolean finJuego()
    {
        if((num_pag-1)==max_huecos)
            return true;
        else
            return false;
    }
}
