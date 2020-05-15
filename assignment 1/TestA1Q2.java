public class TestA1Q2
{
    public static void main(String[] args)
    {
        CourseListQ2 list = new CourseListQ2();
        
        System.out.println("Adding courses to list...");
        list.addCourse(new Course("Structure and Modelling", "Chemistry", 1, 1));
        list.addCourse(new Course("Design in Engineering", "Engineering", 2, 1));
        list.addCourse(new Course("Literary Topics", "English", 3, 1));
        list.addCourse(new Course("Biomachinery", "Biosystems", 2, 4));
        list.addCourse(new Course("Aristotle", "Philosophy", 3, 2));
        list.addCourse(new Course("Finite Element Analysis", "Engineering", 1, 3));
        list.addCourse(new Course("Plant and Animal Physiology", "Agriculture", 3, 2));
        list.addCourse(new Course("Natural Resources", "Geography", 2, 2));
        list.addCourse(new Course("Health and Disease", "History", 3, 4));
        list.addCourse(new Course("Ethics and Biomedicine", "Philosophy", 2, 2));
        list.addCourse(new Course("Programming Language Concepts", "Comp Sci", 1, 3));
        list.addCourse(new Course("Real-Time Systems", "Comp Sci", 3, 4));
        list.addCourse(new Course("Culture and Environment", "Geography", 1, 2));
        
        System.out.println(list);
        
        String [] toDelete = {"20163007", "21602007", "20163005", "20161001"};
        
        System.out.println("Removing courses from list...");
        for(int i = 0; i < toDelete.length; i++){
          Course result = list.removeCourse(toDelete[i]);
          if(result == null)
            System.out.println("CRN: " + toDelete[i] + " not found in course list");
          else
            System.out.println("Deleted " + result);
        }// for
          
        System.out.println("\n Current course list...");
        System.out.println(list);
        
        System.out.println("End of processing.\nProgrammed by Stew Dent.");
    }
}