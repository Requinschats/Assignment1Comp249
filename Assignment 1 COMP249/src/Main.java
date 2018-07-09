/**
 * The Driver class will allow the telephone company to run the software application which they asked for.
 * A welcome message will first be used to introduce the markers to the assignment while a second will mark the beginning of the program.
 *
 * @author Myriam Tayah and Olivier Fradette-roy
 */

import java.util.Scanner;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);
    public static int choice;

    public static void promptMenu() {
        do {
            System.out.println("What do you want to do?");
            System.out.println("     1. Enter new customer (password required)");
            System.out.println("     2. Change information of a customer (password required)");
            System.out.println("     3. Display all customers resdiding on the same street");
            System.out.println("     4. Display all customers residing in the same city");
            System.out.println("     5. Quit");

            do {
                System.out.print("Please enter your choice > ");
                choice = keyboard.nextInt();
            }
            while (choice < 1 || choice > 5);
        }
    }

    public static boolean passwordEntry() {
        int tries = 0;

        do {
            System.out.print("Please enter your password: ");
            passEntered = keyboard.next();
            if (passEntered.equals(PASSWORD)) {
                return true;
            } else {
                tries = tries + 1;
            }

        } while (tries < 3);

        return false;
    }
    public static void enterNewCustomer() {

        System.out.print("How many customers do you wish to enter? ");
        int numberNewCustomers = keyboard.nextInt();
        // Checking for space in array of Customer
        int customerSpace = maxNumberOfCustomers - Customer.numberOfCreatedCustomers;
        if (customerSpace > 0)
            for (int i = 0; i < numberNewCustomers; i++) {
                System.out.print("Customer name: ");
                String cName = keyboard.next();
                System.out.print("Street Number: ");
                int cStreetNum = keyboard.nextInt();
                System.out.print("Street name: ");
                String cStreetName = keyboard.next();
                System.out.print("City: ");
                String cCity = keyboard.next();
                userDatabase[Customer.numberOfCreatedCustomers + i + 1] = new Customer(cCity, cName, cStreetName, cStreetNum);
            }
        else {
            System.out.println("You may add a maximum of " + customerSpace + " customer(s) a this time.");
        }
    }

    public static void main(String[] args) {

        // Implementing the scanner
        Scanner keyboard = new Scanner(System.in);

        // Assignment welcome message
        System.out.println("Welcome to the first assignment of Olivier and Myriam!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // Program welcome message
        System.out.println("Welcome to the customer repertory!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        /**
         * The following lines will be used to initialize the password.
         */
        final String PASSWORD = "password";
        /**
         * The following lines will prompt the user to enter the maximum number of customers possible.
         * This number will be used to create an array which will hold the information about each customer.
         */
        int maxNumberOfCustomers;

        System.out.print("Please enter the maximum number of customers the company can handle: ");
        maxNumberOfCustomers = keyboard.nextInt();

        Customer[] userDatabase = new Customer[maxNumberOfCustomers];

        /**
         * The following lines of code will allow the display of the main menu and will take a choice from the user.
         * It will make sure that the value entered is an integer between 1 and 5 inclusive.
         */


        /**
         * The following lines of code will check the choice made using a switch statement and will display the necessary output accordingly.
         */




        promptMenu();

        switch (choice) {
            case 1:
                int suspiciousActivities = 0;
                do {
                    if (suspiciousActivities!=0) {
                        promptMenu();
                    }
                    passwordEntry();
                    suspiciousActivities = suspiciousActivities + 1;
                } while (!passwordEntry() && suspiciousActivities != 3);

                if (suspiciousActivities == 3) {
                    System.out.println("Program detected suspicious activities and will terminate immediately");
                    System.exit(0);
                }
               enterNewCustomer();
                break;





                case 2: {
                boolean reenterCustNumber = true;
                do {
                    System.out.print("Please enter the number of the customer you wish to update: ");
                    int custNum = keyboard.nextInt();
                    if (custNum <= Customer.numberOfCreatedCustomers && custNum >= 0) {
                        reenterCustNumber = false;
                        System.out.println("Customer: # " + custNum);
                        System.out.println(userDatabase[custNum].toString());
                    } else {
                        char tryNewCustNum;
                        System.out.print("Error! Do you wish to try another customer number (Y capital for yes, anything else for no): ");
                        tryNewCustNum = keyboard.next().charAt(0);
                        if (tryNewCustNum == 'Y')
                            reenterCustNumber = true;
                        else
                            menuReps--;
                    }


                }
            }

            case 3:

        }
    }


        keyboard.close();

}

}
