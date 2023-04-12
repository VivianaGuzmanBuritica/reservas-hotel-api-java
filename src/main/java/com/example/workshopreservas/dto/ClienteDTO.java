package com.example.workshopreservas.dto;

public class ClienteDTO {
    private Integer cedula;
    private String nombre;
    private String apellido;

    private String direccion;
    private Integer edad;
    private String email;

    public ClienteDTO(Integer cedula, String nombre, String apellido, String direccion, Integer edad, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad= edad;
        this.email = email;
    }

    public ClienteDTO() {
    }

    public Integer getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getEdad() {
        return edad;
    }
}
