package Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import Generics.CustomLinkedList;
import Models.Address;
import Models.Order;
import Models.Product;
import Models.User;

public class Setup {
	/**
	 * @param list
	 */
	public static void SetupLinkedListData(CustomLinkedList<User> list) {
		for(int i = 0; i < 12; i++)
		{
			User user = new User("jortiz");
			CreateRandomOrder(user);
			list.addLast(user);
		}
		System.out.println("Built Linked list.");
		System.out.println("Linked List size of : " + list.size());
		list.print();
	}
	
	public static Order CreateRandomOrder(User user)
	{

		//Create an order
		Order order = new Order(user.getId());
		order.setShippingAddress(new Address()); 
		List<Product> products = GenerateListOfProducts();
		Random rand = new Random();
		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		products = products.stream().limit(randomNum).collect(Collectors.toList()); //limit a random number of products so that all orders aren't the same.
		order.setProducts(products);
		return order;
	}

	public static List<Product> GenerateListOfProducts() {
				//Create Category
				Models.ProductCategory bookCategory = new Models.ProductCategory("Books");
				List<Product> products = new ArrayList<Product>();  	
				
				//Create Products
				Product p1 = new Product("Financial Management",  60.00, bookCategory);
				Product p2 = new Product("Advanced Programming",  80.00, bookCategory);
				Product p3 = new Product( "Intro to Marketing",  89.50, bookCategory);
				Product p4 = new Product( "American History 1",  99.99, bookCategory);
				Product p5 = new Product( "American History 2",  69.00, bookCategory);
				Product p6 = new Product( "Principles of Biology",  75.00, bookCategory);
				Product p7 = new Product( "Molecular Biology",  30.00, bookCategory);
				Product p8 = new Product( "Advanced Physics",  125.99, bookCategory);
				Product p9 = new Product( "Operating System",  80.00, bookCategory);
				Product p10 = new Product( "Discrete Mathematics",  123.00, bookCategory);
			
				//add products to the list
				products.add(p1);
				products.add(p2);
				products.add(p3);
				products.add(p4);
				products.add(p5);
				products.add(p6);
				products.add(p7);
				products.add(p8);
				products.add(p9);
				products.add(p10);
				return products;
	}
	

}
