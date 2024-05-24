package lecture03;
import java.util.ArrayList;
import java.util.*;

public class StrBuild01 {
    public static void main(String[] args) {
        Character value = null;
        // List<Character> list1 = List.of("S", "e", "t", "r", "y"); // error 1
        List<Character> list1 = new ArrayList<Character>();
        list1.add("a"); 
        list1.add("g");
        list1.add("r");
        list1.add("w");
        list1.add("s");
        System.out.println(list1);
        // list1.remove(1);
        List<Character> list2 = List.copyOf(list1);
    }    
}
