package com.devhoss.app.item.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devhoss.app.item.clientes.IProductoClienteRest;
import com.devhoss.app.item.models.Item;


@Service("serviceFeign")
public class ItemServiceFeignImpl implements IItemService {

	
	@Autowired
	private IProductoClienteRest clienteFeign;
	
	
	@Override
	public List<Item> findAll() {
		System.out.println("serviceFeign - findAll");
		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		System.out.println("serviceFeign - findById");
		return new Item(clienteFeign.detalle(id), cantidad);
	}


}
