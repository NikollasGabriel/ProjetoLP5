/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author rwspa
 */
public class Prova {
    private Nota valorProva;
    private Nota media;
    private Nota notaTirada;

    /**
     * @return the valorProva
     */
    public Nota getValorProva() {
        return valorProva;
    }

    /**
     * @param valorProva the valorProva to set
     */
    public void setValorProva(Nota valorProva) {
        this.valorProva = valorProva;
    }

    /**
     * @return the media
     */
    public Nota getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Nota media) {
        this.media = media;
    }

    /**
     * @return the notaTirada
     */
    public Nota getNotaTirada() {
        return notaTirada;
    }

    /**
     * @param notaTirada the notaTirada to set
     */
    public void setNotaTirada(Nota notaTirada) {
        this.notaTirada = notaTirada;
    }
}
