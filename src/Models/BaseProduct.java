package Models;


public class BaseProduct {
	
	public BaseProduct(int id, String name, Double cost, ProductCategory category){
		this.Id = id;
		this.name = name;
		this.cost = cost;
		this.category = category;
		
	}

	/***************************** 
	*      Fields
	******************************/
	public int Id;
	public String name;
	public Double cost;
	public ProductCategory category;
	
	
	
	/***************************** Start
	*      GETTERS and Setters
	******************************/
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	/***************************** END
	*      GETTERS and Setters
	******************************/
}
