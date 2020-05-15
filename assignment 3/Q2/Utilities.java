/**
 * Utilities.java
 * COMP 1020
 * (C) Computer Science, University of Manitoba
 * Two small utility methods for general use.
 */
public class Utilities {
    
  public static void delay(){
    //Delay for 1/25 of a second (40 milliseconds)
    try {
      Thread.sleep(40); //This will throw an exception if something
                        //interrupts this little nap.
    }
    catch(InterruptedException e){
      //Catch that exception. Do nothing except return from the method.
    }
  }//delay
  
  public static void waitMouseUp(){
    //Do nothing while waiting for the mouse button to be released.
    while(StdDraw.mousePressed())
      delay();
  }//waitMouseUp
  
}