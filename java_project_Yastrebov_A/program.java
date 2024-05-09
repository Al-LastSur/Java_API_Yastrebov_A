// public class program {
//     public static void main(String[] args) {
//         String s = "gavgav";
//         float e = 2.7f; // reqired to polace f at the end of the number to convert double into float
//         double d = 123.45D; // not compulsory to use D at the end but it makes it clear to use double type of a number
//         char g = 123; // if u put a number so it will transform into char with this index in a table
//         boolean b = true && false; // keep in mind the table of truth values
//         String msg = "Hello world!";
//         System.out.println("buy world!");

//         var i = 123; // type is made automatically?
//         System.out.println(getType(i));// shows the type of variable
//     }
//     static String getType(Object o) {
//     return o.getClass().getSimpleName();
//     }

// }
   //gat data from terminal
//    import java.util.Scanner;
//    public class program {
//       public static void main(String[] args){ 
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("name: ");
//         String name = iScanner.nextLine();
//         System.out.printf("Hello, %s!", name);
//         iScanner.close();
//       }

//    }

   
//    import java.util.Scanner;
//    public class program {
//       public static void main(String[] args){ 
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("int a: ");
//         int x = iScanner.nextInt(); // to get int number from the terminal
//         System.out.printf("double a: ");
//         double y = iScanner.nextDouble(); // to get double number
//         System.out.printf("%d + %f = %f", x, y, x + y);
//         iScanner.close();
//       }

//    }

// to work with files
import java.io.FileWriter;
import java.io.IOException;
public class program {
   public static void main(String[] args) {
      try (FileWriter fw = new FileWriter ("file.txt", false)){
         fw.write ("line 1");
         fw.append (" \n ");
         fw.append (" 2 ");
         fw.append (" \n ");
         fw.write (" line 3 ");
         fw.flush ();
      } catch (IOException ex)  // check for exception to work witth files
      {
         System.out.println(ex.getMessage());
      }
   }
}
