package com.facturacion.torres.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "linea")
public class LineaProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;

    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "QUANTITY")
    private  Integer quantity;

    @Column(name = "PRICE")
    private  Float price;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "LINEA_ID")
    Comprobante comprobante;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    Producto producto;

    public LineaProduct() {
    }

    public LineaProduct(String description, Integer quantity, Float price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ReceiptProduct{" +
                "rpId=" + id +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                ", receipt=" + comprobante +
                ", product=" + producto +
                '}';
    }
}
