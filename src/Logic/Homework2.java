package Logic;

import Helper.Setup;
import Models.Order;
import Models.Payment;
import Models.PaymentType;
import Models.User;

public class Homework2 {
	
	/**
	 * HW#2 problem 2: Create multiple orders and create them as threads.
	 */
	@SuppressWarnings("unused")
	private static void CreateThreadedOrdersExample() {
		User user = new User("jortiz3");
		Order o1 = Setup.CreateRandomOrder(user);
		o1.setPayment(new Payment(PaymentType.AMERICAN_EXPRESS));
		user.orders.add(o1);
		
		
		User user2 = new User("kwilson");
		Order o2 = Setup.CreateRandomOrder(user2);
		o2.setPayment(new Payment(PaymentType.PAYPAL));
		user2.orders.add(o2);
		

		User user3 = new User("kanthony");
		Order o3 = Setup.CreateRandomOrder(user2);
		o2.setPayment(new Payment(PaymentType.MASTERCARD));
		user3.orders.add(o3);
		
		
		Thread t1 = new Thread(new OrderTask(user));
		Thread t2 = new Thread(new OrderTask(user2));
		Thread t3 = new Thread(new OrderTask(user3));

		t1.start();
		t2.start();
		t3.start();
	}
}
