package com.example.workshopreservas.repository;

import com.example.workshopreservas.entity.Habitacion;
import com.example.workshopreservas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value= "SELECT count(*) FROM RESERVA where habitacion=:numero and fecha=:fecha", nativeQuery = true)
    public Integer disponibilidadQuery(@Param("numero") Integer numero, @Param("fecha") Date fecha);

    @Query(value = "select h.numero_h, h.precio_base, h.tipo FROM  Habitacion h left join reserva  r on h.numero_h = r.habitacion where r.habitacion is null and tipo=:tipo", nativeQuery = true)
    public List<Object> disponibilidadPorTipo(@Param("tipo") String tipo);


}
