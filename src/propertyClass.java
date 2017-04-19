/**
 *this class has property features and abstract func
 * @author as
 *
 */
public class propertyClass extends placeClass {


	private int id;
	private String name;
	private int cost;



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



	public propertyClass(int id, String name, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}



	@Override
	public void absFunc() {

	}







}	

