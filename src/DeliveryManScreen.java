


import adt.OrderInterface;
import adt.OrderList;
import adt.ScheduledOrderInterface;
import adt.ScheduledOrderList;
import entity.DeliveryMan;
import entity.PunchedCard;
import entity.ScheduledOrder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import entity.Customer;
import entity.Orders;
import java.util.ArrayList;
import java.util.List;

public class DeliveryManScreen {

    public static ScheduledOrderInterface<ScheduledOrder> scheduledOrder = new ScheduledOrderList<>();
     public static OrderInterface<Orders> orderList = new OrderList<>(); 
    public static List<Customer> customerArray = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);
    private DeliveryMan deliveryman;
    private String type;
    private Customer cus2;
    private ScheduledOrder newSOrder;

    public DeliveryManScreen() {

        System.out.printf("\nDelivery Man Login\n");
        System.out.println("==============");

        Customer cus1 = new Customer(
                "Allan",
                "950103-14-7777",
                "Male",
                "No 8, Jalan Timur 8/3,56743 Serdang,Selangor",
                "0101234567",
                "allan0103@gmail.com",
                "allan",
                "allan0103"
        );
        
        cus2 = new Customer(
                        "Anna",
                        "801108-08-2424",
                        "Female",
                        "16, Taman Gajah, Jalan Gajah, Cheras, 52000 Kuala Lumpur",
                        "01123456789",
                        "anna1234@gmail.com",
                        "anna1234",
                        "anna5678"
                );

//        Calendar cal = new GregorianCalendar();
//
//        cal.set(Calendar.DAY_OF_MONTH, 2);
//        cal.set(Calendar.MONTH, 11);
//        cal.set(Calendar.YEAR, 2017);
//        cal.set(Calendar.HOUR, 1);
//        cal.set(Calendar.MINUTE, 30);
//        cal.set(Calendar.AM_PM, Calendar.PM);
//
//        ScheduledOrder sOrder1 = new ScheduledOrder(0001, "Pending", 30.00, cal.getTime(), cal.getTime(), cus1);
//        scheduledOrder.add(sOrder1);
        checkAutho();
    }

    private void checkAutho() {

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        for (DeliveryMan dm : FastDelivery.deliveryMen) {
            if (username.equals(dm.username)) {
                deliveryman = dm;
            }
        }

        if (deliveryman != null) {
            if (password.equals(deliveryman.password)) {
                punchedCard();
            } else {
                System.out.println(Constants.ERROR_LOG_IN);
                checkAutho();
            }
        } else {
            System.out.println(Constants.ERROR_ACC_NOT_EXIST);
            checkAutho();
        }
    }

    private void punchedCard() {

        // print option menu
        System.out.print("Do you want to Clock In/Clock Out?:" + "\n"
                + "1:Clock In" + "\n"
                + "2:Clock Out" + "\n"
                + "3:Not now" + "\n");
        System.out.print("Option >");

        int input = -1;
        try {
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    clock_in();
                    break;
                case 2:
                    clock_out();
                    break;
                case 3:
                    deliveryManMenu();
                    break;
                default:
                    System.out.println("Invalid option, please try again!\n");
                    punchedCard();
                    break;
            }

        } catch (Exception ex) {
            System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
        }
    }

    private void clock_in() {

        Calendar now = Calendar.getInstance();
        Date clock_in = now.getTime();
        PunchedCard pc = null;

        if (FastDelivery.punchedCards.isEmpty()) {

            pc = new PunchedCard();
            pc.setClock_in(clock_in);
            pc.setPunched_status(Constants.ON_DUTY);
        } else {

            int last = FastDelivery.punchedCards.size() - 1;
            PunchedCard old_pc = FastDelivery.punchedCards.get(last);

            Date today = new Date();
            Date date = old_pc.getClock_in();

            if (isSameDay(today, date)) {
                System.out.println("Today you already clock in on " + date + ". \n");
            } else {

                pc = new PunchedCard();
                pc.setClock_in(clock_in);
                pc.setPunched_status(Constants.ON_DUTY);
            }
        }

        if (pc != null) {
            if (FastDelivery.punchedCards.add(pc)) {
                System.out.println("Clock In Successful!\n"
                        + "Date & Time:   " + clock_in + "\n"
                        + "Employee Name: " + deliveryman.username + "\n");

                

                Calendar cal = new GregorianCalendar();

                cal.set(Calendar.DAY_OF_MONTH, 13);
                cal.set(Calendar.MONTH, 11);
                cal.set(Calendar.YEAR, 2017);
                cal.set(Calendar.HOUR, 1);
                cal.set(Calendar.MINUTE, 30);
                cal.set(Calendar.AM_PM, Calendar.PM);

                newSOrder = new ScheduledOrder(0123, "Pending", 60.00, cal.getTime(), cal.getTime(), cus2);
                scheduledOrder.add(newSOrder);
                System.out.println("\nNew scheduled Order has been assigned\n");
                System.out.println("Scheduled Order");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("ID: " + String.format("%04d", newSOrder.getOrderId()));
                System.out.println("Status: " + newSOrder.getStatus());
                System.out.println("Address: " + newSOrder.getCustomer().getCusAddress());
                Date scheduleDate = newSOrder.getScheduleDate();
                Date currentDate = new Date();
                if (scheduleDate.after(currentDate)) {
                    long diffTime = scheduleDate.getTime() - currentDate.getTime();

                    System.out.println("Estimated Time: " + getEstimatedTime(diffTime) + "\n");
                }
            }
        }
        punchedCard();
    }

    private void clock_out() {

        Calendar now = Calendar.getInstance();
        Date clock_out = now.getTime();

        if (!FastDelivery.punchedCards.isEmpty()) {

            int last = FastDelivery.punchedCards.size() - 1;
            PunchedCard pc = FastDelivery.punchedCards.get(last);

            Date today = new Date();
            Date date = pc.getClock_in();

            if (isSameDay(today, date)) {

                if (pc.getClock_out() == null) {

                    pc.setPunched_status(Constants.OFF_DUTY);
                    pc.setClock_out(clock_out);

                    if (FastDelivery.punchedCards.set(last, pc) != null) {

                        System.out.println("Clock Out Successful!\n"
                                + "Date & Time:   " + clock_out + "\n"
                                + "Employee Name: " + deliveryman.username + "\n");
                    }
                } else {
                    System.out.println("Today you already clock out on " + pc.getClock_out() + ".\n");
                }
            } else {
                System.out.println("Your punch card must be clock in first.\n");
            }
        } else {
            System.out.println("Your punch card must be clock in first.\n");
        }

        punchedCard();
    }

    private boolean isSameDay(Date date1, Date date2) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    private void deliveryManMenu() {

        System.out.printf("\nWelcome back, " + deliveryman.username + "\n");

        boolean valid;
        do {

            valid = true;

            System.out.println("Deliveryman Menu");
            System.out.println("===================");
            System.out.println("1) View order assigned");
            System.out.println("2) Break/End Break");
            System.out.println("3) View customer's details");//Fastest Deliveryman would also like to retrieve a customer’s details based on his phone number.
            System.out.println("4) go back");
            System.out.print("Option >");

            int opt = -1;
            try {
                opt = scanner.nextInt();
            } catch (Exception ex) {
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                valid = false;
            }

            switch (opt) {
                case 1:
                    viewJob();
                    break;
                case 2:
                    breakTime();
                    break;
                case 3:
                    viewCusDetails();
                    break;
                case 4:
                    break;
                default:
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    valid = false;
                    break;
            }
        } while (!valid);
    }

    private void viewJob() {
        System.out.println("Job Assigned");
        System.out.println("===================");
        System.out.println("1) Place Order (ad-hoc)");
        System.out.println("2) Schedule Order");
        System.out.println("3) go back");
        System.out.print("Option >");

        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                type = "ad-hoc";
                displayOrder();
                break;
            case 2:
                type = "schedule";
                displayOrder();
                break;
            case 3:
                return;
            default:
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                break;
        }
    }

    private void viewCusDetails() {

        System.out.println("\n  View customer's details");
        System.out.println("=============================");
        System.out.print("Enter customer's phone number >");
        String cusContactNo = scanner.nextLine();

        for (Customer cus : FastDelivery.customerArray) {
            if (cusContactNo.equals(cus.getCusContactNo())) {

                System.out.printf("Customer name \t\t: " + cus.getCusName() + "\n");
                System.out.printf("Last name \t\t: " + cus.getCusIc() + "\n");;
                System.out.printf("Gender \t\t\t: " + cus.getCusGender() + "\n");
                System.out.printf("NRIC \t\t\t: " + cus.getCusAddress() + "\n");
                System.out.printf("Home address \t\t: " + cus.getCusContactNo() + "\n");
                System.out.printf("Email address \t\t: " + cus.getCusEmail() + "\n");

            } else {
                clearScreen();
                viewCusDetails();
            }
        }
    }

    private static void clearScreen() {
        for (int clear = 0; clear < 40; clear++) {
            System.out.println("\b");
        }
    }

    private void breakTime() {
        Calendar now = Calendar.getInstance();
        if (deliveryman.getWorkingStatus() != Constants.BREAKTIME) {
            deliveryman.setWorkingStatus(Constants.BREAKTIME);
            System.out.println("You are now break at " + now.getTime());
            deliveryManMenu();

        } else {
            deliveryman.setWorkingStatus(Constants.AVAILABLE);
            System.out.println("You had end your break at " + now.getTime());
            deliveryManMenu();
        }
    }

    private void displayOrder() {
        if (type.equals("ad-hoc")) {
            Orders newOrders = new Orders(0001, "Pending", 5.00);
            
            orderList.addNewOrder(newOrders);

            System.out.println("------------------------------------------------------------------------");
            System.out.println("                              Order List");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)");
            System.out.println("------------------------------------------------------------------------");
            System.out.println(orderList);
        } else {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                                 Order List");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "No.", "Order ID", "Status", "Total Price(RM)", "Customer Name", "Customer Contact", "Deliver Date", "Deliver Time");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            for (int i = 0; i < scheduledOrder.size(); i++) {
//                if (new Date().compareTo(scheduledOrder.show(i).getScheduleDate()) > 0) {
//                    System.out.println(scheduledOrder.show(i).toString());
            System.out.println(scheduledOrder);
//                }
//            }
        }
    }

    private String getEstimatedTime(long diffTime) {
        if (diffTime < Constants.MINUTE_MILLIS) {
            int seconds = (int) diffTime / 1000 % 60;
            return seconds + " seconds";
        } else if (diffTime < 50 * Constants.MINUTE_MILLIS) {
            int seconds = (int) diffTime / 1000 % 60;
            int minutes = (int) (diffTime / 1000 / 60 % 60);
            return minutes + " minutes " + seconds + " seconds";
        } else if (diffTime < 24 * Constants.HOUR_MILLIS) {
            int seconds = (int) diffTime / 1000 % 60;
            int minutes = (int) (diffTime / 1000 / 60 % 60);
            int hours = (int) (diffTime / 1000 / 60 / 60 % 24);
            return hours + " hours " + minutes + " minutes " + seconds + " seconds";
        } else {
            int seconds = (int) diffTime / 1000 % 60;
            int minutes = (int) (diffTime / 1000 / 60 % 60);
            int hours = (int) (diffTime / 1000 / 60 / 60 % 24);
            int days = (int) diffTime / 1000 / 60 / 60 / 24;
            return days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds";
        }
    }
}
