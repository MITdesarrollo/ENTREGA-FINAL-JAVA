package com.facturacion.torres.dto;

import com.facturacion.torres.entidades.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class ComprobanteDTO {

    private Long comprobId;
    private Integer quantity;
    private LocalDate date;
    private BigDecimal total;
    private Cliente cliente;
    private Set<LineaProductDTO> lines;

    public Long getComprobId() {
        return comprobId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setComprobId(Long comprobId) {
        this.comprobId = comprobId;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getClient() {
        return cliente;
    }

    public void setClient(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<LineaProductDTO> getLines() {
        return lines;
    }

    public void setLines(Set<LineaProductDTO> lines) {
        this.lines = lines;
    }
}