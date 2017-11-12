
import entity.DeliveryMan;
import entity.HumanResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FastDelivery {

    private static Scanner scanner = new Scanner(System.in);
    
    public static List<HumanResource> humanResources = new ArrayList<>();
    public static List<DeliveryMan> deliveryMen = new ArrayList<>();

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
    }
}
