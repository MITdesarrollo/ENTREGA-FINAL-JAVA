package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.entidades.Comprobante;
import com.facturacion.torres.reposiroty.RepoClient;
import com.facturacion.torres.reposiroty.RepoComprob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServComprob {
    @Autowired
    private RepoComprob RepoComprobante;

    public Comprobante addComprobante(Comprobante comprobante){
        return RepoComprobante.save(comprobante);
    }
    public Comprobante getComprobante(Long id){
        return RepoComprobante.getReferenceById(id);
    }
    public List<Comprobante> list(){
        return RepoComprobante.findAll();
    }
    public void deleteComprobante(Long id){
        RepoComprobante.deleteById(id);
    }
    public void editComprobante(Comprobante comprobante){
        RepoComprobante.save(comprobante);
    }
}
