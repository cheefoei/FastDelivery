
import java.util.Scanner;

public class FastDelivery {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("###################################");
        System.out.println("#                                 #");
        System.out.println("# Welocme to FastDelivery System! #");
        System.out.println("#                                 #");
        System.out.println("###################################");

        promptRole();
    }

    private static void promptRole() {

        System.out.println("Who are you?");
        System.out.println("============");
        System.out.println("1) Customer");
        System.out.println("2) Restaurant Owner");
        System.out.println("3) Delivery Man");
        System.out.println("4) Human Resource Executive");
        System.out.print("Option >");

        int roleNum = -1;
        try {
            roleNum = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.printf("Error! Just choose 1, 2, 3 or 4. \n\n");
            promptRole();
        }

        switch (roleNum) {
            case 1:
                new CustomerScreen();
                break;
            case 2:
                new RestaurantOwnerScreen();
                break;
            case 3:
                new DeliveryManScreen();
                break;
            case 4:
                new HumanResourceScreen();
                break;
            default:
                System.out.printf("Error! Just choose 1, 2, 3 or 4. \n\n");
                promptRole();
                break;
        }
    }
}
