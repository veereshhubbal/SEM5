


/*Write a Java Program to demonstrate the implementation of stream classes in Java. Assume that an input file named "input.txt" already exists with few lines of random text. Accept a filename from the user, this will be the destination file. 

Write a menu driven program to do the following: 
1) Transfer the contents of the input file to the destination file using the ByteArrayInputStream /ByteArrayInputStream class 
3) Display the contents of the destination file.

*/

i
import java.io.*;

public class tw2{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputFileName = "input.txt"; // Assume the input file is named "input.txt"
            
            System.out.println("Enter the destination file name: ");
            String outputFileName = br.readLine();
            
            // Menu-driven options
            System.out.println("Choose an operation:");
            System.out.println("1) Transfer the contents of the input file to the destination file");
            System.out.println("2) Display the contents of the destination file");
            int choice = Integer.parseInt(br.readLine());
            
            switch (choice) {
                case 1:
                    transferContents(inputFileName, outputFileName);
                    System.out.println("Contents transferred successfully.");
                    break;
                case 2:
                    displayContents(outputFileName);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transferContents(String inputFileName, String outputFileName) {
        try(FileInputStream input=new FileInputStream(inputFileName);
            FileOutputStream output=new FileOutputStream(outputFileName)){
                byte[] buffer=new byte[1024];
                int bytesRead;
                while((bytesRead=input.read((buffer)))!=-1){
                    output.write(buffer,0,bytesRead);
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }

    }

    private static void displayContents(String outputFileName) {
        try(FileInputStream input=new FileInputStream(outputFileName);
        ByteArrayOutputStream output=new ByteArrayOutputStream()){
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=input.read(buffer))!=-1){
                output.write(buffer, 0, bytesRead);
            }

        }
        catch(IOException e){
                e.printStackTrace();
            }
        
    }
}