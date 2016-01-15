package es.tta.abuapp.presentation;

import android.os.Bundle;

public class Data {

    private final static String  = "es.tta.ejemploclase.user";

    private final Bundle bundle;

    public Data(Bundle bundle){
        if (bundle==null)
            bundle=new Bundle();
        this.bundle=bundle;
    }

    public Bundle getBundle(){return bundle;}


}
