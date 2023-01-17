package com.facturacion.torres.service;

import com.facturacion.torres.entidades.Producto;
import com.facturacion.torres.reposiroty.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Producto createProduct(Producto producto) {
        return productRepository.save(producto);
    }


    public Optional<Producto> findProductById(Long id) {
        return productRepository.findById(id);
    }


    public Optional<Producto> findProductByPrdCode(Integer prdCode) {
        return productRepository.findProductByProductCode(prdCode);
    }


    public List<Producto> findAllProducts() {
        return productRepository.findAll();
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
