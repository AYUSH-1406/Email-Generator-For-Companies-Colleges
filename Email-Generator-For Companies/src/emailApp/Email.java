package emailApp;

import java.io.*;
import java.util.*;

public class Email {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("First Name: ");
        String fname = sc.next();
        System.out.println("Last Name: ");
        String lname = sc.next();

        Email email = new Email(fname, lname);
        int choice = -1;
        do {
            System.out.println("\n********\nEnter Your Choice\n1.Show Info\n2.Change Password\n3.Change Mail capacity\n4.Alternate Email\n5.Store File \n6.Read File \n7.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    email.info();
                    break;
                case 2:
                    email.setPassword();
                    break;
                case 3:
                    email.setMailBoxCapacity();
                    break;
                case 4:
                    email.alterEmail();
                    break;
                case 5:
                    email.storeFile();
                    break;
                case 6:
                    email.read_File();
                    break;
                case 7:
                    System.out.println("Thank You For Using Application!");
                    break;
                default:
                    System.out.println("Invalid Choice \n ");
            }
        } while (choice != 5);

    }

    public Scanner sc = new Scanner(System.in);
    private String fname;
    private String lname;
    private String department;
    private String password;
    private String email;
    private String alt_email;
    private int mailCount = 500;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);
        this.department = this.department();
        this.password = this.password_generator(8);
        this.email = this.generate_email();
    }

    private String generate_email() {
        return this.fname.toLowerCase() + '.' + this.lname.toLowerCase() + "@" + this.department.toLowerCase() + ".company.com";
    }

    private String department() {
        System.out.println("Department Codes \n1 For Sales \n2 For Development \n3 For Accounting \n4 For None");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";

                case 2:
                    return "Development";

                case 3:
                    return " Accounting";

                case 4:
                    return "";

                default:
                    System.out.println("Enter Valid Choice:");

            }
        }
        while (!flag);
        return null;


    }

    private String password_generator(int length) {
        Random r = new Random();
        String Capt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "@&%&?#!";
        String values = Capt + Small + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void setPassword() {
        boolean flag = false;
        do {
            System.out.println("DO You Want To Change Password! (Y/N)");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("ENTER CURRENT PASSWORD: ");
                String temp = sc.next();
                if (temp.equals(this.password)) {
                    System.out.println("ENTER NEW PASSWORD: ");
                    this.password = sc.next();
                    System.out.println("PASSWORD CHANGED");
                } else {
                    System.out.println("INCORRECT PASSWORD! ");
                }
            } else if (choice == 'N' || choice == 'n') {
                System.out.println("PASSWORD CHANGED OPTION CANCELLED:");

            } else {
                System.out.println("ENTER VALID CHOICE");
            }
        }
        while (!flag);
    }

    public void setMailBoxCapacity() {
        System.out.println("Current Capacity is: " + this.mailCount + "mb");
        System.out.println("ENTER NEW CAPACITY: ");
        this.mailCount = sc.nextInt();
        System.out.println("CAPACITY CHANGED :)");
    }

    public void alterEmail() {
        System.out.println("Enter Alternate Email: ");
        this.alt_email = sc.next();
        System.out.println("Alternate Email Set Successfully");
    }

    public void info() {
        System.out.println("New: " + this.fname + " " + this.lname);
        System.out.println("Mail Capacity: " + this.mailCount);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Alternate Email: " + this.alt_email);
        System.out.println("Password: " + this.password);
    }

    public void storeFile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\ayush\\Desktop\\PROJECTS\\info.txt");
            in.write("First Name:" + this.fname);
            in.append("\nLast Name:" + this.lname);
            in.append("\nEmail:" + this.email);
            in.append("\nPassword:" + this.password);
            in.append("\nCapacity:" + this.mailCount);
            in.append("\nAlternate Email:" + this.alt_email);
            in.close();
            System.out.println("Data Stored....");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_File() {
        try {
            FileReader f1 = new FileReader("C:\\Users\\ayush\\Desktop\\PROJECTS\\info.txt");
            int i;
            while ((i = f1.read()) != 1) {
                System.out.println((char) i);
            }
            System.out.println();
            f1.close();

        } catch (Exception e) {

        }
    }

}
