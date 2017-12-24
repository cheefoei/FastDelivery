


import adt.BasicList;
import adt.BasicListInterface;
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
import entity.ScheduledOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerScreen {

    private Scanner scanner = new Scanner(System.in);

    //public static OrderFoodInterface<OrderDetails> orderFoodList = new OrderFoodList<>();
    public static OrderInterface<Orders> orderList = new OrderList<>();
    public static RestaurantOwnerInterface<RestaurantOwner> restaurantList = new RestaurantOwnerList<>();
    //#
    public static ScheduledOrderInterface<ScheduledOrder> scheduledOrder = new ScheduledOrderList<>();
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

    public CustomerScreen() {

        System.out.printf("\nCustomer Login\n");
        System.out.println("==============");

        checkAutho();

        //OrderDetails orderdetails1 = new OrderDetails(1, 10);

        //orderFoodList.addNewOrder(orderdetails1);
       // Orders order1 = new Orders(id, status, totalPrice);
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
        ScheduledOrder sOrder1 = new ScheduledOrder(id, status, totalPrice, scheduleDate, scheduleTime, currentUser);
        //#
        //id++;
        //orderList.addNewOrder(order1);
        //#
        scheduledOrder.add(sOrder1);
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
