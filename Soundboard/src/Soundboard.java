//Import necessary libraries to create GUI and implement FileIO
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Soundboard 
{
	//Method that runs to populate the sound list and execute the bulkier makeGUI method
	public static void main(String[] args)
	{
		ArrayList<String>soundList = populateSounds();
		Page homePage = new HomePage(soundList);
		homePage.makeGUI(soundList);
	}
	
	/*
	 * Reads from a file containing the paths to each audio sample
	 * This file can be edited by the user to add their own sounds
	 * This makes the product more versatile and widely appealing
	 */
	
	public static ArrayList<String> populateSounds()
	{
		File file = new File("D:\\Programming\\Soundboard\\src\\SoundList.txt");
		ArrayList<String> soundList = new ArrayList<String>();
		
		//If the file containing the paths is not where the program looks for it, no sounds can be imported
		if(!file.exists())
		{
			System.out.println("Sound List Not Found.");
			return null;
		}
		
		//Reads each path from a separate line and adds it to the soundList ArrayList
		try(Scanner fileScan = new Scanner(file))
		{
			while(fileScan.hasNextLine())
			{
				soundList.add(fileScan.nextLine());
			}
		}
		
		//If there is a problem importing the sounds, program prints error message and returns nothing
		catch(Exception e)
		{
			System.out.println("There was a problem importing the sound list.");
			return null;
		}
		
		//If everything works properly, returns soundList full of FilePaths
		return soundList;
	}
}