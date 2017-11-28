
import adt.OrderFoodInterface;
import adt.OrderFoodList;
import adt.OrderInterface;
import adt.OrderList;
import java.util.Scanner;
import entity.Customer;
import entity.OrderDetails;
import entity.Orders;
import java.util.ArrayList;
import java.util.List;

public class CustomerScreen {

    private Scanner scanner = new Scanner(System.in);
    public static List<Customer> customerArray = new ArrayList<>();
    public static OrderFoodInterface<OrderDetails> orderFoodList = new OrderFoodList<>();
    public static OrderInterface<Orders> orderList = new OrderList<>();
    private Customer currentUser;
    private OrderDetails orderDetails;
    public static int id = 0001;
    public static String status = "Pending";

    
    public double subTotal;
    public double totalPrice;
    private double foodPrice;
    static boolean ordering = true;
    
    private int failedCount = 0;

    public CustomerScreen() {

        System.out.printf("\nCustomer Login\n");
        System.out.println("==============");

        checkAutho();
        OrderDetails orderdetails1 = new OrderDetails(1, 10);

        orderFoodList.addNewOrder(orderdetails1);
        Orders order1 = new Orders(id, status, totalPrice);
        id++;
        orderList.addNewOrder(order1);
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

        System.out.println("|--------------------------------|");
        System.out.println("| Please choose a restaurant.    |");
        System.out.println("|--------------------------------|");
        System.out.println("|1. Ho Ciak   Restaurant         |");
        System.out.println("|2. Svaadisht Restaurant         |");
        System.out.println("|3. Maju maju Restaurant         |");
        System.out.println("|4. Exit                         |");
        System.out.println("|--------------------------------|");
        System.out.println("");
        System.out.println("Your choice: ");

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
//        System.out.println("|------------------------------------------|");
//        System.out.println("| Ho Ciak Menu                             |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|1. Char Kuey Teow       | RM 5.00         |");
//        System.out.println("|2. Chicken Rice         | RM 8.00         |");
//        System.out.println("|3. Fish head noodles    | RM 15.00        |");
//        System.out.println("|4. Fried Rice           | RM 4.50         |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("");
//        System.out.println("Please choose your food.\n"
//                + "Your choice: ");
//        
//    int menuOption;
//    int  foodId= 0;
//    Scanner s = new Scanner(System.in);
//    do{
//        double runningTotal=0;
//        
//
//        menuOption = s.nextInt();
//        switch(menuOption){
//            case 1:
//                foodId = 1;
//                foodPrice(foodId);
//                break;
//            case 2:
//                foodId = 2;
//                foodPrice(foodId);
//                break;
//            case 3:
//                foodId = 3;
//                foodPrice(foodId);
//                break;
//            case 4:
//                foodId = 4;
//                foodPrice(foodId);
//                break;
//            default:
//                System.out.println("Invalid option, please try again!\n");
//                chineseMenu();
//        }
//
//    } while(ordering);
//                    OrderDetails newOrderDetails = new OrderDetails(foodId, quantity);
//        orderFoodList.addNewOrder(newOrderDetails);
//
//        System.out.println("Order List");
//        System.out.printf("%-10s %-20s %-20s\n", "No.", "Food Name", "Quantity");
//        System.out.println("----------------------------------------------------");
//        System.out.println(orderFoodList); {
//
//    }
    

 Scanner s = new Scanner(System.in);
        int foodId = 0;
        int qty;
        do {
        System.out.println("|------------------------------------------|");
        System.out.println("| Ho Ciak Menu                             |");
        System.out.println("|------------------------------------------|");
        System.out.println("|1. Char Kuey Teow       | RM 5.00         |");
        System.out.println("|2. Chicken Rice         | RM 8.00         |");
        System.out.println("|3. Fish head noodles    | RM 15.00        |");
        System.out.println("|4. Fried Rice           | RM 4.50         |");
        System.out.println("|------------------------------------------|");
        System.out.println("");
        System.out.println("Please choose your food.\n"
                + "Your choice: ");
        
            while (!s.hasNextInt()) { //hasNextInt() check int
                System.out.println("\nInvalid option, please try again!");
                System.out.println("\nPlease choose 1-4!");
                System.out.println("|------------------------------------------|");
        System.out.println("| Ho Ciak Menu                             |");
        System.out.println("|------------------------------------------|");
        System.out.println("|1. Char Kuey Teow       | RM 5.00         |");
        System.out.println("|2. Chicken Rice         | RM 8.00         |");
        System.out.println("|3. Fish head noodles    | RM 15.00        |");
        System.out.println("|4. Fried Rice           | RM 4.50         |");
        System.out.println("|------------------------------------------|");
        System.out.println("");
        System.out.println("Please choose your food.\n"+ "Your choice: ");
                s.next();
            }
            foodId = s.nextInt();
            foodPrice(foodId);
        } while (foodId <= 0);

        do {
            System.out.println("\nEnter food quantity: ");
            while (!s.hasNextInt()) {
                System.out.println("\nInvalid option, please try again!");
                System.out.println("\nPlease choose 1-4!");
                System.out.println("\nEnter food quantity: ");
                s.next();
               
                
            }
            qty = s.nextInt();
            
            subTotal(qty,foodPrice);
        } while (qty <= 0);
        OrderDetails newOrder = new OrderDetails(foodId, qty);
        orderFoodList.addNewOrder(newOrder);
        orderDetails = new OrderDetails(foodId, qty);
//        if (FastDelivery.orderDetail.add(orderDetails)) {
            System.out.printf("\n");
            System.out.println("\nNew food added!\n");
        System.out.println("---------------------------------------------");
        System.out.println("             Order Details List");
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s %-20s %-20s \n", "No.", "Food Name", "Quantity");
        System.out.println("----------------------------------------------");
        System.out.println(orderFoodList);
        System.out.println("Order more food?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            chineseMenu();
        } else {
            done();
        }
//        }
    }
    

        
    
    private void indianMenu() {
        
         Scanner s = new Scanner(System.in);
        int foodId = 0;
        int qty;
        do {
        System.out.println("|------------------------------------------------|");
        System.out.println("| Svaadisht Menu                                 |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|5. Tose                       | RM 3.00         |");
        System.out.println("|6. Roti telur                 | RM 4.00         |");
        System.out.println("|7. Cheese Naan                | RM 6.00         |");
        System.out.println("|8. Banana Leaf Rice           | RM 15.00        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("");
        System.out.println("Please choose your food.\n"
                + "Your choice: ");
        
            while (!s.hasNextInt()) { //hasNextInt() check int
                System.out.println("\nInvalid option, please try again!");
                System.out.println("\nPlease choose 1-4!");
                System.out.println("|------------------------------------------------|");
        System.out.println("| Svaadisht Menu                                 |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|5. Tose                       | RM 3.00         |");
        System.out.println("|6. Roti telur                 | RM 4.00         |");
        System.out.println("|7. Cheese Naan                | RM 6.00         |");
        System.out.println("|8. Banana Leaf Rice           | RM 15.00        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("");
        System.out.println("Please choose your food.\n"+ "Your choice: ");
                s.next();
            }
            foodId = s.nextInt();
            foodPrice(foodId);
        } while (foodId <= 0);

        do {
            System.out.println("\nEnter food quantity: ");
            while (!s.hasNextInt()) {
                System.out.println("\nInvalid option, please try again!");
                System.out.println("\nPlease choose 5-8!");
                System.out.println("\nEnter food quantity: ");
                s.next();
               
                
            }
            qty = s.nextInt();
            
            subTotal(qty,foodPrice);
        } while (qty <= 0);
        OrderDetails newOrder = new OrderDetails(foodId, qty);
        orderFoodList.addNewOrder(newOrder);
        orderDetails = new OrderDetails(foodId, qty);
//        if (FastDelivery.orderDetail.add(orderDetails)) {
            System.out.printf("\n");
            System.out.println("\nNew food added!\n");
        System.out.println("---------------------------------------------");
        System.out.println("             Order Details List");
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s %-20s %-20s \n", "No.", "Food Name", "Quantity");
        System.out.println("----------------------------------------------");
        System.out.println(orderFoodList);
        System.out.println("Order more food?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            indianMenu();
        } else {
            done();
        }
//        }
    }
//        Scanner s = new Scanner(System.in);
//
//        int foodId;
//        int qty;
//        do {
//            System.out.println(" Indian Food Menu\n "
//                + "Please choose your food.\n"
//                + "------------------------\n"
//                + "1. Tose - RM 3\n"
//                + "2. Roti telur - RM 4\n"
//                + "3. Cheese naan - RM 6\n"
//                + "4. Banana Leaf Rice - RM15\n"
//                + "Your choice: ");
//            while (!s.hasNextInt()) {
//                System.out.println("\n**Invalid option, please try again!**");
//                System.out.println("\nIndian Food Menu\n "
//                + "Please choose your food.\n"
//                + "------------------------\n"
//                + "1. Tose - RM 3\n"
//                + "2. Roti telur - RM 4\n"
//                + "3. Cheese naan - RM 6\n"
//                + "4. Banana Leaf Rice - RM15\n"
//                + "Your choice:  ");
//                s.next();
//            }
//            foodId = s.nextInt();
//        } while (foodId <= 0);
//
//        do {
//            System.out.println("\nEnter food quantity: ");
//            while (!s.hasNextInt()) {
//                System.out.println("\n**Invalid option, please try again!**");
//                System.out.println("\nEnter food quantity: ");
//                s.next();
//            }
//            qty = s.nextInt();
//        } while (qty <= 0);
//        //OrderDetails newOrder = new OrderDetails(foodId, qty);
//        //OrderFoodList.addNewOrder();\
//        orderDetails = new OrderDetails(foodId, qty);
//        if (FastDelivery.orderDetail.add(orderDetails)) {
//            System.out.printf("\n");
//            System.out.println("\nNew food added!\n");
////        System.out.println("Order List");
////        System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Food Name", "Quantity", "Price");
////        System.out.println("-----------------------------------------------------------------");
//        //System.out.println(OrderDetails);
//        System.out.println("Back to Menu?\n"
//                + "1. Yes\n"
//                + "2. No\n");
//        int yesno = s.nextInt();
//        if (yesno == 1) {
//            indianMenu();
//        } else {
//            System.exit(0);
//        }
//        }
    
    private void malayMenu() {
Scanner s = new Scanner(System.in);
        int foodId = 0;
        int qty;
        do {
        System.out.println("|------------------------------------------------|");
        System.out.println("| Maju maju Menu                                 |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|9. Nasi Lemak                  | RM 5.00        |");
        System.out.println("|10. Asam Laksa                 | RM 8.00        |");
        System.out.println("|11. Ayam Penyet                | RM 15.00       |");
        System.out.println("|12. Murtabak                   | RM 4.00        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("");
        System.out.println("Please choose your food.\n"
                + "Your choice: ");
        
            while (!s.hasNextInt()) { //hasNextInt() check int
                System.out.println("\nInvalid option, please try again!");
                System.out.println("\nPlease choose 1-4!");
                System.out.println("|------------------------------------------------|");
        System.out.println("| Maju maju Menu                                 |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|9. Nasi Lemak                  | RM 5.00        |");
        System.out.println("|10. Asam Laksa                 | RM 8.00        |");
        System.out.println("|11. Ayam Penyet                | RM 15.00       |");
        System.out.println("|12. Murtabak                   | RM 4.00        |");
        System.out.println("|------------------------------------------------|");
        System.out.println("");
        System.out.println("Please choose your food.\n"+ "Your choice: ");
                s.next();
            }
            foodId = s.nextInt();
            foodPrice(foodId);
        } while (foodId <= 0);

        do {
            System.out.println("\nEnter food quantity: ");
            while (!s.hasNextInt()) {
                System.out.println("\nInvalid option, please try again!");
                System.out.println("\nPlease choose 9-12!");
                System.out.println("\nEnter food quantity: ");
                s.next();
               
                
            }
            qty = s.nextInt();
            
            subTotal(qty,foodPrice);
        } while (qty <= 0);
        OrderDetails newOrder = new OrderDetails(foodId, qty);
        orderFoodList.addNewOrder(newOrder);
        orderDetails = new OrderDetails(foodId, qty);
//        if (FastDelivery.orderDetail.add(orderDetails)) {
            System.out.printf("\n");
            System.out.println("\nNew food added!\n");
        System.out.println("---------------------------------------------");
        System.out.println("             Order Details List");
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s %-20s %-20s \n", "No.", "Food Name", "Quantity");
        System.out.println("----------------------------------------------");
        System.out.println(orderFoodList);
        System.out.println("Order more food?\n"
                + "1. Yes\n"
                + "2. No\n");
        int yesno = s.nextInt();
        if (yesno == 1) {
            malayMenu();
        } else {
            done();
        }
    }

public double foodPrice(int foodId) {
    if (foodId == 1) {
        //Char Kuey Teow = RM5.00
        System.out.println("Ordered - Char Kuey Teow");
        foodPrice = 5.00;
    }
    if (foodId == 2) {
        //Chicken Rice = RM8.00
        System.out.println("Ordered - Chicken Rice");
        foodPrice = 8.00;
    }
    if (foodId == 3) {
        //Fish head noodles = RM15.00
        System.out.println("Ordered - Fish head noodles");
        foodPrice = 15.00;
    }
    if (foodId == 4) {
        //Fried Rice = RM4.50
        System.out.println("Ordered - Fried Rice");
        foodPrice = 4.50;
    }
    if (foodId == 5) {
        //Tose = RM3.00
        System.out.println("Ordered - Tose");
        foodPrice = 3.00;
    }
    if (foodId == 6) {
        //Roti Telur = RM4.00
        System.out.println("Ordered - Roti Telur");
        foodPrice = 4.00;
    }
    if (foodId == 7) {
        //Cheese naan = RM6.00
        System.out.println("Ordered - Cheese naan");
        foodPrice = 6.00;
    }
    if (foodId == 8) {
        //Banana Leaf Rice = RM15.00
        System.out.println("Ordered - Banana Leaf Rice");
        foodPrice = 15.00;
    }
    if (foodId == 9) {
        //Nasi Lemak = RM5.00
        System.out.println("Ordered - Nasi Lemak");
        foodPrice = 5.00;
    }
    if (foodId == 10) {
        //Asam Laksa = RM8.00
        System.out.println("Ordered - Asam Laksa");
        foodPrice = 8.00;
    }
    if (foodId == 11) {
        //Ayam Penyet = RM15.00
        System.out.println("Ordered - Ayam Penyet");
        foodPrice = 15.00;
    }
    if (foodId == 12) {
        //Murtabak = RM4.00
        System.out.println("Ordered - Murtabak");
        foodPrice = 4.00;
    }
//    quantity();
    return foodPrice;
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
public double subTotal(double quantity, double foodPrice) {
    
    double subTotal = quantity*foodPrice;
    System.out.println("Subtotal: RM"+ subTotal);
    totalPrice += subTotal;
    return subTotal;
}
//public void assignJob(){
//    for (DeliveryMan dm : FastDelivery.deliveryMen) {
//            if (dm.getWorkingStatus() == Constants.AVAILABLE) {
//                
//               inCharge = dm.username;
//            }else inCharge = "";
//        }
//    done();
//}
public void done(){
    ordering = false;   
    System.out.println("|-------------------------------|");
    System.out.println("|Total price: RM"+ totalPrice +"            "+          "|");
    System.out.println("|-------------------------------|");
    System.out.println("|Thank you for your order !     |");
    System.out.println("|-------------------------------|");
    payment();

}
public void payment(){
    System.out.println("\nPlease make payment to the deliveryman. We accept **CASH ONLY!**");
    Orders newOrders = new Orders(id, status, totalPrice);
        id++;
        orderList.addNewOrder(newOrders);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                              Order List");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(orderList);
}
}
