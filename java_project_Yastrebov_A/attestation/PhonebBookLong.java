package attestation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
// import java.util.TreeMap;
// import java.util.stream.Collectors;

public class PhonebBookLong {
    
    public static class PhoneBookEntry{
        private String lastName;
        private String firstName;
        private String middleName;
        private List<String> phoneNumber;

        public PhoneBookEntry (String lastName, String firstName, String middleName, List<String> phoneNumber){
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.phoneNumber = phoneNumber;
        }
        public String getFullName() {
            return lastName + " " + firstName + " " + middleName;
        }
        public List<String> getPhoneNumber() {
            return phoneNumber;
        }
        @Override
        public String toString(){
            return lastName + " " + firstName + " " + middleName + " " + String.join(", ", phoneNumber);
        }
    }


public static void main(String[] args) {
    String filename = "M:\\Lessons-HW-Specialization\\Java-Basic_API\\java_project_Yastrebov_A\\attestation\\initial_phonebook.txt";
    try {
        Map<String, List<Long>> phoneBookMap = readPhoneBookFromFile(filename);
        System.out.println("Phonebook before sorting: ");
        printPhoneBook(phoneBookMap);
        // Note: Phonebook is in English - so the order is sorted accordingly;
        sortPhoneBookByNumber(phoneBookMap);

        System.out.println("Phonebook after sorting: ");
        printPhoneBook(phoneBookMap);

    } catch (IOException e){
        System.err.println("Error reading file: " + e.getMessage());
    }
}

// hashmap method to read from phonebook file to fill in the hashMap
public static Map<String, List<Long>> readPhoneBookFromFile(String filename) throws IOException {
    Map<String, List<Long>> phoneBookMap = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
        String line;
        while ((line = reader.readLine())!= null){
            String[] parts = line.split (" ");
            if (parts.length == 4) {
                String fullName = parts [0]+ " " + parts[1] + " " + parts[2]; 
                String phoneNumber = parts[3];
                Long Number = Long.parseLong(parts[3]);

                phoneBookMap.computeIfAbsent(fullName, k -> new ArrayList<>()).add(phoneNumber);
            }
        }
    }
    return phoneBookMap;
}

public static Map<String, List<Long>> sortPhoneBookByNumber(Map<String, List<Long>> phoneBookMap) {
    // Преобразуем Map в список Map.Entry
    List<Map.Entry<String, List<Long>>> entryList = new ArrayList<>(phoneBookMap.entrySet());
    
    // Сортируем список с использованием Comparator, который сравнивает номера телефонов по длине
    entryList.sort(new Comparator<Map.Entry<String, List<Long>>>() {
        @Override
        public int compare(Map.Entry<String, List<Long>> entry1, Map.Entry<String, List<Long>> entry2) {
            return Integer.compare(entry1.getKey().length(), entry2.getKey().length());
        }
    });
    
    // Собираем отсортированные данные в LinkedHashMap для сохранения порядка
    Map<String, List<Long>> sortedPhoneBookMap = new LinkedHashMap<>();
    for (Map.Entry<String, List<Long>> entry : entryList) {
        sortedPhoneBookMap.put(entry.getKey(), entry.getValue());
    }
    
    return sortedPhoneBookMap;
}

public static void printPhoneBook(Map<String, List<Long>> phoneBookMap) {
    for (Map.Entry<String, List<Long>> entry : phoneBookMap.entrySet()) {
        String fullName = entry.getKey();
        List<Long> phoneNumbers = entry.getValue();
        System.out.println(fullName + ": " + phoneNumbers);
       
    }
}
}
