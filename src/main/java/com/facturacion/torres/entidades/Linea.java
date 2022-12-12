package com.facturacion.torres.entidades;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "linea")
public class Linea {

    public Linea() {
    }

    public Linea(int id, String descripcion, int cantidad, float precio, Comprobante comprobante, Producto producto) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    @Id
    @GeneratedValue
    @Column(name = "linea_id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private float precio;

    //QUISIERA SABER SI ESTA BIEN ESTAS UNIONES

    @ManyToOne
    @JoinColumn(name = "comprobante_id")
    private Comprobante comprobante;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto  producto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
