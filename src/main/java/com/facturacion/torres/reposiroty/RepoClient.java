package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoClient extends JpaRepository<Cliente, Long> {
}
