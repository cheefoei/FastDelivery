
import java.util.Scanner;

public class DeliveryManScreen {

    private Scanner scanner = new Scanner(System.in);

    public DeliveryManScreen() {

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
            deliveryManMenu();
        } else {
            System.out.println(Constants.ERROR_LOG_IN);
            checkAutho();
        }
    }

    private void deliveryManMenu() {

    }
}
