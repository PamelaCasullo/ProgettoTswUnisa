package it.MadDiscord.Model;

import java.util.ArrayList;
import java.util.List;


public class Cart <T>{
	
	List<T> items;
	public Cart() {
		items = new ArrayList<T>();
	}
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public void deleteItem(T item) {
		items.remove(item);
	}
	
	public List<T> getItems(){
		return items;
	}
	
	public void deleteItems() {
		items.clear();
	}

}
