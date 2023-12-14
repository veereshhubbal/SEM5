
import java.util.ArrayList;
import java.util.Scanner;

public class tw4 {
    private ArrayList<Integer> integerList;
    private ArrayList<Float> floatList;

    public tw4() {
        integerList = new ArrayList<>();
        floatList= new ArrayList<>(); 
        //Create an ArrayList object of type float
    }

    // Method to add elements to the integer ArrayList
    public void addElement(int element) {
        integerList.add(element);
    }

    // Method to add elements to the float ArrayList
    public void addElement(float element) {
        floatList.add(element);
    }

    // Method to remove elements from the integer ArrayList
    public void removeElement(int index) {
        if (index >= 0 && index < integerList.size()) {
            integerList.remove(index);
        } else {
            System.out.println("Invalid index for integer ArrayList!");
        }
    }

    // Method to remove elements from the float ArrayList
    public void removeElement(float element) {
        floatList.remove(element);
        //Remove element
    }

    // Method to perform linear search on the integer ArrayList
    public boolean linearSearch(int key) {
        return integerList.contains(key);
    }

    // Method to perform linear search on the float ArrayList
    public boolean linearSearch(float key) {
        return floatList.contains(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tw4 operations = new tw4();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add an integer element");
            System.out.println("2. Add a float element");
            System.out.println("3. Remove an integer element");
            System.out.println("4. Remove a float element");
            System.out.println("5. Search in integer ArrayList");
            System.out.println("6. Search in float ArrayList");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the integer to add in the list: ");
                    int intadd = scanner.nextInt();
                    operations.addElement(intadd);
                    break;
                case 2:
                    System.out.print("Enter the Float to add in the floatlist: ");
                    float floatadd = scanner.nextFloat();
                    operations.addElement(floatadd);
                    break;
                case 4:
                    System.out.print("Enter the element to remove from floatlist: ");
                    float ele = scanner.nextFloat();
                    operations.removeElement(ele);
                    break;
                case 3:
                    System.out.print("Enter the index to remove from intlist: ");
                    int ind = scanner.nextInt();
                    operations.removeElement(ind);
                    break;
                case 5:
                    System.out.print("Enter the key to search in the intlist: ");
                    int intSearchKey = scanner.nextInt();
                    //read int element to be seached and perform a linear Search(return boolean value)
                    System.out.println("Integer found: " + operations.linearSearch(intSearchKey));
                    break;
                case 6:
                    System.out.print("Enter the key to search in the floatlist: ");
                    float intSearchKe = scanner.nextFloat();
                    //read float element to be seached and perform a linear Search(return boolean value)
                    System.out.println("Float found: " + operations.linearSearch(intSearchKe));
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}



