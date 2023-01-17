package com.facturacion.torres.controller;

import com.facturacion.torres.entidades.Producto;
import com.facturacion.torres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("producto")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Producto> productos = productService.findAllProducts();
            if(!productos.isEmpty()) {
                return ResponseEntity.ok(productos);
            } else {
                return new ResponseEntity<>("No se encontraron productos en la lista", HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name="id") Long id) {
        try {
            Optional<Producto> product = productService.findProductById(id);

            if(product.isPresent()) {
                return ResponseEntity.ok(product);
            } else {
                return new ResponseEntity<>("No se encontró ningún producto con id " + id, HttpStatus.NOT_FOUND);
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }

    }

    @PostMapping(value = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addProduct(@RequestBody Producto producto) {
        try {
            Optional<Producto> checkProduct = productService.findProductByPrdCode(producto.getProductCode());
            if(checkProduct.isPresent()) {
                return new ResponseEntity<>("El producto ya se encuentra registrado", HttpStatus.CONFLICT);
            } else {
                Producto savedProducto = productService.createProduct(producto);
                return ResponseEntity.ok(savedProducto);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }
    }

    @PutMapping(value = "/modificar/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody Producto producto) {
        Optional<Producto> productData = productService.findProductById(id);
        try {
            if(productData.isPresent()) {

                Producto updateProducto = productData.get();
                updateProducto.setProductCode(producto.getProductCode());
                updateProducto.setDescription(producto.getDescription());
                updateProducto.setPrice(producto.getPrice());
                updateProducto.setQuantity(producto.getQuantity());

                return new ResponseEntity<>(productService.createProduct(updateProducto), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }
    }

    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable (name = "id") Long id) {
        try {
            Optional<Producto> product = productService.findProductById(id);
            if(product.isPresent()) {
                productService.deleteProduct(id);
                return ResponseEntity.ok("Producto id " + id + " eliminado exitosamente");
            } else {
                return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Ocurrió un error");
        }
    }
}
