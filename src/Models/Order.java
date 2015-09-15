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
		Boolean isValidAddress = this.getShippingAddress().isValid();
		System.out.println("userID: " + this.getUserid()  + " Validated Address");
		Boolean isPaymentAuthorized = this.getPayment().AuthorizePayment();
		System.out.println("userID: " + this.getUserid()  + " Authorized Payment");
		Boolean isValidTotal = this.ValidTotal();
		System.out.println("userID: " + this.getUserid()  + " Validated Total");
		return (isValidAddress
				&& isPaymentAuthorized
				&& isValidTotal);
	}

	private boolean ValidTotal() {
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
