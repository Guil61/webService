package com.placeTi.webService.veiculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos,Long> {
}
