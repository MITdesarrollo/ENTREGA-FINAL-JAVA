package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.reposiroty.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Cliente createClient(Cliente cliente) {
        return clientRepository.save(cliente);
    }


    public Optional<Cliente> findClientById(Long id) {
        return clientRepository.findById(id);
    }


    public Optional<Cliente> findClientByDni(String dni) {
        return clientRepository.findClientByDni(dni);
    }


    public List<Cliente> findAllClients() {
        return clientRepository.findAll();
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
