package com.cibertec.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.proj.entity.Area;
import com.cibertec.proj.entity.Empleado;
import com.cibertec.proj.service.AreaService;
import com.cibertec.proj.service.EmpleadoService;

@Controller
@RequestMapping("/Empleado")
public class EmpleadoController {
	@Autowired
	private AreaService servicioArea;
	@Autowired
	private EmpleadoService servicioEmpleado;
	
	@RequestMapping("/list")
	public String inicio(Model model) {
		model.addAttribute("empleados", servicioEmpleado.listarTodo());
		model.addAttribute("areas", servicioArea.listarTodo());
		return "Empleados";
	}

	@RequestMapping("/grabar")
	public String grabar(@RequestParam("nombre") String nom,@RequestParam("apellido") String ape,@RequestParam("dni") int dni,@RequestParam("numero") int num, 
			@RequestParam("area") int idarea, RedirectAttributes redirect) {
		
		try {
			Empleado bean = new Empleado();
			
			bean.setNombre(nom);
			bean.setApellido(ape);
			bean.setDni(dni);
			bean.setNumero(num);
			Area a = new Area();
			a.setCodigo(idarea);
			
			bean.setArea(a);
			servicioEmpleado.registrar(bean);
			redirect.addFlashAttribute("MENSAJE", "Empleado registrado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en el registro");
			e.printStackTrace();
		}
		
		
		return "redirect:/Empleado/list";
	}
}
