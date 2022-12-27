package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProduct extends JpaRepository<Producto, Long> {
}
