package Models;


public class BaseProduct {
	
	public BaseProduct(int id, String name, float cost, ProductCategory category){
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
	public float cost;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
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
