package com.atexo.JeuCartes.Service;

import com.atexo.JeuCartes.Models.Carte;
import com.atexo.JeuCartes.Models.ResponseTriByColor;
import com.atexo.JeuCartes.Models.ResponseTriByValue;

import java.util.List;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
public interface CarteService {
    List<Carte> getRandomCarte();
    ResponseTriByColor triCarteCouleur(List<Carte> carteAletoire );
    ResponseTriByValue triCarteValeur(List<Carte> carteAletoire );
}
