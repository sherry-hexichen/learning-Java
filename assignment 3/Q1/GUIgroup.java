/*
* [GUIgroup subclass extends GUIelement superclass]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 3]
* QUESTION: [question 1]
*
* PURPOSE: allow smaller subgroups to be a part of a larger group in user interface
*/
import java.util.ArrayList;

public class GUIgroup extends GUIelement {
    //instance variable
    ArrayList<GUIelement> list; //list of GUIelements

    public GUIgroup() {
        super(); //default calling superclass constructor
        list = new ArrayList<GUIelement>(); //initialize ArrayList
    }//constructor

    public void addElement(GUIelement e) {
        list.add(e);
    }//add element into ArrayList

    public void draw() {
        for (GUIelement ele : list) {
            ele.draw();
        }//draw each element in the ArrayList by using different draw() method(polymorphism)
    }//draw method

    public boolean handleClick(double x, double y) {
        boolean click = false;
        for (GUIelement item : list) {
           if (item.handleClick(x, y)) {
              click = true;
              break; //stop and return as soon as one element is true
           }
        }//for
        return click;
    } //handleClick method

    public boolean handleCharTyped(char c) {
        boolean handled = false;
        for (GUIelement item : list) {
            if (item.handleCharTyped(c)) {
                handled = true;
                break; //stop and return as soon as one element is true
            }
        }
        return handled;
    }//handleCharTyped method

    public void resetRadioButtons() {
        for (GUIelement item : list) {
            if (item instanceof RadioButton) {
                ((RadioButton) item).reset(); //only reset RadioButton Object in the ArrayList
            }//if
        }//for
    }//resetRadioButtons method: reset RadioButton type object
    
}//subclass GUIgroup
