package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseOrder{
	
	public BaseOrder(UUID userId){
		this.id = java.util.UUID.randomUUID(); 
		this.total = 0;
		this.payment = new Payment();
		this.products = new ArrayList<Product>();
		this.userid = userId;
		this.ShippingAddress = new Address();
		this.isComplete = false;
	}
	
	public UUID id;
	public int total;
	public Payment payment;
	public List<Product> products;
	public Address ShippingAddress;
	public boolean isComplete;
	public UUID userid;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public UUID getUserid() {
		return userid;
	}
	public void setUserid(UUID userid) {
		this.userid = userid;
	}
	public Address getShippingAddress() {
		return ShippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		ShippingAddress = shippingAddress;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
}
