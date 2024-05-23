package practice02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class program {
    public static void main(String[] args){
       FileReader fr = null;
        try {
        fr = new FileReader("M:\\Lessons-HW-Specialization\\Java-Basic_API\\practice02\\map.txt");
        System.out.println("Executed reading file code");
        int x = 2 / 0;
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        // throw new RuntimeException(e); // stops the program from executing
        System.out.println("Executed error reading file code");
    } catch (ArithmeticException e) {
    System.out.println("Devision by zero error");
    } finally {
        System.out.println("Finally");
        try {
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
    System.out.println("The rest of the code go on"); 

}
}
