
import adt.DeliveryManInterface;
import adt.DeliveryManList;
import adt.BasicList;
import adt.BasicListInterface;
import adt.OrderFoodInterface;
import adt.OrderFoodList;
import entity.Contact;
import entity.Customer;
import entity.DeliveryJob;
import entity.DeliveryMan;
import entity.Food;
import entity.HumanResource;
import entity.RestaurantOwner;
import entity.OrderDetails;
import entity.Orders;
import entity.PunchedCard;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FastDelivery {

    private static Scanner scanner = new Scanner(System.in);
    private static final DateFormat DF = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);

    public static BasicListInterface<HumanResource> humanResources = new BasicList<>();
    public static DeliveryManInterface<DeliveryMan> deliveryMen = new DeliveryManList<>();
    public static BasicListInterface<DeliveryJob> deliverJobs = new BasicList<>();

    public static List<RestaurantOwner> restaurantOwners = new ArrayList<>();
    public static List<Food> foods = new ArrayList<>();
    public static List<Customer> customerArray = new ArrayList<>();
    public static List<Orders> orders = new ArrayList<>();
    public static List<OrderDetails> orderDetail = new ArrayList<>();
    public static List<PunchedCard> punchedCards = new ArrayList<>();
    public static OrderFoodInterface<OrderDetails> orderFoodList = new OrderFoodList<>();
    //public static OrderInterface<Orders> orderList = new OrderList<>();

    public static void main(String[] args) {

        createData();

        while (true) {

            System.out.println("###################################");
            System.out.println("#                                 #");
            System.out.println("# Welcome to FastDelivery System! #");
            System.out.println("#                                 #");
            System.out.println("###################################");

            promptRole();
        }
    }

    private static void promptRole() {

        System.out.println("Who are you?");
        System.out.println("============");
        System.out.println("1) Customer");
        System.out.println("2) Restaurant Owner");
        System.out.println("3) Delivery Man");
        System.out.println("4) Human Resource Executive");
        System.out.println("5) EXIT SYSTEM");
        System.out.print("Option >");

        int roleNum = -1;
        try {
            roleNum = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
            promptRole();
        }

        switch (roleNum) {
            case 1:
//                new CustomerScreen();
                return;
            case 2:
                new RestaurantOwnerScreen();
                return;
            case 3:
//                new DeliveryManScreen();
                return;
            case 4:
                clearScreen();
                new HumanResourceScreen();
                return;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                promptRole();
                break;
        }
    }

    public static void clearScreen() {

        try {
            if (System.getProperty("os.name").startsWith("Window")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException e) {
            for (int i = 0; i < 1000; i++) {
                System.out.println();
            }
        }
    }

    private static void createData() {

        HumanResource hr1 = new HumanResource(
                "Gal",
                "Gadot",
                'F',
                "890921-10-5486",
                new Contact(
                        "No 56 Pengkalan Tldm Teluk Muruk",
                        "Kajang",
                        43000,
                        "Selangor",
                        "galgadot@email.com",
                        "0125683786"
                ),
                "gal",
                "wonder"
        );
        HumanResource hr2 = new HumanResource(
                "Clark",
                "Ken",
                'M',
                "770225-08-4789",
                new Contact(
                        "No 87 Jln 123 Taman Oman",
                        "Titiwangsa",
                        50000,
                        "Kuala Lumpur",
                        "clarkken@email.com",
                        "0178524678"
                ),
                "clark",
                "ken"
        );

        humanResources.add(hr1);
        humanResources.add(hr2);

        DeliveryMan dm1 = new DeliveryMan(
                "Jessica",
                "Fishman",
                'F',
                "910222-10-6334",
                new Contact(
                        "No 123 Jalan Pengkalan Taman Muruk",
                        "Shah Alam",
                        468000,
                        "Selangor",
                        "jess@email.com",
                        "01111225578"
                ),
                "jess",
                "fish"
        );
        DeliveryMan dm2 = new DeliveryMan(
                "Ali",
                "Mohd",
                'M',
                "880512-14-5881",
                new Contact(
                        "Blok A34 Pengkalan Taman Teluk Muruk",
                        "Lumut",
                        32100,
                        "Perak",
                        "ali@email.com",
                        "0182546897"
                ),
                "ali",
                "ali123"
        );
        DeliveryMan dm3 = new DeliveryMan(
                "Ahmad",
                "Safiq",
                'M',
                "910313-14-6849",
                new Contact(
                        "145, Jalan Tengku Taman Flora",
                        "GeorgeTown",
                        55512,
                        "Penang",
                        "ahmad@email.com",
                        "0132457785"
                ),
                "ahmad",
                "ahmad123"
        );
//        dm1.setIsLeave(true);

        if (deliveryMen.add(dm1)) {
            System.out.println("true");
        }
        if (deliveryMen.add(dm2)) {
            System.out.println("true");
        }
        if (deliveryMen.add(dm3)) {
            System.out.println("true");
        }

        RestaurantOwner rol = new RestaurantOwner(
                "Melvin",
                "Tan",
                "990512-14-8877",
                new Contact(
                        "Blok A14 Pengkalan Tldm Teluk Muruk",
                        "mohan",
                        43100,
                        "Perak",
                        "melvin@email.com",
                        "01111445879"
                ),
                "melvin",
                "mmmm1234",
                "Ultra Melvin",
                "Blok B14 Pengkalan Tldm Teluk Muruk 43100 mohan Perak",
                "0388888888"
        );

        restaurantOwners.add(rol);

        Food food1 = new Food(
                "Mee Goreng",
                6.99,
                "Super spicy!!!",
                rol);
        Food food2 = new Food(
                "Nasi Goreng",
                8.88,
                "Spicy!!!",
                rol);
        Food food3 = new Food(
                "Boiled Egg",
                1.29,
                "Hard boiled",
                rol);
        Food food4 = new Food(
                "Roti Goreng",
                10.99,
                "Non-spicy",
                rol);
        Food food5 = new Food(
                "Mi Sup",
                7.89,
                "Got eggs",
                rol);
        Food food6 = new Food(
                "Ayam Goreng",
                4.99,
                "Spicy or non spicy",
                rol);

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        foods.add(food5);
        foods.add(food6);

        Customer cus1 = new Customer(
                "Allan",
                "950103-14-7777",
                "Male",
                new Contact(
                        "No.8 Jalan Dulang,Balakong",
                        "Seri Kembangan",
                        43300,
                        "Selangor",
                        "allan0103@gmail.com",
                        "0101234567"
                ),
                "allan",
                "allan0103"
        );
        customerArray.add(cus1);

        Customer cus2 = new Customer(
                "Ji Yong",
                "880818-10-8888",
                "Male",
                new Contact(
                        "No.18 Putra Avenue ",
                        "Subang Jaya",
                        47100,
                        "Selangor",
                        "jiyong0818@gmail.com",
                        "0102345678"
                ),
                "gd",
                "gd0818"
        );
        customerArray.add(cus2);

        Customer cus3 = new Customer(
                "Charlotte",
                "940505-08-5698",
                "Female",
                new Contact(
                        "No.12 Jalan USJ 13/3",
                        "Subang Jaya",
                        47610,
                        "Selangor",
                        "charlotte@gmail.com",
                        "0112345678"
                ),
                "charlotte",
                "charlotte0505"
        );
        customerArray.add(cus3);

        try {
            PunchedCard pc1 = new PunchedCard(
                    "ON-DUTY",
                    DF.parse("Wed 17-Nov-2017 23:40:26"),
                    null,
                    dm1
            );
            punchedCards.add(pc1);
        } catch (ParseException ex) {
        }

        try {
            Orders order1 = new Orders(
                    "Pending",
                    13.98,
                    DF.parse("Mon 11-Dec-2017 15:33:30"),
                    cus1
            );
            order1.setOrderId(1513099860);

            Orders order2 = new Orders(
                    "Pending",
                    29.88,
                    DF.parse("Tue 12-Dec-2017 11:55:40"),
                    cus1
            );
            order2.setOrderId(1513099861);

            Orders order3 = new Orders(
                    "Pending",
                    35.66,
                    DF.parse("Tue 12-Dec-2017 12:56:23"),
                    cus1
            );
            order3.setOrderId(1513099862);

            Orders order4 = new Orders(
                    "Pending",
                    12.33,
                    DF.parse("Wed 13-Dec-2017 10:25:47"),
                    cus1
            );
            order4.setOrderId(1513099863);

            orders.add(order1);
            orders.add(order2);
            orders.add(order3);
            orders.add(order4);

            OrderDetails od1 = new OrderDetails(order1, food5, 4, "No spicy pls");
            OrderDetails od2 = new OrderDetails(order2, food2, 4, "More spicy pls");
            OrderDetails od3 = new OrderDetails(order3, food4, 4, "Less spicy pls");

            orderDetail.add(new OrderDetails(order4, food1, 2, "Add spicy pls"));
            orderDetail.add(od1);
            orderDetail.add(od2);
            orderDetail.add(od3);

            DeliveryJob dj1 = new DeliveryJob(order1, dm1, 1.5);
            dj1.setDeliveryDate(DF.parse("Mon 11-Dec-2017 15:40:30"));

            DeliveryJob dj2 = new DeliveryJob(order2, dm1, 3.0);
            dj2.setDeliveryDate(DF.parse("Tue 12-Dec-2017 11:55:40"));

            DeliveryJob dj3 = new DeliveryJob(order3, dm1, 5.0);
            dj3.setDeliveryDate(DF.parse("Tue 12-Dec-2017 12:56:23"));

            DeliveryJob dj4 = new DeliveryJob(order4, dm1, 0.8);
            dj4.setDeliveryDate(DF.parse("Wed 13-Dec-2017 10:25:47"));

            deliverJobs.add(dj1);
            deliverJobs.add(dj2);
            deliverJobs.add(dj3);
            deliverJobs.add(dj4);

        } catch (ParseException ex) {
        }
    }
}
