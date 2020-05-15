/**
 * Checkbox.java
 * COMP 1020
 * (C) Computer Science, University of Manitoba
 * A standard checkbox
 */
public class Checkbox extends GUIelement {
  
  //The small distance from the right edge of the box to the label.
  private static final double MARGIN = 0.005;
  
  //Constructor
  public Checkbox(double xc, double yc, double size,
                   String txt) { 
    super(xc,yc,size,size,txt,false); //It's not highlighted to start with.
  }//constructor
  
  public void draw(){    
    StdDraw.setPenRadius(); //Make sure it's a standard narrow pen
    super.draw(); //Let the superclass draw the outer square
    StdDraw.textLeft(xCentre+halfWidth+MARGIN,yCentre,text); //Add the label
    if(highlighted) {
      //Draw two lines to make an X in the box.
      StdDraw.line(xCentre-halfWidth,yCentre+halfHeight,
                   xCentre+halfWidth,yCentre-halfHeight);
      StdDraw.line(xCentre-halfWidth,yCentre-halfHeight,
                   xCentre+halfWidth,yCentre+halfHeight);
    }//if
  }//draw
  
  public boolean handleClick(double x, double y) {
    if(!super.handleClick(x,y)) //The superclass method is always used first.
      return false; //Nothing to do with me. Not in my rectangle.
    else {
      highlighted = !highlighted; //Toggle the box's status
      draw(); //And redraw it.
      return true; //I handled it. Nobody else should.
    }//else
  }//handleClick

}//checkbox