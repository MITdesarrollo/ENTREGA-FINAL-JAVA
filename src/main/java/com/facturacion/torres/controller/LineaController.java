package com.facturacion.torres.controller;

import com.facturacion.torres.dto.ComprobanteDTO;
import com.facturacion.torres.dto.LineaProductDTO;
import com.facturacion.torres.entidades.Comprobante;
import com.facturacion.torres.entidades.LineaProduct;
import com.facturacion.torres.reposiroty.LineaProductRepository;
import com.facturacion.torres.service.LieneaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("linea")
public class LineaController {
    @Autowired
    LieneaService lineaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getLineaById(@PathVariable(name = "id") Long id) {
        try {
            Optional<LineaProduct> receipt = lineaService.findLineaById(id);

            if(receipt.isPresent()) {
                return ResponseEntity.ok(receipt);
            } else {
                return new ResponseEntity<>("No se encontró linea con id " + id, HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }

    }

    @GetMapping(value = "/listar")
    public ResponseEntity<?> getAllLinea() {
        try {
            List<LineaProduct> lineas = lineaService.findAllLineas();
            return ResponseEntity.ok(lineas);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }




    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<?> deleteLinea(@PathVariable(name = "id") Long id) {
        try {
            Optional<LineaProduct> lineaToDelete = lineaService.findLineaById(id);
            if(lineaToDelete.isPresent()) {
                lineaService.deleteLinea(id);
                return ResponseEntity.ok("linea " + id + " eliminado correctamente");
            } else {
                return new ResponseEntity<>("Linea" + id + " no existe", HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @PostMapping(value = "/agregar")
    public LineaProduct createLineatDTO(@RequestBody LineaProduct linea) {
        return this.lineaService.creaLinea(linea);
    }
}
