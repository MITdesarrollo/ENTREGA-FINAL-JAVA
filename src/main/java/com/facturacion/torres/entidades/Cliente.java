package com.facturacion.torres.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;

    @Column(name = "DNI")
    private  String dni;

    @Column(name = "NAME")
    private  String clientName;

    @Column(name = "SURNAME")
    private  String clientSurname;

    @JsonManagedReference(value = "cliente")
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comprobante> comprobantes;



    public Cliente() {
    }

    public Cliente(String dni, String clientName, String clientSurname) {
        this.dni = dni;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.comprobantes = new ArrayList<>();
    }



    public Long getClientId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public List<Comprobante> getComprob() {
        return comprobantes;
    }

    public void setComprob(List<Comprobante> comprobantes) {
        this.comprobantes = comprobantes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + id +
                ", dni='" + dni + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", receipts=" + comprobantes +
                '}';
    }
}
