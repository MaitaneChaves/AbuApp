package es.tta.abuapp.model;

public class Audios
{
    private String titulo;
    private String audio;

    private final int MAX_PAG=29;

    private int pagina=1;

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getMAX_PAG()
    {
        return MAX_PAG;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

}
