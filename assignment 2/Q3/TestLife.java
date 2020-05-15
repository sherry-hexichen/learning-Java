/**
 * COMP 1020 Winter 2016
 * Assignment 2 Question 2
 * Test the implementation of John Conway's Game of Life
 */
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestLife {
  
  //For a random initial setup, what fraction of the board should
  //contain living cells?
  public static double DENSITY = 0.30;

  //------  main method  ----------------------------------------
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("What starting configuration should be used?\n"+
                     "  1=A random board\n"+
                     "  2=Read from a file\n"+
                     "Enter 1 or 2: ");
    ConwaysLife theBoard;
    if(keyboard.nextInt()==1) {
      System.out.print("What size board would you like: ");
      int boardSize = keyboard.nextInt();
      theBoard = new ConwaysLife(boardSize,DENSITY);
    }//if random board chosen
    else {
      File theFile = chooseInputFile();
      if(theFile == null) System.exit(0); //Just bail out
      theBoard = new ConwaysLife(theFile);
    }//else file option chosen
    
    System.out.print("How many generations per second?\n"+
                       "(1 is slow, 5 is moderate, 20 is fast)\n"+
                       "Enter an integer: ");
    int speed = keyboard.nextInt();
    
    System.out.print("How many generations do you want to print out?\n"+
                       "Enter an integer: ");
    int numToPrint = keyboard.nextInt();
    
    animate(theBoard, speed, numToPrint);
  }//main
  
  //------ animate() ------
  
  public static void animate(ConwaysLife theBoard, int speed, int numToPrint) {
    //Bring the board to "life". Draw new generations forever.
    StdDraw.show(0); //Show the StdDraw window. Select "animation mode".
    int delay = 1000/speed;
    int generation = 0;
    while(true) { //infinite loop
      StdDraw.clear();    //erase the old contents
      theBoard.draw();    //draw the new contents
      if(++generation <= numToPrint) {
        System.out.println("Generation "+generation+" :");
        System.out.println(theBoard);
      }
      StdDraw.show(delay);  //Delay for this many milliseconds
      theBoard.nextGeneration(); //Calculate the next generation
    }//infinite loop
  }//animate
  
  //----------  chooseInputFile()  ---------------------------
  
  public static File chooseInputFile() {
    /* A utility method that will open a text file from the
     * current directory using a standard dialog box provided
     * by the swing class.
     */
    try {
      JFileChooser choose = new JFileChooser("."); //current directory
      FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
      choose.setFileFilter(filter);
      int result = choose.showOpenDialog(null); //Standard file open dialog
      if(result!=JFileChooser.APPROVE_OPTION){
        JOptionPane.showMessageDialog(null,"File selection cancelled.");
        return null;
      }//if
      File f = choose.getSelectedFile(); //Open up the file, or at least try to.
      if(!f.exists()){
        JOptionPane.showMessageDialog(null,"Can't find that file.");
        return null;
      }//if
      return f;
    }//try
    catch(Exception e) {
      System.out.println("I couldn't open the file for some reason.");
      return null;
    }//catch
  }//chooseInputFile
    
}//TestLife
