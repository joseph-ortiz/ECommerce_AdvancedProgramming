package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseOrder
{
	private UUID id;
	private double total;
	private Payment payment;
	private List<Product> products;
	private Address ShippingAddress;
	private Boolean isComplete;
	private String userid;
	
	/**Constructor: BaseOrder.java
	 * Initializes object with following params.
	 */
	public BaseOrder()
	{
		super();
	}

	public BaseOrder(String string)
	{
		this.id = java.util.UUID.randomUUID();
		this.total = 0.00;
		this.payment = new Payment(PaymentType.VISA);
		this.products = new ArrayList<Product>();
		this.userid = string;
		this.ShippingAddress = new Address();
		this.isComplete = false;
	}

	public UUID getId()
	{
		return id;
	}

	public void setId(UUID id)
	{
		this.id = id;
	}

	public double getTotal()
	{
		return total;
	}

	public void setTotal(double total)
	{
		this.total = total;
	}

	public Payment getPayment()
	{
		return payment;
	}

	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}

	public List<Product> getProducts()
	{
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public Address getShippingAddress()
	{
		return ShippingAddress;
	}

	public void setShippingAddress(Address shippingAddress)
	{
		ShippingAddress = shippingAddress;
	}

	public boolean isComplete()
	{
		return isComplete;
	}

	public void setComplete(boolean isComplete)
	{
		this.isComplete = isComplete;
	}

}
