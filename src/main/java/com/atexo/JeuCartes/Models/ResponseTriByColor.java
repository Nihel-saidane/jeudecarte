package com.atexo.JeuCartes.Models;

import java.util.List;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public class ResponseTriByColor {
    List<Carte> carteList;
    List<String> eCouleurs;

    public ResponseTriByColor(List<Carte> carteList, List<String> eCouleurs) {
        this.carteList = carteList;
        this.eCouleurs = eCouleurs;
    }

    public List<Carte> getCarteList() {
        return carteList;
    }

    public void setCarteList(List<Carte> carteList) {
        this.carteList = carteList;
    }

    public List<String> geteCouleurs() {
        return eCouleurs;
    }

    public void seteCouleurs(List<String> eCouleurs) {
        this.eCouleurs = eCouleurs;
    }
}
