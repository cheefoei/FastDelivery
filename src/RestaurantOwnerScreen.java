
import entity.RestaurantOwner;
import java.util.Scanner;

public class RestaurantOwnerScreen {

    private Scanner scanner = new Scanner(System.in);
    private RestaurantOwner restaurantOwner;

    public RestaurantOwnerScreen() {

        System.out.printf("\nRestaurant Owner Main Page\n");
        System.out.println("==============");
        selectFunction();
    }

    private void selectFunction() {
        System.out.printf("\nDo you want to Login or Register?\n");
        System.out.println("============");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.print("Option >");

        int Option = -1;
        try {
            Option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
            selectFunction();
        }

        switch (Option) {
            case 1:
                checkAutho();
                break;
            case 2:
                register();
                break;

            default:
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                selectFunction();
                break;
        }

    }

    private void register() {

        System.out.printf("\nPlease enter your detail...\n");
        System.out.print("First Name >");
        String fname = scanner.nextLine();

        System.out.print("Last Name >");
        String lname = scanner.nextLine();

        System.out.print("NRIC >");
        String nric = scanner.nextLine();

        System.out.print("Address >");
        String address = scanner.nextLine();

        System.out.print("Email >");
        String email = scanner.nextLine();

        System.out.print("Phone Number >");
        String phoneNumber = scanner.nextLine();

        System.out.print("User Name >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        System.out.print("Restaurant Name >");
        String restaurantName = scanner.nextLine();

        System.out.print("Restaurant Address >");
        String restaurantAddress = scanner.nextLine();

        System.out.print("Restaurant Phone Number >");
        String restaurantPhoneNumber = scanner.nextLine();

        restaurantOwner = new RestaurantOwner(fname, lname, nric, address, email, phoneNumber, username, password, restaurantName, restaurantAddress, restaurantPhoneNumber);
        if (FastDelivery.restaurantOwners.add(restaurantOwner)) {
            System.out.printf("\n");
            System.out.println(Constants.MSG_REG_SUCCESS);
            restaurantOwnerMenu();
        }
    }

    private void checkAutho() {

        int fails = 0;
        if (fails == 3) {
            System.out.println(Constants.MSG_FAILED_TOO_MANY);
            System.exit(0);
        }

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        for (RestaurantOwner ro : FastDelivery.restaurantOwners) {
            if (username.equals(ro.getUsername())) {
                restaurantOwner = ro;
            }
        }

        if (restaurantOwner != null) {
            if (password.equals(restaurantOwner.getPassword())) {
                restaurantOwnerMenu();
            } else {
                System.out.println(Constants.ERROR_LOG_IN);
                fails++;
                checkAutho();
            }
        } else {
            System.out.println(Constants.ERROR_ACC_NOT_EXIST);
            fails++;
            checkAutho();
        }
    }

    private void restaurantOwnerMenu() {

        System.out.println("Welcome, " + restaurantOwner.getFname() + " " + restaurantOwner.getLname());

    }
}
