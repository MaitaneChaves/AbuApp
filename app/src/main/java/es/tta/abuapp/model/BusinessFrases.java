package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;


public class BusinessFrases
{
    private Client php;
    private Frases frase = new Frases();

    public BusinessFrases (Client php){this.php=php;}


    public Frases getFrases(int indice, String tipo) throws IOException, JSONException
    {
        JSONObject json = null;
        if (tipo.compareTo("medico")==0)
        {
            json = php.getJson(String.format("medico.php?indice=%d", indice));
        }
        else if(tipo.compareTo("bar")==0)
        {
            json = php.getJson(String.format("bar.php?indice=%d", indice));
        }
        else if(tipo.compareTo("pan")==0)
        {
            json = php.getJson(String.format("pan.php?indice=%d", indice));
        }
        if(json!=null)
        {
            frase.setFrase_castellano(json.getString("castellano"));
            frase.setFrase_euskera(json.getString("euskera"));
            frase.setAudio(json.getString("audio"));
        }
        return frase;
    }

    public int devolverMaximoFrases(String tipo)
    {
        int max_frases = 0;
        if(tipo.compareTo("medico")==0)
        {
            max_frases = 3; //Valor de bbdd
        }
        else if(tipo.compareTo("bar")==0)
        {
            max_frases = 6; //Valor de bbdd
        }
        else if(tipo.compareTo("pan")==0)
        {
            max_frases = 6; //Valor de bbdd
        }
        return max_frases;
    }
}
