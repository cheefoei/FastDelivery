
import adt.DeliveryManIteratorInterface;
import adt.DeliveryManList;
import entity.Contact;
import entity.Customer;
import entity.DeliveryMan;
import entity.Food;
import entity.HumanResource;
import entity.RestaurantOwner;
import entity.OrderDetails;
import entity.PunchedCard;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FastDelivery {

    private static Scanner scanner = new Scanner(System.in);
    private static final DateFormat df = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);

    public static List<HumanResource> humanResources = new ArrayList<>();
    public static List<DeliveryMan> deliveryMen = new ArrayList<>();

    public static DeliveryManIteratorInterface<DeliveryMan> t_deliveryMen = new DeliveryManList<>();

    public static List<RestaurantOwner> restaurantOwners = new ArrayList<>();
    public static List<Food> foods = new ArrayList<>();
    public static List<Customer> customerArray = new ArrayList<>();
    public static List<OrderDetails> orderDetail = new ArrayList<>();
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
                new CustomerScreen();
                return;
            case 2:
                new RestaurantOwnerScreen();
                return;
            case 3:
                new DeliveryManScreen();
                return;
            case 4:
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

        humanResources.add(hr1);

        DeliveryMan dm1 = new DeliveryMan(
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

        deliveryMen.add(dm1);
        t_deliveryMen.addDeliveryMan(dm1);

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
        customerArray.add(cus1);

        try {
            PunchedCard pc1 = new PunchedCard(
                    "ON-DUTY",
                    df.parse("Wed 17-Nov-2017 23:40:26"),
                    null,
                    dm1
            );
            punchedCards.add(pc1);
        } catch (ParseException ex) {
        }

    }
}
