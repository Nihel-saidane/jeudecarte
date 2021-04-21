package com.atexo.JeuCartes.Service.Impl;

import com.atexo.JeuCartes.Enumeration.ECouleur;
import com.atexo.JeuCartes.Enumeration.EValeur;
import com.atexo.JeuCartes.Models.Carte;
import com.atexo.JeuCartes.Models.ResponseTriByColor;
import com.atexo.JeuCartes.Models.ResponseTriByValue;
import com.atexo.JeuCartes.Service.CarteService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
@Service
public class CarteServiceImpl implements CarteService {
    @Override
    public List<Carte> getRandomCarte() {
        Carte[] paquets = new Carte[52];
       int i=0;
       List<Carte> paquetsDeDix = new ArrayList<>();
       for(String c: ECouleur.getValues()){
           for(String v: EValeur.getValues()){
               paquets[i++] = new Carte(c,v);
           }
       }
       Random random = new Random();
        for (int j = 0; j < 10; j++) {
            int randomIndex = random.nextInt(paquets.length);
            Carte randomElement = paquets[randomIndex];
            paquetsDeDix.add(randomElement);
        }
    return paquetsDeDix;
    }

    @Override
    public ResponseTriByColor triCarteCouleur(List<Carte> carteAletoire) {
       List<String> listeCouleurs = ECouleur.getValues();
       List<Carte> carteTriCouleur = new ArrayList<>();
        Collections.shuffle(listeCouleurs);
        listeCouleurs.forEach(eCouleur -> {
            carteAletoire.forEach(carte -> {
                if (eCouleur.equals(carte.getCouleur())){
                    carteTriCouleur.add(carte);
                }
            });
        }  );
        return new ResponseTriByColor(carteTriCouleur,listeCouleurs);
    }
    @Override
    public ResponseTriByValue triCarteValeur(List<Carte> carteAletoire) {
       List<String> listeValeurs = EValeur.getValues();
       
       List<Carte> carteTriValeur = new ArrayList<>();
       Collections.shuffle(listeValeurs);
        listeValeurs.forEach(eValeur -> {
            carteAletoire.forEach(carte -> {
                if (eValeur.equals(carte.getValeur())){
                    carteTriValeur.add(carte);
                }
            });
        }  );
        return new ResponseTriByValue(carteTriValeur,listeValeurs);
    }
}
