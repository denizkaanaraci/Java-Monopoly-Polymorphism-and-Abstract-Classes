import java.util.ArrayList;
/**
 * this class has player features and abstract func
 * @author as
 *
 */
public class playerClass extends peopleClass{

	private String playerName;
	private int playerDice;
	private int playerPosition;
	private int playerMoney;
	private String playerMove;
	private ArrayList<String> playerProperty;
	private int playerRailroadCount;
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
	public int getJailCount() {
		return jailCount;
	}
	public void setJailCount(int jailCount) {
		this.jailCount = jailCount;
	}
	public playerClass(String playerName, int playerDice, int playerPosition, int playerMoney, String playerMove,
			ArrayList<String> playerProperty, int playerRailroadCount,int jailCount) {
		super();
		this.playerName = playerName;
		this.playerDice = playerDice;
		this.playerPosition = playerPosition;
		this.playerMoney = playerMoney;
		this.playerMove = playerMove;
		this.playerProperty = playerProperty;
		this.playerRailroadCount = playerRailroadCount;
		this.jailCount = jailCount;
	}

	@Override
	public void absFunc() {


	}


}
