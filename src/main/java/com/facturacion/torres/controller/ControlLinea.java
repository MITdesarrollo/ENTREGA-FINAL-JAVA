package com.facturacion.torres.controller;


import com.facturacion.torres.entidades.Linea;
import com.facturacion.torres.service.ServLinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("linea")
public class ControlLinea {
    @Autowired
    private ServLinea servLinea;

    @GetMapping("/list")
    public ResponseEntity<List<Linea>> list(){
        List<Linea> lista = servLinea.list();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    @GetMapping("detail/{id}")
    public  ResponseEntity<Linea> detail(@PathVariable("id") Long id){
        Linea linea = servLinea.getLinea(id);
        return new ResponseEntity<>( linea , HttpStatus.OK);
    }

    @PostMapping("/create")
    public void create(@RequestBody Linea linea ){
        servLinea.addlinea( linea );
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        servLinea.deleteLinea(id);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Linea linea ){
        servLinea.editLinea( linea );
    }
}
