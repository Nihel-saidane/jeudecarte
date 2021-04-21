package com.atexo.JeuCartes.Models;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public class Carte  {

    private String couleur;
    private String valeur;

    public Carte(String couleur, String valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Carte() {
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
