/*
* [CourseListQ3 Class, work with main program TestA1Q3]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 1]
* QUESTION: [question 3]
*
* PURPOSE: [creating a new class CourseListQ3 based on CourseListQ2
*           adding 3 additional methods to this class:
*           +getCoursesByDept(String): CourseListQ3
*           +getCoursesByTerm(int): CourseListQ3
*           +removeListOfCourses(CourseListQ3): void]
*/

public class CourseListQ3 {
    //instance variables
    private Course[] courseList;
    private int numCourse;

    private final int LIST_SIZE = 5;
    private final int NOT_FOUND = -1;

    public CourseListQ3() {
        courseList = new Course[LIST_SIZE];
        numCourse = 0;
    }//constructor

    public void addCourse(Course newCourse) {
        numCourse++;
        //check space
        if (numCourse == courseList.length) {
            //too small, double the size, copy the elements
            Course[] tempList = new Course[courseList.length * 2];
            for (int i = 0; i < courseList.length; i++) {
                tempList[i] = courseList[i];
            }//for
            courseList = tempList;//change the pointer
        }
        courseList[numCourse - 1] = newCourse;
    }//addCourse method

    public int indexOf(String crn) {
        int index = -1;
        for (int j = 0; j < numCourse; j++) {
            if (courseList[j].getCrn().equals(crn)){
                index = j;
                break;
            }
        }//for
        return index;
    }

    public Course removeCourse(String delCrn) {
        Course delete = null;
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
    }

    public String toString() {
        String listInfo = "";
        System.out.println("There are " + numCourse + " courses available:");
        for (int j = 0; j < numCourse; j++) {
            listInfo += ("\t" + courseList[j] + "\n");
        }
        return listInfo;
    }
    
    public CourseListQ3 getCoursesByDept(String department){
      CourseListQ3 deptOffer = new CourseListQ3();//initialization
      //search through courseList array
      //if dept field is equal to the parameter
      //add it to the new CourseListQ3 Object
      for(int i=0; i<numCourse; i++){
        if(courseList[i].getDept().equals(department)){
          deptOffer.addCourse(courseList[i]);
        }//if
      }//for
      return deptOffer;
    }/*getCoursesByDept method: search the CourseList
                                add Course Object which is same as parameter 
                                into a new CourseListQ3 object and return it */
    
    public CourseListQ3 getCoursesByTerm(int term){
      CourseListQ3 termOffer = new CourseListQ3();//initialization
      //search through couseList array
      //if term field is equal to the parameter
      //add it to the new CourseListQ3 Object
      for(int j=0; j<numCourse; j++){
        if(courseList[j].getTerm() == term){
          termOffer.addCourse(courseList[j]);//call addCourse method
        }//if
      }//for
      return termOffer;
    }/*getCoursesByTerm method: search the CourseList
                                add Course Object which is same as parameter 
                                into a new CourseListQ3 object and return it */
    
    public void removeListOfCourses(CourseListQ3 remove){
      for(int i=0; i<remove.numCourse; i++){
        removeCourse(remove.courseList[i].getCrn());//call removeCourse method
      }//for
    }/*removeListOfCourses method: remove a list of Course Objects as indicate in parameter*/

}//CourseListQ3 class
