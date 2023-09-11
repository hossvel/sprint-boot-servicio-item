package com.devhoss.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devhoss.app.item.models.Item;
import com.devhoss.app.item.services.IItemService;

@RestController
public class ItemController {
	
	
	@Autowired
	@Qualifier("serviceFeign")
	private IItemService iitemService;
	
	@GetMapping("/item")
	public List<Item> listarItemVacio(){
		return List.of();
	}
	
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return iitemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return iitemService.findById(id, cantidad);
	}
	
}