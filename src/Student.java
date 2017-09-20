import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
//import java.lang.*;
//import java.io.*;

public class Student{

    private String name;
    private GregorianCalendar birthDate;
    private double averageScore;
    private List<String> hobbies;

    Student(String name, GregorianCalendar birthDate, double averageScore){
        this.name         = name;
        this.birthDate 		= birthDate;
        this.averageScore = averageScore;
        this.hobbies      = new ArrayList<String>();
    }

    Student(String name, GregorianCalendar birthDate, double averageScore, ArrayList<String> hobbies){
        this.name         = name;
        this.birthDate 		= birthDate;
        this.averageScore = averageScore;
        this.hobbies 		  = hobbies;
    }

    public String getName(){
        return this.name;
    }

    public GregorianCalendar getBirthDate(){
        return this.birthDate;
    }

    public double getAverageScore(){
        return this.averageScore;
    }

    public List<String> getHobbies(){
        return this.hobbies;
    }

    public static int getStudentAge(GregorianCalendar dob){

        GregorianCalendar now = new GregorianCalendar();

        //учтем день рождения
        dob.add(GregorianCalendar.DAY_OF_MONTH, -1);

        int age = now.get(GregorianCalendar.YEAR) - dob.get(GregorianCalendar.YEAR);
        if (now.get(GregorianCalendar.DAY_OF_YEAR) <= dob.get(GregorianCalendar.DAY_OF_YEAR)){
            age--;
        }

        return age;
    }

    public void setAverageScore(double newScore){
        averageScore = newScore;
    }

    @Override
    public String toString(){
        return "Student name: " + name + ", age: " + getStudentAge(birthDate) + ", average score: " + averageScore + ", hobbies: " + getHobbies();
    }

    @Override
    public int hashCode(){
        int hash = 1;
        hash = hash * 11 + getName().hashCode();
        hash = hash * 17 + getBirthDate().hashCode();

        return hash;
    }

    public void addHobby(String hobby){
        hobbies.add(hobby);
    }

}


