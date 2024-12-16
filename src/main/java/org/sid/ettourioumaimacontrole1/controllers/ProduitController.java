package org.sid.ettourioumaimacontrole1.controllers;
import org.sid.ettourioumaimacontrole1.entities.Produit;
import org.sid.ettourioumaimacontrole1.services.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ServiceProduit serviceProduit;

    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return serviceProduit.ajouterProduit(produit);
    }

    @GetMapping
    public List<Produit> obtenirTousLesProduits() {
        return serviceProduit.obtenirTousLesProduits();
    }

    @GetMapping("/{idProduit}")
    public ResponseEntity<Produit> obtenirProduitParId(@PathVariable Long idProduit) {
        Produit produit = serviceProduit.obtenirProduitParId(idProduit);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idProduit}")
    public ResponseEntity<Produit> mettreAJourProduit(@PathVariable Long idProduit, @RequestBody Produit produitDetails) {
        Produit produitMisAJour = serviceProduit.mettreAJourProduit(idProduit, produitDetails);
        if (produitMisAJour != null) {
            return ResponseEntity.ok(produitMisAJour);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idProduit}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable Long idProduit) {
        serviceProduit.supprimerProduit(idProduit);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "nom")
    public ResponseEntity<Produit> rechercherProduitParNom(@RequestParam String nom) {
        Produit produit = serviceProduit.rechercherProduitParNom(nom);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        }
        return ResponseEntity.notFound().build();
    }
}