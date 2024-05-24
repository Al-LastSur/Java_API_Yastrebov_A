package lecture05;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class program03 {
    public static void main(String[] args) {
        Map<Integer, String> linkmap = new LinkedHashMap<>();
        linkmap.put(11, "один один");
        linkmap.put(1, "два");
        linkmap.put(2, "один");
        System.out.println(linkmap);
        Map<Integer, String>map = new HashMap<>();
        map.put (11, "один один");
        map.put (2, "два");
        map.put (1, "один");
        System.out.println(map);
    }
}
