
import adt.OrderFoodInterface;
import adt.OrderFoodList;
import adt.OrderInterface;
import adt.OrderList;
import adt.RestaurantOwnerInterface;
import adt.RestaurantOwnerList;
import adt.ScheduledOrderInterface;
import adt.ScheduledOrderList;
import entity.Contact;
import java.util.Scanner;
import entity.Customer;
import entity.Food;
import entity.OrderDetails;
import entity.Orders;
import entity.RestaurantOwner;
import java.text.DateFormat;
//import entity.ScheduledOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomerScreen {

    private Scanner scanner = new Scanner(System.in);

    //public static OrderFoodInterface<OrderDetails> orderFoodList = new OrderFoodList<>();
    public static OrderInterface<Orders> orderList = new OrderList<>();
    public static RestaurantOwnerInterface<RestaurantOwner> restaurantList = new RestaurantOwnerList<>();
    //#
    //public static ScheduledOrderInterface<ScheduledOrder> scheduledOrder = new ScheduledOrderList<>();
    //#
    
    
    private Customer currentUser;
    private OrderDetails orderDetails;
    public static int id = 0001;
    public static String status = "Pending";

    public double subTotal;
    public double totalPrice;
    private double foodPrice;
    static boolean ordering = true;

    //#
    private String type;
    private Date scheduleDate = new Date();
    private Date scheduleTime = new Date();
    //#
    private int failedCount = 0;
    
    public static final DateFormat DF = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);

    public CustomerScreen() {

        System.out.printf("\nCustomer Login\n");
        System.out.println("==============");

        checkAutho();
            
        try {
            Orders order8 = new Orders(
                    status,
                    50.00,
                    DF.parse("Mon 11-Dec-2017 15:33:30"),
                    currentUser
            );
            order8.setOrderId(1513099860);
            
            orderList.addNewOrder(order8);
            } catch (ParseException ex) {
        }
        

        //OrderDetails orderdetails1 = new OrderDetails(1, 10);

        //orderFoodList.addNewOrder(orderdetails1);
       //Orders order1 = new Orders(id, status, totalPrice);
        //#
        RestaurantOwner ro7 = new RestaurantOwner(
                "Hanbin",
                "Kim",
                "91022-10-5555",
                new Contact(
                        "No 22, Jalan Harmoni,Putra Height",
                        "Shah Alam",
                        47300,
                        "Selangor",
                        "habinnie@email.com",
                        "0101022222"
                ),
                "hanbin",
                "kim",
                "Han Bin Restaurant",
                "No 22, Jalan Harmoni,Putra Height 47300 Shah Alam Selangor",
                "0322222222"
        );

        restaurantList.add(ro7);
        
        RestaurantOwner ro8 = new RestaurantOwner(
                "Bobby",
                "Kim",
                "951220-10-2020",
                new Contact(
                        "No 20, Section 27,Putra Height",
                        "Shah Alam",
                        47300,
                        "Selangor",
                        "bobbykim@email.com",
                        "0101220202"
                ),
                "bobby",
                "kim",
                "Ticket to Korea",
                "12-12 SS17/1 47650 Subang Jaya, Selangor",
                "0320202020"
        );

        restaurantList.add(ro8);
        //ScheduledOrder sOrder1 = new ScheduledOrder(id, status, totalPrice, scheduleDate, scheduleTime, currentUser);
        //#
        //id++;
        //orderList.addNewOrder(order1);
        //#
        //scheduledOrder.add(sOrder1);
        //#
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
                //customerMenu();
                customerMainMenu();
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

    private void customerMainMenu() {

        System.out.println("|--------------------------------|");
        System.out.println("|       Customer Main Menu       |");
        System.out.println("|--------------------------------|");
        System.out.println("|                                |");
        System.out.println("|1. Place Order (ad-hoc)         |");
        System.out.println("|2. Schedule Order               |");
        System.out.println("|3. Update Order                 |");
        System.out.println("|4. Display order                |");
        System.out.println("|0. Back to Main Menu            |");
        System.out.println("|                                |");
        System.out.println("|--------------------------------|");
        System.out.println("");
        System.out.println("Your choice: ");

        int input = scanner.nextInt();

        switch (input) {
            case 1:
                type = "ad-hoc";
                customerMenu();
                break;
            case 2:
                type = "schedule";
                customerMenu();
                break;
                case 3:
                updateOrder();
                break;
                    case 4:
                displayOrder();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option, please try again!\n");
                customerMenu();
                break;
        }
    }

    private void customerMenu() {

        System.out.println("|--------------------------------|");
        System.out.println("| Please choose a restaurant.    |");
        System.out.println("|--------------------------------|");
        
        if (restaurantList.isEmpty()) {
            System.out.println("EMPTY!!");
        } else {
            int n = restaurantList.getLength();

            int y = 1;
            while (y <= n) {
                RestaurantOwner ro = restaurantList.getAt(y);

                String restaurantName = ro.getRestaurantName();
                
                System.out.print(y + ". ");
                System.out.println(String.format("%-18s ", restaurantName));

                y++;

            }

}
        System.out.println("");
        System.out.println("Your choice: ");
    }
    
    private void updateOrder(){
        
        
        System.out.println("|--------------------------------------|");
        System.out.println("| Please choose an Order to update.    |");
        System.out.println("|--------------------------------------|");
        System.out.println("Order Details List");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "No.", "Order ID", "Food", "Quantity", "Remark");
        System.out.println("-------------------------------------------------------------------------------");
        //System.out.println(orderDetailList);
        System.out.printf("Enter required order to update : ");
        int num = scanner.nextInt();
        
        System.out.println("\nUpdated Order Details List:");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "No.", "Order ID", "Food", "Quantity", "Remark");
        System.out.println("-------------------------------------------------------------------------------");
        //System.out.println(orderDetailList);
        
        Scanner s = new Scanner(System.in);

        System.out.println("Back to Main?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            customerMainMenu();
        } else {
            System.exit(0);
        }
        
    }
    
    private void displayOrder(){
        
        Scanner s = new Scanner(System.in);
        System.out.println("Order List");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "No.", "Status", "Total Price(RM)", "Order Date", "Customer");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(orderList);

        System.out.println("Back to Main?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            customerMainMenu();
        } else {
            System.exit(0);
        }
        
    }

    
    
//public int quantity() {
//    Scanner s = new Scanner(System.in);
//    Scanner con = new Scanner(System.in);
//    System.out.println("Enter quantity :");       
//    int quantity = s.nextInt();
//    subTotal(quantity, foodPrice);
//    System.out.println("Order more food?\n"
//                + "1. Yes\n"
//                + "2. No\n"
//                + "Your choice: ");
//        int yesno = con.nextInt();
//        if (yesno == 1) {
//            chineseMenu();
//        } else {
//            done();
//        }
//        
//    return quantity;
// }

//    public double subTotal(double quantity, double foodPrice) {
//
//        double subTotal = quantity * foodPrice;
//        System.out.println("Subtotal: RM" + subTotal);
//        totalPrice += subTotal;
//        return subTotal;
//    }
//    
//public void assignJob(){
//    for (DeliveryMan dm : FastDelivery.deliveryMen) {
//            if (dm.getWorkingStatus() == Constants.AVAILABLE) {
//                
//               inCharge = dm.username;
//            }else inCharge = "";
//        }
//    done();
//}

//    private void makeSchedule() {
//        
//        Scanner s = new Scanner(System.in);
//        System.out.println("Set the date for delivering order > ");
//        String date = s.nextLine();
//        System.out.println("Set the time for delivering order > ");
//        String time = s.nextLine();
//
//        Date currentDate = new Date();
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            scheduleDate = dateFormat.parse(date);
//
//            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//            scheduleTime = timeFormat.parse(time);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        done();
//    }

//    public void done() {
//        
//        ordering = false;
//        System.out.println("|-------------------------------|");
//        System.out.println("|Total price: RM" + totalPrice + "            " + "|");
//        System.out.println("|-------------------------------|");
//        System.out.println("|Thank you for your order !     |");
//        System.out.println("|-------------------------------|");
//        payment();
//    }

//    public void payment() {
//
//        System.out.println("\nPlease make payment to the deliveryman. We accept **CASH ONLY!**");
//        if (type.equals("ad-hoc")) {
//            Orders newOrders = new Orders(id, status, totalPrice);
//            id++;
//            orderList.addNewOrder(newOrders);
//
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println("                              Order List");
//            System.out.println("------------------------------------------------------------------------");
//            System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)");
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println(orderList);
//        } else {
//            ScheduledOrder newScheduledOrder = new ScheduledOrder(id, status, totalPrice, scheduleDate, scheduleTime, currentUser);
//            id++;
//            scheduledOrder.add(newScheduledOrder);
//
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("                                                 Order List");
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)", "Customer Name", "Customer Contact", "Deliver Date", "Deliver Time");
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
////            for (int i = 0; i < scheduledOrder.size(); i++) {
////                if (new Date().compareTo(scheduledOrder.show(i).getScheduleDate()) > 0) {
////                    System.out.println(scheduledOrder.show(i).toString());
//            System.out.println(scheduledOrder);
////                }
////            }
//        }
//    }

}

//
//import adt.OrderFoodInterface;
//import adt.OrderFoodList;
//import adt.OrderInterface;
//import adt.OrderList;
//import adt.ScheduledOrderInterface;
//import adt.ScheduledOrderList;
//import java.util.Scanner;
//import entity.Customer;
//import entity.OrderDetails;
//import entity.Orders;
//import entity.ScheduledOrder;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class CustomerScreen {
//
//    private Scanner scanner = new Scanner(System.in);
//
//    public static OrderFoodInterface<OrderDetails> orderFoodList = new OrderFoodList<>();
//    public static OrderInterface<Orders> orderList = new OrderList<>();
//    //#
//    public static ScheduledOrderInterface<ScheduledOrder> scheduledOrder = new ScheduledOrderList<>();
//    //#
//    private Customer currentUser;
//    private OrderDetails orderDetails;
//    public static int id = 0001;
//    public static String status = "Pending";
//
//    public double subTotal;
//    public double totalPrice;
//    private double foodPrice;
//    static boolean ordering = true;
//
//    //#
//    private String type;
//    private Date scheduleDate = new Date();
//    private Date scheduleTime = new Date();
//    //#
//    private int failedCount = 0;
//
//    public CustomerScreen() {
//
//        System.out.printf("\nCustomer Login\n");
//        System.out.println("==============");
//
//        checkAutho();
//
//        //OrderDetails orderdetails1 = new OrderDetails(1, 10);
//
//        //orderFoodList.addNewOrder(orderdetails1);
//       // Orders order1 = new Orders(id, status, totalPrice);
//        //#
//        ScheduledOrder sOrder1 = new ScheduledOrder(id, status, totalPrice, scheduleDate, scheduleTime, currentUser);
//        //#
//        //id++;
//        //orderList.addNewOrder(order1);
//        //#
//        scheduledOrder.add(sOrder1);
//        //#
//    }
//
//    private void checkAutho() {
//
//        System.out.print("Username >");
//        String cusUsername = scanner.nextLine();
//
//        System.out.print("Password >");
//        String cusPassword = scanner.nextLine();
//
//        for (Customer cus : FastDelivery.customerArray) {
//            if (cusUsername.equals(cus.cusUsername)) {
//                currentUser = cus;
//            }
//        }
//
//        if (currentUser != null) {
//            if (cusPassword.equals(currentUser.cusPw)) {
//                //customerMenu();
//                customerMainMenu();
//            } else {
//                System.out.println(Constants.ERROR_LOG_IN);
//                failedCount++;
//                checkAutho();
//            }
//        } else {
//            System.out.println(Constants.ERROR_ACC_NOT_EXIST);
//            failedCount++;
//            checkAutho();
//        }
//    }
//
//    private void customerMainMenu() {
//
//        System.out.println("|--------------------------------|");
//        System.out.println("|       Customer Main Menu       |");
//        System.out.println("|--------------------------------|");
//        System.out.println("|                                |");
//        System.out.println("|1. Place Order (ad-hoc)         |");
//        System.out.println("|2. Schedule Order               |");
//        System.out.println("|0. Back to Main Menu            |");
//        System.out.println("|                                |");
//        System.out.println("|--------------------------------|");
//        System.out.println("");
//        System.out.println("Your choice: ");
//
//        int input = scanner.nextInt();
//
//        switch (input) {
//            case 1:
//                type = "ad-hoc";
//                customerMenu();
//                break;
//            case 2:
//                type = "schedule";
//                customerMenu();
//                break;
//            case 0:
//                break;
//            default:
//                System.out.println("Invalid option, please try again!\n");
//                customerMenu();
//                break;
//        }
//    }
//
//    private void customerMenu() {
//
//        System.out.println("|--------------------------------|");
//        System.out.println("| Please choose a restaurant.    |");
//        System.out.println("|--------------------------------|");
//        System.out.println("|1. Ho Ciak   Restaurant         |");
//        System.out.println("|2. Svaadisht Restaurant         |");
//        System.out.println("|3. Maju maju Restaurant         |");
//        System.out.println("|4. Exit                         |");
//        System.out.println("|--------------------------------|");
//        System.out.println("");
//        System.out.println("Your choice: ");
//
//        int input = scanner.nextInt();
//
//        switch (input) {
//            case 1:
//                chineseMenu();
//                break;
//            case 2:
//                indianMenu();
//                break;
//            case 3:
//                malayMenu();
//                break;
//            case 4:
//                customerMainMenu();
//                break;
//            default:
//                System.out.println("Invalid option, please try again!\n");
//                customerMenu();
//                break;
//        }
//    }
//
//    private void chineseMenu() {
//
//
//        Scanner s = new Scanner(System.in);
//        int foodId = 0;
//        int qty;
//        do {
//            System.out.println("|------------------------------------------|");
//            System.out.println("| Ho Ciak Menu                             |");
//            System.out.println("|------------------------------------------|");
//            System.out.println("|1. Char Kuey Teow       | RM 5.00         |");
//            System.out.println("|2. Chicken Rice         | RM 8.00         |");
//            System.out.println("|3. Fish head noodles    | RM 15.00        |");
//            System.out.println("|4. Fried Rice           | RM 4.50         |");
//            System.out.println("|------------------------------------------|");
//            System.out.println("");
//            System.out.println("Please choose your food.\n"
//                    + "Your choice: ");
//
//            while (!s.hasNextInt()) { //hasNextInt() check int
//                System.out.println("\nInvalid option, please try again!");
//                System.out.println("\nPlease choose 1-4!");
//                System.out.println("|------------------------------------------|");
//                System.out.println("| Ho Ciak Menu                             |");
//                System.out.println("|------------------------------------------|");
//                System.out.println("|1. Char Kuey Teow       | RM 5.00         |");
//                System.out.println("|2. Chicken Rice         | RM 8.00         |");
//                System.out.println("|3. Fish head noodles    | RM 15.00        |");
//                System.out.println("|4. Fried Rice           | RM 4.50         |");
//                System.out.println("|------------------------------------------|");
//                System.out.println("");
//                System.out.println("Please choose your food.\n" + "Your choice: ");
//                s.next();
//            }
//            foodId = s.nextInt();
//            foodPrice(foodId);
//        } while (foodId <= 0);
//
//        do {
//            System.out.println("\nEnter food quantity: ");
//            while (!s.hasNextInt()) {
//                System.out.println("\nInvalid option, please try again!");
//                System.out.println("\nPlease choose 1-4!");
//                System.out.println("\nEnter food quantity: ");
//                s.next();
//
//            }
//            qty = s.nextInt();
//
//            subTotal(qty, foodPrice);
//        } while (qty <= 0);
//        OrderDetails newOrder = new OrderDetails(foodId, qty);
//        orderFoodList.addNewOrder(newOrder);
//        orderDetails = new OrderDetails(foodId, qty);
////        if (FastDelivery.orderDetail.add(orderDetails)) {
//        System.out.printf("\n");
//        System.out.println("\nNew food added!\n");
//        System.out.println("---------------------------------------------");
//        System.out.println("             Order Details List");
//        System.out.println("----------------------------------------------");
//        System.out.printf("%-10s %-20s %-20s \n", "No.", "Food Name", "Quantity");
//        System.out.println("----------------------------------------------");
//        System.out.println(orderFoodList);
//        System.out.println("Order more food?\n"
//                + "1. Yes\n"
//                + "2. No\n");
//        int yesno = s.nextInt();
//        if (yesno == 1) {
//            chineseMenu();
//        } else {
//            if (type.equals("ad-hoc")) {
//                done();
//            } else {
//                makeSchedule();
//            }
//        }
////        }
//    }
//
//    private void indianMenu() {
//
//        Scanner s = new Scanner(System.in);
//        int foodId = 0;
//        int qty;
//        do {
//            System.out.println("|------------------------------------------------|");
//            System.out.println("| Svaadisht Menu                                 |");
//            System.out.println("|------------------------------------------------|");
//            System.out.println("|5. Tose                       | RM 3.00         |");
//            System.out.println("|6. Roti telur                 | RM 4.00         |");
//            System.out.println("|7. Cheese Naan                | RM 6.00         |");
//            System.out.println("|8. Banana Leaf Rice           | RM 15.00        |");
//            System.out.println("|------------------------------------------------|");
//            System.out.println("");
//            System.out.println("Please choose your food.\n"
//                    + "Your choice: ");
//
//            while (!s.hasNextInt()) { //hasNextInt() check int
//                System.out.println("\nInvalid option, please try again!");
//                System.out.println("\nPlease choose 1-4!");
//                System.out.println("|------------------------------------------------|");
//                System.out.println("| Svaadisht Menu                                 |");
//                System.out.println("|------------------------------------------------|");
//                System.out.println("|5. Tose                       | RM 3.00         |");
//                System.out.println("|6. Roti telur                 | RM 4.00         |");
//                System.out.println("|7. Cheese Naan                | RM 6.00         |");
//                System.out.println("|8. Banana Leaf Rice           | RM 15.00        |");
//                System.out.println("|------------------------------------------------|");
//                System.out.println("");
//                System.out.println("Please choose your food.\n" + "Your choice: ");
//                s.next();
//            }
//            foodId = s.nextInt();
//            foodPrice(foodId);
//        } while (foodId <= 0);
//
//        do {
//            System.out.println("\nEnter food quantity: ");
//            while (!s.hasNextInt()) {
//                System.out.println("\nInvalid option, please try again!");
//                System.out.println("\nPlease choose 5-8!");
//                System.out.println("\nEnter food quantity: ");
//                s.next();
//
//            }
//            qty = s.nextInt();
//
//            subTotal(qty, foodPrice);
//        } while (qty <= 0);
//        OrderDetails newOrder = new OrderDetails(foodId, qty);
//        orderFoodList.addNewOrder(newOrder);
//        orderDetails = new OrderDetails(foodId, qty);
////        if (FastDelivery.orderDetail.add(orderDetails)) {
//        System.out.printf("\n");
//        System.out.println("\nNew food added!\n");
//        System.out.println("---------------------------------------------");
//        System.out.println("             Order Details List");
//        System.out.println("----------------------------------------------");
//        System.out.printf("%-10s %-20s %-20s \n", "No.", "Food Name", "Quantity");
//        System.out.println("----------------------------------------------");
//        System.out.println(orderFoodList);
//        System.out.println("Order more food?\n"
//                + "1. Yes\n"
//                + "2. No\n");
//        int yesno = s.nextInt();
//        if (yesno == 1) {
//            indianMenu();
//        } else {
//            if (type.equals("ad-hoc")) {
//                done();
//            } else {
//                makeSchedule();
//            }
//        }
////        }
//    }
////        Scanner s = new Scanner(System.in);
////
////        int foodId;
////        int qty;
////        do {
////            System.out.println(" Indian Food Menu\n "
////                + "Please choose your food.\n"
////                + "------------------------\n"
////                + "1. Tose - RM 3\n"
////                + "2. Roti telur - RM 4\n"
////                + "3. Cheese naan - RM 6\n"
////                + "4. Banana Leaf Rice - RM15\n"
////                + "Your choice: ");
////            while (!s.hasNextInt()) {
////                System.out.println("\n**Invalid option, please try again!**");
////                System.out.println("\nIndian Food Menu\n "
////                + "Please choose your food.\n"
////                + "------------------------\n"
////                + "1. Tose - RM 3\n"
////                + "2. Roti telur - RM 4\n"
////                + "3. Cheese naan - RM 6\n"
////                + "4. Banana Leaf Rice - RM15\n"
////                + "Your choice:  ");
////                s.next();
////            }
////            foodId = s.nextInt();
////        } while (foodId <= 0);
////
////        do {
////            System.out.println("\nEnter food quantity: ");
////            while (!s.hasNextInt()) {
////                System.out.println("\n**Invalid option, please try again!**");
////                System.out.println("\nEnter food quantity: ");
////                s.next();
////            }
////            qty = s.nextInt();
////        } while (qty <= 0);
////        //OrderDetails newOrder = new OrderDetails(foodId, qty);
////        //OrderFoodList.addNewOrder();\
////        orderDetails = new OrderDetails(foodId, qty);
////        if (FastDelivery.orderDetail.add(orderDetails)) {
////            System.out.printf("\n");
////            System.out.println("\nNew food added!\n");
//////        System.out.println("Order List");
//////        System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Food Name", "Quantity", "Price");
//////        System.out.println("-----------------------------------------------------------------");
////        //System.out.println(OrderDetails);
////        System.out.println("Back to Menu?\n"
////                + "1. Yes\n"
////                + "2. No\n");
////        int yesno = s.nextInt();
////        if (yesno == 1) {
////            indianMenu();
////        } else {
////            System.exit(0);
////        }
////        }
//
//    private void malayMenu() {
//        Scanner s = new Scanner(System.in);
//        int foodId = 0;
//        int qty;
//        do {
//            System.out.println("|------------------------------------------------|");
//            System.out.println("| Maju maju Menu                                 |");
//            System.out.println("|------------------------------------------------|");
//            System.out.println("|9. Nasi Lemak                  | RM 5.00        |");
//            System.out.println("|10. Asam Laksa                 | RM 8.00        |");
//            System.out.println("|11. Ayam Penyet                | RM 15.00       |");
//            System.out.println("|12. Murtabak                   | RM 4.00        |");
//            System.out.println("|------------------------------------------------|");
//            System.out.println("");
//            System.out.println("Please choose your food.\n"
//                    + "Your choice: ");
//
//            while (!s.hasNextInt()) { //hasNextInt() check int
//                System.out.println("\nInvalid option, please try again!");
//                System.out.println("\nPlease choose 1-4!");
//                System.out.println("|------------------------------------------------|");
//                System.out.println("| Maju maju Menu                                 |");
//                System.out.println("|------------------------------------------------|");
//                System.out.println("|9. Nasi Lemak                  | RM 5.00        |");
//                System.out.println("|10. Asam Laksa                 | RM 8.00        |");
//                System.out.println("|11. Ayam Penyet                | RM 15.00       |");
//                System.out.println("|12. Murtabak                   | RM 4.00        |");
//                System.out.println("|------------------------------------------------|");
//                System.out.println("");
//                System.out.println("Please choose your food.\n" + "Your choice: ");
//                s.next();
//            }
//            foodId = s.nextInt();
//            foodPrice(foodId);
//        } while (foodId <= 0);
//
//        do {
//            System.out.println("\nEnter food quantity: ");
//            while (!s.hasNextInt()) {
//                System.out.println("\nInvalid option, please try again!");
//                System.out.println("\nPlease choose 9-12!");
//                System.out.println("\nEnter food quantity: ");
//                s.next();
//
//            }
//            qty = s.nextInt();
//
//            subTotal(qty, foodPrice);
//        } while (qty <= 0);
//        OrderDetails newOrder = new OrderDetails(foodId, qty);
//        orderFoodList.addNewOrder(newOrder);
//        orderDetails = new OrderDetails(foodId, qty);
////        if (FastDelivery.orderDetail.add(orderDetails)) {
//        System.out.printf("\n");
//        System.out.println("\nNew food added!\n");
//        System.out.println("---------------------------------------------");
//        System.out.println("             Order Details List");
//        System.out.println("----------------------------------------------");
//        System.out.printf("%-10s %-20s %-20s \n", "No.", "Food Name", "Quantity");
//        System.out.println("----------------------------------------------");
//        System.out.println(orderFoodList);
//        System.out.println("Order more food?\n"
//                + "1. Yes\n"
//                + "2. No\n");
//        int yesno = s.nextInt();
//        if (yesno == 1) {
//            malayMenu();
//        } else {
//            if (type.equals("ad-hoc")) {
//                done();
//            } else {
//                makeSchedule();
//            }
//        }
//    }
//
//    public double foodPrice(int foodId) {
//        if (foodId == 1) {
//            //Char Kuey Teow = RM5.00
//            System.out.println("Ordered - Char Kuey Teow");
//            foodPrice = 5.00;
//        }
//        if (foodId == 2) {
//            //Chicken Rice = RM8.00
//            System.out.println("Ordered - Chicken Rice");
//            foodPrice = 8.00;
//        }
//        if (foodId == 3) {
//            //Fish head noodles = RM15.00
//            System.out.println("Ordered - Fish head noodles");
//            foodPrice = 15.00;
//        }
//        if (foodId == 4) {
//            //Fried Rice = RM4.50
//            System.out.println("Ordered - Fried Rice");
//            foodPrice = 4.50;
//        }
//        if (foodId == 5) {
//            //Tose = RM3.00
//            System.out.println("Ordered - Tose");
//            foodPrice = 3.00;
//        }
//        if (foodId == 6) {
//            //Roti Telur = RM4.00
//            System.out.println("Ordered - Roti Telur");
//            foodPrice = 4.00;
//        }
//        if (foodId == 7) {
//            //Cheese naan = RM6.00
//            System.out.println("Ordered - Cheese naan");
//            foodPrice = 6.00;
//        }
//        if (foodId == 8) {
//            //Banana Leaf Rice = RM15.00
//            System.out.println("Ordered - Banana Leaf Rice");
//            foodPrice = 15.00;
//        }
//        if (foodId == 9) {
//            //Nasi Lemak = RM5.00
//            System.out.println("Ordered - Nasi Lemak");
//            foodPrice = 5.00;
//        }
//        if (foodId == 10) {
//            //Asam Laksa = RM8.00
//            System.out.println("Ordered - Asam Laksa");
//            foodPrice = 8.00;
//        }
//        if (foodId == 11) {
//            //Ayam Penyet = RM15.00
//            System.out.println("Ordered - Ayam Penyet");
//            foodPrice = 15.00;
//        }
//        if (foodId == 12) {
//            //Murtabak = RM4.00
//            System.out.println("Ordered - Murtabak");
//            foodPrice = 4.00;
//        }
////    quantity();
//        return foodPrice;
//    }
////public int quantity() {
////    Scanner s = new Scanner(System.in);
////    Scanner con = new Scanner(System.in);
////    System.out.println("Enter quantity :");       
////    int quantity = s.nextInt();
////    subTotal(quantity, foodPrice);
////    System.out.println("Order more food?\n"
////                + "1. Yes\n"
////                + "2. No\n"
////                + "Your choice: ");
////        int yesno = con.nextInt();
////        if (yesno == 1) {
////            chineseMenu();
////        } else {
////            done();
////        }
////        
////    return quantity;
//// }
//
//    public double subTotal(double quantity, double foodPrice) {
//
//        double subTotal = quantity * foodPrice;
//        System.out.println("Subtotal: RM" + subTotal);
//        totalPrice += subTotal;
//        return subTotal;
//    }
//    
////public void assignJob(){
////    for (DeliveryMan dm : FastDelivery.deliveryMen) {
////            if (dm.getWorkingStatus() == Constants.AVAILABLE) {
////                
////               inCharge = dm.username;
////            }else inCharge = "";
////        }
////    done();
////}
//
//    private void makeSchedule() {
//        
//        Scanner s = new Scanner(System.in);
//        System.out.println("Set the date for delivering order > ");
//        String date = s.nextLine();
//        System.out.println("Set the time for delivering order > ");
//        String time = s.nextLine();
//
//        Date currentDate = new Date();
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            scheduleDate = dateFormat.parse(date);
//
//            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//            scheduleTime = timeFormat.parse(time);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        done();
//    }
//
//    public void done() {
//        
//        ordering = false;
//        System.out.println("|-------------------------------|");
//        System.out.println("|Total price: RM" + totalPrice + "            " + "|");
//        System.out.println("|-------------------------------|");
//        System.out.println("|Thank you for your order !     |");
//        System.out.println("|-------------------------------|");
//        payment();
//    }
//
//    public void payment() {
//
//        System.out.println("\nPlease make payment to the deliveryman. We accept **CASH ONLY!**");
//        if (type.equals("ad-hoc")) {
//            Orders newOrders = new Orders(id, status, totalPrice);
//            id++;
//            orderList.addNewOrder(newOrders);
//
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println("                              Order List");
//            System.out.println("------------------------------------------------------------------------");
//            System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)");
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println(orderList);
//        } else {
//            ScheduledOrder newScheduledOrder = new ScheduledOrder(id, status, totalPrice, scheduleDate, scheduleTime, currentUser);
//            id++;
//            scheduledOrder.add(newScheduledOrder);
//
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("                                                 Order List");
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)", "Customer Name", "Customer Contact", "Deliver Date", "Deliver Time");
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
////            for (int i = 0; i < scheduledOrder.size(); i++) {
////                if (new Date().compareTo(scheduledOrder.show(i).getScheduleDate()) > 0) {
////                    System.out.println(scheduledOrder.show(i).toString());
//            System.out.println(scheduledOrder);
////                }
////            }
//        }
//    }
//
//}

