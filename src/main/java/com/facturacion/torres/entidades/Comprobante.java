package com.facturacion.torres.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "comprobante")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPROBANTE_ID")
    private  Long id;

    @Column(name = "DATE")
    private  LocalDate date;

    @Column(name = "QUANTITY")
    private  Integer quantity;

    @Column(name = "TOTAL")
    private Float total;


    @JsonBackReference(value = "cliente_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;


    @JsonManagedReference
    @OneToMany(mappedBy = "comprobante")
    private Set<LineaProduct> lineaProducts;



    public Comprobante() {
    }

    public LocalDate getDate() {
        return date;
    }




    public Set<LineaProduct> getLines() {
        return lineaProducts;
    }

    public void setLines(Set<LineaProduct> lines) {
        this.lineaProducts = lines;
    }

    public Long getReceiptId() {
        return id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Cliente getClient() {
        return cliente;
    }

    public void setClient(Cliente cliente) {
        this.cliente = cliente;
    }
    public void addLinea(LineaProduct line) {
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + id +
                ", date=" + date +
                ", quantity=" + quantity +
                ", total=" + total +
                ", client=" + cliente +
                ", lines=" + lineaProducts +
                '}';
    }


}
