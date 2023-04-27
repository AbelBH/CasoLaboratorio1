package com.cibertec.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.proj.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
