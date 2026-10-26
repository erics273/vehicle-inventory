package com.pluralsight;

import java.util.Scanner;

public class VehicleInventoryApp {

    static int numberOfVehiclesInInventory = 0;

    public static void main(String[] args) {

        //create a scanner
        Scanner scanner = new Scanner(System.in);

        //create an array capable of holding up to 20 vehicles
        Vehicle[] inventory = new Vehicle[20];

        //create 6 vehicles and put them in the array
        Vehicle vehicle1 = new Vehicle(123, "Miata", "green", 175000, 32000.57);
        Vehicle vehicle2 = new Vehicle(456, "Mustang", "red", 85000, 28500.00);
        Vehicle vehicle3 = new Vehicle(789, "Civic", "blue", 62000, 21999.99);
        Vehicle vehicle4 = new Vehicle(321, "Wrangler", "black", 94000, 34750.50);
        Vehicle vehicle5 = new Vehicle(654, "Corolla", "silver", 48000, 23500.00);
        Vehicle vehicle6 = new Vehicle(987, "Camry", "white", 71000, 26750.25);

        inventory[0] = vehicle1;
        inventory[1] = vehicle2;
        inventory[2] = vehicle3;
        inventory[3] = vehicle4;
        inventory[4] = vehicle5;
        inventory[5] = vehicle6;

        numberOfVehiclesInInventory = 6;

        //create a loop with this menu in the loop
        /*
        What do you want to do?
        1 - List all vehicles
        2 - Search by make/model
        3 - Search by price range
        4 - Search by color
        5 - Add a vehicle
        6 - Quit
        Enter your command:
         */

        //focus on menu items 1, 2, and 5
        boolean appRunning = true;
        while (appRunning) {

            //create the menu
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.println("Enter your command: ");

            //store the answer
            int command = scanner.nextInt();

            //do something based on the answer
            switch (command) {
                case 1 -> listAllVehicles(inventory);
                case 2 -> searchByModel(scanner, inventory);
                case 5 -> addVehicle(scanner, inventory);
                case 6 -> appRunning = false;
                default -> System.out.println("Invalid command");
            }

        }

    }

    //list all the vehicles
    public static void listAllVehicles(Vehicle[] inventory) {
        for(int i = 0; i < numberOfVehiclesInInventory; i++) {
            System.out.println("make : " + inventory[i].getMakeModel());
        }
    }

    //searchByColor
    public static void searchByModel(Scanner theScanner, Vehicle[] inventory) {

        //ask for the make model
        System.out.println("Please enter the make: ");
        String makeModel = theScanner.nextLine();

        for(int i = 0; i < numberOfVehiclesInInventory; i++) {
            if(inventory[i].getMakeModel().equals(makeModel)) {
                System.out.println("make : " + inventory[i].getMakeModel());
            }
        }
    }

    public static void addVehicle(Scanner theScanner, Vehicle[] inventory) {

        //ask all the questions
        System.out.println("Please enter the vehicle's id: ");
        int id = theScanner.nextInt();

        //eat the newline
        theScanner.nextLine();

        System.out.println("Please enter the make: ");
        String makeModel = theScanner.nextLine();
        System.out.println("Please enter the color: ");
        String color = theScanner.nextLine();
        System.out.println("Please enter the odometer reading: ");
        int odometerReading = theScanner.nextInt();
        System.out.println("Please enter the price: ");
        double price = theScanner.nextDouble();

        //create the vehicle
        Vehicle newVehicle = new Vehicle(id, makeModel, color, odometerReading, price);

        //add it to the last open spot in the ivnetory
        inventory[numberOfVehiclesInInventory] = newVehicle;

        //you have to deal with the inventory count
        numberOfVehiclesInInventory++;
    }

}
