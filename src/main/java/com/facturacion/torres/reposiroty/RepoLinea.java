package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.Linea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoLinea extends JpaRepository<Linea, Long> {
}
