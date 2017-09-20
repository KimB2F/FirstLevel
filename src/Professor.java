import java.util.*;

public class Professor{

    private String name;
    private String subject;

    Professor(String name, String subject){
        this.name    = name;
        this.subject = subject;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return "Professor name: " + name + ", subject: " + subject;
    }

    public List<StudentStatus> doRollCall(Group group){
        List<StudentStatus> studentStatuses = new ArrayList<StudentStatus>();

        for (Student student:group.getStudents()){
            studentStatuses.add(new StudentStatus(student, randomStatus()));
        }

        return studentStatuses;
    }

    private Status randomStatus() {
        int i = new Random().nextInt(Status.values().length);

        return Status.values()[i];
    }

}
