package com.atexo.JeuCartes.Enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public enum ECouleur {
    CARREAUX("Carreaux"),
    COEUR("Coeur"),
    PIQUE("Pique"),
    TREFLE("Trèfle");

    ECouleur(String valeur) {
    }

    public static List<String> getValues() {
        return Arrays.stream(ECouleur.values()).map(Enum::name).collect(Collectors.toList());
    }
}
