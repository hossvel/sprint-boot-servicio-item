package com.devhoss.app.item.services;

import java.util.List;

import com.devhoss.app.item.models.Item;
import com.devhoss.app.item.models.Producto;

public interface IItemService {
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

	public Producto save(Producto producto);

	public Producto update(Producto producto, Long id);

	public void delete(Long id);
}
