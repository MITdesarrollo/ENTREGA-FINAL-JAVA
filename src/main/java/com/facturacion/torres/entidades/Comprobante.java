package com.facturacion.torres.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private float total;

    @JsonBackReference(value = "cliente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente123;

    @JsonManagedReference(value = "linea")
    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Linea> linea;

    public Comprobante() {
    }

    public Comprobante(long id, Date fecha, int cantidad, float total, Cliente cliente, List<Linea> linea) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente123 = cliente123;
        this.linea = linea;
    }

    public Comprobante(Date fecha, int cantidad, float total, Cliente cliente, List<Linea> linea) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente123 = cliente123;
        this.linea = linea;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return cliente123;
    }

    public void setCliente(Cliente cliente) {
        this.cliente123 = cliente;
    }

    public List<Linea> getLinea() {
        return linea;
    }

    public void setLinea(List<Linea> linea) {
        this.linea = linea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprobante that = (Comprobante) o;
        return id == that.id && cantidad == that.cantidad && Float.compare(that.total, total) == 0 && Objects.equals(fecha, that.fecha) && Objects.equals(cliente123, that.cliente123) && Objects.equals(linea, that.linea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, cantidad, total, cliente123, linea);
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", total=" + total +
                ", cliente=" + cliente123 +
                ", linea=" + linea +
                '}';
    }
}
