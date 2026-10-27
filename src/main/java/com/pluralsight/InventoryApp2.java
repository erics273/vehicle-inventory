package com.pluralsight;

//we have to import the ArrayList
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryApp2 {

    public static void main(String[] args) {

        //create a scanner so we can ask the user some questions
        Scanner myScanner = new Scanner(System.in);

        //load our inventory
        ArrayList<Vehicle> inventory = getInventory();

        //display the main menu

        //create a variable to keep the menu looping
        boolean menuRunning = true;
        //loop the menu
        while (menuRunning) {

            //display the menu and store the selection
            int command = displayMainMenu(myScanner);

            switch (command) {

                case 1:
                    listAllInventory(inventory);
                    break;
                case 2:
                    listVehiclesByMakeModel(myScanner, inventory);
                    break;
                case 6:
                    menuRunning = false;
                    break;
                default:
                    System.out.println(" === Invalid command === Try again ===");

            }


        }



    }

    public static void listAllInventory(ArrayList<Vehicle> inventory) {
        //list all the vehicles
        for (Vehicle vehicle : inventory) {
            System.out.println("=== Vehicle Details ===");
            System.out.println(vehicle.getVehicleId());
            System.out.println(vehicle.getMakeModel());
            System.out.println("\n");
        }
    }

    public static void listVehiclesByMakeModel(Scanner myScanner,  ArrayList<Vehicle> inventory) {
        System.out.println("What make/model you are looking for?");
        String makeModelTheyAreLookingFor =  myScanner.nextLine();

        for(Vehicle vehicle : inventory) {

            if(vehicle.getMakeModel().equalsIgnoreCase(makeModelTheyAreLookingFor)) {
                System.out.println("=== Vehicle Details ===");
                System.out.println(vehicle.getVehicleId());
                System.out.println(vehicle.getMakeModel());
                System.out.println("\n");
            }

        }
    }

    public static int displayMainMenu(Scanner scanner) {
        //display the choices the user can choose from when working
        //with the inventory
        System.out.println("""
                What do you want to do?
                    1 - List all vehicles
                    2 - Search by make/model
                    3 - Search by price range
                    4 - Search by color
                    5 - Add a vehicle
                    6 - Quit
                Enter your command: """);

        //store the answer from this menu
        int menuSelection = scanner.nextInt();

        //eat the next line so we can switch from asking for numbers to strings gracefully
        scanner.nextLine();

        return menuSelection;
    }


    //method to get inventory
    public static ArrayList<Vehicle> getInventory() {

        //use an array list to store our inventory
        ArrayList<Vehicle> inventory = new ArrayList<>();

        //create some vehicles
        //create 6 vehicles and put them in the array
        Vehicle vehicle1 = new Vehicle(123, "Maza Miata", "green", 175000, 32000.57);
        Vehicle vehicle2 = new Vehicle(456, "Ford Mustang", "red", 85000, 28500.00);
        Vehicle vehicle3 = new Vehicle(789, "Honda Civic", "blue", 62000, 21999.99);
        Vehicle vehicle4 = new Vehicle(321, "Jeep Wrangler", "black", 94000, 34750.50);
        Vehicle vehicle5 = new Vehicle(654, "Toyota Corolla", "silver", 48000, 23500.00);
        Vehicle vehicle6 = new Vehicle(987, "Toyota Camry", "white", 71000, 26750.25);
        Vehicle vehicle7 = new Vehicle(555, "Dodge Ram", "black", 66000, 85000);

        //get the vehicles i created into my inventory
        inventory.add(vehicle1);
        inventory.add(vehicle2);
        inventory.add(vehicle3);
        inventory.add(vehicle4);
        inventory.add(vehicle5);
        inventory.add(vehicle6);

        return inventory;

    }

}
