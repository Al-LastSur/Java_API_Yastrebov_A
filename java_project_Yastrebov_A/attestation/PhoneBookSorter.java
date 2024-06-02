package attestation;
import java.util.*;

public class PhoneBookSorter {

    public static Map<String, List<Long>> sortPhoneBookByNumber(Map<String, List<Long>> phoneBookMap) {
        // Преобразуем Map в список Map.Entry
        List<Map.Entry<String, List<Long>>> entryList = new ArrayList<>(phoneBookMap.entrySet());

        // Сортируем телефонные номера в каждой записи по убыванию
        for (Map.Entry<String, List<Long>> entry : entryList) {
            entry.getValue().sort(Comparator.reverseOrder());
        }

        // Сортируем список с использованием Comparator, который сравнивает количество номеров по убыванию
        entryList.sort(new Comparator<Map.Entry<String, List<Long>>>() {
            @Override
            public int compare(Map.Entry<String, List<Long>> entry1, Map.Entry<String, List<Long>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });

        // Собираем отсортированные данные в LinkedHashMap для сохранения порядка
        Map<String, List<Long>> sortedPhoneBookMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<Long>> entry : entryList) {
            sortedPhoneBookMap.put(entry.getKey(), entry.getValue());
        }

        return sortedPhoneBookMap;
    }

    public static void main(String[] args) {
        // Пример использования
        Map<String, List<Long>> phoneBookMap = new HashMap<>();
        phoneBookMap.put("Alice", Arrays.asList(1234567890L, 9876543210L));
        phoneBookMap.put("Bob", Arrays.asList(5555555555L));
        phoneBookMap.put("Charlie", Arrays.asList(1111111111L, 2222222222L, 3333333333L));

        Map<String, List<Long>> sortedPhoneBookMap = sortPhoneBookByNumber(phoneBookMap);

        for (Map.Entry<String, List<Long>> entry : sortedPhoneBookMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}