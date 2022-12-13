package com.facturacion.torres.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "linea")
public class Linea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private float precio;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Comprobante comprobante;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto  producto;

    public Linea() {
    }
    public Linea(long id, String descripcion, int cantidad, float precio, Comprobante comprobante, Producto producto) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public Linea(String descripcion, int cantidad, float precio, Comprobante comprobante, Producto producto) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linea linea = (Linea) o;
        return id == linea.id && cantidad == linea.cantidad && Float.compare(linea.precio, precio) == 0 && Objects.equals(descripcion, linea.descripcion) && Objects.equals(comprobante, linea.comprobante) && Objects.equals(producto, linea.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, cantidad, precio, comprobante, producto);
    }

    @Override
    public String toString() {
        return "Linea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", comprobante=" + comprobante +
                ", producto=" + producto +
                '}';
    }
}
