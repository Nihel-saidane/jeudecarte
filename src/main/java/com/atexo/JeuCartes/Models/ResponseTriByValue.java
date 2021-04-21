package com.atexo.JeuCartes.Models;

import java.util.List;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public class ResponseTriByValue {
    List<Carte> carteList;
    List<String> eValeurs;

    public List<Carte> getCarteList() {
        return carteList;
    }

    public void setCarteList(List<Carte> carteList) {
        this.carteList = carteList;
    }

    public List<String> geteValeurs() {
        return eValeurs;
    }

    public void seteValeurs(List<String> eValeurs) {
        this.eValeurs = eValeurs;
    }

    public ResponseTriByValue(List<Carte> carteList, List<String> eValeurs) {
        this.carteList = carteList;
        this.eValeurs = eValeurs;
    }

}
