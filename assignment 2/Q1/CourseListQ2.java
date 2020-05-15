/*
* [CourseListQ2 Class]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 2]
* QUESTION: [question 1]
*
* PURPOSE:  creating a new class CourseListQ2:
*           +addCourse(Course): void
*           +removeCourse(String): Course
*           +indexOf(String): int
*           +toString(): String
*           +getNumCourses(): int
            +getCourse(int): Course
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

    public void addCourse(Course newCourse) throws Exception {
        //duplicate CRN
        for(int i=0; i<numCourse; i++){
          if(courseList[i].getCrn().equals(newCourse.getCrn())){
             throw new Exception();
          }//when a Course in courseList has the same CRN with the input Course Object param, throw an exception
        }
        //check space
        if (numCourse == courseList.length) {
            //too small, double the array size, copy the elements
            Course[] tempList = new Course[courseList.length * 2];
            for (int i = 0; i < courseList.length; i++) {
                tempList[i] = courseList[i];
            }//for loop
            courseList = tempList;//change the pointer, "courseList" is now pointing the new array
        }
        courseList[numCourse ] = newCourse;//add the new Course Object into the array
        numCourse++; //increment numCourse
    }//addCourse method: add a new Course Object into the array of CourseListQ2 type
     //if the input param has duplicate CRN with one Course which is already in courseList, throw an exception and terminate the method

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
        //System.out.println("There are " + numCourse + " courses available:");
        for (int j = 0; j < numCourse; j++) {
            listInfo += ("\t" + courseList[j] + "\n");
        }
        return listInfo;
    }//toString method: return the list of Course Object
    
    public int getNumCourses(){
      return numCourse;
    }//get private field numCourse
    
    public Course getCourse(int i){
        if(i<0 || i>=numCourse)
            throw new ArrayIndexOutOfBoundsException("getCourse received out of bounds index of "+i);
        return courseList[i];
    }//get the Course Object at position i in the courseList array
     //if the input position param is out of the array size, throw an exception
}//CourseListQ2 class
