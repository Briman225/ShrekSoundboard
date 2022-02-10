//Imports for Info Page
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoPage extends Page
{
	private JFrame homeFrame;
	//Constructor for Info Page
	public InfoPage(ArrayList<String> soundList, JFrame homeFrame) 
	{
		super(soundList);
		this.homeFrame = homeFrame;
	}
	
	//Makes frame for Info Page
	public void makeGUI()
	{
		JFrame infoFrame = new JFrame("Shrek Soundboard");
		infoFrame.setSize(1800, 200);
		infoFrame.setResizable(true);
		GridLayout infoLayout = new GridLayout(2, 2, 10, 10);
		infoFrame.setLayout(infoLayout);
		
		//Makes home button for Info Page
		JButton homeButton = new JButton();
		homeButton.addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
		{
			try
			{
				infoFrame.setVisible(false);
				homeFrame.setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println("Error Switching To Home Page");
			}
		}
		});
		homeButton.add(new JLabel("Home Page"));
		
		//Adds button and text to Info Page
		infoFrame.getContentPane().add(new JLabel("Info"));
		infoFrame.getContentPane().add(homeButton);
		infoFrame.getContentPane().add(new JLabel("Disclaimer: The Shrek Soundboard is a product made by an IB CS student and has no offical affiliation with Dreamworks or the Shrek Franchise."));
		infoFrame.getContentPane().add(new JLabel("To add your own sounds to the soundboard, replace one of the exisitng file paths in SoundList.txt with that of your desired sound."));
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.setVisible(true);
	}
}
