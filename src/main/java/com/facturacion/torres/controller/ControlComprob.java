package com.facturacion.torres.controller;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.entidades.Comprobante;
import com.facturacion.torres.service.ServClient;
import com.facturacion.torres.service.ServComprob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comprobante")
public class ControlComprob {
    @Autowired
    private ServComprob servComprob;


    @GetMapping("/list")
    public ResponseEntity<List<Comprobante>> list(){
        List<Comprobante> lista = servComprob.list();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    @GetMapping("detail/{id}")
    public  ResponseEntity<Comprobante> detail(@PathVariable("id") Long id){
        Comprobante comprob = servComprob.getComprobante(id);
        return new ResponseEntity<>(comprob, HttpStatus.OK);
    }

    @PostMapping("/create")
    public void create(@RequestBody Comprobante comprob){
        servComprob.addComprobante(comprob);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        servComprob.deleteComprobante(id);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Comprobante comprob){
        servComprob.editComprobante(comprob);
    }
}
