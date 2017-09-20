import java.util.*;
//import java.lang.*;
//import java.io.*;

public class Group{

    private int localGroupLevel;
    private int localGroupNumber;
    private Student groupLeader = null;
    private Set<Student> students = new HashSet<Student>();

    Group(int localGroupLevel, int localGroupNumber){
        this.localGroupLevel  = localGroupLevel;
        this.localGroupNumber = localGroupNumber;
    }

    public int getLocalGroupLevel(){
        return this.localGroupLevel;
    }

    public int getLocalGroupNumber(){
        return this.localGroupNumber;
    }

    public Student getGroupLeader(){
        return this.groupLeader;
    }

    public Set<Student> getStudents(){
        return this.students;
    }

    /*Т.к. в условии не сказано, что назначение старосты производится исключительно
    ч/з выборы, то метод определяем с модификатором public*/
    public void setGroupLeader(Student groupLeader){
        this.groupLeader = groupLeader;

        System.out.println("Group #" + getLocalGroupNumber() + " from level " + getLocalGroupLevel() + " elected the leader. His name is " + groupLeader.getName());
        System.out.println(groupLeader);
    }

    @Override
    public String toString(){
        return "Group number: " + getLocalGroupNumber() + ", level: " + getLocalGroupLevel();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    /*Старосту выбираем по максимальному среднему балу и наибольшему количеству интересов*/
    public void electionGroupLeader(){
        Set<Student> setStudents = getStudents();
        double[] arrayScores = new double[setStudents.size()];
        Map<Double,ArrayList<Student>> mapStudScore = new HashMap();

        int i=0;
        for(Student student:setStudents){
            //Student student = setStudents..get(i);
            double studentScore = student.getAverageScore();
            arrayScores[i] = studentScore;

            ArrayList<Student> al = mapStudScore.get(studentScore);
            if(al == null){
                al = new ArrayList<Student>();
                mapStudScore.put(studentScore,al);
            }
            al.add(student);
            i++;
        }

        OptionalDouble max = Arrays.stream(arrayScores).max();
        double maxScore = max.getAsDouble();
        ArrayList<Student> arrayLeader = mapStudScore.get(maxScore);

        /*Если студентов с максимальным балом более одного,
        то выберем победителя по большему количеству хобби*/
        if(arrayLeader.size() > 1){
            int maxQtyHobbies = 0;
            Student lastStudent = null;
            for(i=arrayLeader.size()-1; i>=0; i--){
                Student currentStudent = arrayLeader.get(i);
                int currentQty = currentStudent.getHobbies().size();
                if(currentQty > maxQtyHobbies){
                    maxQtyHobbies = currentQty;
                    if(lastStudent != null){
                        arrayLeader.remove(lastStudent);
                    }
                    lastStudent = currentStudent;
                }
                else if(currentQty < maxQtyHobbies){
                    arrayLeader.remove(currentStudent);
                }
                else{
                    lastStudent = currentStudent;
                }
            }

            /*Если студентов с максимальным количеством хобби больше одного,
            то выберем старосту рандомно (остались только достойные кандидаты:)*/
            while(arrayLeader.size() > 1){
                arrayLeader.remove(new Random().nextInt(arrayLeader.size()));
            }
        }

        Student groupLeader = arrayLeader.get(0);

        setGroupLeader(groupLeader);
    }

    public void printAllStudents(){
        System.out.println(this);

        for (Student elem : getStudents())
            System.out.println(elem);
    }
}


