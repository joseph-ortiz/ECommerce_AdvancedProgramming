package Models;

import java.util.List;
import java.util.UUID;

public class Order extends BaseOrder{
	
	
	public Order(UUID userId) {
		super(userId);
	}

	public Boolean placeOrder()
	{
		Boolean isSuccesseful = false;
		if(this.ShippingAddress.isValid()) isSuccesseful = true;
		if(this.payment.AuthorizePayment()) isSuccesseful = true;
	    this.isComplete = true;
	    System.out.println("Placed Order with return type of: " + isSuccesseful);
		return isSuccesseful;
	}
	
	public void cancelOrder()
	{
		this.products.clear();
		this.setShippingAddress(new Address());
		this.setPayment(new Payment());
		System.out.println("Cancelled Order");
		
	}
	
}
