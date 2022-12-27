package com.facturacion.torres.controller;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.service.ServClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ControlCliente {
    @Autowired
    private ServClient servClient;


    @GetMapping("/list")
        public ResponseEntity<List<Cliente>> list(){
            List<Cliente> lista = servClient.list();
            return new ResponseEntity(lista, HttpStatus.OK);
        }
    @GetMapping("detail/{id}")
    public  ResponseEntity<Cliente> detail(@PathVariable("id") Long id){
        Cliente client = servClient.getCliente(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/create")
    public void create(@RequestBody Cliente cliente){
        servClient.addCliente(cliente);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        servClient.deleteCliente(id);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Cliente cliente){
        servClient.editCliente(cliente);
    }


}
