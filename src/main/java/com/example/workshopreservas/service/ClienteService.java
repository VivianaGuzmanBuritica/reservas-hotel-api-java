package com.example.workshopreservas.service;

import com.example.workshopreservas.dto.ClienteDTO;
import com.example.workshopreservas.entity.Cliente;
import com.example.workshopreservas.repository.ClienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;



@Service
//@Slf4j
public class ClienteService {

    private ClienteRepository clienteRepository;

   // private static final Logger log = LogManager.getLogger(ClienteService.class);


    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

       public ClienteDTO crear(ClienteDTO clienteDTO){

       if(clienteDTO.getCedula() == null || clienteDTO.getApellido() == null || clienteDTO.getNombre() == null){
           throw new RuntimeException("la cedula, el apellido o el nombre son invalidos");
       }

        Cliente cliente = new Cliente(
                clienteDTO.getCedula(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido(),
                clienteDTO.getDireccion(),
                clienteDTO.getEdad(),
                clienteDTO.getEmail()
     );
       //  log.info("se creo el cliente con cedula: {}",cliente.getCedula());
        clienteRepository.save(cliente);
        return clienteDTO;
    }

}
