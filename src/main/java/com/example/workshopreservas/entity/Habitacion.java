package com.example.workshopreservas.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Habitacion")
public class Habitacion {

    @Id
    @Column(name = "numero_h")
    public Integer numero;

    @Column(name = "tipo")
    public String tipo;

    @Column(name = "precioBase")
    public Double precioBase;

    public Habitacion() {
    }

    public Habitacion(Integer numero, String tipo, Double precioBase) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }
}
