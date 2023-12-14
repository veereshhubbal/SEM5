/*
Write a menu-driven Java Program to create a HashMap to store key-value pairs of login credentials. The menu options to be provided are for : adding a key-value pair, retrieve the “value” for a given “key” (first check if the specified key is present),  retrieve all the keys, retrieve all the values, retrieve all the key-value pairs, change the value associated with a key in a HashMap, remove a HashMap element given the key, remove a HashMap entry with Key and Value, check if a given “value” exists in the Hashmap and display the HashMap. Read user input where required and display suitable error messages where applicable.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static private Map<String, String> credentials = new HashMap<>();
    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n----- Hash Map Menu -----");
            System.out.println("1. Add a key-value pair");
            System.out.println("2. Retrieve the value for a given key");
            System.out.println("3. Retrieve all keys");
            System.out.println("4. Retrieve all values");
            System.out.println("5. Retrieve all key-value pairs");
            System.out.println("6. Change the value associated with a key");
            System.out.println("7. Remove a HashMap element given the key");
            System.out.println("8. Remove a HashMap entry with Key and Value");
            System.out.println("9. Check if a given value exists in the HashMap");
            System.out.println("10. Display the HashMap");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addKeyValuePair();
                    break;
                case 2:
                    retrieveValueForKey();
                    break;
                case 3:
                    retrieveAllKeys();
                    break;
                case 4:
                    retrieveAllValues();
                    break;
                case 5:
                    retrieveAllKeyValuePairs();
                    break;
                case 6:
                    changeValueForKey();
                    break;
                case 7:
                    removeElementByKey();
                    break;
                case 8:
                    removeEntryByKeyAndValue();
                    break;
                case 9:
                    checkValueExistence();
                    break;
                case 10:
                    displayHashMap();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

    private static void addKeyValuePair() {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        System.out.print("Enter value: ");
        String value = scanner.nextLine();

        credentials.put(key, value);
        System.out.println("Key-value pair added successfully.");
    }

    private static void retrieveValueForKey() {
        System.out.print("Enter key to retrieve value: ");
        String key = scanner.nextLine();

        if (credentials.containsKey(key)) {
            String value = credentials.get(key);
            System.out.println("Value for key '" + key + "' : " + value);
        } else {
            System.out.println("Key not found!");
        }
    }

    private static void retrieveAllKeys() {
        Set<String> keys = credentials.keySet();
        System.out.println("Keys in the HashMap: " + keys);
    }

    private static void retrieveAllValues() {
        System.out.println("Values in the HashMap: " + credentials.values());
    }

    private static void retrieveAllKeyValuePairs() {
        Set<Map.Entry<String, String>> keyValuePairs = credentials.entrySet();
        System.out.println("Key-Value pairs in the HashMap: " + keyValuePairs);
    }

    private static void changeValueForKey() {
        System.out.print("Enter key to change its value: ");
        String key = scanner.nextLine();

        if (credentials.containsKey(key)) {
            System.out.print("Enter new value: ");
            String newValue = scanner.nextLine();

            credentials.put(key, newValue);
            System.out.println("Value for key '" + key + "' changed successfully.");
        } else {
            System.out.println("Key not found!");
        }
    }

    private static void removeElementByKey() {
        System.out.print("Enter key to remove: ");
        String key = scanner.nextLine();

        if (credentials.containsKey(key)) {
            credentials.remove(key);
            System.out.println("Key-value pair removed successfully.");
        } else {
            System.out.println("Key not found!");
        }
    }

    private static void removeEntryByKeyAndValue() {
        System.out.print("Enter key to remove: ");
        String key = scanner.nextLine();
        System.out.print("Enter value to remove: ");
        String value = scanner.nextLine();

        boolean removed = credentials.entrySet().removeIf(entry -> entry.getKey().equals(key) && entry.getValue().equals(value));
        if (removed) {
            System.out.println("Key-value pair removed successfully.");
        } else {
            System.out.println("Key-value pair not found!");
        }
    }

    private static void checkValueExistence() {
        System.out.print("Enter value to check its existence: ");
        String value = scanner.nextLine();

        if (credentials.containsValue(value)) {
            System.out.println("Value '" + value + "' exists in the HashMap.");
        } else {
            System.out.println("Value '" + value + "' does not exist in the HashMap.");
        }
    }

    private static void displayHashMap() {
        System.out.println("HashMap contents: " + credentials);
    }
}