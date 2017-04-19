/**
 * this class has banker features and abstract func.
 * @author as
 *
 */
public class bankerClass extends peopleClass {

	private int bankerMoney;

	public int getBankerMoney() {
		return bankerMoney;
	}

	public void setBankerMoney(int bankerMoney) {
		this.bankerMoney = bankerMoney;
	}

	public bankerClass(int bankerMoney) {
		super();
		this.bankerMoney = bankerMoney;
	}

	@Override
	public void absFunc() {

	}

}
