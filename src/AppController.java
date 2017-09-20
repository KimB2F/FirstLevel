import java.util.*;

public class AppController {

    private Course course;

    AppController(Course course){
        this.course = course;
    }

    public Course getCourse(){
        return this.course;
    }

    public List<Group> getGroups(){
        return getCourse().getGroups();
    }

    public List<Professor> getProfessors(){
        return getCourse().getProfessors();
    }

    public void menuDoRollCall(Professor professor, Group group){
        List<StudentStatus> studentStatuses = professor.doRollCall(group);

        System.out.println("Professor " + professor.getName() + " say:");
        for(StudentStatus s:studentStatuses)
            System.out.println(s);
    }

    public void electGroupLeader(Group group){
        group.electionGroupLeader();
    }

    public void printProfessorlist(){
        List<Professor> professors = getProfessors();

        for(Professor p:professors)
            System.out.println(p);
    }

    public void printGroupStudents(Group group){
        group.printAllStudents();
    }

}
