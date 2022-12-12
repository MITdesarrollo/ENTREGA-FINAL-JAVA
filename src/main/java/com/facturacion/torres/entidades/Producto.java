package com.facturacion.torres.entidades;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="producto")
public class Producto {
    public Producto() {

    }

    public Producto(int id, int codigo, String descripcion, int cantidad, float precio) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Id
    @GeneratedValue
    @Column(name = "producto_id")
    private int id;

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private float precio;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && codigo == producto.codigo && cantidad == producto.cantidad && Float.compare(producto.precio, precio) == 0 && Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, descripcion, cantidad, precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
