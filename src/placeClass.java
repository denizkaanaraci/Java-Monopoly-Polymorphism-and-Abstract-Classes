/**
 * this class has property,card features and abstract func
 * @author as
 *
 */
public abstract class placeClass {

	private int id;
	private String name;
	private int cost;
	private String item;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public abstract void absFunc();

}
