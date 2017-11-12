
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

        System.out.println("Please choose a restaurant.\n"
                + "------------------------\n"
                + "1. Chinese Restaurant\n"
                + "2. Indian Restaurant\n"
                + "3. Malay Restaurant\n"
                + "4. Exit\n\n\n"
                + "Your choice: ");

        int input = scanner.nextInt();

        switch (input) {
            case 1:
                chineseMenu();
                break;
            case 2:
                indianMenu();
                break;
            case 3:
                malayMenu();
                break;
            case 4:
                customerMenu();
                break;
            default:
                System.out.println("Invalid option, please try again!\n");
                customerMenu();
                break;
        }
    }

    private void chineseMenu() {

        System.out.println("Chinese Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Char Kuey Teow - RM 5\n"
                + "2. Chicken Rice - RM 8\n"
                + "3. Fish head noodles - RM 15\n"
                + "4. Back To Main Menu\n"
                + "5. Exit\n\n\n"
                + "Your choice: ");
    }

    private void indianMenu() {

        System.out.println("Indian Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Tose - RM 3\n"
                + "2. Roti telur - RM 4\n"
                + "3. Cheese naan - RM 6\n"
                + "4. Back To Main Menu\n"
                + "5. Exit\n\n\n"
                + "Your choice: ");
    }

    private void malayMenu() {

        System.out.println("Malay Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Nasi Lemak - RM 5\n"
                + "2. Asam Laksa - RM 8\n"
                + "3. Ayam Penyet - RM 15\n"
                + "4. Back To Main Menu\n"
                + "5. Exit\n\n\n"
                + "Your choice: ");
    }

}
