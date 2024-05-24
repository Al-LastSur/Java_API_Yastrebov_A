package lecture05;

import java.util.HashMap;
import java.util.Map;

public class program01 {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<Integer, String>();
        db.putIfAbsent( 1, "один");
        db.put( 2, "два"); // values just rewritten
        db.put(null, "!null");
        System.out.println(db);
        System.out.println(db.get(44));
        // db.remove(null);
        System.out.println(db);
        System.out.println(db.containsValue("один"));
        System.out.println(db.containsKey(1));
        System.out.println(db.keySet());
        System.out.println(db.values());

    }
}
