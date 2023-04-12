package com.example.workshopreservas.controller;

import com.example.workshopreservas.dto.ClienteDTO;
import com.example.workshopreservas.service.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    private ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente creado con exito"),
            @ApiResponse(code = 404, message = "No existe el cliente"),
            @ApiResponse(code = 500, message = "Error de conexion")
    })

    @ApiOperation(value = "Crear un cliente", notes= "Crea un nuevo cliente en la base de datos con la información proporcionada en el cuerpo de la solicitud.", response = ClienteDTO.class)
    @PostMapping("/cliente")
    public ClienteDTO crear(@RequestBody ClienteDTO cliente){
        return service.crear(cliente);
    }
}
