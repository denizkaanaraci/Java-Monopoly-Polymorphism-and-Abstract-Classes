import java.io.IOException;
import java.util.ArrayList;
/**
 * this class includes all control functions
 * @author as
 *
 */
public class functionClass {


	int chanceInt=0;
	int chestInt=0;
/**
 * showFunc sends player and card features to writeFileShow when it called by user
 * @param player1
 * @param player2
 * @param banker
 * @param landList
 * @param railroadList
 * @param companyList
 * @param chanceCardList
 * @param chestCardList
 * @throws IOException
 */

	public void showFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{

		writeClass writeObj = new writeClass();

		if(player1.getPlayerName().equals("Player 1")){
			writeObj.writeFileShow(player1, player2, banker);
		}
		else{
			writeObj.writeFileShow(player2, player1, banker);
		}	
	}
	/**
	 * dataFunc sends player and card features to writeFileData when it called by user
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @throws IOException
	 */
	public void dataFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{

		writeClass writeObj = new writeClass();

		if(player1.getPlayerName().equals("Player 1")){
			String lineData = (player1.getPlayerName()+"\t"+player1.getPlayerDice()+"\t"+player1.getPlayerPosition()+
					"\t"+player1.getPlayerMoney()+"\t"+player2.getPlayerMoney()+"\t"+player1.getPlayerMove());
			writeObj.writeFileData(lineData);
		}
		else {
			String lineData = (player1.getPlayerName()+"\t"+player1.getPlayerDice()+"\t"+player1.getPlayerPosition()+
					"\t"+player2.getPlayerMoney()+"\t"+player1.getPlayerMoney()+"\t"+player1.getPlayerMove());
			writeObj.writeFileData(lineData);
		}
	}
	/**
	 * describeFunc is main loop function. 
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @param readCommand
	 * @throws IOException
	 */
	public void describeFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList,String[] readCommand) throws IOException{

		for ( int i=0; i< readCommand.length; i++){

			if(readCommand[i].equals("show()")){

				showFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
			}
			else {

				String[] move = readCommand[i].split(";");

				if(move[0].equals("Player 1")){
					player1.setPlayerDice(Integer.parseInt(move[1]));
					player1.setPlayerPosition(player1.getPlayerPosition()+Integer.parseInt(move[1]));
					while(player1.getPlayerPosition()>40){
						player1.setPlayerPosition(player1.getPlayerPosition()%40);
						player1.setPlayerMoney(player1.getPlayerMoney()+200);
						banker.setBankerMoney(banker.getBankerMoney()-200);						
					}
					if((player1.getJailCount()%4)>2){

						passFunc(player1, player2, banker, landList,railroadList, companyList,chanceCardList,chestCardList);
						dataFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
					}
					else{
						jailCounter(player1, player2);
						dataFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
					}
				}
				else if(move[0].equals("Player 2")){
					player2.setPlayerDice(Integer.parseInt(move[1]));
					player2.setPlayerPosition(player2.getPlayerPosition()+Integer.parseInt(move[1]));
					while(player2.getPlayerPosition()>40){
						player2.setPlayerPosition(player2.getPlayerPosition()%40);
						player2.setPlayerMoney(player2.getPlayerMoney()+200);
						banker.setBankerMoney(banker.getBankerMoney()-200);
					}
					if((player2.getJailCount()%4)>2){
						passFunc(player2, player1, banker, landList,railroadList, companyList,chanceCardList,chestCardList);
						dataFunc(player2, player1, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
					}
					else{
						jailCounter(player2, player1);
						dataFunc(player2, player1, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
					}
				}
			}
		}
		if(player1.getPlayerName().equals("Player 1")){
			showFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
		}
		else{
			showFunc(player2, player1, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
		}
	}
	/**
	 * passFunc is pass function. It just calls controlFunction
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @throws IOException
	 */
	public void passFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{

		controlFunc(player1, player2, banker, landList,railroadList, companyList,chanceCardList,chestCardList);

	}
	/**
	 * jailCounter is setting player jailcount,playerposition and playermove
	 * @param player1
	 * @param player2
	 */
	public void jailCounter(peopleClass player1,peopleClass player2){
		player1.setJailCount(player1.getJailCount()+1);
		player1.setJailCount(player1.getJailCount()%4);
		player1.setPlayerPosition(11);
		player1.setPlayerMove(player1.getPlayerName() + " in jail " + "(count=" + player1.getJailCount() + ")");
	}
	/**
	 * when player out of money,bankruptFunc will called.
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @throws IOException
	 */
	public void bankruptFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{
		player1.setPlayerMove(player1.getPlayerName()+" goes bankrupt");
		dataFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
		showFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
		System.exit(0);
	}
	/**
	 * landRent function calculates land rent
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @param landCost
	 * @throws IOException
	 */
	public void landRent(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList,int landCost) throws IOException{

		if(landCost <= 2000){
			if((player1.getPlayerMoney()-((landCost*40)/100))<0){
				bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
			}
			player1.setPlayerMoney(player1.getPlayerMoney()-((landCost*40)/100));
			player2.setPlayerMoney(player2.getPlayerMoney()+((landCost*40)/100));		
		}
		else if(landCost <= 3000){
			if((player1.getPlayerMoney()-((landCost*30)/100))<0){
				bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
			}
			player1.setPlayerMoney(player1.getPlayerMoney()-((landCost*30)/100));
			player2.setPlayerMoney(player2.getPlayerMoney()+((landCost*30)/100));		
		}
		else if(landCost <= 4000){
			if((player1.getPlayerMoney()-((landCost*35)/100))<0){
				bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
			}
			player1.setPlayerMoney(player1.getPlayerMoney()-((landCost*35)/100));
			player2.setPlayerMoney(player2.getPlayerMoney()+((landCost*35)/100));		
		}	
	}
	/**
	 * railroadRent function calculates railroad rent
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @throws IOException
	 */
	public void railroadRent(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{
		if(((player1.getPlayerMoney()-(player2.getPlayerRailroadCount()*25))<0)){
			bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
		}
		player1.setPlayerMoney(player1.getPlayerMoney()-(player2.getPlayerRailroadCount()*25));
		player2.setPlayerMoney(player2.getPlayerMoney()+(player2.getPlayerRailroadCount()*25));
	}
	/**
	 * companyRent function calculates company rent
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @throws IOException
	 */
	public void companyRent(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{
		if((player1.getPlayerMoney()-(player1.getPlayerDice()*4))<0){
			bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
		}
		player1.setPlayerMoney(player1.getPlayerMoney()-(player1.getPlayerDice()*4));
		player2.setPlayerMoney(player2.getPlayerMoney()+(player1.getPlayerDice()*4));
	}
	/**
	 * chanceFunc function includes chance list features
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @param landId
	 * @throws IOException
	 */
	public void chanceFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList,ArrayList<Integer> landId) throws IOException{

		chanceInt=chanceInt%6;

		if (chanceInt==0){

			player1.setPlayerPosition(1);
			player1.setPlayerMoney(player1.getPlayerMoney()+200);
			banker.setBankerMoney(banker.getBankerMoney()-200);

			controlFunc(player1, player2, banker, landList,railroadList, companyList,chanceCardList,chestCardList);		
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chanceCardList.get(chanceInt).getItem());

		}
		else if (chanceInt==1){
			if(player1.getPlayerPosition()+27>40){
				player1.setPlayerMoney(player1.getPlayerMoney()+200);
				banker.setBankerMoney(banker.getBankerMoney()-200);			
			}
			player1.setPlayerPosition(27);
			controlFunc(player1, player2, banker, landList,railroadList, companyList,chanceCardList,chestCardList);
			player1.setPlayerMove(player1.getPlayerName()+" draws " +chanceCardList.get(chanceInt).getItem()+" "+player1.getPlayerMove());
		}
		else if (chanceInt==2){
			player1.setPlayerPosition(player1.getPlayerPosition()-3);
			controlFunc(player1, player2, banker, landList,railroadList, companyList,chanceCardList,chestCardList);
			player1.setPlayerMove(player1.getPlayerName()+" draws " +chanceCardList.get(chanceInt).getItem()+" "+player1.getPlayerMove());
		}
		else if (chanceInt==3){
			player1.setPlayerMoney(player1.getPlayerMoney()-15);
			banker.setBankerMoney(banker.getBankerMoney()+15);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chanceCardList.get(chanceInt).getItem());
		}
		else if (chanceInt==4){
			player1.setPlayerMoney(player1.getPlayerMoney()+150);
			banker.setBankerMoney(banker.getBankerMoney()-150);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chanceCardList.get(chanceInt).getItem());
		}
		else if (chanceInt==5){
			player1.setPlayerMoney(player1.getPlayerMoney()+100);
			banker.setBankerMoney(banker.getBankerMoney()-100);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chanceCardList.get(chanceInt).getItem());
		}

		chanceInt++;
	}
	/**
	 * communityFunc function includes community chest list features
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @param landId
	 * @throws IOException
	 */
	public void communityFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList,ArrayList<Integer> landId) throws IOException{

		chestInt=chestInt%11;

		if (chestInt==0){
			player1.setPlayerPosition(1);
			player1.setPlayerMoney(player1.getPlayerMoney()+200);
			banker.setBankerMoney(banker.getBankerMoney()-200);

			controlFunc(player1, player2, banker, landList,railroadList, companyList,chanceCardList,chestCardList);		
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());
		}
		else if (chestInt==1){
			player1.setPlayerMoney(player1.getPlayerMoney()+75);
			banker.setBankerMoney(banker.getBankerMoney()-75);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());	
		}
		else if (chestInt==2){

			player1.setPlayerMoney(player1.getPlayerMoney()-50);
			banker.setBankerMoney(banker.getBankerMoney()+50);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());			
		}
		else if (chestInt==3){

			player1.setPlayerMoney(player1.getPlayerMoney()+10);
			player2.setPlayerMoney(player2.getPlayerMoney()-10);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());
		}
		else if (chestInt==4){

			player1.setPlayerMoney(player1.getPlayerMoney()+50);
			player2.setPlayerMoney(player2.getPlayerMoney()-50);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());
		}
		else if (chestInt==5){

			player1.setPlayerMoney(player1.getPlayerMoney()+20);
			banker.setBankerMoney(banker.getBankerMoney()-20);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());		
		}
		else if (chestInt==6){

			player1.setPlayerMoney(player1.getPlayerMoney()+100);
			banker.setBankerMoney(banker.getBankerMoney()-100);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());		
		}
		else if (chestInt==7){

			player1.setPlayerMoney(player1.getPlayerMoney()-100);
			banker.setBankerMoney(banker.getBankerMoney()+100);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());		
		}
		else if (chestInt==8){

			player1.setPlayerMoney(player1.getPlayerMoney()-50);
			banker.setBankerMoney(banker.getBankerMoney()+50);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());		
		}
		else if (chestInt==9){

			player1.setPlayerMoney(player1.getPlayerMoney()+100);
			banker.setBankerMoney(banker.getBankerMoney()-100);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());		
		}
		else if (chestInt==10){

			player1.setPlayerMoney(player1.getPlayerMoney()+50);
			banker.setBankerMoney(banker.getBankerMoney()-50);
			player1.setPlayerMove(player1.getPlayerName()+" draws "+chestCardList.get(chestInt).getItem());		
		}

		chestInt++;
	}
	/**
	 * controlFunc function includes player position features. 
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param landList
	 * @param railroadList
	 * @param companyList
	 * @param chanceCardList
	 * @param chestCardList
	 * @throws IOException
	 */
	public void controlFunc(peopleClass player1,peopleClass player2,peopleClass banker,ArrayList<placeClass> landList,
			ArrayList<placeClass> railroadList,ArrayList<placeClass> companyList,
			ArrayList<placeClass> chanceCardList,ArrayList<placeClass> chestCardList) throws IOException{

		ArrayList<Integer> landId=new ArrayList<Integer>();
		ArrayList<Integer> railroadId=new ArrayList<Integer>();
		ArrayList<Integer> companyId=new ArrayList<Integer>();

		for ( int i1=0; i1< landList.size(); i1++){
			landId.add(landList.get(i1).getId());
		}
		for ( int i1=0; i1< railroadList.size(); i1++){
			railroadId.add(railroadList.get(i1).getId());
		}
		for ( int i1=0; i1< companyList.size(); i1++){
			companyId.add(companyList.get(i1).getId());
		}
		if(player1.getPlayerPosition() == 1){
			player1.setPlayerMove(player1.getPlayerName()+" is in GO Square");

		}
		else if(landId.contains(player1.getPlayerPosition())){

			if(player2.getPlayerProperty().contains(landList.get(landId.indexOf(player1.getPlayerPosition())).getName())){
				landRent(player1, player2, banker, chestCardList, chestCardList, chestCardList, chestCardList, chestCardList, landList.get(landId.indexOf(player1.getPlayerPosition())).getCost());
				player1.setPlayerMove(player1.getPlayerName()+" paid rent for "+landList.get(landId.indexOf(player1.getPlayerPosition())).getName());
			}
			else if(player1.getPlayerProperty().contains(landList.get(landId.indexOf(player1.getPlayerPosition())).getName())){

				player1.setPlayerMove(player1.getPlayerName()+" has "+landList.get(landId.indexOf(player1.getPlayerPosition())).getName());
			}
			else {
				if((player1.getPlayerMoney()-(landList.get(landId.indexOf(player1.getPlayerPosition())).getCost())<0)){
					bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
				}
				player1.setPlayerMoney(player1.getPlayerMoney()-landList.get(landId.indexOf(player1.getPlayerPosition())).getCost());
				banker.setBankerMoney(banker.getBankerMoney()+landList.get(landId.indexOf(player1.getPlayerPosition())).getCost());
				player1.getPlayerProperty().add(landList.get(landId.indexOf(player1.getPlayerPosition())).getName());
				player1.setPlayerMove(player1.getPlayerName()+" bought "+landList.get(landId.indexOf(player1.getPlayerPosition())).getName());
			}		
		}
		else if(railroadId.contains(player1.getPlayerPosition())){

			if(player2.getPlayerProperty().contains(railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getName())){
				railroadRent(player1, player2, banker, chestCardList, chestCardList, chestCardList, chestCardList, chestCardList);
				player1.setPlayerMove(player1.getPlayerName()+" paid rent for "+railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getName());
			}
			else if(player1.getPlayerProperty().contains(railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getName())){

				player1.setPlayerMove(player1.getPlayerName()+" has "+railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getName());
			}	
			else {
				if((player1.getPlayerMoney()-railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getCost())<0){
					bankruptFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList);
				}
				player1.setPlayerMoney(player1.getPlayerMoney()-railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getCost());
				banker.setBankerMoney(banker.getBankerMoney()+railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getCost());
				player1.getPlayerProperty().add(railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getName());
				player1.setPlayerRailroadCount(player1.getPlayerRailroadCount()+1);
				player1.setPlayerMove(player1.getPlayerName()+" bought "+railroadList.get(railroadId.indexOf(player1.getPlayerPosition())).getName());
			}		
		}
		else if(companyId.contains(player1.getPlayerPosition())){

			if(player2.getPlayerProperty().contains(companyList.get(companyId.indexOf(player1.getPlayerPosition())).getName())){
				companyRent(player1, player2, banker, chestCardList, chestCardList, chestCardList, chestCardList, chestCardList);
				player1.setPlayerMove(player1.getPlayerName()+" paid rent for "+companyList.get(companyId.indexOf(player1.getPlayerPosition())).getName());
			}
			else if(player1.getPlayerProperty().contains(companyList.get(companyId.indexOf(player1.getPlayerPosition())).getName())){

				player1.setPlayerMove(player1.getPlayerName()+" has "+companyList.get(companyId.indexOf(player1.getPlayerPosition())).getName());
			}
			else {
				player1.setPlayerMoney(player1.getPlayerMoney()-companyList.get(companyId.indexOf(player1.getPlayerPosition())).getCost());
				banker.setBankerMoney(banker.getBankerMoney()+companyList.get(companyId.indexOf(player1.getPlayerPosition())).getCost());
				player1.getPlayerProperty().add(companyList.get(companyId.indexOf(player1.getPlayerPosition())).getName());
				player1.setPlayerMove(player1.getPlayerName()+" bought "+companyList.get(companyId.indexOf(player1.getPlayerPosition())).getName());


			}		
		}
		else if((player1.getPlayerPosition()==8) || (player1.getPlayerPosition()==23) || (player1.getPlayerPosition()==37)){//chancelist

			chanceFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList, landId);
		}
		else if((player1.getPlayerPosition()==3) || (player1.getPlayerPosition()==18) || (player1.getPlayerPosition()==34)){//communitychest

			communityFunc(player1, player2, banker, landList, railroadList, companyList, chanceCardList, chestCardList, landId);
		}
		else if(player1.getPlayerPosition()==11 ){//jail

			player1.setJailCount(0);
			player1.setPlayerMove(player1.getPlayerName() + " went to jail");
		}
		else if(player1.getPlayerPosition()==31){//go to jail
			player1.setJailCount(0);
			player1.setPlayerMove(player1.getPlayerName() + " went to jail");
		}
		else if(player1.getPlayerPosition()==21){//free parking

			player1.setPlayerMove(player1.getPlayerName() + " is in Free Parking");
		}
		else if((player1.getPlayerPosition()==5) || (player1.getPlayerPosition()==39)){//tax
			player1.setPlayerMoney(player1.getPlayerMoney()-100);
			banker.setBankerMoney(banker.getBankerMoney()+100);
			player1.setPlayerMove(player1.getPlayerName()+ " paid Tax");
		}
	}
}


