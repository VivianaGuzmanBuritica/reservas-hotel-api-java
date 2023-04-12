package com.example.workshopreservas.repository;

import com.example.workshopreservas.entity.Cliente;
import com.example.workshopreservas.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Integer> {
}
