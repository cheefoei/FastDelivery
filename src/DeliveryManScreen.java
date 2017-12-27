
import entity.Contact;
import entity.DeliveryMan;
import entity.PunchedCard;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import entity.Customer;
import entity.DeliveryJob;
import entity.DeliveryOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DeliveryManScreen {

    private Scanner scanner = new Scanner(System.in);
    private DeliveryMan deliveryman;
    private Customer cus2;

    public static final DateFormat DF = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);

    public DeliveryManScreen() {

        System.out.printf("\nDelivery Man Login\n");
        System.out.println("==============");

        checkAutho();
    }

    private void checkAutho() {

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        while (FastDelivery.deliveryMen.hasNext()) {
            DeliveryMan dm = FastDelivery.deliveryMen.next();
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
            deliveryman.setWorkingStatus(Constants.AVAILABLE);
        } else {

            int last = FastDelivery.punchedCards.size() - 1;
            PunchedCard old_pc = FastDelivery.punchedCards.getPunchCard(last);

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

            if (FastDelivery.punchedCards.addPunchCard(pc)) {
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
            }
        }
        punchedCard();
    }

    private void clock_out() {

        Calendar now = Calendar.getInstance();
        Date clock_out = now.getTime();

        if (!FastDelivery.punchedCards.isEmpty()) {

            int last = FastDelivery.punchedCards.size() - 1;
            PunchedCard pc = FastDelivery.punchedCards.getPunchCard(last);
            Date today = new Date();
            Date date = pc.getClock_in();
            deliveryman.setWorkingStatus(Constants.NOT_AVAILABLE);

            if (isSameDay(today, date)) {

                if (pc.getClock_out() == null) {

                    pc.setPunched_status(Constants.OFF_DUTY);
                    pc.setClock_out(clock_out);

                    if (FastDelivery.punchedCards.updatePunchCard(last, pc)) {

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
        System.out.printf("%-5s %-20s %-30s %-20s %-50s\n",
                "No.", "Order ID", "Customer Name", "Customer Phone Number", "Deliver To");
        System.out.printf("%-5s %-20s %-30s %-20s %-50s\n",
                "---", "--------", "-------------", "---------------------", "----------");

        DeliveryJob selDJ = null;
        for (int i = 0; i < FastDelivery.deliverJobs.size(); i++) {
            DeliveryJob dj = FastDelivery.deliverJobs.get(i);
            if (dj.getDeliveryMan() == deliveryman && !dj.isIsDelivered()) {
                selDJ = dj;

            }
        }

        for (int i = 0; i < FastDelivery.deliverOrders.size(); i++) {

            DeliveryOrder dor = FastDelivery.deliverOrders.get(i);
            if (dor.getDeliveryJob() == selDJ && !dor.isIsDone()) {

                Customer cust = dor.getOrder().getCustomer();
                Contact contact = cust.getContact();

                System.out.printf("%-5s %-20s %-30s %-20s %-50s\n",
                        i + 1, dor.getOrder().getOrderId(),
                        cust.getCusName(), contact.getPhoneNumber(),
                        contact.getAddress() + ","
                        + contact.getPostcode() + " " + contact.getCity() + ","
                        + contact.getState());
            }
        }

    }

    private void viewCusDetails() {

        System.out.println("\n  View customer's details");
        System.out.println("=============================");

        boolean v = true;
        String phone = scanner.nextLine();
        do {
            System.out.println("Q: What's his/her phone number (Exclude '-') ?");
            System.out.print("Phone number > ");
            phone = scanner.nextLine();

            v = phone.matches("\\d{10,12}");
            if (!v) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        } while (!v);

        System.out.print("Enter customer's phone number >\n");

//            Contact cont = FastDelivery.customerArray.get(i);
        for (int i = 0; i < FastDelivery.deliverOrders.size(); i++) {
            if (FastDelivery.deliverOrders.get(i).getOrder().getStatus().equals("Done")) {
                if (phone.equals(FastDelivery.deliverOrders.get(i).getOrder().
                        getCustomer().getContact().getPhoneNumber())) {

                    System.out.printf("Customer name \t\t: " + FastDelivery.deliverOrders.get(i).getOrder().getCustomer().getCusName() + "\n");
                    System.out.printf("Home address \t\t: " + FastDelivery.deliverOrders.get(i).getOrder().getCustomer().getContact().getAddress() + ","
                            + FastDelivery.deliverOrders.get(i).getOrder().getCustomer().getContact().getPostcode() + " " + FastDelivery.deliverOrders.get(i).getOrder().getCustomer().getContact().getCity() + ","
                            + FastDelivery.deliverOrders.get(i).getOrder().getCustomer().getContact().getState() + "\n");
                    System.out.printf("Email address \t\t: " + FastDelivery.deliverOrders.get(i).getOrder().getCustomer().getContact().getEmail() + "\n");
                    deliveryManMenu();

                }
            }
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
}
