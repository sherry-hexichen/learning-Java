/**
 * A4Q2Test.java
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */
public class A4Q2Test{
  public static void main(String [] args){
    String fileName = "darwin.txt";
    System.out.println("This is A4Q2Test.\n");
    LinkedList myList = new LinkedList(fileName);
    System.out.println(myList.toAlphaString());
    System.out.println(fileName + " contains " + myList.sizeAlpha() + " unique words.");
  }// main
}// class A4Q2Test