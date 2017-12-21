
import adt.DeliveryManInterface;
import adt.DeliveryManList;
import entity.Contact;
import entity.DeliveryJob;
import entity.DeliveryMan;
import entity.HumanResource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HumanResourceScreen {

    private final Scanner scanner = new Scanner(System.in);
    private HumanResource currentUser;

    private int failedCount = 0;

    public HumanResourceScreen() {

        System.out.printf("\nHuman Resource Executive Login\n");
        System.out.println("==================================");

        checkAutho();
    }

    private void checkAutho() {

        // Assign to null
        currentUser = null;

        // If fail more than 3 times then exit
        if (failedCount >= 3) {
            System.out.println(Constants.MSG_FAILED_TOO_MANY);
            System.exit(0);
        }

        System.out.println(Constants.MSG_EMPTY_TO_BACK);

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        if (!username.isEmpty() && !password.isEmpty()) {

            // Check existing HR staffs
            while (FastDelivery.humanResources.hasNext()) {
                HumanResource hr = FastDelivery.humanResources.next();
                if (username.equals(hr.username)) {
                    currentUser = hr;
                }
            }

            if (currentUser != null) {
                if (password.equals(currentUser.password)) {
                    humanResourceMenu();
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
    }

    private void humanResourceMenu() {

        System.out.printf("\nWelcome back, " + currentUser.fname + " " + currentUser.lname + "\n");

        boolean valid;
        do {

            valid = true;

            System.out.println("Human Resource Menu");
            System.out.println("===================");
            System.out.println("1) View delivery men");
            System.out.println("2) Add delivery man");
            System.out.println("3) Update delivery man");
            System.out.println("4) Retrieve pending deliveries");
            System.out.println("5) Delivery men daily report");
            System.out.println("6) go back");
            System.out.print("Option >");

            int opt = -1;
            try {
                opt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                valid = false;
            }

            switch (opt) {
                case 1:
                    viewDeliveryMan();
                    break;
                case 2:
                    addDeliveryMan();
                    break;
                case 3:
                    updateDeliveryMan();
                    break;
                case 4:
                    retrievePendingDeliveries();
                    break;
                case 5:
                    deliveryManDailyReport();
                    break;
                case 6:
                    FastDelivery.clearScreen();
                    return;
                default:
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    valid = false;
                    break;
            }
        } while (!valid);
    }

    private void viewDeliveryMan() {

        System.out.printf("\nDelivery Men\n");
        System.out.println("================");
        System.out.printf("%-5s %-35s %-15s\n", "No.", "Delivery Man Name", "Working Status");
        System.out.printf("%-5s %-35s %-15s\n", "---", "-----------------", "--------------");

        int count = 1;
        while (FastDelivery.deliveryMen.hasNext()) {

            DeliveryMan dm = FastDelivery.deliveryMen.next();
            String status = "";

            if (dm.isIsLeave()) {
                status = "LEAVE";
            } else if (dm.isIsResigned()) {
                status = "RESIGNED";
            } else {
                status = "WORKING";
            }
            System.out.printf("%-5s %-35s %-15s\n", count + ") ", dm.getFullName(), status);
            count++;
        }

        System.out.println("Enter the number to view full detail.");
        System.out.println("Else will go back to menu.");
        System.out.print(">");
        String option = scanner.nextLine();

        try {

            int opt = Integer.parseInt(option);

            if (opt > 0 && opt < count) {

                DeliveryMan dm = FastDelivery.deliveryMen.get(opt - 1);
                Contact contact = dm.contact;

                System.out.printf("%-20s %-5s %-50s\n", "First name", ":", dm.fname);
                System.out.printf("%-20s %-5s %-50s\n", "Last name", ":", dm.lname);
                System.out.printf("%-20s %-5s %-50s\n", "Gender", ":", dm.gender);
                System.out.printf("%-20s %-5s %-50s\n", "NRIC", ":", dm.nric);
                System.out.printf("%-20s %-5s %-50s\n", "Home address", ":", contact.getAddress() + ","
                        + contact.getPostcode() + " " + contact.getCity() + ","
                        + contact.getState());
                System.out.printf("%-20s %-5s %-50s\n", "Email address", ":", contact.getEmail());
                System.out.printf("%-20s %-5s %-50s\n", "Phone number", ":", contact.getPhoneNumber());
                System.out.printf("%-20s %-5s %-50s\n", "Working Status", ":", dm.getWorkingStatus());

                System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
                scanner.nextLine();
                humanResourceMenu();

            } else {
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                viewDeliveryMan();
            }

        } catch (NumberFormatException ex) {
            humanResourceMenu();
        }
    }

    private void addDeliveryMan() {

        boolean v = true;
        DeliveryMan dm = new DeliveryMan();
        Contact contact = new Contact();

        System.out.println("< Adding Delivery Man >");

        System.out.println("Q: What's his/her first name ?");
        System.out.print("First name > ");
        dm.fname = scanner.nextLine();

        System.out.println("Q: What's his/her last name ?");
        System.out.print("Last name > ");
        dm.lname = scanner.nextLine();

        do {
            System.out.println("Q: What's gender (M/F) ?");
            System.out.print("Gender > ");

            String input = scanner.nextLine();
            char gender = Character.toUpperCase(input.charAt(0));

            if ((gender == 'M' || gender == 'F') && input.length() == 1) {
                dm.gender = gender;
                v = true;
            } else {
                System.out.println(Constants.ERROR_INVALID_INPUT);
                v = false;
            }
        } while (!v);

        do {
            System.out.println("Q: What's his/her NRIC (Exclude '-') ?");
            System.out.print("NRIC > ");
            dm.nric = scanner.nextLine();

            v = dm.nric.matches("\\d{12}");
            if (!v) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        } while (!v);

        System.out.println("Q: What's his/her home address ?");
        System.out.print("Home address > ");
        contact.setAddress(scanner.nextLine());

        System.out.println("Q: What's his/her home city ?");
        System.out.print("City > ");
        contact.setCity(scanner.nextLine());

        do {
            v = true;
            System.out.println("Q: What's his/her home postcode ?");
            System.out.print("Postcode > ");

            try {
                contact.setPostcode(Long.parseLong(scanner.nextLine()));
            } catch (Exception ex) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
                v = false;
            }
        } while (!v);

        System.out.println("Q: What's his/her home state ?");
        System.out.print("State > ");
        contact.setState(scanner.nextLine());

        do {
            System.out.println("Q: What's his/her email address ?");
            System.out.print("Email address > ");
            contact.setEmail(scanner.nextLine());

            v = contact.getEmail().matches("\\S+@\\S+\\.\\S+");
            if (!v) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        } while (!v);

        do {
            System.out.println("Q: What's his/her phone number (Exclude '-') ?");
            System.out.print("Phone number > ");
            contact.setPhoneNumber(scanner.nextLine());

            v = contact.getPhoneNumber().matches("\\d{10,12}");
            if (!v) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        } while (!v);

        System.out.println("Let help he/she to create an username and password:");
        System.out.print("Username > ");
        dm.username = scanner.nextLine();
        System.out.print("Password > ");
        dm.password = scanner.nextLine();
        dm.contact = contact;

        if (FastDelivery.deliveryMen.add(dm)) {

            System.out.println("New delivery man added!");
            System.out.print("Continue to add? (Yes/No) > ");
            String cont = scanner.nextLine();

            if (cont.equals("Yes") || cont.equals("YES") || cont.equals("yes")) {
                addDeliveryMan();
            } else {
                humanResourceMenu();
            }
        }
    }

    private void updateDeliveryMan() {

        System.out.printf("\nUpdate Delivery Man\n");
        System.out.println("================");
        System.out.printf("%-5s %-35s\n", "No.", "Delivery Man Name");
        System.out.printf("%-5s %-35s\n", "---", "-----------------");

        int count = 1;
        while (FastDelivery.deliveryMen.hasNext()) {
            DeliveryMan dm = FastDelivery.deliveryMen.next();
            System.out.printf("%-5s %-35s\n", count + ") ", dm.getFullName());
            count++;
        }
        System.out.println("Enter the number to select delivery man and update. .");
        System.out.println("Else will go back to menu.");
        System.out.print(">");

        try {

            int deliveryManOption = Integer.parseInt(scanner.nextLine());

            if (deliveryManOption > 0 && deliveryManOption < count) {

                DeliveryMan dm = FastDelivery.deliveryMen.get(deliveryManOption - 1);

                System.out.println("\nUpdate " + dm.getFullName() + "'s information");
                System.out.println("=====================================");
                System.out.println("1) Home aadress");
                System.out.println("2) Email address");
                System.out.println("3) Phone number");
                System.out.println("4) Set status");
                System.out.print("Option >");

                String updateOption = scanner.nextLine();
                boolean valid = true;

                if (updateOption.equals("1")) {

                    System.out.println("Q: What's his/her new home address ?");
                    System.out.print("New Home address > ");
                    dm.contact.setAddress(scanner.nextLine());

                    System.out.println("Q: What's his/her new home city ?");
                    System.out.print("New City > ");
                    dm.contact.setCity(scanner.nextLine());

                    boolean v;
                    do {
                        v = true;
                        System.out.println("Q: What's his/her new home postcode ?");
                        System.out.print("New Postcode > ");

                        try {
                            dm.contact.setPostcode(Long.parseLong(scanner.nextLine()));
                        } catch (Exception ex) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                            v = false;
                        }
                    } while (!v);

                    System.out.println("Q: What's his/her new home state ?");
                    System.out.print("New State > ");
                    dm.contact.setState(scanner.nextLine());

                    FastDelivery.deliveryMen.replace(dm, deliveryManOption - 1);
                    System.out.println("His/her home address is updated successfully.");
                    humanResourceMenu();

                } else if (updateOption.equals("2")) {

                    do {
                        System.out.println("Q: What's his/her new email address ?");
                        System.out.print("New Email address > ");
                        dm.contact.setEmail(scanner.nextLine());

                        valid = dm.contact.getEmail().matches("\\S+@\\S+\\.\\S+");
                        if (!valid) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                        }
                    } while (!valid);

                    FastDelivery.deliveryMen.replace(dm, deliveryManOption - 1);
                    System.out.println("His/her email address is updated successfully.");
                    humanResourceMenu();

                } else if (updateOption.equals("3")) {

                    do {
                        System.out.println("Q: What's his/her new phone number (Exclude '-') ?");
                        System.out.print("New Phone number > ");
                        dm.contact.setPhoneNumber(scanner.nextLine());

                        valid = dm.contact.getPhoneNumber().matches("\\d{10,12}");
                        if (!valid) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                        }
                    } while (!valid);

                    FastDelivery.deliveryMen.replace(dm, deliveryManOption - 1);
                    System.out.println("His/her phone number is updated successfully.");
                    humanResourceMenu();

                } else if (updateOption.equals("4")) {

                    setDeliveryManStatus(deliveryManOption - 1, dm);
                } else {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    updateDeliveryMan();
                }
            } else {
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                updateDeliveryMan();
            }
        } catch (NumberFormatException ex) {
            humanResourceMenu();
        }
    }

    private void setDeliveryManStatus(int index, DeliveryMan dm) {

        System.out.println("");

        if (dm.isIsLeave()) {

            System.out.println(dm.getFullName() + " is LEAVE ");
            System.out.println("Which status need to change to?");
            System.out.println("1) AVAILABLE TO WORK");
            System.out.println("2) RESIGNED");
            System.out.println("Else will go back to menu.");
            System.out.print("Option >");

            String option = scanner.nextLine();
            if (option.equals("1")) {

                dm.setIsLeave(false);
                FastDelivery.deliveryMen.replace(dm, index);
                System.out.println(dm.getFullName() + " is AVAILABLE TO WORK now.");
                humanResourceMenu();

            } else if (option.equals("2")) {

                dm.setIsLeave(false);
                dm.setIsResigned(true);

                FastDelivery.deliveryMen.replace(dm, index);
                System.out.println(dm.getFullName() + " is RESIGNED now.");
                humanResourceMenu();

            } else {
                updateDeliveryMan();
            }

        } else if (dm.isIsResigned()) {

            System.out.println(dm.getFullName() + " is RESIGNED ");
            System.out.println("Which status need to change to?");
            System.out.println("1) AVAILABLE TO WORK");
            System.out.println("Else will go back to menu.");
            System.out.print("Option >");

            String option = scanner.nextLine();
            if (option.equals("1")) {

                dm.setIsResigned(false);
                FastDelivery.deliveryMen.replace(dm, index);
                System.out.println(dm.getFullName() + " is AVAILABLE TO WORK now.");
                humanResourceMenu();

            } else {
                updateDeliveryMan();
            }
        } else {

            System.out.println(dm.getFullName() + " is WORKING ");
            System.out.println("Which status need to change to?");
            System.out.println("1) LEAVE");
            System.out.println("2) RESIGNED");
            System.out.println("Else will go back to menu.");
            System.out.print("Option >");

            String option = scanner.nextLine();
            if (option.equals("1")) {

                dm.setIsLeave(true);
                FastDelivery.deliveryMen.replace(dm, index);
                System.out.println(dm.getFullName() + " is LEAVE now.");
                humanResourceMenu();

            } else if (option.equals("2")) {

                dm.setIsResigned(true);

                FastDelivery.deliveryMen.replace(dm, index);
                System.out.println(dm.getFullName() + " is RESIGNED now.");
                humanResourceMenu();

            } else {
                updateDeliveryMan();
            }
        }
    }

    private void retrievePendingDeliveries() {

        System.out.printf("\nPending Deliveries\n");
        System.out.println("============================");
        System.out.printf("%-5s %-35s %-15s\n", "No.", "Delivery Man", "Total Pending Delivery");
        System.out.printf("%-5s %-35s %-15s\n", "---", "------------", "----------------------");

        DeliveryManInterface<DeliveryMan> pendingDeliveryMan = new DeliveryManList<>();
        int count = 1;

        while (FastDelivery.deliveryMen.hasNext()) {

            DeliveryMan dm = FastDelivery.deliveryMen.next();

            int numOfDelivery = 0;
            while (FastDelivery.deliverJobs.hasNext()) {
                DeliveryJob dj = FastDelivery.deliverJobs.next();
                if (dj.getDeliveryMan() == dm && !dj.isIsDone()) {
                    numOfDelivery++;
                }
            }

            if (numOfDelivery > 0) {
                System.out.printf("%-5s %-35s %-15s\n", count, dm.getFullName(), numOfDelivery + "\n");
                pendingDeliveryMan.add(dm);
                count++;
            }
        }

        if (pendingDeliveryMan.isEmpty()) {
            System.out.println("No record.");
        } else {

            System.out.println("Select a delivery man to see delivery details.");
            System.out.println("Else will go back to menu.");
            System.out.print(">");

            try {

                int deliveryManOption = Integer.parseInt(scanner.nextLine());
                if (deliveryManOption > 0 && deliveryManOption <= pendingDeliveryMan.size()) {

                    DeliveryMan dm = pendingDeliveryMan.get(deliveryManOption - 1);

                    System.out.println("\n" + dm.getFullName() + "'s Pending Deliveries");
                    System.out.println("==================================");
                    System.out.printf("%-5s %-20s %-35s %-15s\n", "No.", "Order ID", "Customer Name", "Time");
                    System.out.printf("%-5s %-20s %-35s %-15s\n", "---", "--------", "-------------", "----");

                    int numOfDelivery = 1;
                    while (FastDelivery.deliverJobs.hasNext()) {
                        DeliveryJob dj = FastDelivery.deliverJobs.next();
                        if (dj.getDeliveryMan() == dm && !dj.isIsDone()) {
                            System.out.printf("%-5s %-20s %-35s %-15s\n",
                                    numOfDelivery, dj.getOrder().getOrderId(),
                                    dj.getOrder().getCustomer().getCusName(),
                                    new SimpleDateFormat("HH:mm:ss").format(dj.getOrder().getDoneOrderDate()));
                            numOfDelivery++;
                        }
                    }
                    System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
                    scanner.nextLine();
                    humanResourceMenu();

                } else {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    retrievePendingDeliveries();
                }
            } catch (NumberFormatException ex) {
                humanResourceMenu();
            }
        }
    }

    private void deliveryManDailyReport() {

        System.out.printf("\nDelivery Man Daily Report\n");
        System.out.println("============================");
        System.out.println("1) Today");
        System.out.println("2) Yesterday");
        System.out.println("3) Select a date");
        System.out.print("Option >");
        String option = scanner.nextLine();

        if (!option.equals("1") && !option.equals("2") && !option.equals("3")) {

            System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
            deliveryManDailyReport();
        } else {

            Calendar calendar = Calendar.getInstance();
            Calendar selectedCal = Calendar.getInstance();

            if (option.equals("1")) {
                selectedCal.setTime(new Date());
            } else if (option.equals("2")) {
                selectedCal.add(Calendar.DATE, -1);
            } else if (option.equals("3")) {

                int year = 0;
                int month = 0;
                int day = 0;
                boolean v;

                do {
                    v = true;
                    System.out.print("Year   > ");
                    String y = scanner.nextLine();

                    if (y.matches("\\d{4}")) {
                        try {
                            year = Integer.parseInt(y);
                        } catch (Exception ex) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                            v = false;
                        }
                    } else {
                        System.out.println(Constants.ERROR_INVALID_INPUT);
                        v = false;
                    }
                } while (!v);

                do {
                    v = true;
                    System.out.print("Month  > ");
                    try {
                        month = Integer.parseInt(scanner.nextLine()) - 1;
                        if (month < 0 || month > 11) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                            v = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(Constants.ERROR_INVALID_INPUT);
                        v = false;
                    }
                } while (!v);

                Calendar cal = new GregorianCalendar(year, month, day);
                int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                do {
                    v = true;
                    System.out.print("Day    > ");
                    try {
                        day = Integer.parseInt(scanner.nextLine());
                        if (day < 1 || day > daysInMonth) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                            v = false;
                        }
                    } catch (Exception ex) {
                        System.out.println(Constants.ERROR_INVALID_INPUT);
                        v = false;
                    }
                } while (!v);

                selectedCal.set(Calendar.YEAR, year);
                selectedCal.set(Calendar.MONTH, month);
                selectedCal.set(Calendar.DATE, day);
            }

            System.out.printf("\nDate        : "
                    + new SimpleDateFormat("dd-MMM-yyyy").format(selectedCal.getTime())
                    + "\n");
            System.out.printf("%-5s %-20s %-20s %-20s\n",
                    "No.", "Delivery Man", "Total Deliveries", "Total Distances(km)");
            System.out.printf("%-5s %-20s %-20s %-20s\n",
                    "---", "------------", "----------------", "-------------------");

            int count = 1;
            while (FastDelivery.deliveryMen.hasNext()) {

                DeliveryMan dm = FastDelivery.deliveryMen.next();
                int numberOfDelivery = 0;
                double totalDistances = 0;

                while (FastDelivery.deliverJobs.hasNext()) {

                    DeliveryJob dj = FastDelivery.deliverJobs.next();

                    if (dj.getDeliveryMan() == dm) {

                        calendar.setTime(dj.getDeliveryDate());
                        boolean isSameDay = selectedCal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
                                && selectedCal.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR);

                        if (isSameDay) {
                            numberOfDelivery++;
                            totalDistances += dj.getDistance();
                        }
                    }
                }

                System.out.printf("%-5s %-20s %-20s %-20s\n",
                        count, dm.getFullName(), numberOfDelivery, totalDistances);
                count++;
            }

            System.out.println("Select a delivery man to see detail.");
            System.out.println("Else will go back to menu.");
            System.out.print(">");

            try {
                int deliveryManOption = Integer.parseInt(scanner.nextLine());

                if (deliveryManOption > 0 && deliveryManOption < count) {

                    DeliveryMan dm = FastDelivery.deliveryMen.get(deliveryManOption - 1);
                    deliveryManDetailReport(dm, selectedCal);

                    System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
                    scanner.nextLine();
                    humanResourceMenu();
                } else {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    deliveryManDailyReport();
                }
            } catch (NumberFormatException ex) {
                humanResourceMenu();
            }
        }

    }

    private void deliveryManDetailReport(DeliveryMan dm, Calendar selectedCal) {

        System.out.printf("\nDelivery Man: " + dm.getFullName() + "\n");
        System.out.printf("Date        : "
                + new SimpleDateFormat("dd-MMM-yyyy").format(selectedCal.getTime())
                + "\n");
        System.out.printf("%-5s %-20s %-20s %-20s\n", "No.", "Order ID", "Time", "Distances(km)");
        System.out.printf("%-5s %-20s %-20s %-20s\n", "---", "--------", "-----", "------------");

        Calendar calendar = Calendar.getInstance();
        int numberOfDelivery = 0;
        while (FastDelivery.deliverJobs.hasNext()) {

            DeliveryJob dj = FastDelivery.deliverJobs.next();

            if (dj.getDeliveryMan() == dm) {

                calendar.setTime(dj.getDeliveryDate());
                boolean isSameDay = selectedCal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
                        && selectedCal.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR);

                if (isSameDay) {
                    numberOfDelivery++;
                    System.out.printf("%-5s %-20s %-20s %-20s\n",
                            numberOfDelivery, dj.getOrder().getOrderId(),
                            new SimpleDateFormat("HH:mm:ss").format(dj.getDeliveryDate()),
                            dj.getDistance());
                }
            }
        }

        if (numberOfDelivery == 0) {
            System.out.println("No record\n");
        }
    }

}
