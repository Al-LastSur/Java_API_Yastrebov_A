package lecture03;
import java.util.Arrays;
import java.util.List;

public class Collection01 {
    public static void main(String[] args) {
        int day = 29;
        int month = 9;
        int year = 1990;
        Integer[] date = {day, month, year};
        List<Integer> d = Arrays.asList(date);
        System.out.println(d);
    }
}
