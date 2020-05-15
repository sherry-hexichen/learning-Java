
/**
 * Do a test of the GUI elements
 */
public class TestA3Q1 {

    public static void main(String[] args) {

        //X coordinates of objects
        final double LEFT = 0.2; //Left side components
        final double CENTRE = 0.46; //Textboxes
        final double RIGHT = 0.6; //Right side Components
        //Y coordinates of objects
        final double ROW0 = 0.95; //top text box (input)
        final double ROW1 = 0.8;  //middle text box (input)
        final double ROW2 = 0.65; //bottom text box (output)
        final double ROW3 = 0.5;  //Both buttons
        final double ROW4 = 0.37; //Upper radio buttons
        final double ROW5 = 0.30; //Middle radio buttons
        final double ROW6 = 0.23; //Lower radio buttons
        final double ROW7 = 0.15; //Checkboxes
        //Sizes of objects
        final double BUTTON_HEIGHT = 0.08;
        final double BUTTON_WIDTH = 0.04;
        final double OPTION_SIZE = 0.02; //Both checkboxes and radio buttons
        final double TEXTBOX_WIDTH = 0.38;
        final double TEXTBOX_HEIGHT = 0.05;

        //Create a master group, a left side group, and a right side group
        GUIgroup allElements = new GUIgroup();
        GUIgroup leftSide = new GUIgroup();
        GUIgroup rightSide = new GUIgroup();
        allElements.addElement(leftSide);
        allElements.addElement(rightSide);

        //Add a dozen different UIElements of all kinds, for testing.
        rightSide.addElement(new Button(RIGHT, ROW3, BUTTON_HEIGHT, BUTTON_WIDTH, "Right"));
        leftSide.addElement(new Button(LEFT, ROW3, BUTTON_HEIGHT, BUTTON_WIDTH, "Left"));
        rightSide.addElement(new Checkbox(RIGHT, ROW7, OPTION_SIZE, "R option"));
        rightSide.addElement(new RadioButton(RIGHT, ROW4, OPTION_SIZE, "R choice 1", true, rightSide));
        rightSide.addElement(new RadioButton(RIGHT, ROW5, OPTION_SIZE, "R choice 2", false, rightSide));
        rightSide.addElement(new RadioButton(RIGHT, ROW6, OPTION_SIZE, "R choice 3", false, rightSide));
        leftSide.addElement(new Checkbox(LEFT, ROW7, OPTION_SIZE, "L option"));
        leftSide.addElement(new RadioButton(LEFT, ROW4, OPTION_SIZE, "L choice 1", true, leftSide));
        leftSide.addElement(new RadioButton(LEFT, ROW5, OPTION_SIZE, "L choice 2", false, leftSide));
        leftSide.addElement(new RadioButton(LEFT, ROW6, OPTION_SIZE, "L choice 3", false, leftSide));
        allElements.addElement(new TextBox(CENTRE, ROW0, TEXTBOX_WIDTH, TEXTBOX_HEIGHT, "Input box 1", true));
        allElements.addElement(new TextBox(CENTRE, ROW1, TEXTBOX_WIDTH, TEXTBOX_HEIGHT, "Input box 2", true));
        TextBox outbox;
        allElements.addElement(outbox = new TextBox(CENTRE, ROW2, TEXTBOX_WIDTH, TEXTBOX_HEIGHT, "Output box", false));

        //Handle mouse clicks and keyboard characters and make it all work.
        allElements.draw();
        int count = 0;
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {    //Check for a key typed
                char c = StdDraw.nextKeyTyped();
                allElements.handleCharTyped(c);
            } else if (StdDraw.mousePressed()) {  //Check for a mouse click
                allElements.handleClick(StdDraw.mouseX(), StdDraw.mouseY());
                Utilities.waitMouseUp();
                outbox.displayText("Click " + (++count));
            } else {
                Utilities.delay(); //Nothing going on. Have a short nap. Zzzzzzzzzzzzzzzz
            }
        }//infinite while loop
    }//main

}//Test A3Q1 class
