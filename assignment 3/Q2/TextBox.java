
public class TextBox extends GUIelement {
    private boolean input;
    private static final double MARGIN = 0.005;
    
    public TextBox(double xc, double yc, double hw, double hh, String txt, boolean inp){
        super(xc, yc, hw, hh, txt, false);
        input = inp;
    }
    
    public void draw(){
      super.draw();
      StdDraw.textLeft(xCentre-halfWidth+MARGIN, yCentre, text);
    }
    
    public boolean handleClick(double x, double y){
        boolean click = false;
        if(super.handleClick(x,y)){
            if(input){
                text="";
                highlighted = true;
                draw();
                click = true;
            }
        }
        else
            click = false;
        return click;
    }
    
    public boolean handleCharTyped(char c){
        boolean handled = false;
        if(highlighted && input){
            if(Character.toString(c).equals("\n")){
                highlighted = false;
            }
            else{
                text += Character.toString(c);
                draw();
            }
        handled = true;
        }
        else if(!input)
            handled = false;
        
        return handled;
    }
    
    public void displayText(String s){
        text = s;
        draw();
    }
}
