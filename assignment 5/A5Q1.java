/*
* [A5Q1 Class]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 1]
*
* PURPOSE: draw Sierpinski triangles by using recursion
*/

import java.awt.Color;

public class A5Q1 {

    public static void main(String[] args) {
        drawTriangles(5, 0.0, 0.0, 1.0);
    }//main method
    
    public static void drawTriangles(int n, double x1, double y1, double currentSideLen){
        drawTriangles(n, x1, y1, currentSideLen, StdDraw.BLACK );
    }//call the recursive version of drawTriangles method
    
    public static void drawTriangles(int n, double x1, double y1, double currentSideLen, Color fill){
        double[] xData = new double[3];
        double[] yData = new double[3]; //initial 2 double arrays to store three data sets for the triangle
        //base case
        if (n==1){
            xData[0]=x1;
            xData[1]=x1+currentSideLen;
            xData[2]=x1+0.5*currentSideLen;
            yData[0]=y1;
            yData[1]=y1;
            yData[2]=y1+Math.sqrt(3)*currentSideLen/2;
            StdDraw.setPenColor(fill);
            StdDraw.filledPolygon(xData, yData);
        }
        //recursive case
        else{
            //left bottom one with (x1,y1)
            drawTriangles(n-1,x1,y1,currentSideLen/2,StdDraw.GREEN);
            //top one with (x2,y2)
            drawTriangles(n-1,x1+0.25*currentSideLen,y1+Math.sqrt(3)*currentSideLen/4,currentSideLen/2,StdDraw.BLACK);
            //right bottom one with (x3,y3)
            drawTriangles(n-1,x1+0.5*currentSideLen,y1,currentSideLen/2,StdDraw.BLUE);
        }
    }
}//A5Q1 class
