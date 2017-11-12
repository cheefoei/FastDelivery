
import java.util.Scanner;

public class DeliveryManScreen {

    private Scanner scanner = new Scanner(System.in);

    public DeliveryManScreen() {

        System.out.printf("\nHuman Resource Executive Login\n");
        System.out.println("==============");

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        if (isAuthorised(username, password)) {
            deliveryManMenu();
        }
    }

    private boolean isAuthorised(String username, String password) {

        if (1 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void deliveryManMenu() {

    }
}
