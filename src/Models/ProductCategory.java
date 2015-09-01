package Models;

import java.util.UUID;

public class ProductCategory {
	public ProductCategory(String name){
		this.Id = java.util.UUID.randomUUID();
		this.name = name;
	}
	public UUID Id;
	public String name;
	
	public UUID getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
