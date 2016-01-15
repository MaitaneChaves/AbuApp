package es.tta.abuapp.model;

public class Canciones
{
    private String titulo;
    private String video;
    private int nextCanciones;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getNextCanciones() {
        return nextCanciones;
    }

    public void setNextCanciones(int nextCanciones) {
        this.nextCanciones = nextCanciones;
    }
}
