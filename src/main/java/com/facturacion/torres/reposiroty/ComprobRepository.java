package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobRepository extends JpaRepository<Comprobante, Long> {

}
