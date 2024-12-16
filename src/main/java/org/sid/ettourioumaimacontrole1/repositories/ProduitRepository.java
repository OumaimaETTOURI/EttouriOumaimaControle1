package org.sid.ettourioumaimacontrole1.repositories;

import org.sid.ettourioumaimacontrole1.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Produit findByNomProduit(String nomProduit);
}
