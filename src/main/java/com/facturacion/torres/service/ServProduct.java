package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Producto;
import com.facturacion.torres.reposiroty.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServProduct {
    @Autowired
    private RepoProduct repoProduct;

    public Producto addProducto(Producto producto){
        return repoProduct.save(producto);
    }
    public Producto getProducto(Long id){
        return repoProduct.getReferenceById(id);
    }
    public List<Producto> list(){
        return repoProduct.findAll();
    }
    public void deleteProducto(Long id){
        repoProduct.deleteById(id);
    }
    public void editProducto(Producto producto){
        repoProduct.save(producto);
    }
}
