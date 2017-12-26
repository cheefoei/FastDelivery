
import adt.FoodInterface;
import adt.FoodList;
import java.util.Scanner;
import entity.Customer;
import entity.DeliveryJob;
import entity.DeliveryMan;
import entity.DeliveryOrder;
import entity.Food;
import entity.OrderDetails;
import entity.Orders;
import entity.RestaurantOwner;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CustomerScreen {

    private final Scanner scanner = new Scanner(System.in);
    private Customer currentUser;
    private Orders currentOrder;

    private final static String status = "Pending";

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

        while (FastDelivery.customerArray.hasNext()) {
            Customer cus = FastDelivery.customerArray.next();
            if (cusUsername.equals(cus.cusUsername)) {
                currentUser = cus;
            }
        }

        if (currentUser != null) {
            if (cusPassword.equals(currentUser.cusPw)) {
                customerMainMenu();
            } else {
                System.out.println(Constants.ERROR_LOG_IN);
                checkAutho();
            }
        } else {
            System.out.println(Constants.ERROR_ACC_NOT_EXIST);
            checkAutho();
        }
    }

    private void customerMainMenu() {

        System.out.printf("\nWelcome back, " + currentUser.getCusName() + "\n");

        boolean valid;
        do {
            valid = true;

            System.out.println("|--------------------------------|");
            System.out.println("|       Customer Main Menu       |");
            System.out.println("|--------------------------------|");
            System.out.println("|                                |");
            System.out.println("|1. Place Order                  |");
            System.out.println("|2. Display Order                |");
            System.out.println("|3. Current Month Order Report   |");
            System.out.println("|0. GO BACK                      |");
            System.out.println("|                                |");
            System.out.println("|--------------------------------|");
            System.out.print("Your choice: ");

            int input = -1;
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                valid = false;
            }

            switch (input) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    displayOrder();
                    break;
                case 3:
                    report();
                    break;
                case 0:
                    FastDelivery.clearScreen();
                    return;
                default:
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    valid = false;
                    break;
            }
        } while (!valid);
    }

    private void customerMenu() {

        boolean valid;
        do {
            valid = true;

            System.out.println("|--------------------------------|");
            System.out.println("| Please choose a restaurant.    |");
            System.out.println("|--------------------------------|");

            if (FastDelivery.restaurantOwnerList.isEmpty()) {
                System.out.println("No restaurant available!");
            } else {

                int n = FastDelivery.restaurantOwnerList.getLength();
                int y = 1;
                while (y <= n) {
                    RestaurantOwner ro = FastDelivery.restaurantOwnerList.getRestOwner(y - 1);
                    String restaurantName = ro.getRestaurantName();
                    System.out.print(y + ". ");
                    System.out.println(String.format("%-18s ", restaurantName));
                    y++;
                }

                System.out.println("");
                System.out.print("Your choice: ");

                try {
                    int option = Integer.parseInt(scanner.nextLine());
                    if (option > 0 && option <= n) {
                        displayFoodMenu(option);
                    } else {
                        System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                        valid = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    valid = false;
                }
            }
        } while (!valid);
    }

    private void displayFoodMenu(int restOption) {

        System.out.printf("\nMenu\n");
        System.out.println("=======");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "No.", "Food Name", "Food Description", "Food Price");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "---", "---------", "----------------", "----------");

        RestaurantOwner ro = FastDelivery.restaurantOwnerList.getRestOwner(restOption - 1);
        FoodInterface<Food> currFoodList = new FoodList<>();

        int count = 1;
        while (FastDelivery.foodList.moveToNext()) {

            Food food = FastDelivery.foodList.getCurrentFood();

            if (food.getRestaurant() == ro) {
                System.out.printf("%-5s %-30s %-50s %-10s\n",
                        count + ".",
                        food.getFoodName(),
                        food.getFoodDesc(),
                        "RM " + food.getFoodPrice());
                currFoodList.addFood(food);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No food yet.");
        } else {
            System.out.println("Please select your food.");
            System.out.print("Food >");

            int option = Integer.parseInt(scanner.nextLine());

            if (option > 0 && option < count) {

                System.out.println("Please enter your quantity.");
                System.out.print("Quantity >");
                int qty = Integer.parseInt(scanner.nextLine());

                System.out.println("Please enter any remark.");
                System.out.print("Remark >");
                String remark = scanner.nextLine();

                Food selectedFood = currFoodList.getFood(option - 1);
                double totalPrice = selectedFood.getFoodPrice() * qty;

                if (currentOrder == null) {
                    currentOrder = new Orders(status, totalPrice, new Date(), currentUser);
                }

                OrderDetails od = new OrderDetails(currentOrder, selectedFood, qty, remark);
                FastDelivery.orderFoodList.addNewOrder(od);

                System.out.println("\nOrder more food?[Yes/No]");
                System.out.print("Continue? >");
                String cont = scanner.nextLine().toLowerCase();
                if (cont.equals("yes") || cont.equals("y")) {
                    displayFoodMenu(restOption);
                } else {
                    if (FastDelivery.orderList.addNewOrder(currentOrder)) {

                        int max = FastDelivery.deliveryMen.size();
                        int rand = new Random().nextInt((max - 0) + 1) + 0;
                        DeliveryMan dm = FastDelivery.deliveryMen.get(rand);
                        Date curr = new Date();

                        DeliveryJob dj = new DeliveryJob();
                        dj.increTotalDelivery();
                        DeliveryOrder dor = new DeliveryOrder(dj, currentOrder);
                        dj.setTotalDistance(dor.getDistance());
                        dj.setDeliveryStartTime(curr);
                        dj.setDeliveryEndTime(curr);
                        dor.setDeliveryJob(dj);

                        if (FastDelivery.deliverJobs.add(dj)) {
                            if (FastDelivery.deliverOrders.add(dor)) {
                                displayOrder();
                            }
                        }
                    }
                }
            }
        }
    }

    private void displayOrder() {

        if (currentOrder == null) {
            while (FastDelivery.deliverOrders.hasNext()) {
                DeliveryOrder dor = FastDelivery.deliverOrders.next();
                Orders o = dor.getOrder();
                if (o.getCustomer() == currentUser && o.getStatus().equals("Pending")) {
                    System.out.println(o);
                    currentOrder = o;
                }
            }
        }

        System.out.printf("%-5s %-30s %-15s %-10s %-15s %-50s\n",
                "No.", "Food Name", "Unit Price", "Quantity", "Total Price", "Remark");
        System.out.printf("%-5s %-30s %-15s %-10s %-15s %-50s\n",
                "---", "---------", "----------", "--------", "-----------", "-------");

        if (currentOrder != null) {

            int count = 1;
            double totalPay = 0;

            while (FastDelivery.orderFoodList.goToNext()) {

                OrderDetails od = FastDelivery.orderFoodList.getCurrentOrderDetail();

                if (od.getOrder() == currentOrder) {

                    Food food = od.getFood();
                    double totalPrice = food.getFoodPrice() * od.getQty();
                    System.out.printf("%-5s %-30s %-15s %-10s %-15s %-50s\n",
                            count, 
                            food.getFoodName(),
                            new DecimalFormat("#0.00").format(food.getFoodPrice()),
                            od.getQty(), 
                            new DecimalFormat("#0.00").format(totalPrice), 
                            od.getRemark());
                    count++;
                    totalPay += totalPrice;
                }
            }

            System.out.println("\nTotal Payable Amount: RM" + new DecimalFormat("#0.00").format(totalPay));

            Date startDate = null;
            int distance = 0;
            while (FastDelivery.deliverOrders.hasNext()) {
                DeliveryOrder deord = FastDelivery.deliverOrders.next();
                if (deord.getOrder() == currentOrder) {
                    distance = (int) deord.getDistance();
                    startDate = deord.getDeliveryDate();
                }
            }

            long endTime = startDate.getTime() + (distance * 8 * 60 * 1000);
            long diffNow = endTime - new Date().getTime();
            long hour = diffNow / (60 * 60 * 1000) % 24;
            long minute = diffNow / (60 * 1000) % 60;
            long sec = diffNow / 1000 % 60;
            System.out.println("Remaining Time: " + hour + " :" + minute + ": " + sec);

        } else {
            System.out.println("You do not have any order yet.");
        }

        System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
        scanner.nextLine();
        customerMainMenu();
    }

    private void report() {

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH,
                calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar2.getTime();

        System.out.printf("\nCurrent Month Order Report\n");
        System.out.println("============================");
        System.out.printf("%-5s %-20s %-20s %-10s \n",
                "No.", "Order ID", "Time", "Total Price");
        System.out.printf("%-5s %-20s %-20s %-10s \n",
                "---", "--------", "----", "-----------");

        int count = 1;
        while (FastDelivery.orderList.goToNext()) {

            Orders o = FastDelivery.orderList.getCurrentOrder();
            Date oDate = o.getDoneOrderDate();

            if (o.getCustomer() == currentUser
                    && (oDate.after(startDate) && oDate.before(endDate))) {
                System.out.printf("%-5s %-20s %-20s %-10s \n",
                        count, o.getOrderId(),
                        new SimpleDateFormat("HH:mm:ss").format(oDate),
                        new DecimalFormat("#0.00").format(o.getTotalPrice()));
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No record\n");
        }

        System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
        scanner.nextLine();
        customerMainMenu();
    }
}
