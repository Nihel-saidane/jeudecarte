package com.atexo.JeuCartes.Controller;

import com.atexo.JeuCartes.Models.Carte;
import com.atexo.JeuCartes.Models.ResponseTriByColor;
import com.atexo.JeuCartes.Models.ResponseTriByValue;
import com.atexo.JeuCartes.Service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
@RestController
@RequestMapping("/carte")
public class CarteController {

    @Autowired
    CarteService carteService;
    
    @CrossOrigin
    @GetMapping("/randomCartes")
    public ResponseEntity<List<Carte>> randomCartes() {
        List<Carte> cartes = carteService.getRandomCarte();
        return new ResponseEntity<>(cartes, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/ordreCouleurs")
    public ResponseEntity<ResponseTriByColor> ordreCouleurs(@RequestBody List<Carte> requestCartes) {
        ResponseTriByColor cartes = carteService.triCarteCouleur(requestCartes);
        return new ResponseEntity<>(cartes, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/ordreValeurs")
    public ResponseEntity<ResponseTriByValue> ordreValeurs(@RequestBody List<Carte> requestCartes) {
        ResponseTriByValue cartes = carteService.triCarteValeur(requestCartes);
        return new ResponseEntity<>(cartes, HttpStatus.OK);
    }
}
