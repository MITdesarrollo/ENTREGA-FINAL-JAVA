package com.facturacion.torres.reposiroty;

import com.facturacion.torres.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findClientByDni(String dni);
}
