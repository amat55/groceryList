package com.company.ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class mainForGroceryStore {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryStore groceryStore = new GroceryStore();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstruction();
        while (!quit) {
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryStore.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    findItem();
                    break;
                case 6:
                    progressArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstruction() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - to quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryStore.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter item number: ");
        String itemNo = scanner.nextLine();

        String newItem = scanner.nextLine();
        groceryStore.modifyGroceryList(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item number");
        String itemNo = scanner.nextLine();
        groceryStore.removeGroceryList(itemNo);
    }

    public static void findItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryStore.onFile(searchItem)) {
            System.out.println(searchItem + " has been found on grocery list");
        } else
            System.out.println(searchItem + " hasn't been found on grocery list");
    }

    public static void progressArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryStore.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryStore.getGroceryList());

        String[] myArray = new String[groceryStore.getGroceryList().size()];
        myArray = groceryStore.getGroceryList().toArray(myArray);
    }
}
