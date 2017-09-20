import java.util.List;
import java.util.Scanner;

public class View {

    private AppController appController;

    public View(AppController appController) {
        this.appController = appController;
    }

    public void start() {
        mainMenu("Select menu item:");
    }

    private void mainMenu(String str){
        System.out.println("\n********************************");
        System.out.println(str);
        System.out.println("********************************\n");
        System.out.println(" 1. Print a student list.");
        System.out.println(" 2. Elect a leader of group.");
        System.out.println(" 3. Print a professor list.");
        System.out.println(" 4. Start a roll call. \n");
        System.out.println(" 0. Exit programm.");
        System.out.println("\n********************************\n");

        int i = 9;
        try {
            Scanner in = new Scanner(System.in);
            i = in.nextInt();
        }catch (Exception e){
            System.out.println("Incorrect choise!");
            mainMenu(str);
        }

        switch (i) {
            case 1:
                printStudentList();
                break;
            case 2:
                menuElectLeader();
                break;
            case 3:
                printProfessorList();
                break;
            case 4:
                menuDoRollCall();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Incorrect choise!");
                mainMenu(str);
        }
    }

    private void printStudentList(){
        Group group = menuSelectGroup("Select a group to print the student list.");
        appController.printGroupStudents(group);

        mainMenu("Select menu item:");
    }

    private void menuElectLeader(){
        Group group = menuSelectGroup("Select a group to start election the leader.");
        appController.electGroupLeader(group);

        mainMenu("Select menu item:");
    }

    private void printProfessorList() {
        appController.printProfessorlist();

        mainMenu("Select menu item:");
    }

    private void menuDoRollCall(){
        Professor professor = menuSelectProfessor("Select a professor to start the roll call.");
        Group group = menuSelectGroup("Select a group to start the roll call.");
        appController.menuDoRollCall(professor, group);

        mainMenu("Select menu item:");
    }

    private Group menuSelectGroup(String str){
        System.out.println("\n********************************");
        System.out.println(str);
        System.out.println("********************************\n");
        List<Group> groups = appController.getGroups();

        for (int i=0; i<groups.size(); i++) {
            System.out.println(" " + (i+1) + ". " + groups.get(i).toString());
        }
        System.out.println("\n********************************\n");

        try {
            Scanner in = new Scanner(System.in);
            int i =  in.nextInt();

            if (groups.size() < i){
                System.out.println("Incorrect choise! \n");
                return menuSelectGroup(str);
            }

            return groups.get(--i);
        }catch (Exception e){
            System.out.println("Incorrect choise! \n");
            menuSelectGroup(str);
        }

        return menuSelectGroup(str);
    }

    private Professor menuSelectProfessor(String str){
        System.out.println("\n********************************");
        System.out.println(str);
        System.out.println("********************************\n");
        List<Professor> professors = appController.getProfessors();

        for (int i=0; i<professors.size(); i++) {
            System.out.println(" " + (i+1) + ". " + professors.get(i).toString());
        }
        System.out.println("\n********************************\n");

        try {
            Scanner in = new Scanner(System.in);
            int i =  in.nextInt();

            if (professors.size() < i){
                return menuSelectProfessor(str);
            }

            return professors.get(--i);
        }catch (Exception e){
            System.out.println("Incorrect choise! \n");
            menuSelectGroup(str);
        }

        return menuSelectProfessor(str);
    }


}
