package com.facturacion.torres.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "cliente")
public class Cliente {

    public Cliente() {

    }

    public Cliente(int id_cliente, String nombre, String apellido, long dni) {
        this.id = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Id
    @GeneratedValue
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private long dni;


    public int getId_cliente() {
        return id;
    }

    public void setId_cliente(int id_cliente) {
        this.id = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
