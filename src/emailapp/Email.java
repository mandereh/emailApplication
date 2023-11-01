package emailapp;

import java.util.*;
import java.io.*;
public class Email {

    public Scanner scanner = new Scanner(System.in);
    //setting variables as private
    private String firstname;
    private String lastname;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alternativeEmail;

    public Email(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("New Employee : " + this.firstname + "" + this.lastname);
        //calling methods
        this.department = this.setDepartment();//department
        this.password = this.generatePassword(8);//password
        this.email = this.generateEmail();//email generation.
    }
    //generate mail.
    private String generateEmail(){
        return this.firstname.toLowerCase()+"."+this.lastname.toLowerCase()+"@"+this.department.toLowerCase()+".company.com";
    }
    //Asking for Department.
    private String setDepartment(){
        System.out.println("Department codes \n1 : for sales\n2 : for Development \n3 : for Accounting \n0 : for None");
        boolean flag = false;
        do {
            System.out.println("Enter Department code");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice, please choose again.");
            }
        }while(!flag);
        return null;
    }

    //Generate random password methods
    private String generatePassword(int length){
        Random random = new Random();
        String capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWSYZ";
        String small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!~@#$%^&*()_";
        String values = capital_chars + small_chars + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++){
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }
    //change password
    public void setPassword(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password!(Y/N)");
            char choice = scanner.next().charAt(0);
            if (choice == 'Y' || choice == 'y'){
                flag = true;
                System.out.println("Enter current password:");
                String temp = scanner.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password:");
                    this.password = scanner.next();
                    System.out.println("Password changed successfully..");
                }else {
                    System.out.println("Incorrect password..");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password change option cancelled.");
            }else {
                System.out.println("Enter valid choice.");
            }
        }while (!flag);
    }

    //set mailbox capacity
    public void setMailCapacity(){
        System.out.println("Current capacity : " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity : ");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed.");
    }

    //set alternate mail.
    public void alternateEmail(){
        System.out.println("Enter new alternate mail.");
        this.alternativeEmail = scanner.next();
        System.out.println("Alternate email is set.");
    }

    //display user information
    public void getInfo(){
        System.out.println("New : " + this.firstname + " " + this.lastname);
        System.out.println("Department : " + this.department);
        System.out.println("Email : " + this.email);
        System.out.println("Password : " + this.password);
        System.out.println("Mailbox capacity : " + this.mailCapacity + "mb");
        System.out.println("Alternative email : " + this.alternativeEmail);
    }

    public void writeToFile(){
        try{
            FileWriter file = new FileWriter("storage.txt");
            file.write("Firstname : " + this.firstname);
            file.append("\nLastname : " + this.lastname);
            file.append("\nEmail : " + this.email);
            file.append("\nPassword : " + this.password);
            file.append("\nCapacity : " + this.mailCapacity);
            file.append("\nAlternate mail : " + this.alternativeEmail);
            file.close();
            System.out.println("Data stored..");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Read storage
    public void readFromFile(){
        try{
            FileReader file = new FileReader("storage.txt");
            int i;
            while ((i = file.read()) != -1){
                System.out.print((char)i);
            }
            file.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
