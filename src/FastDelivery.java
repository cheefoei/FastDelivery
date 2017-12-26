
import adt.DeliveryManList;
import adt.BaseList;
import adt.DeliveryManInterface;
import adt.FoodInterface;
import adt.FoodList;
import adt.OrderFoodInterface;
import adt.OrderFoodList;
import adt.OrderInterface;
import adt.OrderList;
import adt.RestaurantOwnerInterface;
import adt.RestaurantOwnerList;
import entity.Contact;
import entity.Customer;
import entity.DeliveryJob;
import entity.DeliveryMan;
import entity.DeliveryOrder;
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
import adt.BaseListInterface;

public class FastDelivery {

    private static Scanner scanner = new Scanner(System.in);
    private static final DateFormat DF = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);

    public static RestaurantOwnerInterface<RestaurantOwner> restaurantOwnerList = new RestaurantOwnerList<>();
    public static FoodInterface<Food> foodList = new FoodList<>();

    public static BaseListInterface<HumanResource> humanResources = new BaseList<>();
    public static DeliveryManInterface<DeliveryMan> deliveryMen = new DeliveryManList<>();
    public static BaseListInterface<DeliveryOrder> deliverOrders = new BaseList<>();
    public static BaseListInterface<DeliveryJob> deliverJobs = new BaseList<>();

    public static List<Customer> customerArray = new ArrayList<>();
    public static OrderFoodInterface<OrderDetails> orderFoodList = new OrderFoodList<>();
    public static OrderInterface<Orders> orderList = new OrderList<>();

    public static List<PunchedCard> punchedCards = new ArrayList<>();

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
                clearScreen();
//                new CustomerScreen();
                return;
            case 2:
                clearScreen();
                new RestaurantOwnerScreen();
                return;
            case 3:
                clearScreen();
//new DeliveryManScreen();
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

        /* Human Resource data */
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

        /* Delivery Man data */
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
        DeliveryMan dm4 = new DeliveryMan(
                "Alexandar",
                "Oman",
                'M',
                "850311-14-4157",
                new Contact(
                        "55-G, Jalan Wisma Hill",
                        "Shah Alam",
                        48700,
                        "Selangor",
                        "alexandar@email.com",
                        "012145873"
                ),
                "alexandar",
                "alex1234"
        );
        DeliveryMan dm5 = new DeliveryMan(
                "Mandy",
                "Wong",
                'F',
                "740529-10-5536",
                new Contact(
                        "J-2-1, Jalan Sungai Besar",
                        "Gombak",
                        52300,
                        "Kuala Lumpur",
                        "mandy@email.com",
                        "0165874893"
                ),
                "mandy",
                "mandy123"
        );
        deliveryMen.add(dm1);
        deliveryMen.add(dm2);
        deliveryMen.add(dm3);
        deliveryMen.add(dm4);
        deliveryMen.add(dm5);

        /* Restaurant Owner data */
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
        RestaurantOwner ro2 = new RestaurantOwner(
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
        RestaurantOwner ro3 = new RestaurantOwner(
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
        RestaurantOwner ro4 = new RestaurantOwner(
                "Mitra",
                "Siva",
                "91022-10-5555",
                new Contact(
                        "No 50,  Kota Kemuning Bayu,Kota Kemuning",
                        "Shah Alam",
                        47300,
                        "Selangor",
                        "mitra@email.com",
                        "0101022222"
                ),
                "mitra",
                "siva",
                "Kapitan Restaurant",
                "No 34, Jalan Megah,Alam Denai 47300 Shah Alam Selangor",
                "0333333333"
        );
        RestaurantOwner ro5 = new RestaurantOwner(
                "Abu",
                "Mohd",
                "881220-10-2020",
                new Contact(
                        "No 88, Section 29,Putra Height",
                        "Shah Alam",
                        47300,
                        "Selangor",
                        "abumohd@email.com",
                        "0103434343"
                ),
                "abu",
                "mohd",
                "Maju maju restaurant",
                "No. 77 SS19/1 47650 Subang Jaya, Selangor",
                "0302121212"
        );
        restaurantOwnerList.addRestOwner(rol);
        restaurantOwnerList.addRestOwner(ro2);
        restaurantOwnerList.addRestOwner(ro3);
        restaurantOwnerList.addRestOwner(ro4);
        restaurantOwnerList.addRestOwner(ro5);

        /* Food data */
        Food food1 = new Food(
                "Mee Goreng",
                6.99,
                "Super spicy!!!",
                25,
                rol);
        Food food2 = new Food(
                "Nasi Goreng",
                8.88,
                "Spicy!!!",
                12,
                rol);
        Food food3 = new Food(
                "Boiled Egg",
                1.29,
                "Hard boiled",
                6,
                rol);
        Food food4 = new Food(
                "Roti Goreng",
                10.99,
                "Non-spicy",
                35,
                rol);
        Food food5 = new Food(
                "Mi Sup",
                7.89,
                "Got eggs",
                17,
                rol);
        Food food6 = new Food(
                "Ayam Goreng",
                4.99,
                "Spicy or non spicy",
                41,
                ro4);
        Food food7 = new Food(
                "Bihun Goreng",
                8.99,
                "Added black pepper",
                11,
                rol);
        Food food8 = new Food(
                "Bihun Goreng",
                8.99,
                "Added black pepper",
                11,
                ro2);
        Food food9 = new Food(
                "Bihun Goreng",
                8.99,
                "Added black pepper",
                11,
                ro2);
        Food food10 = new Food(
                "Bihun Goreng",
                8.99,
                "Added black pepper",
                11,
                ro2);

        foodList.addFood(food1);
        foodList.addFood(food2);
        foodList.addFood(food3);
        foodList.addFood(food4);
        foodList.addFood(food5);
        foodList.addFood(food6);
        foodList.addFood(food7);
        foodList.addFood(food8);
        foodList.addFood(food9);
        foodList.addFood(food10);

        /* Customer data */
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
        Customer cus4 = new Customer(
                "Amelia Fu",
                "650212-08-5486",
                "Female",
                new Contact(
                        "G248 Jalan Kepong 13/3",
                        "Kepong",
                        58600,
                        "Kuala Lumpur",
                        "amelia@gmail.com",
                        "0175896347"
                ),
                "amelia",
                "a1234"
        );
        Customer cus5 = new Customer(
                "Jack To",
                "890426-14-7849",
                "Male",
                new Contact(
                        "A-32 Taman Melati",
                        "Wangsa Maju",
                        50000,
                        "Kuala Lumpur",
                        "jack@gmail.com",
                        "0142154268"
                ),
                "jack",
                "jack0123"
        );
        customerArray.add(cus1);
        customerArray.add(cus2);
        customerArray.add(cus3);
        customerArray.add(cus4);
        customerArray.add(cus5);

        try {
            /* Order data */
            Orders order1 = new Orders(
                    "Done",
                    13.98,
                    DF.parse("Mon 25-Dec-2017 15:33:30"),
                    cus1
            );
            order1.setOrderId(1513099860);

            Orders order2 = new Orders(
                    "Done",
                    29.88,
                    DF.parse("Mon 25-Dec-2017 22:55:40"),
                    cus3
            );
            order2.setOrderId(1513099861);

            Orders order3 = new Orders(
                    "Done",
                    35.66,
                    DF.parse("Mon 25-Dec-2017 23:56:23"),
                    cus2
            );
            order3.setOrderId(1513099862);

            Orders order4 = new Orders(
                    "Done",
                    58.99,
                    DF.parse("Mon 25-Dec-2017 23:57:47"),
                    cus5
            );
            order4.setOrderId(1513099863);

            Orders order5 = new Orders(
                    "Done",
                    29.98,
                    DF.parse("Tue 26-Dec-2017 12:33:30"),
                    cus4
            );
            order5.setOrderId(1513099864);

            Orders order6 = new Orders(
                    "Done",
                    28.00,
                    DF.parse("Tue 26-Dec-2017 17:33:30"),
                    cus2
            );
            order6.setOrderId(1513099865);

            Orders order7 = new Orders(
                    "Done",
                    57.98,
                    DF.parse("Tue 26-Dec-2017 17:45:28"),
                    cus3
            );
            order7.setOrderId(1513099866);

            Orders order8 = new Orders(
                    "Pending",
                    41.98,
                    DF.parse("Wed 27-Dec-2017 12:56:42"),
                    cus4
            );
            order8.setOrderId(1513099867);

            Orders order9 = new Orders(
                    "Pending",
                    38.98,
                    DF.parse("Wed 27-Dec-2017 12:58:12"),
                    cus2
            );
            order9.setOrderId(1513099868);

            Orders order10 = new Orders(
                    "Pending",
                    23.98,
                    DF.parse("Wed 27-Dec-2017 13:20:23"),
                    cus5
            );
            order10.setOrderId(1513099869);

            orderList.addNewOrder(order1);
            orderList.addNewOrder(order2);
            orderList.addNewOrder(order3);
            orderList.addNewOrder(order4);
            orderList.addNewOrder(order5);
            orderList.addNewOrder(order6);
            orderList.addNewOrder(order7);
            orderList.addNewOrder(order8);
            orderList.addNewOrder(order9);
            orderList.addNewOrder(order10);

            /* Order Detail data */
            OrderDetails od1 = new OrderDetails(order1, food5, 4, "No spicy pls");
            OrderDetails od2 = new OrderDetails(order2, food2, 4, "More spicy pls");
            OrderDetails od3 = new OrderDetails(order3, food4, 4, "Less spicy pls");
            OrderDetails od4 = new OrderDetails(order4, food1, 2, "Add spicy pls");
            OrderDetails od5 = new OrderDetails(order4, food4, 4, "Less spicy pls");
            OrderDetails od6 = new OrderDetails(order5, food7, 4, "Add more cheese");
            OrderDetails od7 = new OrderDetails(order6, food2, 2, "Nothing");
            OrderDetails od8 = new OrderDetails(order7, food4, 5, "more spicy");
            OrderDetails od9 = new OrderDetails(order8, food1, 3, "Up size");
            OrderDetails od10 = new OrderDetails(order8, food2, 1, "-");
            OrderDetails od11 = new OrderDetails(order9, food6, 1, "Dont want egg");
            OrderDetails od12 = new OrderDetails(order9, food3, 1, "-");
            OrderDetails od13 = new OrderDetails(order10, food2, 5, "No chili");

            orderFoodList.addNewOrder(od1);
            orderFoodList.addNewOrder(od2);
            orderFoodList.addNewOrder(od3);
            orderFoodList.addNewOrder(od4);
            orderFoodList.addNewOrder(od5);
            orderFoodList.addNewOrder(od6);
            orderFoodList.addNewOrder(od7);
            orderFoodList.addNewOrder(od8);
            orderFoodList.addNewOrder(od9);
            orderFoodList.addNewOrder(od10);
            orderFoodList.addNewOrder(od11);
            orderFoodList.addNewOrder(od12);
            orderFoodList.addNewOrder(od13);

            /* Delivery Job and Order data */
            DeliveryJob dj1 = new DeliveryJob(dm5, DF.parse("Mon 25-Dec-2017 11:39:30"), 4.0, 1);
            DeliveryJob dj2 = new DeliveryJob(dm4, DF.parse("Mon 25-Dec-2017 13:40:34"), 2.5, 1);
            DeliveryJob dj3 = new DeliveryJob(dm1, DF.parse("Mon 25-Dec-2017 15:17:50"), 7.8, 2);
            DeliveryJob dj4 = new DeliveryJob(dm3, DF.parse("Tue 26-Dec-2017 15:17:50"), 2.5, 1);
            DeliveryJob dj5 = new DeliveryJob(dm2, DF.parse("Tue 26-Dec-2017 15:17:50"), 4.5, 2);
            DeliveryJob dj6 = new DeliveryJob(dm5, DF.parse("Wed 27-Dec-2017 12:56:45"), 7.0, 2);
            DeliveryJob dj7 = new DeliveryJob(dm1, DF.parse("Wed 27-Dec-2017 13:20:24"), 2.0, 1);

            DeliveryOrder do1 = new DeliveryOrder(dj1, order1, 4.0);
            do1.setDeliveryDate(DF.parse("Mon 25-Dec-2017 15:33:41"));
            do1.setIsDone(true);

            DeliveryOrder do2 = new DeliveryOrder(dj2, order2, 2.5);
            do2.setDeliveryDate(DF.parse("Mon 25-Dec-2017 22:55:41"));
            do2.setIsDone(true);

            DeliveryOrder do3 = new DeliveryOrder(dj3, order3, 5.0);
            do3.setDeliveryDate(DF.parse("Mon 25-Dec-2017 23:56:23"));
            do3.setIsDone(true);

            DeliveryOrder do4 = new DeliveryOrder(dj3, order4, 2.8);
            do4.setDeliveryDate(DF.parse("Mon 25-Dec-2017 23:58:55"));
            do4.setIsDone(true);

            DeliveryOrder do5 = new DeliveryOrder(dj4, order5, 2.5);
            do5.setDeliveryDate(DF.parse("Tue 26-Dec-2017 12:33:30"));
            do5.setIsDone(true);

            DeliveryOrder do6 = new DeliveryOrder(dj5, order6, 1.0);
            do6.setDeliveryDate(DF.parse("Tue 26-Dec-2017 17:33:30"));
            do6.setIsDone(true);

            DeliveryOrder do7 = new DeliveryOrder(dj5, order7, 3.5);
            do7.setDeliveryDate(DF.parse("Tue 26-Dec-2017 17:45:28"));
            do7.setIsDone(true);

            DeliveryOrder do8 = new DeliveryOrder(dj6, order8, 1.5);
            do8.setDeliveryDate(DF.parse("Wed 27-Dec-2017 12:56:42"));

            DeliveryOrder do9 = new DeliveryOrder(dj6, order9, 5.5);
            do9.setDeliveryDate(DF.parse("Wed 27-Dec-2017 12:58:12"));

            DeliveryOrder do10 = new DeliveryOrder(dj7, order10, 2.0);
            do10.setDeliveryDate(DF.parse("Wed 27-Dec-2017 13:20:23"));

            deliverOrders.add(do1);
            deliverOrders.add(do2);
            deliverOrders.add(do3);
            deliverOrders.add(do4);
            deliverOrders.add(do5);
            deliverOrders.add(do6);
            deliverOrders.add(do7);
            deliverOrders.add(do8);
            deliverOrders.add(do9);
            deliverOrders.add(do10);

            deliverJobs.add(dj1);
            deliverJobs.add(dj2);
            deliverJobs.add(dj3);
            deliverJobs.add(dj4);
            deliverJobs.add(dj5);
            deliverJobs.add(dj6);
            deliverJobs.add(dj7);

            /* Punch Card data */
            PunchedCard pc1 = new PunchedCard(
                    "ON-DUTY",
                    DF.parse("Wed 17-Nov-2017 23:40:26"),
                    null,
                    dm1
            );
            punchedCards.add(pc1);
        } catch (ParseException ex) {
        }
    }
}
