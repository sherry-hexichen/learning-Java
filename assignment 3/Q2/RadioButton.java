
public class RadioButton extends GUIelement {
    private GUIgroup sideGrp;

    private static final double MARGIN = 0.005;

    public RadioButton(double xc, double yc, double radius, String title, boolean hilite, GUIgroup g) {
        super(xc, yc, radius, radius, title, hilite);
        sideGrp = g;
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(xCentre, yCentre, halfWidth);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        StdDraw.circle(xCentre, yCentre, halfWidth);
        StdDraw.textLeft(xCentre + halfWidth + MARGIN, yCentre, text);
        if (highlighted) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(xCentre, yCentre, halfWidth / 2);
        }
    }

    public void reset() {
        highlighted = false;
        draw();
    }

    public boolean handleClick(double x, double y) {
        boolean handled = false;
        if (super.handleClick(x, y)) {
            sideGrp.resetRadioButtons();
            highlighted = true;
            draw();
            handled = true;
        } 
        return handled;
    }
}//subclass RadioButton