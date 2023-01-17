package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.LineaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaProductRepository extends JpaRepository<LineaProduct, Long> {
}
