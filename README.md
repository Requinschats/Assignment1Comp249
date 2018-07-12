# Assignment1Comp249

/**
 * The Driver class will allow the telephone company to run the software application which they asked for.
 * A welcome message will first be used to introduce the markers to the assignment while a second will mark the beginning of the program.
 *
 * @author Myriam Tayah and Olivier Fradette-roy
 */

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);
    public static int choice;
    /**
     * The following lines will be used to initialize the password.
     */
    public final static String PASSWORD = "password";
    /**
     * The following lines will prompt the user to enter the maximum number of customers possible.
     * This number will be used to create an array which will hold the information about each customer.
     */
    public static int maxNumberOfCustomers = 1000;

    public static void promptMaxNumberOfCustomers() {
        out.print("Please enter the maximum number of customers the company can handle: ");
        maxNumberOfCustomers = keyboard.nextInt();
    }

    public static Customer[] userDatabase = new Customer[maxNumberOfCustomers];


    public static void promptMenu() {
        out.println();
        out.println("What do you want to do?");
        out.println("     1. Enter new customer (password required)");
        out.println("     2. Change information of a customer (password required)");
        out.println("     3. Display all customers resdiding on the same street");
        out.println("     4. Display all customers residing in the same city");
        out.println("     5. Quit");
        out.println();

        do {
            out.print("Please enter your choice > ");
            choice = keyboard.nextInt();
        }
        while (choice < 1 || choice > 5);
    }

    private static boolean passwordEntry() {
        int tries = 0;
        String passEntered;
        do {
            out.print("Please enter your password: ");
            passEntered = keyboard.next();
            if (passEntered.equals(PASSWORD)) {
                return true;
            } else {
                tries = tries + 1;
                out.println("Wrong Password");
            }
        } while (tries < 3);
        return false;
    }

    private static void enterNewCustomer() {

        out.print("How many customers do you wish to enter? ");
        int numberNewCustomers = keyboard.nextInt();
        // Checking for space in array of Customer
        int customerSpace = maxNumberOfCustomers - Customer.numberOfCreatedCustomers;
        if (customerSpace > 0)
            for (int i = 0; i < numberNewCustomers; i++) {
                out.println();
                out.println("New customer");
                out.print("Customer name: ");
                String cName = keyboard.next();
                int cStreetNum = -1;
                while (true) {
                    try {
                        out.print("Street Number: ");
                        cStreetNum = keyboard.nextInt();
                        break;
                    } catch (java.util.InputMismatchException e) {
                        out.println("You entered a String instead of a numerical value, please try again");
                        keyboard.next();
                        continue;
                    }
                }
                out.print("Street name: ");
                String cStreetName = keyboard.next();
                out.print("City: ");
                String cCity = keyboard.next();
                userDatabase[Customer.numberOfCreatedCustomers] = new Customer(cCity, cName, cStreetName, cStreetNum);
            }
        else {
            out.println("You may add a maximum of " + customerSpace + " customer(s) a this time.");
        }
    }

    public static void updateCustomer() {
        boolean reenterCustNumber = true;
        do {
            out.print("Please enter the number of the customer you wish to update: ");
            int custNum = keyboard.nextInt();
            if (custNum <= Customer.numberOfCreatedCustomers && custNum >= 0) {
                reenterCustNumber = false;
                out.println("Customer: # " + custNum);
                out.println(userDatabase[custNum].toString());
            } else {
                char tryNewCustNum;
                out.print("Error! Do you wish to try another customer number (Y capital for yes, anything else for no): ");
                tryNewCustNum = keyboard.next().charAt(0);
                if (tryNewCustNum == 'Y') {
                    reenterCustNumber = true;
                } else {
                    promptMenu();
                }
            }
        } while (reenterCustNumber);
    }

    private static void findCustomersByStreet() {
        out.print("What street are you looking for? ");
        String streetMenu = keyboard.next();

        for (int i = 0; i < Customer.numberOfCreatedCustomers; i++) {
            if (userDatabase[i].getStreetName().equalsIgnoreCase(streetMenu)) {
                out.println(userDatabase[i].toString());
            }
        }
    }

    private static void findCustomersFromCity() {

        out.print("What city are you looking for ? ");
        String cityMenu = keyboard.next();
        out.println();

        for (int i = 0; i < Customer.numberOfCreatedCustomers; i++) {
            if (userDatabase[i].getCity().equalsIgnoreCase(cityMenu)) {
                out.println(userDatabase[i].getName());
            }
        }
        out.println();
    }

    public static boolean keepGoingMenu() {

        out.print("Do you want to do another action in the menu ? (yes/no) ");
        Scanner scanner = new Scanner(System.in);
        String keepGoing = scanner.next().toLowerCase();

        if (keepGoing.equals("yes")) {
            return true;
        }
        return false;
    }

    public static void closingMessage() {
        out.println("This is the end of the program. Have a good day!");
    }

    public static void openingMessage() {
        // Assignment welcome message
        out.println("Welcome to the first assignment of Olivier and Myriam!");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

        // Program welcome message
        out.println("Welcome to the customer repertory!");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    private static int suspiciousActivities;
    /**
     * The following lines of code will allow the display of the main menu and will take a choice from the user.
     * It will make sure that the value entered is an integer between 1 and 5 inclusive.
     */
    /**
     * The following lines of code will check the choice made using a switch statement and will display the necessary output accordingly.
     */

    public static void main(String[] args) {

        openingMessage();

        promptMaxNumberOfCustomers();

        do {

            promptMenu();

            switch (choice) {
                case 1:
                    suspiciousActivities = 0;
                    do {
                        if (suspiciousActivities > 0) {
                            promptMenu();
                        }
                        suspiciousActivities = suspiciousActivities + 1;
                    } while (!passwordEntry() && suspiciousActivities != 3);

                    if (suspiciousActivities == 3) {
                        out.println("Program detected suspicious activities and will terminate immediately");
                        System.exit(0);
                    }
                    enterNewCustomer();
                    break;

                case 2: {
                    do {

                    } while (!passwordEntry());
                    updateCustomer();
                }
                break;

                case 3: {
                    findCustomersByStreet();
                }
                break;
                case 4:
                    findCustomersFromCity();
                    break;
                case 5:
                    closingMessage();
                    System.exit(0);
            }
        } while (keepGoingMenu());
        closingMessage();
    }

}








