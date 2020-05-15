/*
* [Button subclass extends GUIelement superclass]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: control the rectangular buttons in user interface
*/
public class Button extends GUIelement {
    public Button(double xc, double yc, double hw, double hh, String title){
        super(xc, yc, hw, hh, title, false);
    }//constructor
    
    public void draw(){
      if(highlighted){
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      } //button is light gray color when being selected
      else{
        StdDraw.setPenColor(StdDraw.WHITE);
      } //button is white color when not being selected
      StdDraw.filledRectangle(xCentre,yCentre,halfWidth,halfHeight); //draw the button
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.setPenRadius(); 
      StdDraw.rectangle(xCentre,yCentre,halfWidth,halfHeight); //draw the stroke
      StdDraw.text(xCentre, yCentre, text); //draw the text
    }
    
    public boolean handleClick(double x, double y){
        if(super.handleClick(x,y)){
            highlighted = true; //user is pressing the button
            draw(); //redraw the button
            Utilities.waitMouseUp(); //wait until user release mouse press
            highlighted = false; //button is not highlighted
            draw(); //redraw the button
            return true;
        }
        else
            return false;
    }//handleClick method: changing the button color to indicate it is pressed by mouse
}//Button subclass
