package com.facturacion.torres.controller;

import com.facturacion.torres.dto.ComprobanteDTO;
import com.facturacion.torres.entidades.Comprobante;
import com.facturacion.torres.service.ComprobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("comprobante")
public class ComprobController {
    @Autowired
    ComprobService comprobService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getClientById(@PathVariable(name = "id") Long id) {
        try {
            Optional<Comprobante> receipt = comprobService.getComprotById(id);

            if(receipt.isPresent()) {
                return ResponseEntity.ok(receipt);
            } else {
                return new ResponseEntity<>("No se encontró ningún comprobante con id " + id, HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }

    }

    @GetMapping(value = "/listar")
    public ResponseEntity<?> getAllComprob() {
        try {
            List<Comprobante> comprobantes = comprobService.getAllComprobantes();
            if(!comprobantes.isEmpty()) {
                return ResponseEntity.ok(comprobantes);
            } else {
                return new ResponseEntity<>("No se encontraron comprobantes en la lista", HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }




    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<?> deleteComprb(@PathVariable(name = "id") Long id) {
        try {
            Optional<Comprobante> receiptToDelete = comprobService.getComprotById(id);
            if(receiptToDelete.isPresent()) {
                comprobService.deleteComprob(id);
                return ResponseEntity.ok("Comprobante de id " + id + " eliminado correctamente");
            } else {
                return new ResponseEntity<>("El comprobante de id " + id + " no existe", HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @PostMapping(value = "/agregar/comprobante")
    public ComprobanteDTO createComprobtDTO(@RequestBody Comprobante comprobante) {
        return this.comprobService.saveReceipt(comprobante);
    }
}
