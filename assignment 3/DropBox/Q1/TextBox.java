/*
* [TextBox subclass extends GUIelement superclass]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: control text boxes in user interface
*/
public class TextBox extends GUIelement {
    //instance variable
    private boolean input; //whether the textbox for input or for output
    
    private static final double MARGIN = 0.005; //margin value for drawing
    
    public TextBox(double xc, double yc, double hw, double hh, String txt, boolean inp){
        super(xc, yc, hw, hh, txt, false);
        input = inp;
    } //constructor
    
    public void draw(){
      super.draw(); //superclass draw method, draw the rectangle
      StdDraw.textLeft(xCentre-halfWidth+MARGIN, yCentre, text); //draw the text in the textboxs
    } //draw method
    
    public boolean handleClick(double x, double y){
        boolean click = false;
        if(super.handleClick(x,y)){
            if(input){
                text=""; //clear "input box" text
                highlighted = true; //indicate the textbox is selected
                draw(); //redraw the textbox
                click = true;
            } //if click happens in input textbox
        }
        else
            click = false;
        return click;
    } //handleClick method: control the mouse click in input textbox, ignore the mouse click in output textbox
    
    public boolean handleCharTyped(char c){
        boolean handled = false;
        if(highlighted && input){
            if(Character.toString(c).equals("\n")){
                highlighted = false;
            } //unselect input textbox by pressing ENTER
            else{
                text += Character.toString(c); //convert keyboard characters to String
                draw(); //redraw the textbox
            } 
        handled = true;
        } //if a input textbox is highlighted
        else if(!input)
            handled = false;
        
        return handled;
    }//handleCharTyped method: deal with the typing on keyboard
    
    public void displayText(String s){
        text = s;
        draw();
    } //displayText method: show keyboard inputs in the textbox
}//TextBox subclass
