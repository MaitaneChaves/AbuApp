package es.tta.abuapp.presentation;

import android.os.Bundle;

import es.tta.abuapp.model.Huecos;
import es.tta.abuapp.model.Parejas;

/**
 * Created by Naiara on 15/01/2016.
 */
public class DataHuecos
{
    public final static String EXTRA_HUECOS_PALABRA_COMPLETA = "es.tta.abuapp.extra_huecos_palabra_completa";
    public final static String EXTRA_HUECOS_PALABRA_INCOMPLETA = "es.tta.abuapp.extra_huecos_palabra_incompleta";
    public final static String EXTRA_HUECOS_IMAGEN = "es.tta.abuapp.extra_huecos_imagen";
    public final Bundle bundle;

    public DataHuecos(Bundle bundle)
    {
        if (bundle==null)
            bundle=new Bundle();
        this.bundle=bundle;
    }

    public Bundle getBundle(){return bundle;}

    public void putHuecos(Huecos hueco)
    {
        bundle.putString(EXTRA_HUECOS_PALABRA_COMPLETA, hueco.getPalabra_completa());
        bundle.putString(EXTRA_HUECOS_PALABRA_INCOMPLETA, hueco.getPalabra_incompleta());
        bundle.putString(EXTRA_HUECOS_IMAGEN, hueco.getImagen());
    }
}
