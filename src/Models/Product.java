package Models;

import java.util.stream.Collectors;

public class Product extends BaseProduct{
	
	
	public Product(int id, String name, float cost, ProductCategory category) {
		super(id, name, cost, category);
	}
	/***************************** 
	*      Public Methods
	******************************/
	public void addItem(Order order){
		order.products.add(this);
	}
	public void removeItem(Order order){ //TODO:remove all products with that name.
		order.products = order.products.stream().filter( e -> e.getName() != this.name).collect(Collectors.toList());
	}
	
}
