
import java.util.Scanner;

public class RestaurantOwnerScreen {

    private Scanner scanner = new Scanner(System.in);

    public RestaurantOwnerScreen() {

        System.out.printf("\nHuman Resource Executive Login\n");
        System.out.println("==============");

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        if (isAuthorised(username, password)) {
            restaurantOwnerMenu();
        }
    }

    private boolean isAuthorised(String username, String password) {

        if (1 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void restaurantOwnerMenu() {

    }
}
