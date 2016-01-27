package es.tta.abuapp.model;

import android.graphics.Bitmap;

public class Huecos {
    private String palabra_completa;
    private String palabra_incompleta;
    private Bitmap imagen;

    public String getPalabra_completa() {
        return palabra_completa;
    }

    public void setPalabra_completa(String palabra_completa) {
        this.palabra_completa = palabra_completa;
    }

    public String getPalabra_incompleta() {
        return palabra_incompleta;
    }

    public void setPalabra_incompleta(String palabra_incompleta) {
        this.palabra_incompleta = palabra_incompleta;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
