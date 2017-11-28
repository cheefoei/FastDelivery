
import entity.DeliveryMan;
import entity.HumanResource;
import java.util.Scanner;

public class HumanResourceScreen {

    private Scanner scanner = new Scanner(System.in);
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
            for (HumanResource hr : FastDelivery.humanResources) {
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
            System.out.println("4) Assign delivery man");
            System.out.println("5) Report");
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
                    break;
                case 5:
                    break;
                case 6:
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

        int count = 1;
        for (DeliveryMan dm : FastDelivery.deliveryMen) {

            String status = "";
            if (dm.isIsLeave()) {
                status = "LEAVE";
            } else if (dm.isIsResigned()) {
                status = "RESIGNED";
            } else {
                status = "WORKING";
            }
            System.out.printf(count + ") " + dm.fname + " " + dm.lname + " (" + status + ")\n");
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

                System.out.printf("First name \t\t: " + dm.fname + "\n");
                System.out.printf("Last name \t\t: " + dm.lname + "\n");;
                System.out.printf("Gender \t\t\t: " + dm.gender + "\n");
                System.out.printf("NRIC \t\t\t: " + dm.nric + "\n");
                System.out.printf("Home address \t\t: " + dm.address + "\n");
                System.out.printf("Email address \t\t: " + dm.email + "\n");
                System.out.printf("Phone number \t\t: " + dm.phoneNumber + "\n");
                System.out.printf("Current Working Status \t: " + dm.getWorkingStatus() + "\n");

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
        dm.address = scanner.nextLine();

        do {
            System.out.println("Q: What's his/her email address ?");
            System.out.print("Email address > ");
            dm.email = scanner.nextLine();

            v = dm.email.matches("\\S+@\\S+\\.\\S+");
            if (!v) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        } while (!v);

        do {
            System.out.println("Q: What's his/her phone number (Exclude '-') ?");
            System.out.print("Phone number > ");
            dm.phoneNumber = scanner.nextLine();

            v = dm.phoneNumber.matches("\\d{10,12}");
            if (!v) {
                System.out.println(Constants.ERROR_INVALID_INPUT);
            }
        } while (!v);

        System.out.println("Let help he/she to create an username and password:");
        System.out.print("Username > ");
        dm.username = scanner.nextLine();
        System.out.print("Password > ");
        dm.password = scanner.nextLine();

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

        int count = 1;
        for (DeliveryMan dm : FastDelivery.deliveryMen) {
            System.out.printf(count + ") " + dm.fname + " " + dm.lname + "\n");
            count++;
        }
        System.out.println("Enter the number to select delivery man and update. .");
        System.out.println("Else will go back to menu.");
        System.out.print(">");

        try {

            int deliveryManOption = Integer.parseInt(scanner.nextLine());

            if (deliveryManOption > 0 && deliveryManOption < count) {

                DeliveryMan dm = FastDelivery.deliveryMen.get(deliveryManOption - 1);

                System.out.println("\nUpdate " + dm.fname + " " + dm.lname + "'s information");
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
                    dm.address = scanner.nextLine();

                    FastDelivery.deliveryMen.set(deliveryManOption - 1, dm);
                    System.out.println("His/her home address is updated successfully.");
                    humanResourceMenu();

                } else if (updateOption.equals("2")) {

                    do {
                        System.out.println("Q: What's his/her new email address ?");
                        System.out.print("New Email address > ");
                        dm.email = scanner.nextLine();

                        valid = dm.email.matches("\\S+@\\S+\\.\\S+");
                        if (!valid) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                        }
                    } while (!valid);

                    FastDelivery.deliveryMen.set(deliveryManOption - 1, dm);
                    System.out.println("His/her email address is updated successfully.");
                    humanResourceMenu();

                } else if (updateOption.equals("3")) {

                    do {
                        System.out.println("Q: What's his/her new phone number (Exclude '-') ?");
                        System.out.print("New Phone number > ");
                        dm.phoneNumber = scanner.nextLine();

                        valid = dm.phoneNumber.matches("\\d{10,12}");
                        if (!valid) {
                            System.out.println(Constants.ERROR_INVALID_INPUT);
                        }
                    } while (!valid);

                    FastDelivery.deliveryMen.set(deliveryManOption - 1, dm);
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

            System.out.println(dm.fname + " " + dm.lname + " is LEAVE ");
            System.out.println("Which status need to change to?");
            System.out.println("1) AVAILABLE TO WORK");
            System.out.println("2) RESIGNED");
            System.out.println("Else will go back to menu.");
            System.out.print("Option >");

            String option = scanner.nextLine();
            if (option.equals("1")) {

                dm.setIsLeave(false);
                FastDelivery.deliveryMen.set(index, dm);
                System.out.println(dm.fname + " " + dm.lname + " is AVAILABLE TO WORK now.");
                humanResourceMenu();

            } else if (option.equals("2")) {

                dm.setIsLeave(false);
                dm.setIsResigned(true);

                FastDelivery.deliveryMen.set(index, dm);
                System.out.println(dm.fname + " " + dm.lname + " is RESIGNED now.");
                humanResourceMenu();

            } else {
                updateDeliveryMan();
            }

        } else if (dm.isIsResigned()) {

            System.out.println(dm.fname + " " + dm.lname + " is RESIGNED ");
            System.out.println("Which status need to change to?");
            System.out.println("1) AVAILABLE TO WORK");
            System.out.println("Else will go back to menu.");
            System.out.print("Option >");

            String option = scanner.nextLine();
            if (option.equals("1")) {

                dm.setIsResigned(false);
                FastDelivery.deliveryMen.set(index, dm);
                System.out.println(dm.fname + " " + dm.lname + " is AVAILABLE TO WORK now.");
                humanResourceMenu();

            } else {
                updateDeliveryMan();
            }
        } else {

            System.out.println(dm.fname + " " + dm.lname + " is WORKING ");
            System.out.println("Which status need to change to?");
            System.out.println("1) LEAVE");
            System.out.println("2) RESIGNED");
            System.out.println("Else will go back to menu.");
            System.out.print("Option >");

            String option = scanner.nextLine();
            if (option.equals("1")) {

                dm.setIsLeave(true);
                FastDelivery.deliveryMen.set(index, dm);
                System.out.println(dm.fname + " " + dm.lname + " is LEAVE now.");
                humanResourceMenu();

            } else if (option.equals("2")) {

                dm.setIsResigned(true);

                FastDelivery.deliveryMen.set(index, dm);
                System.out.println(dm.fname + " " + dm.lname + " is RESIGNED now.");
                humanResourceMenu();

            } else {
                updateDeliveryMan();
            }
        }

    }
}
