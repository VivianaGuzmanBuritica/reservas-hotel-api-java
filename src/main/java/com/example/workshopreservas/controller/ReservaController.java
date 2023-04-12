package com.example.workshopreservas.controller;


import com.example.workshopreservas.dto.ReservaDTO;
import com.example.workshopreservas.service.ReservaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ReservaController {

    private ReservaService service;

    @Autowired
    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reserva creada con exito"),
            @ApiResponse(code = 404, message = "No existe la reserva"),
            @ApiResponse(code = 500, message = "Error de conexion")
    })
    @ApiOperation(value = "Crear una Reserva", notes= "Crea una nueva reserva en la base de datos con la información proporcionada en los parametros del endpoint", response = ReservaDTO.class)
    @PostMapping("/cliente/{cedula}/habitacion/{numero}/fecha/{fecha}/reservar")
    public ReservaDTO reservar(@ApiParam(value = "Digite la cédula de un cliente creado previamente", required = true)
                               @PathVariable("cedula") Integer cedula,
                               @ApiParam(value = "Digite el número de una habitación creada previamente", required = true)
                               @PathVariable("numero") Integer numero,
                               @ApiParam(value = "Digite la fecha en la que desea hacer su reserva con el formato yyyy-MM-dd", required = true)
                               @PathVariable("fecha") String fechaReserva){
        return service.reservar(cedula, numero, fechaReserva);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado de habitaciones disponibles"),
            @ApiResponse(code = 404, message = "No existe habitaciones disponibles"),
            @ApiResponse(code = 500, message = "Error de conexion")
    })
    @ApiOperation(value = "Habitaciones disponibles", notes= "Lista las habitaciones disponibles en la base de datos con la información proporcionada en los parametros del endpoint.", response = Object.class)
    @PostMapping("/cliente/{cedula}/habitacion/{tipo}/consultar")
    public List<Object> consultar(@ApiParam(value = "Digite la cédula de un cliente creado previamente", required = true)
                                  @PathVariable("cedula") Integer cedula,
                                  @ApiParam(value = "Digite el tipo de habitación que desea reservar premium o estandar", required = true)
                                  @PathVariable("tipo") String tipo){
        return service.consultar(cedula,tipo);
    }

}
