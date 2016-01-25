package es.tta.abuapp.presentation;

import android.os.Bundle;

import es.tta.abuapp.model.Audios;

/**
 * Created by maitane on 25/01/16.
 */
public class DataAudios {
    private final static String EXTRA_AUDIOS_TITULO = "es.tta.abuapp.extra_audios_euskera";
    private final static String EXTRA_AUDIOS_AUDIO = "es.tta.abuapp.extra_audios_audio";

    private final Bundle bundle;

    public DataAudios(Bundle bundle){
        if (bundle==null)
            bundle=new Bundle();
        this.bundle=bundle;
    }

    public Bundle getBundle(){return bundle;}

    public void putAudios(Audios audios) {
        bundle.putString(EXTRA_AUDIOS_TITULO, audios.getTitulo());
        bundle.putString(EXTRA_AUDIOS_AUDIO, audios.getAudio());
    }

    public Audios getAudios() {
        Audios audios = new Audios();

        audios.setAudio(bundle.getString(EXTRA_AUDIOS_AUDIO));
        audios.setTitulo(bundle.getString(EXTRA_AUDIOS_TITULO));
        return audios;
    }
}
