
import entity.HumanResource;
import java.util.Scanner;

public class HumanResourceScreen {

    private Scanner scanner = new Scanner(System.in);
    private HumanResource currentUser;

    private int failedCount = 0;

    public HumanResourceScreen() {

        System.out.printf("\nHuman Resource Executive Login\n");
        System.out.println("==============");

        checkAutho();
    }

    private void checkAutho() {

        if (failedCount >= 3) {
            System.out.println(Constants.MSG_FAILED_TOO_MANY);
            System.exit(0);
        }

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        for (HumanResource hr : FastDelivery.humanResources) {
            if (username.equals(hr.username)) {
                currentUser = hr;
            }
        }

        if (currentUser != null) {
            if (password.equals(currentUser.password)) {
                humanResourceMenu();
            } else {
                System.out.println(Constants.ERROR_LOG_IN);
                failedCount++;
                checkAutho();
            }
        } else {
            System.out.println(Constants.ERROR_ACC_NOT_EXIST);
            failedCount++;
            checkAutho();
        }
    }

    private void humanResourceMenu() {

    }
}
