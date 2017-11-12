
import java.util.Scanner;

public class HumanResourceScreen {

    private Scanner scanner = new Scanner(System.in);

    public HumanResourceScreen() {

        System.out.printf("\nHuman Resource Executive Login\n");
        System.out.println("==============");

        checkAutho();
    }

    private void checkAutho() {

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        if (1 == 1) {
            humanResourceMenu();
        } else {
            System.out.println(Constants.ERROR_LOG_IN);
            checkAutho();
        }
    }

    private void humanResourceMenu() {

    }
}
