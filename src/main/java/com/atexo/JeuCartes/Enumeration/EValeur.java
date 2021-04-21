package com.atexo.JeuCartes.Enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public enum EValeur {
    AS("AS"),
    DEUX("2"),
    TROIS("3"),
    QUATRE("4"),
    CINQ("5"),
    SIX("6"),
    SEPT("7"),
    HUIT("8"),
    NEUF("9"),
    DIX("10"),
    DAME("Dame"),
    ROI("Roi"),
    VALET("Valet");

   EValeur(String valeur) {
    }
    public static List<String> getValues() {
        return Arrays.stream(EValeur.values()).map(Enum::name).collect(Collectors.toList());
    }
}
