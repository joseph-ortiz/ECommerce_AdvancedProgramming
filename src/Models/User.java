package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User implements Comparable<User> {
	
	
	public User(String username, int priority){
		this.Id = UUID.randomUUID().toString().substring(0, 4);
		this.username = username;
		this.email = username + "@ggc.edu";
		this.orders = new ArrayList<Order>();
		this.priority = priority;
	}
	
	public User(String username){
		this.Id = UUID.randomUUID().toString().substring(0, 4);
		this.username = username;
		this.email = username + "@ggc.edu";
		this.orders = new ArrayList<Order>();
		this.priority = 0;
	}
	
	public String Id;
	public String username;
	public String email;
	public List<Order> orders;
	private int priority;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + this.Id + "\tUser ID: " + this.username);
		return sb.toString();	
	}
	@Override
	public int compareTo(User o) {
			return this.priority - o.priority;
	}

	public int getPriority() {
		return this.priority;
	}
	
	
}
