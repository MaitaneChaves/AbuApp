package es.tta.abuapp.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import es.tta.abuapp.Client;

public class BusinessParejas {

    private Client php;
    private Parejas pareja=new Parejas();

    public BusinessParejas(Client php){this.php=php;}

    public Parejas getParejas () throws IOException, JSONException
    {
        JSONObject json = php.getJson(String.format("parejas.php?indice=%d", pareja.getPagina()));
        pareja.setImagen1(json.getString("i1"));
        pareja.setImagen2(json.getString("i2"));
        pareja.setImagen3(json.getString("i3"));
        pareja.setImagen4(json.getString("i4"));
        pareja.setImagen5(json.getString("i5"));
        pareja.setImagen6(json.getString("i6"));

        pareja.setPalabra1(json.getString("p1"));
        pareja.setPalabra2(json.getString("p2"));
        pareja.setPalabra3(json.getString("p3"));
        pareja.setPalabra4(json.getString("p4"));
        pareja.setPalabra5(json.getString("p5"));
        pareja.setPalabra6(json.getString("p6"));

        pareja.setComp1(json.getString("c1"));
        pareja.setComp2(json.getString("c2"));
        pareja.setComp3(json.getString("c3"));
        pareja.setComp4(json.getString("c4"));
        pareja.setComp5(json.getString("c5"));
        pareja.setComp6(json.getString("c6"));

        return pareja;
    }

    public boolean comprueba(String palabra, String comprobacion)
    {
        if (palabra.contentEquals(comprobacion))
        {
            int parejas_correctas=pareja.getParejas_correctas()+1;
            pareja.setParejas_correctas(parejas_correctas);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean juegoCompletado()
    {
        if(pareja.getParejas_correctas()==pareja.getParejas_totales())
        {
            int pagina=pareja.getPagina()+1;
            pareja.setPagina(pagina);
            pareja.setParejas_correctas(0);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean finJuego()
    {
        if(pareja.getPagina()>pareja.getMAX_PAG())
        {
            return true;
        }
        else{
            return false;
        }
    }

}
