package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;

/**
 * Created by Naiara on 24/01/2016.
 */
public class BusinessFrases
{
    private Client php;
    private Frases frase = new Frases();
    private int MAX_FRASES;

    public int getMAX_FRASES() {
        return MAX_FRASES;
    }

    public BusinessFrases (Client php){this.php=php;}


    public Frases getFrases(int indice, String tipo) throws IOException, JSONException
    {
        JSONObject json = null;
        if (tipo.compareTo("medico")==0)
        {
            MAX_FRASES = 3;  //PONER VERDADERO VALOR
            json = php.getJson(String.format("medico.php?indice=%d", indice));
        }
        else if(tipo.compareTo("bar")==0)
        {
            MAX_FRASES = 3;  //PONER VERDADERO VALOR
            json = php.getJson(String.format("bar.php?indice=%d", indice));
        }
        else if(tipo.compareTo("pan")==0)
        {
            MAX_FRASES = 3;  //PONER VERDADERO VALOR
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

    /*public String getFrasesTodas(String tipo) throws IOException, JSONException
    {
        JSONObject json = null;
        String script = null;
        String frases = null;

        if (tipo.compareTo("medico")==0)
        {
            script="medico.php?indice=";
            MAX_FRASES = 3;  //PONER VERDADERO VALOR
        }
        else if(tipo.compareTo("bar")==0)
        {
            script="bar.php?indice=";
            MAX_FRASES = 3;  //PONER VERDADERO VALOR
        }
        else if(tipo.compareTo("pan")==0)
        {
            script="pan.php?indice=";
            MAX_FRASES = 3;  //PONER VERDADERO VALOR
        }
        if(script!=null)
        {
            for(int i=1; i<=MAX_FRASES; i++)
            {
                json = php.getJson(String.format(script+i));
                frases = frases + "\n" + json.getString("castellano");
            }
        }
        return frases;
    }*/
}
