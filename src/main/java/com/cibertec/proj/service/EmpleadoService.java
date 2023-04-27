package com.cibertec.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.proj.entity.Empleado;
import com.cibertec.proj.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	@Autowired
	private EmpleadoRepository repo;
	
	public void registrar(Empleado e) {
		repo.save(e);
	}
	
	public List<Empleado> listarTodo(){
		return repo.findAll();
	}
}
