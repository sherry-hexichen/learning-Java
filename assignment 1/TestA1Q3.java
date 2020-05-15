public class TestA1Q3
{
    public static void main(String[] args)
    {
        CourseListQ3 list = new CourseListQ3();

        list.addCourse(new Course("Natural Resources", "Geography", 1, 2));
        list.addCourse(new Course("Real-Time Systems", "Comp Sci", 2, 4));
        list.addCourse(new Course("Culture and Environment", "Geography", 3, 2));
        list.addCourse(new Course("Aristotle", "Philosophy", 2, 2));
        list.addCourse(new Course("Design in Engineering", "Engineering", 3, 1));
        list.addCourse(new Course("Literary Topics", "English", 3, 1));
        list.addCourse(new Course("Structure and Modelling", "Chemistry", 1, 1));
        list.addCourse(new Course("Finite Element Analysis", "Engineering", 2, 3));
        list.addCourse(new Course("Plant and Animal Physiology", "Agriculture", 1, 2));
        list.addCourse(new Course("Biomachinery", "Biosystems", 3, 4));
        list.addCourse(new Course("Health and Disease", "History", 1, 4));
        list.addCourse(new Course("Ethics and Biomedicine", "Philosophy", 3, 2));
        list.addCourse(new Course("Programming Language Concepts", "Comp Sci", 3, 3));

        System.out.println(list);
        
        System.out.println("Cancelling courses offered by Engineering and Geography...");
        list.removeListOfCourses(list.getCoursesByDept("Engineering"));
        list.removeListOfCourses(list.getCoursesByDept("Geography"));
        System.out.println(list);
        
        System.out.println("List of remaining Term 3 courses:");
        System.out.println(list.getCoursesByTerm(3));
        
        System.out.println("End of processing.\nProgrammed by Stew Dent.");
    }
}