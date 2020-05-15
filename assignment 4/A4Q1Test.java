/**
 * A4Q1Test.java
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */
public class A4Q1Test{
  public static void main(String [] args){
    String fileName = "darwin.txt";
    System.out.println("This is A4Q1Test.\n");
    LinkedList myList = new LinkedList(fileName);
    System.out.println(myList.format(80));
    System.out.println(fileName + " contains " + myList.size() + " words.");
  }// main
}// class A4Q1Test