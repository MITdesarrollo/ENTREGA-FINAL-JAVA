package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Comprobante;
import com.facturacion.torres.entidades.Linea;
import com.facturacion.torres.reposiroty.RepoComprob;
import com.facturacion.torres.reposiroty.RepoLinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServLinea {

    @Autowired
    private RepoLinea RepoLinea;

    public Linea addlinea(Linea linea){
        return RepoLinea.save(linea);
    }
    public Linea getLinea(Long id){
        return RepoLinea.getReferenceById(id);
    }
    public List<Linea> list(){
        return RepoLinea.findAll();
    }
    public void deleteLinea(Long id){
        RepoLinea.deleteById(id);
    }
    public void editLinea(Linea linea){
        RepoLinea.save(linea);
    }
}
