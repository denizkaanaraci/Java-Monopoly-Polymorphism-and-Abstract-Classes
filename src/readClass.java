import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  

/**
 * This class includes read,create and start functions.
 */
public class readClass { 
	
	
	ArrayList<placeClass> landList = new ArrayList<placeClass>();
	ArrayList<placeClass> railroadList = new ArrayList<placeClass>();
	ArrayList<placeClass> companyList = new ArrayList<placeClass>();
	ArrayList<placeClass> chanceCardList = new ArrayList<placeClass>();
	ArrayList<placeClass> chestCardList = new ArrayList<placeClass>();

	/**
	 * startFunc function is start function.
	 * @param xxxx
	 * @param yyyy
	 * @param zzzz
	 * @param player1
	 * @param player2
	 * @param banker
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */

	public void startFunc (String xxxx, String yyyy,String zzzz,peopleClass player1,peopleClass player2,peopleClass banker)
			throws FileNotFoundException, IOException, ParseException{

		readJson(xxxx);		
		readJson(yyyy);		
		createCommand(zzzz);


		functionClass b = new functionClass();
		b.describeFunc(player1, player2, banker,landList,railroadList,companyList,chanceCardList,chestCardList,readCommand(zzzz));


		

	}
/**
 * readJson function is reading json file.
 * @param path
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void readJson(String path) throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();  

		
		Object objList = parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8")));
		


		JSONObject jsonObject = (JSONObject) objList;

		if (path.equals("property.json")){

			createPropertiesArray(jsonObject);
		}
		else if(path.equals("list.json")){
			createCardArray(jsonObject);
		}



	}  
	/**
	 * readCommand function reads command file
	 * @param path
	 * @return
	 */
	public String[] readCommand(String path){
		try {
			int i=0;
			int lenght= Files.readAllLines(Paths.get(path)).size();

			String[] results = new String[lenght];


			for (String line : Files.readAllLines(Paths.get(path))) {

				results[i++]= line;	

			}			
			return results;
		} catch(IOException e){
			e.printStackTrace();
			return null;

		}

	}
/**
 * createCommand function takes parameter and split it
 * @param qqq
 */
	public void createCommand (String qqq){

		String[] command = readCommand(qqq);

		for ( int i=0; i< command.length; i++){

			if(command[i].equals("show()")){

				
			}

			else {

				String[] move = command[i].split(";");

				if(move[0].equals("Player 1")){



					
				}
				else {
					
				}

			}

		}

	}
/**
 * createPropertiesArray takes json object,split elements and set property features
 * @param proObj
 */
	public void createPropertiesArray (JSONObject proObj){


		JSONArray list1 = (JSONArray) proObj.get("1");
		JSONArray list2 = (JSONArray) proObj.get("2");
		JSONArray list3 = (JSONArray) proObj.get("3");


		Iterator i11 = list1.iterator();
		Iterator i12 = list2.iterator();
		Iterator i13 = list3.iterator();

		while (i11.hasNext()) {
			JSONObject slide = (JSONObject) i11.next();

			String title = (String)slide.get("id");		      
			String title2 = (String)slide.get("name");
			String title3= (String)slide.get("cost");
			
			propertyClass pro = new propertyClass(Integer.parseInt(title), title2, Integer.parseInt(title3));
			landList.add(pro);




		}
		while (i12.hasNext()) {
			JSONObject slide = (JSONObject) i12.next();

			String title = (String)slide.get("id");		      
			String title2 = (String)slide.get("name");
			String title3= (String)slide.get("cost");

			propertyClass pro = new propertyClass(Integer.parseInt(title), title2, Integer.parseInt(title3));

			railroadList.add(pro);



		}
		while (i13.hasNext()) {
			JSONObject slide = (JSONObject) i13.next();

			String title = (String)slide.get("id");		      
			String title2 = (String)slide.get("name");
			String title3= (String)slide.get("cost");

			propertyClass pro = new propertyClass(Integer.parseInt(title), title2, Integer.parseInt(title3));
			companyList.add(pro);

		}


	}
/**
 * createCardArray takes json object,split elements and set card features
 * @param cardObj
 */
	public void createCardArray (JSONObject cardObj){


		JSONArray chanceList = (JSONArray) cardObj.get("chanceList");
		JSONArray communityChestList = (JSONArray) cardObj.get("communityChestList");


		Iterator i1 = chanceList.iterator();
		Iterator i2 = communityChestList.iterator();

		while (i1.hasNext()) {
			JSONObject slide = (JSONObject) i1.next();

			String title = (String)slide.get("item");

			placeClass card1 = new cardClass(title);

			chanceCardList.add(card1);
		}
		while (i2.hasNext()) {
			JSONObject slide = (JSONObject) i2.next();

			String title = (String)slide.get("item");		      

			placeClass card2 = new cardClass(title);

			chestCardList.add(card2);


		}


	}

}
