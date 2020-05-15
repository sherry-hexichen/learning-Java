
import java.util.ArrayList;

public class GUIgroup extends GUIelement {

    ArrayList<GUIelement> list; //list of GUIelements

    public GUIgroup() {
        super();
        list = new ArrayList<GUIelement>();
    }//constructor

    public void addElement(GUIelement e) {
        list.add(e);
    }

    public void draw() {
        for (GUIelement ele : list) {
            ele.draw();
        }
    }

    public boolean handleClick(double x, double y) {
        boolean click = false;
        for (GUIelement item : list) {
           if (item.handleClick(x, y)) {
              click = true;
              break;
           }
        }//for
        return click;
    }

    public boolean handleCharTyped(char c) {
        boolean handled = false;
        for (GUIelement item : list) {
            if (item.handleCharTyped(c)) {
                handled = true;
                break;
            }
        }
        return handled;
    }

    public void resetRadioButtons() {
        for (GUIelement item : list) {
            if (item instanceof RadioButton) {
                ((RadioButton) item).reset();
            }//if
        }//for
    }

}
