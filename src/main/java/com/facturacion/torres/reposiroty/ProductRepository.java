package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {
    public Optional<Producto> findProductByProductCode(Integer productCode);
}
