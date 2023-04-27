package com.cibertec.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.proj.entity.Area;
import com.cibertec.proj.repository.AreaRepository;

@Service
public class AreaService {
	@Autowired
	private AreaRepository repo; //para el combo
	
	public List<Area> listarTodo(){
		return repo.findAll();
	}
}
