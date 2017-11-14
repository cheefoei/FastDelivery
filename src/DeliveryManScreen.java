
import entity.DeliveryMan;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DeliveryManScreen {

    private Scanner scanner = new Scanner(System.in);
    private DeliveryMan deliveryman;

    public DeliveryManScreen() {

        System.out.printf("\nHuman Resource Executive Login\n");
        System.out.println("==============");

        checkAutho();
    }

    private void checkAutho() {

        System.out.print("Username >");
        String username = scanner.nextLine();

        System.out.print("Password >");
        String password = scanner.nextLine();

        if (1 == 1) {
            punchedCard();
        } else {
            System.out.println(Constants.ERROR_LOG_IN);
            checkAutho();
        }
    }
    private void punchedCard(){
        // print option menu
        System.out.print("Do you want to Clock In/Clock Out?:" + "\n"
               + "1:Clock In" + "\n"
               + "2:Clock Out" + "\n"
               + "3:Not now"+"\n");

        int input = scanner.nextInt();

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
        
        
    }
    private void clock_in(){
         
                Calendar now = Calendar.getInstance(); 
     
                Date clock_in= now.getTime();
                if(deliveryman.getPunchedStatus() != "On-Duty"){
                deliveryman.setClockIn(clock_in);
                deliveryman.setPunchedStatus("On-Duty");
                                                       
                System.out.println("Clock In Successful!\n"
                                 + "Date & Time:   " + clock_in + "\n"
                                 + "Employee Name: " + deliveryman.username +"\n"); 
                }else{
                    System.out.println("THIS USER IS ALREADY ON-DUTY!!\n");
                    punchedCard();
                }
        
    }
    private void clock_out(){
         
                Calendar now = Calendar.getInstance(); 
     
                Date clock_out= now.getTime();
                if(deliveryman.getPunchedStatus() != "Off-Duty"){
                deliveryman.setClockOut(clock_out);
                deliveryman.setPunchedStatus("Off-Duty");
                                                       
                System.out.println("Clock Out Successful!\n"
                                 + "Date & Time:   " + clock_out + "\n"
                                 + "Employee Name: " + deliveryman.username +"\n"); 
                }else{
                    System.out.println("THIS USER IS ALREADY OFF-DUTY!!\n");
                    punchedCard();
                }
        
    }

    private void deliveryManMenu() {

    }
}
