//Imports for Main Page
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainPage extends Page
{
	//Constructor for Main Page
	private JFrame homeFrame;
	public MainPage(ArrayList<String> soundList, JFrame homeFrame) 
	{
		super(soundList);
		this.homeFrame = homeFrame;
	}
	
	//Creates interface for user and handles button selections
	public void makeGUI()
	{
		//Creates frame to contain buttons corresponding to each sound in a GridLayout
		JFrame frame = new JFrame("Shrek Soundboard");
		frame.setSize(600,200);
		frame.setResizable(true);
		GridLayout layout = new GridLayout(3,3,10,10);
		frame.setLayout(layout);
		
		//Creates six buttons that play a corresponding sound when pressed using the audioPlayer
		JButton[] soundButtons = new JButton[6];
		for(int i = 0; i <=5; i++)
		{
			soundButtons[i] = new JButton();
		}	
		
		/* Adds functionality to each button
		 * Prints simple error message if something goes wrong while trying to add functionality
		 * Button action assignment must be done outside of loop since the sound index must be final
		 */
		
		Queue<String> audioQueue = new LinkedList<String>();
		
		soundButtons[0].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
			{
				setSelectedSound(0, getSoundList());
				try
				{
					audioQueue.add(getSelectedSound());
				}
				catch(Exception e)
				{
					System.out.println("Error Instantiating Audio Player");
				}
			}
		});
		
		soundButtons[1].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
			{
				setSelectedSound(1, getSoundList());
				try
				{
					audioQueue.add(getSelectedSound());
				}
				catch(Exception e)
				{
					System.out.println("Error Instantiating Audio Player");
				}
			}
		});
		
		soundButtons[2].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
			{
				setSelectedSound(2, getSoundList());
				try
				{
					audioQueue.add(getSelectedSound());
				}
				catch(Exception e)
				{
					System.out.println("Error Instantiating Audio Player");
				}
			}
		});
		
		soundButtons[3].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
			{
				setSelectedSound(3, getSoundList());
				try
				{
					audioQueue.add(getSelectedSound());
				}
				catch(Exception e)
				{
					System.out.println("Error Instantiating Audio Player");
				}
			}
		});
		
		soundButtons[4].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
			{
				setSelectedSound(4, getSoundList());
				try
				{
					audioQueue.add(getSelectedSound());
				}
				catch(Exception e)
				{
					System.out.println("Error Instantiating Audio Player");
				}
			}
		});
		
		soundButtons[5].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
			{
				setSelectedSound(5, getSoundList());
				try
				{
					audioQueue.add(getSelectedSound());
				}
				catch(Exception e)
				{
					System.out.println("Error Instantiating Audio Player");
				}
			}
		});
		
		/*
		 * Creates Home Button and Execute Button to either 
		 *return to Home Screen or play selected sounds
		 */
		JButton homeButton = new JButton();
		homeButton.addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
		{
			try
			{
				frame.setVisible(false);
				homeFrame.setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println("Error Swithcing To Home Page");
			}
		}
		});
		homeButton.add(new JLabel("Home Page"));
		
		JButton executeButton = new JButton();
		executeButton.addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent action) 
		{
			try
			{
				System.out.println(audioQueue.toString());
				executeQueue(audioQueue);
			}
			catch(Exception e)
			{
				System.out.println("Error Executing Queue");
			}
		}
		});
		
		//Adds buttons to Main Screen
		executeButton.add(new JLabel("Execute Sound Queue"));
		frame.getContentPane().add(new JLabel("Click a button to play a sound"));
		frame.getContentPane().add(executeButton);
		frame.getContentPane().add(homeButton);
		
		
		/* Labels each button
		 * Actual sound for each button can be changed by the user
		 * Generic names are therefore used
		 */
		JLabel[] soundButtonLabels = new JLabel[6];		
		for(int i =0; i <= 5; i++)
		{
			soundButtonLabels[i] = new JLabel("Sound " + (i + 1));
			soundButtons[i].add(soundButtonLabels[i]);
		}
		
		//Adds all of the sound buttons to the frame
		for(int i =0; i <= 5; i++)
		{
			frame.getContentPane().add(soundButtons[i]);
		}
		
		//Sets close operation for the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Makes frame visible to the user
		frame.setVisible(true);
	}
	
	//Plays sounds stored in the audioQueue
	public static void executeQueue(Queue<String> audioQueue)
	{
		while(!audioQueue.isEmpty())
		{
			try 
			{
				AudioPlayer audioPlayer = new AudioPlayer(audioQueue.poll());
				long sleepLength = audioPlayer.soundPlay();
				//Delays sound playing until current sound is done
				Thread.sleep(sleepLength/1000);
			}
			catch(Exception e)
			{
				System.out.println("Error Playing Audio");
			}
		}
	}
}