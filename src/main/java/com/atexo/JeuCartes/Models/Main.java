package com.atexo.JeuCartes.Models;

import java.util.List;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public class Main {
    private List<Carte> cartes;

    public Main(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }
}
