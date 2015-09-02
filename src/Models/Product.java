package Models;

import java.util.List;
import java.util.stream.Collectors;

public class Product extends BaseProduct{
	
	
	public Product(int id, String name, Double cost, ProductCategory category) {
		super(id, name, cost, category);
	}
	/***************************** 
	*      Public Methods
	******************************/
	public void addItem(Order order){
		order.getProducts().add(this);
	}
	public void removeItem(Order order){ //TODO:remove all products with that name.
		List<Product> products = order.getProducts().stream().filter( e -> e.getName() != this.name).collect(Collectors.toList());
		order.setProducts(products);
	}
	
}
