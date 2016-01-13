package es.tta.abuapp.model;

public class Frases {
    private String frase_euskera;
    private String frase_castellano;
    private String audio;
    private int next_frases;
    private String lugar;

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

    public int getNext_frases() {
        return next_frases;
    }

    public void setNext_frases(int next_frases) {
        this.next_frases = next_frases;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }



}
