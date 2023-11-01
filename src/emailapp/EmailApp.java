package emailapp;
import java.util.*;
public class EmailApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //User info
        System.out.println("Enter firstname : ");
        String firstname = scanner.next();
        System.out.println("Enter lastname : ");
        String lastname = scanner.next();

        //creating object for email class.
        Email email = new Email(firstname, lastname);
        int choice = -1;
        do {
            System.out.println("\n**********\n Enter your choice\n1.Show info\n2.Change password\n3.Change mailbox capacity\n4.Set alternate mail.\n5.Store data in file.\n6.Display data from file.\n7.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    email.getInfo();
                    break;
                case 2:
                    email.setPassword();
                    break;
                case 3:
                    email.setMailCapacity();
                    break;
                case 4:
                    email.alternateEmail();
                    break;
                case 5:
                    email.writeToFile();
                    break;
                case 6:
                    email.readFromFile();
                    break;
                case 7:
                    System.out.println("Thank you for using our application...");
                    break;
                default:
                    System.out.println("Invalid choice!\nEnter proper choice again..");
            }
        }while (choice != 7);
    }
}
