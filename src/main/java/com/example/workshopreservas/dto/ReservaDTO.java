package com.example.workshopreservas.dto;

import com.example.workshopreservas.entity.Cliente;
import com.example.workshopreservas.entity.Habitacion;

import java.util.Date;

public class ReservaDTO {
    private Integer codigo;
    private Habitacion habitacion;
 //   private Cliente cliente;
    private Date fecha;
    private Double total;

    public ReservaDTO(Integer codigo, Habitacion habitacion,  Date fecha, Double total) {
        this.codigo = codigo;
        this.habitacion = habitacion;
       // this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }

    public ReservaDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }


    public Date getFecha() {
        return fecha;
    }

    public Double getTotal() {
        return total;
    }
}
