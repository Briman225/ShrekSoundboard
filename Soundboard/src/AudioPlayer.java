//Import all necessary libraries to implement sound playing
import java.io.File; 
import java.io.IOException; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
  
public class AudioPlayer  
{ 
	//Clip reference to be used when playing audio
    private Clip clip; 

    //AudioInputStream that allows audio to be played
    private AudioInputStream audioInputStream; 
    
    //FilePath to import the audio files to be played
    public static String filePath;
    
    //Constructor to initialize audio stream and clip 
    public AudioPlayer(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException  
    { 
    	//Takes name of file as argument and assigns that value to the filePath
    	filePath = fileName;
    	
    	//Creates a new sound file object so it can be played
    	File soundFile = new File(filePath).getAbsoluteFile();
    	
        //Create AudioInputStream object 
        audioInputStream = AudioSystem.getAudioInputStream(soundFile); 
        
        //Create clip reference 
        clip = AudioSystem.getClip(); 
        
        //Open audioInputStream to the clip 
        clip.open(audioInputStream); 
    } 
  
    //Plays the audio
    public long soundPlay()  
    { 
    	//If an unforeseen error occurs while trying to play audio, message printed to the console saying so
        try
        { 
        	clip.start();
        }
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound.");
        } 
        //Tells program how long to wait before playing another sound
        return clip.getMicrosecondLength();
    }
}