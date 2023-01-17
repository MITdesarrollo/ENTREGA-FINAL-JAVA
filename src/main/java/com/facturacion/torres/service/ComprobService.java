package com.facturacion.torres.service;

import com.facturacion.torres.dto.ComprobanteDTO;
import com.facturacion.torres.dto.LineaProductDTO;
import com.facturacion.torres.entidades.*;
import com.facturacion.torres.reposiroty.ClientRepository;
import com.facturacion.torres.reposiroty.ComprobRepository;
import com.facturacion.torres.reposiroty.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class ComprobService {
    @Autowired
    ComprobRepository comprobRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;


    public ComprobService(ComprobRepository comprobRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.comprobRepository = comprobRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public List<Comprobante> getAllComprobantes() {
        return comprobRepository.findAll();
    }

    public Optional<Comprobante> getComprotById(Long id) {
        return comprobRepository.findById(id);
    }

    public void deleteComprob(Long id) {
        comprobRepository.deleteById(id);
    }


    private Comprobante buildComprob(Comprobante comprobante) {
        Comprobante comprobanteToSave = new Comprobante();

        comprobanteToSave.setClient(this.clientRepository.findById(comprobante.getClient().getClientId()).get());

        WorldClock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldClock.class);

        LocalDate currentDateTime = LocalDate.parse(worldClock.getCurrentDateTime());

        try {
            comprobanteToSave.setDate(currentDateTime);
        } catch (Exception e) {
            e.printStackTrace();
            comprobanteToSave.setDate(LocalDate.now());
        }


        comprobanteToSave.setLines(new HashSet<LineaProduct>());
        for(LineaProduct lineaProduct : comprobante.getLines()) {
            comprobanteToSave.addLinea(createLinea(lineaProduct));
        }

        comprobanteToSave.setTotal(calculateTotal(comprobanteToSave.getLines()));
        comprobanteToSave.setQuantity(comprobante.getLines().size());

        return comprobanteToSave;
    }


    public ComprobanteDTO saveReceipt(Comprobante comprobante) {
        Boolean clientExists = isClient(comprobante.getClient());
        Boolean productsExist = isProduct(comprobante.getLines());
        Boolean stockExists = isStock(comprobante.getLines());

        if(clientExists && productsExist && stockExists) {
            Comprobante comprobanteToSave = buildComprob(comprobante);
            updateStock(comprobanteToSave.getLines());

            return createComprobDTO(this.comprobRepository.save(comprobanteToSave));
        } else {
            return new ComprobanteDTO(); //
        }
    }


    private Set<LineaProductDTO> createReceiptProductDTO(Set<LineaProduct> lineaProducts) {
        Set<LineaProductDTO> dtos = new HashSet<>();

        for(LineaProduct lineaProduct : lineaProducts) {
            LineaProductDTO dto = new LineaProductDTO();
            dto.setDescription(lineaProduct.getDescription());
            dto.setRpid(lineaProduct.getProducto().getProductId());
            dto.setPrice(lineaProduct.getPrice());
            dto.setQuantity(lineaProduct.getQuantity());
            dtos.add(dto);
        }

        return dtos;
    }



    public ComprobanteDTO findById(Long id) {
        Optional<Comprobante> comprobante = this.comprobRepository.findById(id);
        if(comprobante.isPresent()) {
            return createComprobDTO(comprobante.get());
        } else {
            return new ComprobanteDTO();
        }
    }


    private ComprobanteDTO createComprobDTO(Comprobante comprobante) {
        ComprobanteDTO dto = new ComprobanteDTO();

        dto.setComprobId(comprobante.getReceiptId());
        dto.setClient(comprobante.getClient());
        dto.setDate(comprobante.getDate());
        dto.setLines(createReceiptProductDTO(comprobante.getLines()));

        return dto;
    }

    private LineaProduct createLinea(LineaProduct linea) {
        LineaProduct lineaAGuardar = new LineaProduct();

        Producto productoDB = this.productRepository.findById(linea.getProducto().getProductId()).get();
        lineaAGuardar.setQuantity(linea.getQuantity());
        lineaAGuardar.setDescription(productoDB.getDescription());
        lineaAGuardar.setPrice(productoDB.getPrice());
        lineaAGuardar.setProducto(productoDB);

        return lineaAGuardar;
    }

    private List<ComprobanteDTO> createComprobDTO(List<Comprobante> comprobantes) {
        List<ComprobanteDTO> receiptsDTOs = new ArrayList<>();
        for(Comprobante comprobante : comprobantes) {
            receiptsDTOs.add(this.createComprobDTO(comprobante));
        }

        return receiptsDTOs;
    }

    private Boolean isStock(Set<LineaProduct> lineaProducts){
        for(LineaProduct lineaProduct : lineaProducts) {
            Long productId = lineaProduct.getProducto().getProductId();
            Optional<Producto> product = this.productRepository.findById(productId);

            if(product.isEmpty()) {
                return false;
            }

            if(lineaProduct.getQuantity() <= product.get().getQuantity()) {
                return true;
            }
        }
        return false;
    }


    private Boolean isProduct(Set<LineaProduct> lineaProducts) {
        for ( LineaProduct lineaProduct : lineaProducts) {
            Long productId = lineaProduct.getProducto().getProductId();
            Optional<Producto> product = this.productRepository.findById(productId);

            if(product.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    private Boolean isClient(Cliente cliente) {
        Optional<Cliente> c = this.clientRepository.findById(cliente.getClientId());

        return c.isPresent();
    }


    private Float calculateTotal(Set<LineaProduct> lineaProducts) {
        Float total = 0.00f;

        for(LineaProduct lineaProduct : lineaProducts) {
            total += lineaProduct.getPrice();
        }

        return total;
    }


    private void updateStock(Set<LineaProduct> lineaProducts) {
        for(LineaProduct lineaProduct : lineaProducts) {
            Integer soldQuantity = lineaProduct.getQuantity();
            Producto productoSold = lineaProduct.getProducto();
            Optional<Producto> productDB = this.productRepository.findById(productoSold.getProductId());
            if(productDB.isPresent()) {
                Integer stock = productDB.get().getQuantity();

                Integer updatedStock = stock - soldQuantity;
                this.productRepository.save(productDB.get());
            }

        }
    }
}
