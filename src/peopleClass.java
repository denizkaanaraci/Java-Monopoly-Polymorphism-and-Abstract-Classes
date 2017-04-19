import java.util.ArrayList;
/**
 * this class has player,bank features and abstract func.
 * 
 * @author as
 *
 */
public abstract class peopleClass {

	private String playerName;
	private int playerDice;
	private int playerPosition;
	private int playerMoney;
	private String playerMove;
	private ArrayList<String> playerProperty;
	private int playerRailroadCount;
	private int bankerMoney;
	private int jailCount;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerDice() {
		return playerDice;
	}
	public void setPlayerDice(int playerDice) {
		this.playerDice = playerDice;
	}
	public int getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
	public int getPlayerMoney() {
		return playerMoney;
	}
	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}
	public String getPlayerMove() {
		return playerMove;
	}
	public void setPlayerMove(String playerMove) {
		this.playerMove = playerMove;
	}
	public ArrayList<String> getPlayerProperty() {
		return playerProperty;
	}
	public void setPlayerProperty(ArrayList<String> playerProperty) {
		this.playerProperty = playerProperty;
	}
	public int getPlayerRailroadCount() {
		return playerRailroadCount;
	}
	public void setPlayerRailroadCount(int playerRailroadCount) {
		this.playerRailroadCount = playerRailroadCount;
	}
	public int getBankerMoney() {
		return bankerMoney;
	}
	public void setBankerMoney(int bankerMoney) {
		this.bankerMoney = bankerMoney;
	}
	public int getJailCount() {
		return jailCount;
	}
	public void setJailCount(int jailCount) {
		this.jailCount = jailCount;
	}
	public abstract void absFunc();

}
