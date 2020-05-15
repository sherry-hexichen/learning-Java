
/**
 * GUIelement.java
 * COMP 1020
 * (C) Computer Science, University of Manitoba
 * A superclass for all User Interface Elements
 */
public abstract class GUIelement {

    //Six instance variables that all GUI elements need.
    protected double xCentre;
    protected double yCentre;
    protected double halfWidth;
    protected double halfHeight;
    protected boolean highlighted;
    protected String text;

    //A normal constructor
    public GUIelement(double xc, double yc, double hw, double hh,
            String txt, boolean hilite) {
        xCentre = xc;
        yCentre = yc;
        halfWidth = hw;
        halfHeight = hh;
        text = txt;
        highlighted = hilite;
    }

    //A no-parameters constructor that leaves everything at default values.
    public GUIelement() {
    }

    //The basic draw() method will erase the rectanglular area, and then
    //outline it with a thin black box.
    public void draw() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(xCentre, yCentre, halfWidth, halfHeight);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(); //Default thin line.
        StdDraw.rectangle(xCentre, yCentre, halfWidth, halfHeight);
    }

    //All subclasses will need to know when a click is in the rectangle
    //for this particulat GUI element.
    public boolean handleClick(double x, double y) {
        return (x >= xCentre - halfWidth)
                && (x <= xCentre + halfWidth)
                && (y >= yCentre - halfHeight)
                && (y <= yCentre + halfHeight);
    }

    //Only textboxes will override this one.
    public boolean handleCharTyped(char c) {
        return false;
    }

    //Accessors
    public boolean isHighlighted() {
        return highlighted;
    }

    public String getText() {
        return text;
    }

}//GUIelement
