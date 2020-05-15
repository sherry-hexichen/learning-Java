/* Test program
 * COMP 1020 Winter 2016
 * Assignment 2 Question 2
 */
import java.io.*; //I/O operations

public class TestA2Q2
{
 public static void main(String [] args) throws IOException
 {
  A2Q2 remover = new A2Q2("words.txt","newWords.txt");
  remover.removeDuplicateLines();
  System.out.println("End of processing.\nProgrammed by Stew Dent.");
 }
}