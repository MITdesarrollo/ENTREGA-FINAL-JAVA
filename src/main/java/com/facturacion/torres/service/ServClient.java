package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.reposiroty.RepoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServClient {
    @Autowired
    private RepoClient RepoCliente;

    public Cliente addCliente(Cliente cliente){
        return RepoCliente.save(cliente);
    }
    public Cliente getCliente(Long id){
       return RepoCliente.getReferenceById(id);
    }
    public List<Cliente> list(){
        return RepoCliente.findAll();
    }
    public void deleteCliente(Long id){
        RepoCliente.deleteById(id);
    }
    public void editCliente(Cliente cliente){
        RepoCliente.save(cliente);
    }
}
