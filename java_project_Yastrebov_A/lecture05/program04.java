package lecture05;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class program04 {
    public static void main(String[] args) {
        Map<Integer, String> table = new Hashtable<>();
        table.put(1, "два"); // null values inaplicable
        table.put(11, "один один");
        table.put(2, "один");
        System.out.println(table);
    }
}
