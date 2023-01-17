package com.facturacion.torres.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID")
   private  Long id;

   @Column(name = "CODE")
   private  Integer productCode;

   @Column(name = "DESCRIPTION")
   private  String description;

   @Column(name = "QUANTITY")
   private  Integer quantity;

   @Column(name = "PRICE")
   private Float price;

   @JsonManagedReference
   @JsonIgnore
   @OneToMany(mappedBy = "producto")
   private List<LineaProduct> linea;


   public Producto() {
   }

   public Producto(Integer productCode, String description, Integer quantity, Float price) {
      this.productCode = productCode;
      this.description = description;
      this.quantity = quantity;
      this.price = price;
   }

   // GETTERS & SETTERS

   public Long getProductId() {
      return id;
   }

   public void setProductId(Long id) {
      this.id = id;
   }

   public Integer getProductCode() {
      return productCode;
   }

   public void setProductCode(Integer productCode) {
      this.productCode = productCode;
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

   public List<LineaProduct> getLina() {
      return linea;
   }

   public void setLines(List<LineaProduct> linea) {
      this.linea = linea;
   }

   @Override
   public String toString() {
      return "Product{" +
              "productId=" + id +
              ", productCode=" + productCode +
              ", description='" + description + '\'' +
              ", quantity=" + quantity +
              ", price=" + price +
              '}';
   }
}
