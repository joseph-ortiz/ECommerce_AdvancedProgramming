package Models;

import java.util.UUID;

import GUI.Home;

public class Order extends BaseOrder
{
	
	public Order(String string)
	{
		super(string);
	}

	public Boolean placeOrder()
	{
		System.out.println("userID: " + this.getUserid()  +" Attempting to place order");
		Boolean isSuccessful = false;
		CalculateTotal();
		if (isValidOrder())
		{
			this.setComplete(true);
			isSuccessful = true;
		}else{
			this.setComplete(false);
		}

		
		System.out
				.println("Placed Order with return type of: " + isSuccessful);
		return isSuccessful;
	}

	private boolean isValidOrder() {
		System.out.println("userID: " + this.getUserid()  + " Validating order...");
		return (this.getShippingAddress().isValid()
				&& this.getPayment().AuthorizePayment() 
				&& this.ValidTotal());
	}

	private boolean ValidTotal() {
		System.out.println("userID: " + this.getUserid()  + " validating total...");	
		if (this.getTotal() <= 0)
				return false;
			return true;
	}

	public Double CalculateTotal()
	{
		System.out.println("userID: " + this.getUserid() + " Calculating total...");
		this.setTotal(0.00); //reset the total to zero and calculate the cost of all products on the order.
		this.getProducts().stream().forEach(p ->
		{
			this.setTotal(this.getTotal() + p.cost);
		});
		
		System.out.println("userID: " + this.getUserid() + " Total set to:" + this.getTotal());
		return this.getTotal();
	}

	public void cancelOrder()
	{
		this.getProducts().clear();
		this.setShippingAddress(new Address());
		this.setPayment(null);
		System.out.println("userID: " + this.getUserid() + "Cancelled Order");
	}
}
