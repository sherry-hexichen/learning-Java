public class TestA1Q1
{
    public static void main(String[] args)
    {
        Course[] courses = {new Course("Advanced YouTube Commenting", "Comp Sci", 1, 3),
                            new Course("Basket Weaving", "Fine Arts", 1, 1),
                            new Course("Intermediate Cereal Cooking", "Culinary Arts", 2, 2),
                            new Course("Potato Trees", "Agriculture", 3, 2),
                            new Course("Paper Airplanes", "Mechanical Engineering", 1, 4),
                            new Course("Zookeeping", "Animal Science", 2, 1)};
        
        printCourses(courses);
        
        System.out.println("End of processing.\nProgrammed by Stew Dent.");
    }
    
    public static void printCourses(Course[] courses)
    {
        int i;
        
        System.out.println("There are " + courses.length + " courses available:");
        
        for(i = 0; i < courses.length; i ++)
        {
            System.out.println("\t" + courses[i]);
        }
    }
}