import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
/**
 * 
 * @author Denizkaan Araci
 *
 */
public class Main {
/**
 * 
 * @param args
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
/**
 * I send objects to start function. It's main function.
 */
		ArrayList<String> player1property = new ArrayList<String>();
		ArrayList<String> player2property = new ArrayList<String>();
		
		peopleClass player1 = new playerClass("Player 1", 0, 1, 15000, "Player 1 is in GO square", player1property,0,3);
		peopleClass player2 = new playerClass("Player 2", 0, 1, 15000, "Player 2 is in GO square", player2property,0,3);				
		peopleClass banker = new bankerClass(100000);

		readClass readClassObj = new readClass();	
		writeClass writeObj = new writeClass();
		
		writeObj.createFile();
		readClassObj.startFunc("property.json", "list.json", args[0],player1,player2,banker);
		
	}
}
