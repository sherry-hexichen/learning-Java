/**
 * Do a test of Handler mechanism.
 */
public class TestA3Q2 {
  
  public static void main(String[] args) {
    
    //X coordinates of three buttons
    final double LEFT    = 0.3; 
    final double CENTRE  = 0.5;
    final double RIGHT   = 0.7;
    //Y coordinate of all three buttons
    final double Y = 0.6;
    //Sizes of buttons
    final double BUTTON_HEIGHT = 0.08;
    final double BUTTON_WIDTH = 0.04;    
    //Create a group of 3 buttons
    GUIgroup myButtons = new GUIgroup();
    myButtons.addElement(new Button2(RIGHT,Y,BUTTON_HEIGHT,BUTTON_WIDTH,"Red", new HandleRed()));
    myButtons.addElement(new Button2(CENTRE,Y,BUTTON_HEIGHT,BUTTON_WIDTH,"Green", new HandleGreen()));
    myButtons.addElement(new Button2(LEFT,Y,BUTTON_HEIGHT,BUTTON_WIDTH,"Blue", new HandleBlue()));
     
    //Handle mouse clicks and make it all work.
    myButtons.draw();
    while(true){
      if(StdDraw.mousePressed()){  //Check for a mouse click
        myButtons.handleClick(StdDraw.mouseX(),StdDraw.mouseY());
        Utilities.waitMouseUp();
       }
      else
        Utilities.delay(); //Nothing going on. Have a short nap. Zzzzzzzzzzzzzzzz
    }//infinite while loop
  }//main

  /* The methods below are the ones that we want the buttons to trigger
   * For each, add a new subclass of Handler that will call it.
   */
  
  public static void drawRed(){
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.filledCircle(0.5,0.2,0.2);
    StdDraw.setPenColor(); //Reset the colour to the default - be nice
  }

  public static void drawGreen(){
    StdDraw.setPenColor(StdDraw.GREEN);
    StdDraw.filledCircle(0.5,0.2,0.2);
    StdDraw.setPenColor(); //Reset the colour to the default - be nice
  }

  public static void drawBlue(){
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.filledCircle(0.5,0.2,0.2);
    StdDraw.setPenColor(); //Reset the colour to the default - be nice
  }

}//TestA3Q2 class
