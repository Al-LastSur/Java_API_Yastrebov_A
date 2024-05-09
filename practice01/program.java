package practice01;// initialized folder as package??

// // task1
// // set up the  project, output Hello World to the terminal
// // output system date and time to the terminal

import java.util.Arrays;
import java.util.stream.Stream;

// import java.time.LocalDateTime;

// public class program{

//     public static void main(String[] args) {
//         // System.out.println("Hello, World!");
//         System.out.println(LocalDateTime.now());
//     }
// }

// //  task2
// // the program ask the user to input the name and output the greatings message
// import java.util.Scanner;
// public class program{
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         String name = scanner.nextLine();
//         System.out.println("Hello, " + name+  "!"); // russian language is not readable
//         scanner.close();
//     }
// }

// // task 2.1 combine tasks 2 and 1. 
// // show time inside the greating message
// import java.time.LocalTime;
// import java.util.Scanner;

// public class program{
//     public static void main(String[] args) {
//         while (true) {
//             time();
// }
// public static void time(){
//     Scanner scanner = new Scanner(System.in);
//     String name = scanner.nextLine();
//     LocalTime current_time = LocalTime.now();
//     if (current_time >= "23:00" && current_time <= "04:59") {
//         System.out.println("Доброй ночи, " + name + "!");           
//     }
//     else if (current_time >= "05:00" && current_time <= "11:59") {
//         System.out.println("Доброе утро, " + name + "!");
//     }
//     else if (current_time >= "12:00" && current_time <= "17:59") {
//         System.out.println("Добрый день, " + name + "!");           
//     }
//     else if (current_time >= "18:00" && current_time <= "22:59"){
//         System.out.println("Добрый вечер, " + name + "!");
//     }
//     scanner.close();
// System.exit(-1); // comparison is not working
// }
// }

// // task3. get an array and output the suim of elements

// public class program{
//     public static void main(String[] args) {
//         int[] arr = {1,4,5,9,8,11,25,69};
//         int[] arr1 = new int[] {1,4,5,9,8,11,25,69}; // alternative way to setup an array
//         int[] arr2 = new int[5];  // to set up an array with definite length NB - Arrays are not flexible in Java
//         System.out.println(Arrays.toString(arr1));
//         arr1 [2] = 10;
//         System.out.println(Arrays.toString(arr1));
//         int sum = 0;      
//         for (int i = 0; i < arr1.length; i++)
//         {

//             sum +=arr1[i];
//         }
//         System.out.println(sum);
//     }
// }

// task4. replace words in line so the first is the last ...

public class program {
    public static void main(String[] args) {
        String str = "Welcome to the Course on Java";
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            String temp = arr[i];
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}