package com.example.workshopreservas.dto;

public class HabitacionDTO {
    private Integer numero;
    private String tipo;
    private Double precioBase;

    public HabitacionDTO(Integer numero, String tipo, Double precioBase) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public HabitacionDTO() {
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }
}
