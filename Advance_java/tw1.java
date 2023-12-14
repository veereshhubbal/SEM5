/*Write a menu driven Java program to read contents of a file and : 
a) print characters on the console – one character at a time 
b) print the entire file
c) print contents to another file. 
Read both source & target file names & check for their existence/ non – existence to take appropriate actions.
*/
import java.io.*;
import java.util.Scanner;

public class tw1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the name of the source file: ");
        String sourceFileName = scanner.nextLine();
        
        System.out.println("Enter the name of the target file (for option c): ");
        String targetFileName = scanner.nextLine();
        
        // Check if the source file exists
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }
        
        // Option menu
        System.out.println("Choose an operation:");
        System.out.println("a) Print characters on the console - one character at a time");
        System.out.println("b) Print the entire file");
        System.out.println("c) Print contents to another file");
        char choice = scanner.nextLine().charAt(0);
        
        switch (choice) {
            case 'a':
                printCharactersOneByOne(sourceFile);
                break;
            case 'b':
                printEntireFile(sourceFile);
                break;
            case 'c':
                copyFileContents(sourceFile, targetFileName);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void printCharactersOneByOne(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printEntireFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileContents(File sourceFile, String targetFileName) {
        try {
            File targetFile = new File(targetFileName);
            if (targetFile.exists()) {
                System.out.println("Target file already exists. Overwriting...");
            }

            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Contents copied to the target file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
