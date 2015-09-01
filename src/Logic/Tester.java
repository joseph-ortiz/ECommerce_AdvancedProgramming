package Logic;

import Models.Address;
import Models.Order;
import Models.PaymentType;
import Models.Product;
import Models.ProductCategory;
import Models.User;

public class Tester {

	public static void main(String[] args) {
		
		//Create user.
		User user = new User("jortiz3");
		
		
		//Create an order
		Order order = new Order(user.getId());
		
		order.setShippingAddress(new Address()); //TODO: get address from user input.
		user.orders.add(order);
		
		//Create Category
		ProductCategory category = new ProductCategory("Books");
		
		//adds product to order.
		order.products.add(
				new Product(1,"Financial Management", (float) 60.00, category)
		);
		order.products.add(
				new Product(2,"Advanced Programming", (float) 80.00, category)
		);
		
		//Set payment type
		order.payment.type = PaymentType.PAYPAL;
		
		//Create Order from added products.
		order.placeOrder();
	}

}
