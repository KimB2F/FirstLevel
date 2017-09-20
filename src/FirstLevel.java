import java.util.*;

public class FirstLevel{

    public static void main(String[] args){
        Course course = setParameters();
        AppController appController = new AppController(course);
        View view = new View(appController);
        view.start();
    }

    private static ArrayList<String> getArrayListHobbies(String stringHobies){
        ArrayList<String> arrayListHobbies = new ArrayList<String>();
        Collections.addAll(arrayListHobbies, stringHobies.split(","));

        return arrayListHobbies;
    }

    private static Course setParameters(){
        //
        Course course = new Course("Java");

        Group group1 = new Group(1, 1);
        group1.addStudent(new Student("Ivanenko", new GregorianCalendar(1987,8,18), 4.7, getArrayListHobbies("programming,soccer,reading")));
        group1.addStudent(new Student("Petrenko", new GregorianCalendar(1984,11,2), 4.2, getArrayListHobbies("ski,sweeming,reading")));
        group1.addStudent(new Student("Sidorchuk", new GregorianCalendar(1995,0,1), 3.5));
        group1.addStudent(new Student("Shevchenko", new GregorianCalendar(1978,5,30), 4.0, getArrayListHobbies("tennis,reading")));

        Group group2 = new Group(1, 2);
        group2.addStudent(new Student("Tischenko", new GregorianCalendar(1981,10,11), 4.8, getArrayListHobbies("programming,science")));
        group2.addStudent(new Student("Chumak", new GregorianCalendar(1988,3,28), 4.5, getArrayListHobbies("basketball,baseball")));
        group2.addStudent(new Student("Franchuk", new GregorianCalendar(1992,8,12), 4.6, getArrayListHobbies("programming")));
        group2.addStudent(new Student("Hryb", new GregorianCalendar(1980,7,20), 4.8, getArrayListHobbies("poetry,reading")));

        course.addGroup(group1);
        course.addGroup(group2);

        course.addProfessor(new Professor("Kuchma", "Java-Core"));
        course.addProfessor(new Professor("Yuschenko", "Hibernate"));
        course.addProfessor(new Professor("Kravchuk", "Spring"));

        return course;
    }
}
