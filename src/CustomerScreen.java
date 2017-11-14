
import java.util.Scanner;
import entity.Customer;
import entity.OrderDetails;
import java.util.ArrayList;
import java.util.List;

public class CustomerScreen {

    private Scanner scanner = new Scanner(System.in);
    public static List<Customer> customerArray = new ArrayList<>();
    private Customer currentUser;
    private OrderDetails orderDetails;
    
    
    private int failedCount = 0;

    public CustomerScreen() {

        System.out.printf("\nCustomer Login\n");
        System.out.println("==============");

        checkAutho();
    }

    private void checkAutho() {

        System.out.print("Username >");
        String cusUsername = scanner.nextLine();

        System.out.print("Password >");
        String cusPassword = scanner.nextLine();
        
        for (Customer cus : FastDelivery.customerArray) {
            if (cusUsername.equals(cus.cusUsername)) {
                currentUser = cus;
            }
        }

        if (currentUser != null) {
            if (cusPassword.equals(currentUser.cusPw)) {
                customerMenu();
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
        Scanner s = new Scanner(System.in);

        int foodId;
        int qty;
        do {
            System.out.println(" Chinese Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Char Kuey Teow - RM 5\n"
                + "2. Chicken Rice - RM 8\n"
                + "3. Fish head noodles - RM 15\n"
                + "4. Fried Rice - RM 6\n"
                + "Your choice: ");
            while (!s.hasNextInt()) {
                System.out.println("\n**Invalid option, please try again!**");
                System.out.println("\nChinese Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Char Kuey Teow - RM 5\n"
                + "2. Chicken Rice - RM 8\n"
                + "3. Fish head noodles - RM 15\n"
                + "4. Fried Rice - RM 6\n"
                + "Your choice:  ");
                s.next();
            }
            foodId = s.nextInt();
        } while (foodId <= 0);

        do {
            System.out.println("\nEnter food quantity: ");
            while (!s.hasNextInt()) {
                System.out.println("\n**Invalid option, please try again!**");
                System.out.println("\nEnter food quantity: ");
                s.next();
            }
            qty = s.nextInt();
        } while (qty <= 0);
        //OrderDetails newOrder = new OrderDetails(foodId, qty);
        //OrderFoodList.addNewOrder();\
        orderDetails = new OrderDetails(foodId, qty);
        if (FastDelivery.orderDetail.add(orderDetails)) {
            System.out.printf("\n");
            System.out.println("\nNew food added!\n");
//        System.out.println("Order List");
//        System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Food Name", "Quantity", "Price");
//        System.out.println("-----------------------------------------------------------------");
        //System.out.println(OrderDetails);
        System.out.println("Back to Menu?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            chineseMenu();
        } else {
            System.exit(0);
        }
        }

        
    }
    private void indianMenu() {
        Scanner s = new Scanner(System.in);

        int foodId;
        int qty;
        do {
            System.out.println(" Indian Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Tose - RM 3\n"
                + "2. Roti telur - RM 4\n"
                + "3. Cheese naan - RM 6\n"
                + "4. Banana Leaf Rice - RM15\n"
                + "Your choice: ");
            while (!s.hasNextInt()) {
                System.out.println("\n**Invalid option, please try again!**");
                System.out.println("\nIndian Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Tose - RM 3\n"
                + "2. Roti telur - RM 4\n"
                + "3. Cheese naan - RM 6\n"
                + "4. Banana Leaf Rice - RM15\n"
                + "Your choice:  ");
                s.next();
            }
            foodId = s.nextInt();
        } while (foodId <= 0);

        do {
            System.out.println("\nEnter food quantity: ");
            while (!s.hasNextInt()) {
                System.out.println("\n**Invalid option, please try again!**");
                System.out.println("\nEnter food quantity: ");
                s.next();
            }
            qty = s.nextInt();
        } while (qty <= 0);
        //OrderDetails newOrder = new OrderDetails(foodId, qty);
        //OrderFoodList.addNewOrder();\
        orderDetails = new OrderDetails(foodId, qty);
        if (FastDelivery.orderDetail.add(orderDetails)) {
            System.out.printf("\n");
            System.out.println("\nNew food added!\n");
//        System.out.println("Order List");
//        System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Food Name", "Quantity", "Price");
//        System.out.println("-----------------------------------------------------------------");
        //System.out.println(OrderDetails);
        System.out.println("Back to Menu?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            indianMenu();
        } else {
            System.exit(0);
        }
        }
    }

    private void malayMenu() {
        Scanner s = new Scanner(System.in);

        int foodId;
        int qty;
        do {
            System.out.println(" Malay Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Nasi Lemak - RM 5\n"
                + "2. Asam Laksa - RM 8\n"
                + "3. Ayam Penyet - RM 15\n"
                + "4. Murtabak - RM4\n"
                + "Your choice: ");
            while (!s.hasNextInt()) {
                System.out.println("\n**Invalid option, please try again!**");
                System.out.println("\nIndian Food Menu\n "
                + "Please choose your food.\n"
                + "------------------------\n"
                + "1. Nasi Lemak - RM 5\n"
                + "2. Asam Laksa - RM 8\n"
                + "3. Ayam Penyet - RM 15\n"
                + "4. Murtabak - RM4\n"
                + "Your choice:  ");
                s.next();
            }
            foodId = s.nextInt();
        } while (foodId <= 0);

        do {
            System.out.println("\nEnter food quantity: ");
            while (!s.hasNextInt()) {
                System.out.println("\n**Invalid option, please try again!**");
                System.out.println("\nEnter food quantity: ");
                s.next();
            }
            qty = s.nextInt();
        } while (qty <= 0);
        //OrderDetails newOrder = new OrderDetails(foodId, qty);
        //OrderFoodList.addNewOrder();\
        orderDetails = new OrderDetails(foodId, qty);
        if (FastDelivery.orderDetail.add(orderDetails)) {
            System.out.printf("\n");
            System.out.println("\nNew food added!\n");
//        System.out.println("Order List");
//        System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Food Name", "Quantity", "Price");
//        System.out.println("-----------------------------------------------------------------");
        //System.out.println(OrderDetails);
        System.out.println("Back to Menu?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            malayMenu();
        } else {
            System.exit(0);
        }
        }
    }

}
