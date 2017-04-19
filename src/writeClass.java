import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * this class includes write features
 * @author as
 *
 */
public class writeClass {
	/**
	 * createFile function creates file if file doesnt exist.
	 * @throws IOException
	 */
	public void createFile() throws IOException{
		
		File file = new File("output.txt");
		file.delete();
		if (!file.exists()) {
        	
            file.createNewFile();
        }
		
	}
	/**
	 * writeFileData function writes Data features
	 * @param dataLine
	 * @throws IOException
	 */
	public void writeFileData(String dataLine) throws IOException{
		
		File file = new File("output.txt");
        

        FileWriter fileWriter = new FileWriter(file, true);
        
        PrintWriter pWriter = new PrintWriter(fileWriter);
        pWriter.println(dataLine);
             
        pWriter.close();
		
	}
	/**
	 * writeFileShow function writes Show features
	 * @param player1
	 * @param player2
	 * @param banker
	 * @throws IOException
	 */
	public void writeFileShow(peopleClass player1,peopleClass player2,peopleClass banker) throws IOException{
		
		File file = new File("output.txt");
       

        FileWriter fileWriter = new FileWriter(file, true);
        
        PrintWriter pWriter = new PrintWriter(fileWriter);
        
        String player1properties = String.join(",", player1.getPlayerProperty());
        String player2properties = String.join(",", player2.getPlayerProperty());
       
        
        pWriter.println("----------------------------------------------------------------------------------------------------------");
        pWriter.println(player1.getPlayerName()+"\t"+player1.getPlayerMoney()+"\t"+"have: "+"\t"+player1properties);
        pWriter.println(player2.getPlayerName()+"\t"+player2.getPlayerMoney()+"\t"+"have: "+"\t"+player2properties);
        pWriter.println("Banker"+"\t"+banker.getBankerMoney());
        if(player1.getPlayerMoney()>player2.getPlayerMoney()){
        	pWriter.println("Winner " + player1.getPlayerName());
        }
        else if(player1.getPlayerMoney()<player2.getPlayerMoney()){
        	pWriter.println("Winner " + player2.getPlayerName());
        }
        else{
        	pWriter.println("Draw. No one wins");
        }
        pWriter.println("----------------------------------------------------------------------------------------------------------");
                
        pWriter.close();
		
	}

}
