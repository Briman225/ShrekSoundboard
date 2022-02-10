//Necessary imports for Home Screen
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends Page
{

	//Constructor for the Home Screen
	public HomePage(ArrayList<String> soundList) 
	{
		super(soundList);
	}
	
	//Creates home screen for program that then runs methods for other screens
	public void makeGUI(ArrayList<String> soundList)
	{
		//Creates home frame
		JFrame homeFrame = new JFrame("Shrek Soundboard");
		homeFrame.setSize(600, 200);
		homeFrame.setResizable(true);
		GridLayout homeLayout = new GridLayout(2, 2, 10, 10);
		homeFrame.setLayout(homeLayout);
		
		//Creates the two buttons for the home frame
		JButton startButton = new JButton();
		JButton infoButton = new JButton();
		
		//Adds functionality to the start button
		startButton.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent action) 
		{
			try
			{
				homeFrame.setVisible(false);
				Page mainPage = new MainPage(soundList, homeFrame);
				mainPage.makeGUI();
			}
			catch(Exception e)
			{
				System.out.println("Error Opening Program");
			}
		}
		});
			
		//Adds functionality to the info button
		infoButton.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent action) 
		{
			try
			{
				homeFrame.setVisible(false);
				Page infoPage = new InfoPage(soundList, homeFrame);
				infoPage.makeGUI();
			}
			catch(Exception e)
			{
				System.out.println("Error Opening Program");
			}
		}
		});
		
		//Labels buttons and adds them to frame
		startButton.add(new JLabel("Start"));
		infoButton.add(new JLabel("Info"));
		homeFrame.getContentPane().add(new JLabel("Welcome to the Shrek Soundboard"));
		homeFrame.getContentPane().add(new JLabel());
		homeFrame.getContentPane().add(startButton);
		homeFrame.getContentPane().add(infoButton);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setVisible(true);
	}
}