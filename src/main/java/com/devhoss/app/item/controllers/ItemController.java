package com.devhoss.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devhoss.app.item.models.Item;
import com.devhoss.app.item.models.Producto;
import com.devhoss.app.item.services.IItemService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ItemController {
	
	private final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	
	@Autowired
	@Qualifier("serviceFeign")
	private IItemService iitemService;
	
	@GetMapping("/item")
	public List<Item> listarItemVacio(){
		return List.of();
	}
	
	
	@GetMapping("/listar")
	public List<Item> listar(@RequestParam(name="nombre", required= false) String nombre, @RequestHeader(name="token-request", required = false) String token){
		System.out.println(nombre);
		System.out.println(token);
		return iitemService.findAll();
	}
	
	//@CircuitBreaker(name = "detalle", fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return cbFactory.create("items")
				.run(()-> iitemService.findById(id, cantidad), e -> metodoAlternativoprogramatico(id, cantidad,e));
	}
	
	
	public Item metodoAlternativoprogramatico(Long id,  Integer cantidad,Throwable e) {
		logger.info(e.getMessage());
		Item item = new Item();
		Producto producto = new Producto();
		
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Producto por defecto programatico");
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
	}
	
	
	@CircuitBreaker(name="items", fallbackMethod = "metodoAlternativoAnotaciones")
	@GetMapping("/ver2/{id}/cantidad/{cantidad}")
	public Item detalle2(@PathVariable Long id, @PathVariable Integer cantidad) {
		return iitemService.findById(id, cantidad);
	}
	
	public Item metodoAlternativoAnotaciones(Long id, Integer cantidad, Throwable e) {
		logger.info(e.getMessage());
		Item item = new Item();
		Producto producto = new Producto();
		
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Producto por defecto anotaciones");
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
	}
	
	
}