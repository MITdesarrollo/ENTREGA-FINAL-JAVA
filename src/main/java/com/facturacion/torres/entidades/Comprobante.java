package com.facturacion.torres.entidades;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "comprobante")
public class Comprobante {
    public Comprobante() {
    }

    public Comprobante(int id, Date fecha, int cantidad, float total, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente = cliente;
    }

    @Id
    @GeneratedValue
    @Column(name = "comprobante_id")
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private float total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprobante that = (Comprobante) o;
        return id == that.id && cantidad == that.cantidad && Float.compare(that.total, total) == 0 && Objects.equals(fecha, that.fecha) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, cantidad, total, cliente);
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
