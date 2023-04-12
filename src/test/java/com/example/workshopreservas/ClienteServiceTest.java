package com.example.workshopreservas;

import com.example.workshopreservas.dto.ClienteDTO;
import com.example.workshopreservas.repository.ClienteRepository;
import com.example.workshopreservas.service.ClienteService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class ClienteServiceTest {

    ClienteRepository clienteRepository;
    ClienteService clienteService;

    @Before
    public void setUp() {
        this.clienteRepository = mock(ClienteRepository.class);
        this.clienteService = new ClienteService(clienteRepository);
    }

    @Test(expected = RuntimeException.class)
    public void clienteCedulaNula(){
        //Arrange
        ClienteDTO cliente = new ClienteDTO(null, "vivi", "guzman", "call-123", 31, "vivi@guzman.com");
        //Act&Assert
        clienteService.crear(cliente);

    }

    @Test(expected = RuntimeException.class)
    public void clienteNombreNulo(){
        //Arrange
        ClienteDTO cliente = new ClienteDTO(1234, null, "guzman", "call-123", 31, "vivi@guzman.com");
        //Act&Assert
        clienteService.crear(cliente);

    }

    @Test(expected = RuntimeException.class)
    public void clienteApellidoNulo(){
        //Arrange
        ClienteDTO cliente = new ClienteDTO(1234, "vivi", null, "call-123", 31, "vivi@guzman.com");
        //Act&Assert
        clienteService.crear(cliente);

    }

    @Test
    public void crearCliente(){
        //Arrange
        ClienteDTO cliente = new ClienteDTO(1234, "vivi", "guzman", "call-123", 31, "vivi@guzman.com");
        //Act&Assert
        clienteService.crear(cliente);
        verify(clienteRepository, times(1)).save(any());
        assertTrue(cliente.getCedula().equals(1234));
        assertTrue(cliente.getNombre().equals("vivi"));
        assertTrue(cliente.getApellido().equals("guzman"));
        assertTrue(cliente.getDireccion().equals("call-123"));
        assertTrue(cliente.getEdad().equals(31));
        assertTrue(cliente.getEmail().equals("vivi@guzman.com"));

    }



}
