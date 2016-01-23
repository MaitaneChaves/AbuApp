package es.tta.abuapp.presentation;

import android.os.Bundle;

import es.tta.abuapp.model.Parejas;

public class DataParejas {

    private final static String EXTRA_PAREJAS_IMAGEN1 = "es.tta.abuapp.extra_parejas_imagen1";
    private final static String EXTRA_PAREJAS_IMAGEN2 = "es.tta.abuapp.extra_parejas_imagen2";
    private final static String EXTRA_PAREJAS_IMAGEN3 = "es.tta.abuapp.extra_parejas_imagen3";
    private final static String EXTRA_PAREJAS_IMAGEN4 = "es.tta.abuapp.extra_parejas_imagen4";
    private final static String EXTRA_PAREJAS_IMAGEN5 = "es.tta.abuapp.extra_parejas_imagen5";
    private final static String EXTRA_PAREJAS_IMAGEN6 = "es.tta.abuapp.extra_parejas_imagen6";

    private final static String EXTRA_PAREJAS_PALABRA1 = "es.tta.abuapp.extra_parejas_palabra1";
    private final static String EXTRA_PAREJAS_PALABRA2 = "es.tta.abuapp.extra_parejas_palabra2";
    private final static String EXTRA_PAREJAS_PALABRA3 = "es.tta.abuapp.extra_parejas_palabra3";
    private final static String EXTRA_PAREJAS_PALABRA4 = "es.tta.abuapp.extra_parejas_palabra4";
    private final static String EXTRA_PAREJAS_PALABRA5 = "es.tta.abuapp.extra_parejas_palabra5";
    private final static String EXTRA_PAREJAS_PALABRA6 = "es.tta.abuapp.extra_parejas_palabra6";

    private final static String EXTRA_PAREJAS_COMP1 = "es.tta.abuapp.extra_parejas_comp1";
    private final static String EXTRA_PAREJAS_COMP2 = "es.tta.abuapp.extra_parejas_comp2";
    private final static String EXTRA_PAREJAS_COMP3 = "es.tta.abuapp.extra_parejas_comp3";
    private final static String EXTRA_PAREJAS_COMP4 = "es.tta.abuapp.extra_parejas_comp4";
    private final static String EXTRA_PAREJAS_COMP5 = "es.tta.abuapp.extra_parejas_comp5";
    private final static String EXTRA_PAREJAS_COMP6 = "es.tta.abuapp.extra_parejas_comp6";


    private final static String EXTRA_PAREJAS_NEXT = "es.tta.abuapp.extra_parejas_next";


    private final Bundle bundle;

    public DataParejas(Bundle bundle){
        if (bundle==null)
            bundle=new Bundle();
        this.bundle=bundle;
    }

    public Bundle getBundle(){return bundle;}

    public void putParejas(Parejas parejas) {

        bundle.putString(EXTRA_PAREJAS_IMAGEN1, parejas.getImagen1());
        bundle.putString(EXTRA_PAREJAS_IMAGEN2, parejas.getImagen2());
        bundle.putString(EXTRA_PAREJAS_IMAGEN3, parejas.getImagen3());
        bundle.putString(EXTRA_PAREJAS_IMAGEN4, parejas.getImagen4());
        bundle.putString(EXTRA_PAREJAS_IMAGEN5, parejas.getImagen5());
        bundle.putString(EXTRA_PAREJAS_IMAGEN6, parejas.getImagen6());

        bundle.putString(EXTRA_PAREJAS_PALABRA1, parejas.getPalabra1());
        bundle.putString(EXTRA_PAREJAS_PALABRA2, parejas.getPalabra2());
        bundle.putString(EXTRA_PAREJAS_PALABRA3, parejas.getPalabra3());
        bundle.putString(EXTRA_PAREJAS_PALABRA4, parejas.getPalabra4());
        bundle.putString(EXTRA_PAREJAS_PALABRA5, parejas.getPalabra5());
        bundle.putString(EXTRA_PAREJAS_PALABRA6, parejas.getPalabra6());

        bundle.putString(EXTRA_PAREJAS_COMP1, parejas.getComp1());
        bundle.putString(EXTRA_PAREJAS_COMP2, parejas.getComp2());
        bundle.putString(EXTRA_PAREJAS_COMP3, parejas.getComp3());
        bundle.putString(EXTRA_PAREJAS_COMP4, parejas.getComp4());
        bundle.putString(EXTRA_PAREJAS_COMP5, parejas.getComp5());
        bundle.putString(EXTRA_PAREJAS_COMP6, parejas.getComp6());

        bundle.putInt(EXTRA_PAREJAS_NEXT, parejas.getNext_pareja());

    }

    public Parejas getParejas(){
        Parejas pareja=new Parejas();
        pareja.setNext_pareja(bundle.getInt(EXTRA_PAREJAS_NEXT));

        pareja.setPalabra1(bundle.getString(EXTRA_PAREJAS_PALABRA1));
        pareja.setPalabra2(bundle.getString(EXTRA_PAREJAS_PALABRA2));
        pareja.setPalabra3(bundle.getString(EXTRA_PAREJAS_PALABRA3));
        pareja.setPalabra4(bundle.getString(EXTRA_PAREJAS_PALABRA4));
        pareja.setPalabra5(bundle.getString(EXTRA_PAREJAS_PALABRA5));
        pareja.setPalabra6(bundle.getString(EXTRA_PAREJAS_PALABRA6));

        pareja.setComp1(bundle.getString(EXTRA_PAREJAS_COMP1));
        pareja.setComp2(bundle.getString(EXTRA_PAREJAS_COMP2));
        pareja.setComp3(bundle.getString(EXTRA_PAREJAS_COMP3));
        pareja.setComp4(bundle.getString(EXTRA_PAREJAS_COMP4));
        pareja.setComp5(bundle.getString(EXTRA_PAREJAS_COMP5));
        pareja.setComp6(bundle.getString(EXTRA_PAREJAS_COMP6));

        pareja.setImagen1(bundle.getString(EXTRA_PAREJAS_IMAGEN1));
        pareja.setImagen2(bundle.getString(EXTRA_PAREJAS_IMAGEN2));
        pareja.setImagen3(bundle.getString(EXTRA_PAREJAS_IMAGEN3));
        pareja.setImagen4(bundle.getString(EXTRA_PAREJAS_IMAGEN4));
        pareja.setImagen5(bundle.getString(EXTRA_PAREJAS_IMAGEN5));
        pareja.setImagen6(bundle.getString(EXTRA_PAREJAS_IMAGEN6));

        return pareja;
    }
}
