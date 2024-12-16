package org.sid.ettourioumaimacontrole1.services;

import org.sid.ettourioumaimacontrole1.entities.Produit;
import org.sid.ettourioumaimacontrole1.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduit {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> obtenirTousLesProduits() {
        return produitRepository.findAll();
    }

    public Produit obtenirProduitParId(Long idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

    public Produit mettreAJourProduit(Long idProduit, Produit produitDetails) {
        Produit produit = obtenirProduitParId(idProduit);
        if (produit != null) {
            produit.setNomProduit(produitDetails.getNomProduit());
            produit.setPrixProduit(produitDetails.getPrixProduit());
            produit.setQuantite(produitDetails.getQuantite());
            return produitRepository.save(produit);
        }
        return null;
    }

    public void supprimerProduit(Long idProduit) {
        produitRepository.deleteById(idProduit);
    }

    public Produit rechercherProduitParNom(String nomProduit) {
        return produitRepository.findByNomProduit(nomProduit);
    }
}
