package es.tta.abuapp.model;

public class Huecos {
    private String palabra_completa;
    private String palabra_incompleta;
    private String imagen;

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
