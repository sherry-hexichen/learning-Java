/*
* [Button2 subclass extends GUIelement superclass]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 2]
*
* PURPOSE: control the rectangular buttons in user interface
*/
public class Button2 extends GUIelement {
    //instance variable
    private Handler hButton; //reference to Handler when the button is pressed
    
    public Button2(double xc, double yc, double hw, double hh, String title, Handler color){
        super(xc, yc, hw, hh, title, false);
        hButton = color;
    } //constructor
    
    public void draw(){
      if(highlighted){
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      } //pressed button is in grey color
      else{
        StdDraw.setPenColor(StdDraw.WHITE);
      } //not-pressed button is in white color
      StdDraw.filledRectangle(xCentre,yCentre,halfWidth,halfHeight); //draw the button
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.setPenRadius(); 
      StdDraw.rectangle(xCentre,yCentre,halfWidth,halfHeight); //draw the button stroke
      StdDraw.text(xCentre, yCentre, text); //draw the text label in the button
    }//draw method
    
    public boolean handleClick(double x, double y){
        if(super.handleClick(x,y)){
            highlighted = true;
            draw(); //redraw the pressed button with grey
            Utilities.waitMouseUp(); //wait until user releases mouse
            highlighted = false;
            draw(); //redraw the relesed button with white
            if(hButton != null)
                hButton.doIt(); //(polymorphism) using different doIt() method 
            return true;
        }
        else
            return false;
    }//handleClick method: deal with the click happened in the button
}//Button2 subclass
