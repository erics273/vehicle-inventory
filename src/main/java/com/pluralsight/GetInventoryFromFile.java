package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GetInventoryFromFile {

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

        try {

            BufferedReader theInventoryFile = new BufferedReader(new FileReader("carsihave.csv"));

            //create a variable that represents each line
            String theCar;
            //loop over the file and assign each line to the line variable until we run out of lines and get null
            while((theCar = theInventoryFile.readLine()) != null) {
                //give me all the car parts for each line in the csv
                String[] theCarPars = theCar.split("\\|");

                //create variables for all the parts
                long vehicleId = Long.parseLong(theCarPars[0]);
                String makeModel = theCarPars[1];
                String color = theCarPars[2];
                int odometer = Integer.parseInt(theCarPars[3]);
                double price = Double.parseDouble(theCarPars[4]);

                //create the actual car from the data in the csv line
                Vehicle theNewCar = new Vehicle(vehicleId, makeModel, color, odometer, price);

                //add to the inventory
                inventory.add(theNewCar);

            }


        }catch (Exception e) {

            System.out.println(" === Invalid inventory file === Try again ===");

        }


        //return the inventory
        return inventory;

    }

}
