
public class StudentStatus {

    private Student student;
    private Status status;

    public StudentStatus(Student student, Status status) {
        this.student = student;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student " + student.getName() + " is " + status;
    }

}
