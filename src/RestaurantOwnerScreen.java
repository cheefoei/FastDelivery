
import adt.FoodInterface;
import adt.FoodList;
import entity.Contact;
import entity.Food;
import entity.RestaurantOwner;
import java.text.DecimalFormat;
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

        System.out.print("Restaurant City >");
        String restaurantCity = scanner.nextLine();

        System.out.print("Restaurant Postcode >");
        long restaurantPostcode = scanner.nextLong();

        System.out.print("Restaurant State >");
        String restaurantState = scanner.nextLine();

        System.out.print("Restaurant Phone Number >");
        String restaurantPhoneNumber = scanner.nextLine();

        restaurantOwner = new RestaurantOwner(
                fname, lname, nric,
                new Contact(
                        restaurantAddress,
                        restaurantCity,
                        restaurantPostcode,
                        restaurantState,
                        email,
                        restaurantPhoneNumber
                ),
                username, password, restaurantName, restaurantAddress, restaurantPhoneNumber);

        if (FastDelivery.restaurantOwnerList.addRestOwner(restaurantOwner)) {
            System.out.printf("\n");
            System.out.println(Constants.MSG_REG_SUCCESS);
            FastDelivery.clearScreen();
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

        while (FastDelivery.restaurantOwnerList.moveToNext()) {
            RestaurantOwner ro = FastDelivery.restaurantOwnerList.getCurrentRestOwner();
            if (username.equals(ro.getUsername())) {
                restaurantOwner = ro;
            }
        }

        if (restaurantOwner != null) {
            if (password.equals(restaurantOwner.getPassword())) {
                FastDelivery.clearScreen();
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

        System.out.println("\nWelcome, " + restaurantOwner.getFname() + " " + restaurantOwner.getLname());

        System.out.println("What do you willing to do?");
        System.out.println("============");
        System.out.println("0) View my menu");
        System.out.println("1) Add food to menu");
        System.out.println("2) Remove food from menu");
        System.out.println("3) Update food in menu");
        System.out.println("4) Arrange food in menu");
        System.out.println("5) View Food Sale summary report");
        System.out.println("6) EXIT SYSTEM");
        System.out.print("Option >");
        String option = scanner.nextLine();

        switch (option) {
            case "0":
                viewMenu();
                return;
            case "1":
                addFood();
                return;
            case "2":
                removeFood();
                return;
            case "3":
                updateFood();
                return;
            case "4":
                arrangeFood();
                return;
            case "5":
                summaryReport();
                return;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                restaurantOwnerMenu();
                break;
        }
    }

    private void viewMenu() {

        System.out.printf("\nMenu\n");
        System.out.println("=======");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "No.", "Food Name", "Food Description", "Food Price");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "---", "---------", "----------------", "----------");

        int count = 1;
        while (FastDelivery.foodList.moveToNext()) {

            Food food = FastDelivery.foodList.getCurrentFood();

            if (food.getRestaurant() == restaurantOwner) {
                System.out.printf("%-5s %-30s %-50s %-10s\n",
                        count + ".",
                        food.getFoodName(),
                        food.getFoodDesc(),
                        "RM " + new DecimalFormat("#0.00").format(food.getFoodPrice()));
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No food inside...");
        }

        System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
        scanner.nextLine();
        restaurantOwnerMenu();
    }

    private void addFood() {

        System.out.printf("\nPlease enter menu detail...\n");

        String foodname = null;
        String fooddesc = null;
        double foodprice = 0.00;

        do {
            System.out.print("Food Name >");
            foodname = scanner.nextLine();
            if (foodname.equals("") || foodname == null) {
                System.out.printf(Constants.ERROR_INVALID_INPUT);
            }
        } while (foodname.equals("") || foodname == null);

        boolean valid;
        do {
            valid = true;
            System.out.print("Food Price >");
            String input = scanner.nextLine();

            if (input.equals("") || input == null) {
                System.out.printf(Constants.ERROR_INVALID_INPUT);
                valid = false;
            } else {
                try {
                    foodprice = Double.parseDouble(input);
                } catch (NumberFormatException ex) {
                    System.out.printf(Constants.ERROR_INVALID_INPUT);
                    valid = false;
                }
            }
        } while (!valid);

        do {
            System.out.print("Food Description >");
            fooddesc = scanner.nextLine();
            if (fooddesc.equals("") || fooddesc == null) {
                System.out.printf(Constants.ERROR_INVALID_INPUT);
            }
        } while (fooddesc.equals("") || fooddesc == null);

        Food food = new Food(foodname, foodprice, fooddesc, restaurantOwner);

        if (FastDelivery.foodList.addFood(food)) {
            System.out.printf("\n");
            System.out.println("Your new food is added successfully.");
            System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
            scanner.nextLine();
            restaurantOwnerMenu();
        }
    }

    private void removeFood() {

        System.out.printf("\nRemove Food from Menu\n");
        System.out.println("========================");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "No.", "Food Name", "Food Description", "Food Price");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "---", "---------", "----------------", "----------");

        FoodInterface<Food> currentFoodList = new FoodList<>();
        int count = 1;
        while (FastDelivery.foodList.moveToNext()) {

            Food food = FastDelivery.foodList.getCurrentFood();

            if (food.getRestaurant() == restaurantOwner) {
                System.out.printf("%-5s %-30s %-50s %-10s\n",
                        count + ".",
                        food.getFoodName(),
                        food.getFoodDesc(),
                        "RM " + new DecimalFormat("#0.00").format(food.getFoodPrice()));
                currentFoodList.addFood(food);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No food inside...");
            restaurantOwnerMenu();
        } else {

            System.out.println("Which do you willing to remove?");
            System.out.println("Else will go back to menu.");
            System.out.print("Food Number >");

            String foodOption = scanner.nextLine();

            try {

                int foodNumber = Integer.parseInt(foodOption);

                if (foodNumber > 0 && foodNumber < count) {

                    Food food = currentFoodList.getFood(foodNumber - 1);
                    System.out.print("Confirm to remove " + food.getFoodName() + "?[YES or No]  ");
                    String confirm = scanner.nextLine().toLowerCase();

                    if (confirm.equals("yes") || confirm.equals("y")) {

                        if (FastDelivery.foodList.removeFood(food)) {
                            System.out.println(food.getFoodName() + " already removed from your menu.");
                            System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
                            scanner.nextLine();
                            restaurantOwnerMenu();
                        }
                    } else {
                        System.out.println("Cancelled to remove food.");
                        removeFood();
                    }
                } else {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    removeFood();
                }

            } catch (NumberFormatException ex) {
                restaurantOwnerMenu();
            }
        }
    }

    private void arrangeFood() {

        System.out.printf("\nArrange Food in Menu\n");
        System.out.println("========================");
        System.out.printf("%-5s %-30s\n", "No.", "Food Name");
        System.out.printf("%-5s %-30s\n", "---", "---------");

        FoodInterface<Food> currentFoodList = new FoodList<>();
        int count = 1;
        while (FastDelivery.foodList.moveToNext()) {

            Food food = FastDelivery.foodList.getCurrentFood();

            if (food.getRestaurant() == restaurantOwner) {
                System.out.printf("%-5s %-30s\n",
                        count + ".",
                        food.getFoodName());
                currentFoodList.addFood(food);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No food inside...");
            restaurantOwnerMenu();
        } else {

            System.out.println("Which do you willing to Arrange?");

            int foodTo = -1;
            int foodFrom = -1;
            boolean v;

            do {
                v = true;
                System.out.print("Arrange Food Number FROM >");
                try {
                    foodFrom = Integer.parseInt(scanner.nextLine());
                    if (foodFrom > count - 1 || foodFrom <= 0) {
                        System.out.printf(Constants.ERROR_OUT_OF_BOUND);
                        v = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    v = false;
                }
            } while (!v);

            do {
                v = true;
                System.out.print("Arrange Food Number TO >");
                try {
                    foodTo = Integer.parseInt(scanner.nextLine());
                    if (foodTo > count - 1 || foodTo <= 0) {
                        System.out.printf(Constants.ERROR_OUT_OF_BOUND);
                        v = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    v = false;
                }
            } while (!v);

            Food food1 = currentFoodList.getFood(foodFrom - 1);
            Food food2 = currentFoodList.getFood(foodTo - 1);

            FastDelivery.foodList.arrangeFood(food1, food2);

            System.out.println("The foods are arranged successfully.");
            System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
            scanner.nextLine();
            restaurantOwnerMenu();
        }
    }

    private void updateFood() {

        System.out.printf("\nUpdate Food in Menu\n");
        System.out.println("========================");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "No.", "Food Name", "Food Description", "Food Price");
        System.out.printf("%-5s %-30s %-50s %-10s\n", "---", "---------", "----------------", "----------");

        FoodInterface<Food> currentFoodList = new FoodList<>();
        int count = 1;
        while (FastDelivery.foodList.moveToNext()) {

            Food food = FastDelivery.foodList.getCurrentFood();

            if (food.getRestaurant() == restaurantOwner) {
                System.out.printf("%-5s %-30s %-50s %-10s\n",
                        count + ".",
                        food.getFoodName(),
                        food.getFoodDesc(),
                        "RM " + food.getFoodPrice());
                currentFoodList.addFood(food);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No food inside...");
            restaurantOwnerMenu();
        } else {

            System.out.println("Which do you willing to Update?");
            System.out.println("Else will go back to menu.");
            System.out.print("Food Number >");

            String foodOption = scanner.nextLine();

            try {

                int foodNumber = Integer.parseInt(foodOption);

                if (foodNumber > 0 && foodNumber < count) {

                    Food oldFood = currentFoodList.getFood(foodNumber - 1);
                    Food newFood = oldFood;

                    System.out.println("(Enter to bypass)");
                    System.out.print("New Food Name >");
                    String foodname = scanner.nextLine();

                    double foodprice = Double.NaN;
                    boolean valid;
                    do {
                        valid = true;
                        System.out.println("(Enter to bypass)");
                        System.out.print("New Food Price >");
                        String input = scanner.nextLine();

                        if (!input.equals("")) {
                            try {
                                foodprice = Double.parseDouble(input);
                                if (foodprice <= 0) {
                                    System.out.printf(Constants.ERROR_INVALID_INPUT);
                                    valid = false;
                                }
                            } catch (NumberFormatException ex) {
                                System.out.printf(Constants.ERROR_INVALID_INPUT);
                                valid = false;
                            }
                        }
                    } while (!valid);

                    System.out.println("(Enter to bypass)");
                    System.out.print("New Food Description >");
                    String fooddesc = scanner.nextLine();

                    if (!foodname.equals("")) {
                        newFood.setFoodName(foodname);
                    }
                    if (!fooddesc.equals("")) {
                        newFood.setFoodDesc(fooddesc);
                    }
                    if (foodprice != Double.NaN && foodprice > 0) {
                        newFood.setFoodPrice(foodprice);//
                    }

                    if (FastDelivery.foodList.updateFood(oldFood, newFood)) {
                        System.out.printf("\n");
                        System.out.println("Your food already updated successfully.");
                        System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
                        scanner.nextLine();
                        restaurantOwnerMenu();
                    }
                } else {
                    System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                    updateFood();
                }

            } catch (NumberFormatException ex) {
                restaurantOwnerMenu();
            }
        }
    }

    private void summaryReport() {

        FoodInterface<Food> currentFoodList = new FoodList<>();
        int limit = 1;
        while (FastDelivery.foodList.moveToNext() && limit <= 10) {

            Food food = FastDelivery.foodList.getCurrentFood();

            if (food.getRestaurant() == restaurantOwner) {
                currentFoodList.addFoodByRank(food);
            }
            limit++;
        }

        System.out.printf("\nTop 10 Food Sale Summary Report\n");
        System.out.println("==================================");
        System.out.printf("%-10s %-50s %-15s\n", "Rank No.", "Food Name", "Total Sale");
        System.out.printf("%-10s %-50s %-15s\n", "--------", "---------", "----------");

        int rank = 1;
        while (currentFoodList.moveToNext()) {
            Food food = currentFoodList.getCurrentFood();
            System.out.printf("%-10s %-50s %-15s\n", rank, food.getFoodName(), food.getNumberOfSold());
            rank++;
        }

        System.out.print(Constants.MSG_ENTER_TO_CONTINUE);
        scanner.nextLine();
        restaurantOwnerMenu();
    }
}
