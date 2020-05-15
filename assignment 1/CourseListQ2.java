/*
* [CourseListQ2 Class, work with main program TestA1Q2]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 2]
*
* PURPOSE: [creating a new class CourseListQ2
*           an instance of CourseListQ2 object would contain many Course Objects as instance fields
*           an instance of CourseListQ2 objcet would contain some instance methods:
*           +addCourse(Course): void
*           +removeCourse(String): Course
*           +indexOf(String): int
*           +toString(): String]
*/

public class CourseListQ2 {
    //instance variables
    private Course[] courseList;
    private int numCourse;

    private final int LIST_SIZE = 5;
    private final int NOT_FOUND = -1;

    public CourseListQ2() {
        courseList = new Course[LIST_SIZE];
        numCourse = 0;
    }//constructor

    public void addCourse(Course newCourse) {
        numCourse++; //increment numCourse
        //check space
        if (numCourse == courseList.length) {
            //too small, double the array size, copy the elements
            Course[] tempList = new Course[courseList.length * 2];
            for (int i = 0; i < courseList.length; i++) {
                tempList[i] = courseList[i];
            }//for loop
            courseList = tempList;//change the pointer, "courseList" is now pointing the new array
        }
        courseList[numCourse - 1] = newCourse;//add the new Course Object into the array
    }//addCourse method: add a new Course Object into the array of CourseListQ2 type

    public int indexOf(String crn) {
        int index = -1;//initialization
        for (int j = 0; j < numCourse; j++) {
            if (courseList[j].getCrn().equals(crn)){  //comparing the CRN in CourseList with the parameter
                index = j; 
                break; //break the for loop
            }//if
        }//for
        return index;
    }//indexOf method: return the index of the Course Object whose CRN is the same as the parameter

    public Course removeCourse(String delCrn) {
        Course delete = null;//initialization
        int delIndex = indexOf(delCrn); //call indexOf method

        if (delIndex != NOT_FOUND) {
            delete = courseList[delIndex];
            //overwrite Course object at delIndex with the last Course object in the array
            //find the last Course object in courseList array
            courseList[delIndex] = courseList[numCourse - 1];
            courseList[numCourse - 1] = null;
            numCourse--;
        }//if
        return delete;
    }/*removeCourse method: find the Course Object which is same as the parameter, return it;
                            replace the deleted Course Object by the last one in the array*/

    public String toString() {
        String listInfo = "";//initialization
        System.out.println("There are " + numCourse + " courses available:");
        for (int j = 0; j < numCourse; j++) {
            listInfo += ("\t" + courseList[j] + "\n");
        }
        return listInfo;
    }//toString method: return the list of Course Object
}//CourseListQ2 class
