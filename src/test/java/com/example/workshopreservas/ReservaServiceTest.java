package com.example.workshopreservas;


import com.example.workshopreservas.dto.ClienteDTO;
import com.example.workshopreservas.dto.HabitacionDTO;
import com.example.workshopreservas.dto.ReservaDTO;
import com.example.workshopreservas.entity.Cliente;
import com.example.workshopreservas.entity.Habitacion;
import com.example.workshopreservas.entity.Reserva;
import com.example.workshopreservas.exception.ApiRequestException;
import com.example.workshopreservas.repository.ClienteRepository;
import com.example.workshopreservas.repository.HabitacionRepository;
import com.example.workshopreservas.repository.ReservaRepository;
import com.example.workshopreservas.service.ReservaService;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReservaServiceTest {

    private ReservaRepository  reservaRepository;
    private ReservaService reservaService;
    private HabitacionRepository habitacionRepository;
    private ClienteRepository clienteRepository;



    @Before
    public void Setup(){
        this.reservaRepository = mock(ReservaRepository.class);
        this.habitacionRepository = mock(HabitacionRepository.class);
        this.clienteRepository = mock(ClienteRepository.class);


        this.reservaService = new ReservaService(reservaRepository, habitacionRepository,clienteRepository);

    }

    @Test(expected = RuntimeException.class)
    public void asignarReservaConFechaNula(){
        //Arrange
        Integer cedula = 1234;
        Integer numero = 1;
        String fecha = null;
        //act
        ReservaDTO reserva = this.reservaService.reservar(cedula, numero, fecha);
    }

    @Test(expected = RuntimeException.class)
    public void asignarReservaConHabitacionNula(){
        //Arrange
        Integer cedula = 1234;
        Integer numero = null;
        String fecha = "2023-05-10";
        //act
        ReservaDTO reserva = this.reservaService.reservar(cedula, numero, fecha);
    }


    @Test(expected = RuntimeException.class)
    public void asignarReservaConCedulaNula(){
        //Arrange
        Integer cedula = null;
        Integer numero = 1;
        String fecha = "2023-05-10";
        //act
        ReservaDTO reserva = this.reservaService.reservar(cedula, numero, fecha);
    }

    @Test(expected = RuntimeException.class)
    public void todoNulo(){
    //Arrange
    Integer cedula = null;
    Integer numero = null;
    String fecha= null;
    //act
    this.reservaService.reservar(cedula, numero, fecha);
    }

    @Test
    public void reservarEstandar(){
        //Arrange
        Integer cedula = 1234;
        Integer numero = 1;
        String fecha = "2023-05-10";

        Habitacion habitacion = new Habitacion(1, "estandar", 10000.0);
        when(habitacionRepository.findById(any())).thenReturn(Optional.of(habitacion));

        Cliente cliente = new Cliente(1234, "vivi", "guzman", "call-123", 31, "vivi@guzman.com");
        when(clienteRepository.findById(any())).thenReturn(Optional.of(cliente));
        //Act
       ReservaDTO reserva= this.reservaService.reservar(cedula, numero, fecha);
        //Assert
        assertNotNull(reserva.getFecha());
        assertTrue(reserva.getTotal().equals(habitacion.precioBase));
        assertTrue(reserva.getHabitacion().getNumero().equals(numero));

    }
    @Test
    public void reservarPremium(){
        //Arrange
        Integer cedula = 1234;
        Integer numero = 1;
        String fecha = "2023-05-10";

        Habitacion habitacion = new Habitacion(1, "premium", 10000.0);
        when(habitacionRepository.findById(any())).thenReturn(Optional.of(habitacion));

        Double precioBase = habitacion.precioBase.doubleValue();
        Double total = precioBase - (precioBase * 0.05);

        Cliente cliente = new Cliente(1234, "vivi", "guzman", "call-123", 31, "vivi@guzman.com");
        when(clienteRepository.findById(any())).thenReturn(Optional.of(cliente));
        //Act
        ReservaDTO reserva= this.reservaService.reservar(cedula, numero, fecha);
        //Assert
        assertNotNull(reserva.getFecha());
        assertTrue(reserva.getTotal().equals(total));
        assertTrue(reserva.getHabitacion().getNumero().equals(numero));

    }
    @Test
    public void sinClienteNiHabiacion(){
        //Arrange
        Integer cedula = 1234;
        Integer numero = 1;
        String fecha = "2023-05-10";

       when(habitacionRepository.findById(any())).thenReturn(Optional.empty());
       when(clienteRepository.findById(any())).thenReturn(Optional.empty());
        //Act
        ReservaDTO reserva= this.reservaService.reservar(cedula, numero, fecha);
        //Assert
        assertNull(reserva);

    }

    @Test()
    public void consultar(){

        //Arrange
        Integer cedula = 1234;
        String tipo = "estandar";
        //Act

        Habitacion habitacion1 = new Habitacion(1, "estandar", 10000.0);
        when(habitacionRepository.findById(any())).thenReturn(Optional.of(habitacion1));
        Habitacion habitacion2 = new Habitacion(2, "premium", 10000.0);
        when(habitacionRepository.findById(any())).thenReturn(Optional.of(habitacion2));

        Cliente cliente = new Cliente(1234, "vivi", "guzman", "call-123", 31, "vivi@guzman.com");
        when(clienteRepository.findById(any())).thenReturn(Optional.of(cliente));

        List<Object> disponibles = this.reservaService.consultar(cedula, tipo);
        //Assert
       assertNotNull(disponibles);

    }

    @Test(expected = NoSuchElementException.class)
    public void consultarSinCliente(){

        //Arrange
        Integer cedula = 1234;
        String tipo = "estandar";
        //Act&Assert
        when(clienteRepository.findById(any())).thenReturn(Optional.empty());
        List<Object> disponibles = this.reservaService.consultar(cedula, tipo);

    }
}
