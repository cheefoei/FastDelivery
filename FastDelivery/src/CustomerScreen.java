
import java.util.Scanner;

public class CustomerScreen {

    private Scanner scanner = new Scanner(System.in);

    public CustomerScreen() {

        System.out.printf("\nCustomer Login\n");
        System.out.println("==============");

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        if (isAuthorised(username, password)) {
            customerMenu();
        }
    }

    private boolean isAuthorised(String username, String password) {

        if (1 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void customerMenu() {

    }
}
