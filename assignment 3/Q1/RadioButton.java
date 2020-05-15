/*
* [RadioButton subclass extends GUIelement superclass]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: control radio buttons in user interface
*/
public class RadioButton extends GUIelement {
    //instance variable
    private GUIgroup sideGrp; //side group, which group the radio button belongs to
    
    private static final double MARGIN = 0.005; //margin for drawing

    public RadioButton(double xc, double yc, double radius, String title, boolean hilite, GUIgroup g) {
        super(xc, yc, radius, radius, title, hilite);
        sideGrp = g;
    }//constructor

    public void draw() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(xCentre, yCentre, halfWidth); //draw white circle
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        StdDraw.circle(xCentre, yCentre, halfWidth); //draw circle stroke
        StdDraw.textLeft(xCentre + halfWidth + MARGIN, yCentre, text); //draw the text
        if (highlighted) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(xCentre, yCentre, halfWidth / 2);
        } //draw the black small circle when user selects one radio button
    }//draw method

    public void reset() {
        highlighted = false;
        draw();
    }//reset method: reset the group of radio buttons and redraw them

    public boolean handleClick(double x, double y) {
        boolean handled = false;
        if (super.handleClick(x, y)) {
            sideGrp.resetRadioButtons();
            highlighted = true;
            draw();
            handled = true;
        } //when user selects one radio button, reset the whole group then redraw the whole group with proper dot
        return handled;
    }//handleClick method
}//subclass RadioButton