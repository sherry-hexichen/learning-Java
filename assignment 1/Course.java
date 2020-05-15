/*
* [Course Class, work with main program TestA1Q1]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 1]
*
* PURPOSE: [creating a new class "Course" 
*           an instance of Course object will have some instance fields:
*           -courseName: String
*           -department: String
*           -year: int
*           -term: int
*           -CRN: String
*           an instance of Course object will have some instance methods:
*           +constructor
*           +5 accessors for each instance fields
*           +toString(): String
*/

public class Course {
  //instance variables
  private String courseName;
  private String dept;
  private int year;
  private int term;
  private String crn;
  //static variable
  private static int numCourse = 0; //num of instance of Course Object
  private static final String C_YEAR = "2016"; 
  
  private final String[] TERM_CODE = {"Winter","Spring","Fall"}; //constant String array
  
  public Course(String title, String department, int t, int proYear) { 
    courseName = title;
    dept = department;
    term = t;
    year = proYear;
    numCourse++;
    crn = C_YEAR + t + String.format("%03d", numCourse);//format numCourse to three digits
  }//constructor
  
  //instance methods
  public String getCourseName(){
    return courseName;
  }//accessor for instance variable courseName
  
  public String getDept(){
    return dept;
  }//accessor for instance variable department
  
  public int getYear(){
    return year;
  }//accessor for instance variable year
  
  public int getTerm(){
    return term;
  }//accessor for instance variable term
  
  public String getCrn(){
    return crn;
  }//access for instance variable crn
  
  public String toString(){
    String courseInfo = "";
    courseInfo = "CRN: "+crn+": Term: "+TERM_CODE[term-1]+", "+courseName+", "+"Dept: "+dept+" (year "+year+")";
  
    return courseInfo;
  }//return a String which contain the infomation about an instance of Course object
  
}//Course class
