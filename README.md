# API REST de reservas de habitación de hotel :hotel::sparkles:

<div align= "rigth">Esta API REST de reservas de habitación de hotel es una aplicación Spring Boot que te permite gestionar reservas de habitaciones en un hotel. El proyecto esta construido con la versión de '2.7.10' de Spring Boot, un gestor de dependecias con  Gradle-Groovy compatible con Java 11, con un motor de base de datos H2 y persistencia de datos co JPA e Hibernate.

Las principales dependencias utilizadas son:

- Spring Data JPA (Persiste bases de datos SQL utilizando Java Persistence API mediante Spring Data y Hibernate.)
- Spring Web (Construye aplicaciones web, incluyendo RESTful, utilizando Spring MVC. Utiliza Apache Tomcat como contenedor integrado predeterminado.) 
- JUnit (Testeo de pruebas unitarias)

Adicionalmente esta API se encuentra documentada con Swagger y podrá probar la funcionalidad de los Endpoints en el siguiente link [Swagger documentación](http://localhost:8080/swagger-ui/index.html#/basic-error-controller) una vez la aplicación se encuentre levantada. 

## :computer: Endpoints:

### Endpoint de creación de cliente :raising_hand:

#### POST: /api/v1/cliente

Crea un nuevo cliente en la base de datos con la información proporcionada en el cuerpo de la solicitud.

##### Parámetros de entrada:

 cedula: cedula del cliente (numero)
 nombre: nombre del cliente (cadena de texto)
 apellido: apellido del cliente (cadena de texto)
 direccion: direccion del cliente (cadena de texto) 
 edad: edad del cliente (numero) 
 email: dirección de correo electrónico del cliente (cadena de texto)

 
Ejemplo de solicitud:

```java {.highlight .highlight-source-java .bg-black}
{
"cedula": Integer,
"nombre": String,
"apellido": String,
"direccion": String,
"edad": Integer,
"email": String
}
```

La API devolverá el nuevo cliente creado en formato JSON:
```java
{
"cedula": 1234,
"nombre": "Juan",
"apellido": "Pérez",
"direccion": "Pérez",
"edad": 31,
"email": "juan.perez@example.com"
}
```

### Endpoint de creación de reservas :key:

#### POST: /api/v1/cliente/{cedula}/habitacion/{numero}/fecha/{fecha}/reservar

Crea una nueva reserva en la base de datos con la información proporcionada en el cuerpo de la solicitud.

Parámetros de entrada:


##### Parámetros de entrada:

cedula: cedula del cliente creado(numero)
numero: numero de la habitacion(numero)
fecha: fecha que se desea reservar (cadena de texto con la fecha en formato YYYY- mm - dd)


Ejemplo de solicitud:

```(http://localhost:8080/api/v1/cliente/0/habitacion/1/fecha/2023-05-10/reservar)```

La API devolverá la nueva reserva creada en formato JSON:
```java
{
"codigo": 1,
"fecha": "2023-04-02T02:22:04.416Z",
"habitacion": {
    "numero": 1,
    "precioBase": 10000.0,
    "tipo": "estandar"
    },
"total": 10000.0
}
```

### Endpoint consulta de habitaciones disponibles :hotel:

#### POST: /api/v1/cliente/{cedula}/habitacion/{tipo}/consultar

Mostar una lista de las habitaciones disponibles sin reserva en la base de datos con la información proporcionada en el cuerpo de la solicitud.

Parámetros de entrada:


##### Parámetros de entrada:

cedula: cedula del cliente creado(numero)
tipo: tipo de la habitacion(cadena de texto)

Ejemplo de solicitud:

```(http://localhost:8080/api/v1/cliente/1234/habitacion/estandar/consultar)```

La API devolverá la nueva reserva creada en formato JSON:
```java
[
    [
        3,
        10000,
        "estandar"
    ]
]
```
