package com.devhoss.app.item.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devhoss.app.item.models.Item;

@RestController
public class ItemController {
	
	@GetMapping("/item")
	public List<Item> listar(){
		return List.of();
	}
	
	
}