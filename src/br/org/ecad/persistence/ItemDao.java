package br.org.ecad.persistence;

import java.util.List;

import br.org.ecad.model.Item;

public interface ItemDao {
	public boolean save(Item item);
	public List<Item> listaItem();
	public boolean remove (Item item);
	

}
