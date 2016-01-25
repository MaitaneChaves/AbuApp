package es.tta.abuapp.model;

public class Frases {
    private String frase_euskera;
    private String frase_castellano;
    private String audio;

    public String getFrase_euskera() {
        return frase_euskera;
    }

    public void setFrase_euskera(String frase_euskera) {
        this.frase_euskera = frase_euskera;
    }

    public String getFrase_castellano() {
        return frase_castellano;
    }

    public void setFrase_castellano(String frase_castellano) {
        this.frase_castellano = frase_castellano;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
