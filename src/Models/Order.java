package Models;

import java.util.UUID;

import GUI.Home;

public class Order extends BaseOrder
{
	
	public Order(UUID userId)
	{
		super(userId);
	}

	public Boolean placeOrder()
	{
		Boolean isSuccessful = false;
		CalculateTotal();
		if (this.getShippingAddress().isValid()
				&& this.getPayment().AuthorizePayment() && this.getTotal() <= 0)
		{
			isSuccessful = false;
		}

		this.setComplete(true);
		System.out
				.println("Placed Order with return type of: " + isSuccessful);
		return isSuccessful;
	}

	public void CalculateTotal()
	{
		System.out.println("Calculating total...");
		this.setTotal(0.00); //reset the total to zero and calculate the cost of all products on the order.
		this.getProducts().stream().forEach(p ->
		{
			this.setTotal(this.getTotal() + p.cost);
		});
		Home h = new Home();
		h.textField.setText("Order placed.  Your total is: " + this.getTotal());
		System.out.println("Total set to:" + this.getTotal());
	}

	public void cancelOrder()
	{
		this.getProducts().clear();
		this.setShippingAddress(new Address());
		this.setPayment(new Payment());
		System.out.println("Cancelled Order");
	}
}
