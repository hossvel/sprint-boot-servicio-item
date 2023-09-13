package com.devhoss.app.item.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devhoss.app.item.clientes.IProductoClienteRest;
import com.devhoss.app.item.models.Item;
import com.devhoss.app.item.models.Producto;



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
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeign.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeign.eliminar(id);
	}


}
