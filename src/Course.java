import java.util.*;
//import java.lang.*;
//import java.io.*;


public class Course{

    private String name;
    private List<Group> groups = new ArrayList<Group>();
    private List<Professor> professors = new ArrayList<Professor>();

    public List<Group> getGroups(){
        return this.groups;
    }

    public List<Professor> getProfessors(){
        return this.professors;
    }

    Course(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Course: " + name;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public void addProfessor(Professor professor){
        professors.add(professor);
    }
}
