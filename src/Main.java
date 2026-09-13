import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/idfc_instrumental.wav");
        try(Scanner sc = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("P to Play");
            System.out.println("S to Stop");
            System.out.println("R to Reset");
            System.out.println("Q to Quit");

            String input = "";

            while(!input.equals("Q")){
                System.out.print("Type your response: ");
                input = sc.nextLine().toUpperCase();
                switch(input){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid input");
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("File not supported");
        }
        catch(LineUnavailableException e){
            System.out.println("Music can't be opened");
        }
    }
}