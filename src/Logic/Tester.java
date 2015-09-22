package Logic;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import Generics.GenericStack;
import Models.Address;
import Models.Order;
import Models.Payment;
import Models.PaymentType;
import Models.Product;
import Models.User;




public class Tester {
	public static void main(String[] args) {
		 
		//Homework#3
		//Instructions	 
		//#1.  Apply the GenericStack<E> as discussed in class, “add” 12 e-commerce customers and/or transactions, 
		//“remove” the 5th customer. Make sure you keep the rest of the patients in the same stack.
		
		//#1 Apply the GenericStack<E> as discussed in class, “add” 12 e-commerce customers and/or transactions
		//GenericStackExample();
	
		
		
		
		
		

		//#2.  Create a new LinkedList ( and an associated ListIterator), store “add” 12 customers. 
		//“Remove” the customer(s) in the middle. 
		// hint    listiterator<costomer> it = list.listiterator();
		//TODO: create LInkedList
		//TODO: get the middle nodes. i.e. 5 and 6
		//TODO: pop the head off  push the head node to the queue but skip 5 and 6 by using a counter
		//TODO: build a new LInked List with the new list.
		//TODO: 
		 

		//#3.  Create a “queue”, “add” 12 customers, remove a couple customers in the middle. Maintain the same queueing order for the rest of customers.
		//user piorityQueue
	
	}

	/**
	 * 
	 */
	private static void GenericStackExample() {
		GenericStack<User> stack= new GenericStack<User>();
		for(int i = 0; i < 12; i++)
		{
			User user = new User("jortiz");
			Order o= CreateRandomOrder(user);
			stack.push(user);
		}
		System.out.println("Building the stack");
		System.out.println("stack size: " + stack.getSize());
		
		
		//#2 Remove the fifth customer
		int originalStackSize = stack.getSize();
		GenericStack<User> tempStack = new GenericStack<User>();
		for(int j = 0; j < originalStackSize; j++)
		{
			if(j != 4){
				System.out.println("added element at index: " + j + " to the tempStack.");
				tempStack.push(stack.pop());
			}else{
				System.out.println("skipped over the fifth element");
			}
		}
		System.out.println("pushing to the  temp stack");
		System.out.println("stack size: " + stack.getSize());
		System.out.println("tempStack size: " + tempStack.getSize());
		
		
		for(int k = 0; k < originalStackSize-1; k++)
		{	
			User user = tempStack.pop();
			stack.push(user); 
		}
		System.out.println("Pushing to the original stack");
		System.out.println("tempStack size: " + tempStack.getSize());
		System.out.println("stack size: " + stack.getSize());
	}

	/**
	 * Homework #2: Create multiple orders and create them as threads.
	 */
	private static void CreateThreadedOrdersExample() {
		User user = new User("jortiz3");
		Order o1 = CreateRandomOrder(user);
		o1.setPayment(new Payment(PaymentType.AMERICAN_EXPRESS));
		user.orders.add(o1);
		
		
		User user2 = new User("kwilson");
		Order o2 = CreateRandomOrder(user2);
		o2.setPayment(new Payment(PaymentType.PAYPAL));
		user2.orders.add(o2);
		

		User user3 = new User("kanthony");
		Order o3 = CreateRandomOrder(user2);
		o2.setPayment(new Payment(PaymentType.MASTERCARD));
		user3.orders.add(o3);
		
		
		Thread t1 = new Thread(new OrderTask(user));
		Thread t2 = new Thread(new OrderTask(user2));
		Thread t3 = new Thread(new OrderTask(user3));

		t1.start();
		t2.start();
		t3.start();
	}
	
	private static Order CreateRandomOrder(User user)
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

	private static List<Product> GenerateListOfProducts() {
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
