package com.facturacion.torres.controller;

import com.facturacion.torres.entidades.Cliente;
import com.facturacion.torres.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> getAllClients() {
        List<Cliente> clientes = clientService.findAllClients();
        try {
            if(!clientes.isEmpty()) {
                return ResponseEntity.ok(clientes);
            } else {
                return new ResponseEntity<>("No se encontraron clientes", HttpStatus.OK);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable(name = "id") Long id) {
        try {
            Optional<Cliente> client = clientService.findClientById(id);

            if(client.isPresent()) {
                return ResponseEntity.ok(client);
            } else {
                return new ResponseEntity<>("No se existe cliente con id " + id, HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }

    }

    @PostMapping(value = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addClient(@RequestBody Cliente cliente) {
        try {
            Optional<Cliente> checkClient = clientService.findClientByDni(cliente.getDni());
            if(checkClient.isPresent()) {
                return new ResponseEntity<>("El cliente ya se encuentra registrado", HttpStatus.CONFLICT);
            } else {
                Cliente savedCliente = clientService.createClient(cliente);
                return ResponseEntity.ok(savedCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }
    }

    @PutMapping(value = "/modificar/{id}")
    public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clientData = clientService.findClientById(id);
        try {
            if(clientData.isPresent()) {

                Cliente updateCliente = clientData.get();
                updateCliente.setClientName(cliente.getClientName());
                updateCliente.setClientSurname(cliente.getClientSurname());
                updateCliente.setDni(cliente.getDni());

                return new ResponseEntity<>(clientService.createClient(updateCliente), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El cliente no existe", HttpStatus.NOT_FOUND);
            }
        }
        catch ( Exception e ) {
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }
    }

    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        try {
            Optional<Cliente> client = clientService.findClientById(id);
            if(client.isPresent()) {
                clientService.deleteClient(id);
                return ResponseEntity.ok("Se ha borrado el cliente" + id);
            } else {
                return new ResponseEntity<>("El cliente no existe", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("error");
        }
    }
}
