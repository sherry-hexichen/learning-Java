/* COMP 1020 Winter 2016
 * Assignment 2 Question 1
 * Supplied test program
 */
public class TestA2Q1
{
    public static void main(String[] args)throws Exception
    {
        //Create a Database object and load the test file into it.
        Database courseList = new Database("courses.txt","coursesOut.txt");
        CourseListQ2 courses = courseList.load();

        //Add a new course and delete an existing course
        courses.addCourse(new Course("Aristotle", "Department of Philosophy",3,2));
        courses.removeCourse("20161001");
        
        //Write out the contents of the database, and save it to a file.
        try {
          for(int i=0; i<=courses.getNumCourses(); i++)
            System.out.println(courses.getCourse(i).toCsv());
        } catch (ArrayIndexOutOfBoundsException e){
          System.out.println("TestA2Q1: " + e);
        }
       try {
          courseList.save(courses);
        } catch (Exception e){
          System.out.println("TestA2Q1: " + e);
        }

        System.out.println("End of processing.\nProgrammed by Stew Dent.");
    }//main

}//TestA2Q1