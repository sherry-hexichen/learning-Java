/*
* [Database Class]
*
* COMP 1020 SECTION [A03]
* INSTRUCTOR: [Amir Memar]
* NAME: [Xichen HE]
* ASSIGNMENT: [Assignment 2]
* QUESTION: [question 1]
*
* PuRPOSE: Database Class can load course information from a file, and save course information to a file:
*           -input: String
*           -output: String
*           +load(): CourseListQ2
*           +save(CourseListQ2): void
*/

import java.io.*; //I/O operations
import java.util.Scanner;

public class Database {
    //instance variables
    private String input = "inputFile";
    private String output = "outputFile";

    public Database(String in, String out) {
        this.input = in;
        this.output = out;
    }//constructor

    //instance methods
    public CourseListQ2 load() throws IOException {
        CourseListQ2 loadList = new CourseListQ2();//new CourseListQ2 Object
        Scanner inputFile = new Scanner(new File(input)); //open input file
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();//read one line
            String[] details = line.split(",");//split by each comma, and put each String into an array
            String crn = details[0];
            String name = details[1];
            String dept = details[2];
            int term = Integer.parseInt(details[3]);
            int year = Integer.parseInt(details[4]);
            Course load = new Course(crn, name, dept, term, year);//call Course constructor 2
            try {
                loadList.addCourse(load); //call addCourse method to add Course Object into CourseListQ2 Object
            }catch (Exception error){
                System.out.println("Duplicate CRN: " + crn); //catch duplicateCRN exception thrown by addCourse method
            }//catch
        }//while
        inputFile.close();//close input file
        return loadList;
    }/* load method: read the comma seperated input file, each line as a Course Object, 
        add all the Course Objects into a CourseListQ2 Object and return the CourseListQ2 Object */

    public void save(CourseListQ2 courseList) throws IOException {
        PrintWriter outputFile = new PrintWriter(output);//create output file
        int numCourse = courseList.getNumCourses(); //how many courses in the input CourseListQ2 Object
        for(int i=0; i<numCourse; i++){
            Course saveCourse = courseList.getCourse(i);//get each Course Object in the parameter
            outputFile.println(saveCourse.toCsv()); //call toCsv method to convert to String and write into the output file
        }
        outputFile.close();//close output file
    }/* save method: get Course information from parameter CourseListQ2, write them into one line seperated by comma in an output txt file */
}//Database Class
