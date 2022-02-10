import java.util.ArrayList;

public class Page {
	//Acts as base class for other pages to build upon
	private ArrayList<String> soundList;
	private String selectedSound;
	public Page(ArrayList<String> soundList)
	{
		this.soundList = soundList;
		this.selectedSound = null;
	}

	public void makeGUI()
	{
		//Must be overwritten by children classes
	}

	//Allows other classes to access the soundList
	public ArrayList<String> getSoundList()
	{
		return this.soundList;
	}

	//Assigns a value to the selectedSound variable depending on which button was pressed
	public void setSelectedSound(int selectedIndex, ArrayList<String> soundList)
	{
		this.selectedSound = soundList.get(selectedIndex);
	}

	//Allows other classes to access the selectedSound
	public String getSelectedSound()
	{
		return this.selectedSound;
	}

	public void makeGUI(ArrayList<String> soundList) 
	{
		//Must be overwritten by children classes
	}
	
}
