package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;




@Controller
public class MainController {
	
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private LibroDAO libroDAO;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
		
	}
	
	@RequestMapping("/categoria")
	public ModelAndView ingresarCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("categoria");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView categoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			//regresar con los errores
			mav.setViewName("categoria");
		}else {
			categoriaDAO.insert(categoria);
			mav.addObject("exito","Categoria guardada con exito");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/libro")
	public ModelAndView ingresarLibro() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> categorias = categoriaDAO.findAll();
		mav.addObject("libro", libro);
		mav.addObject("categoria", libro.getCategoria());
		mav.addObject("categoriass", categorias);
		mav.setViewName("libro");
		return mav;
		
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView libro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> categorias = categoriaDAO.findAll();
			mav.addObject("categoriass", categorias);
			mav.setViewName("libro");
		}else {
			libroDAO.insert(libro);
			mav.addObject("exito","Libro guardado con exito");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = libroDAO.findAll();
		try {
			mav.addObject("libros", libros);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listado");
		return mav;
	}
	
	
	/*@RequestMapping("/inicio")
	public ModelAndView initMain2() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente =new Contribuyente();
		mav.addObject("contribuyente",  contribuyente);
		List<Importancia> importancias = null;
		importancias = importanciaDAO.findAll();
		mav.addObject("importancia", contribuyente.getImportancia());
		mav.addObject("importancias", importancias);
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/exito")
	public ModelAndView exito(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		contribuyenteDAO.insert(contribuyente);
		mav.setViewName("exito");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = contribuyenteDAO.findAll(); 
		
		try {
			mav.addObject("contribuyentes", contribuyentes);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listado");
		return mav;
	}*/
}
