package lecture03;
import java.util.ArrayList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(123);
        // list.add ("string line"); won't work because the tipe is set
        for (Object o : list) {
            System.out.println(o);
    }
}
}
