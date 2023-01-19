package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.entidades.LineaProduct;
import com.facturacion.torres.reposiroty.ClientRepository;
import com.facturacion.torres.reposiroty.LineaProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LieneaService {
    @Autowired
    private  LineaProductRepository lineaProductRepository;


    public LineaProduct creaLinea(LineaProduct linea) {
        return lineaProductRepository.save(linea);
    }


    public Optional<LineaProduct> findLineaById(Long id) {
        return lineaProductRepository.findById(id);
    }


    public List<LineaProduct> findAllLineas() {
        return lineaProductRepository.findAll();
    }


    public void deleteLinea(Long id) {
        lineaProductRepository.deleteById(id);
    }
}
