
import java.util.Scanner;

public class DeliveryManScreen {

    private Scanner scanner = new Scanner(System.in);

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
        System.out.print("Please choose an option below:" + "\n"
               + "1:Clock In" + "\n"
               + "2:Clock Out" + "\n");

        int input = scanner.nextInt();

        switch (input) {
            case 1:
                clock_in();
                break;
            case 2:
                clock_out();
                break;
            default:
                System.out.println("Invalid option, please try again!\n");
                punchedCard();
                break;
        }
        
        
    }
    private void clock_in(){
         
                // addition of screen choice to arraylist/text file
                //timeClock.add(choice);
             
          
                
                
                // if employee ID is valid, have they punched in already?
                // if not, try again.
                
                    // has employee punched in?  If yes, continue.
                    for(TimeClock t : timePunches)
                    {
                        if(t.getPunchInOrOut() && choice.equalsIgnoreCase("i"))
                        {
                            timePunches = t;
                            break;
                        }
                        else()
                        {
                            // if employee has not punched in, try again
                        }
                    }
 
                
                 
                TimeClock newTimePunch = new TimeClock(employeeID, new Date(), choice);
 
                // if employee ID is valid,
                // addition of date and time to arraylist/text file
                timePunches.add(newTimePunch);
 
                //write to the file
                timeClockDAO.writeTimePunch(newTimePunch);
                 
                // conditional statement for in/out + formatting
                System.out.println("Punch-" + (choice.equalsIgnoreCase("i") ? "In" : "Out") + " Successful!" + "\n"
                                 + "Date & Time:   " + dateFormat.format(new Date()) + "\n"
                                 + "Employee Name: " + employee.getFirstName() + " " + employee.getLastName() + "\n"
                                 + "Employee ID:   " + employee.getEmployeeID() + "\n");
 
                System.out.println(); // print a blank line
                break;
            }
            else
            {
                System.out.println("Invalid entry. Please try again.");
            }
        }
        
    }

    private void deliveryManMenu() {

    }
}
