package Logic;


import java.util.ArrayList;
import java.util.List;

import Models.Address;
import Models.Order;
import Models.Product;
import Models.ProductCategory;
import Models.User;


public class Tester {

	public static void main(String[] args) {
		
		User user = new User("jortiz3");
		//Create an order
		Order order = new Order(user.getId());
		order.setShippingAddress(new Address()); //TODO: Create GUI for address field Then get address from user input. 
		user.orders.add(order);
		
		//Create Category
		ProductCategory category = new ProductCategory("Books");
		
		//Create Products
		Product p1 = new Product(1,"Financial Management",  60.00, category);
		Product p2 = new Product(2,"Advanced Programming",  80.00, category);
		Product p3 = new Product(3, "Networking Book",  40.00, category);
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		order.setProducts(products);
		order.placeOrder();
		}
}
