import entity.Customer;
import entity.DeliveryMan;
import entity.HumanResource;
import entity.RestaurantOwner;
import entity.OrderDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FastDelivery {

    private static Scanner scanner = new Scanner(System.in);

    public static List<HumanResource> humanResources = new ArrayList<>();
    public static List<DeliveryMan> deliveryMen = new ArrayList<>();
    public static List<RestaurantOwner> restaurantOwners = new ArrayList<>();
    public static List<Customer> customerArray = new ArrayList<>();
    public static List<OrderDetails> orderDetail = new ArrayList<>();

    public static void main(String[] args) {

        createData();

        System.out.println("###################################");
        System.out.println("#                                 #");
        System.out.println("# Welocme to FastDelivery System! #");
        System.out.println("#                                 #");
        System.out.println("###################################");

        promptRole();
    }

    private static void promptRole() {

        System.out.println("Who are you?");
        System.out.println("============");
        System.out.println("1) Customer");
        System.out.println("2) Restaurant Owner");
        System.out.println("3) Delivery Man");
        System.out.println("4) Human Resource Executive");
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
                break;
            case 2:
                new RestaurantOwnerScreen();
                break;
            case 3:
                new DeliveryManScreen();
                break;
            case 4:
                new HumanResourceScreen();
                break;
            default:
                System.out.printf(Constants.ERROR_OPTION_NOT_AVAILABLE);
                promptRole();
                break;
        }
    }

    private static void createData() {

        HumanResource hr1 = new HumanResource(
                "Ali",
                "Mohd",
                "880512-14-5881",
                "Blok A34 Pengkalan Tldm Teluk Muruk 32100 Lumut Lumut Perak",
                "ali@email.com",
                "0182546897",
                "ali",
                "ali123"
        );

        humanResources.add(hr1);

        DeliveryMan dm1 = new DeliveryMan(
                "Ali",
                "Mohd",
                "880512-14-5881",
                "Blok A34 Pengkalan Tldm Teluk Muruk 32100 Lumut Lumut Perak",
                "ali@email.com",
                "0182546897",
                "ali",
                "ali123"
        );

        deliveryMen.add(dm1);

        RestaurantOwner rol = new RestaurantOwner(
                "Melvin",
                "Tan",
                "990512-14-8877",
                "Blok A14 Pengkalan Tldm Teluk Muruk 43100 mohan Perak",
                "ali@email.com",
                "0182546897",
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
        
    
    }
}
