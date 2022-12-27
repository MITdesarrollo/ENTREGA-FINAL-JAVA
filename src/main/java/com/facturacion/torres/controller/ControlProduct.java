package com.facturacion.torres.controller;


import com.facturacion.torres.entidades.Producto;
import com.facturacion.torres.service.ServProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto")
public class ControlProduct {
    @Autowired
    private ServProduct servProduct;

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> list(){
        List<Producto> lista = servProduct.list();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    @GetMapping("detail/{id}")
    public  ResponseEntity<Producto> detail(@PathVariable("id") Long id){
        Producto producto = servProduct.getProducto(id);
        return new ResponseEntity<>( producto , HttpStatus.OK);
    }

    @PostMapping("/create")
    public void create(@RequestBody Producto producto ){
        servProduct.addProducto( producto );
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        servProduct.deleteProducto(id);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Producto producto ){
        servProduct.editProducto( producto );
    }
}
