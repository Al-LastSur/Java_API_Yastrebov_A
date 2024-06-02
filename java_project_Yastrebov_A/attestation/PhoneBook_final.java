package attestation;


// Initial_PhoneBook.txt
// Ivanov Ivan Ivannovich 87071475599
// Lobov Viktor Dmitrievich 87479895561
// Garina Diana Sultanovna 89477891255
// Marion Daniil Aleksandrovich 87479974598
// Afanasiev Dmitriy Semyonovic 87986631202
// Ivanov Ivan Serrgeyevich 87478985145
// Bassova Zhanna Alimovna 87001205587
// Marion Daniil Aleksandrovich 87172997598
// Garina Diana Sultanovna 84957791805
// Lobov Oleg Dmitrievich 87576125597

// Sorted_PhoneBook.txt
// Garina Diana Sultanovna 89477891255
// Afanasiev Dmitriy Semyonovic 87986631202
// Lobov Oleg Dmitrievich 87576125597
// Marion Daniil Aleksandrovich 87479974598
// Lobov Viktor Dmitrievich 87479895561
// Ivanov Ivan Serrgeyevich 87478985145
// Marion Daniil Aleksandrovich 87172997598
// Ivanov Ivan Ivannovich 87071475599
// Bassova Zhanna Alimovna 87001205587
// Garina Diana Sultanovna 84957791805

// imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
// import java.util.List;
// import java.util.Map;

public class PhoneBook_final {
    public static class PhoneBookEntry{
        private String lastName; // identify separately lastname
        private String firstName; // identify first name
        private String middleName; // identfy middlename
        private List<Long> phoneNumber; // identify number as the List of string numbers

        public PhoneBookEntry (String lastName, String firstName, String middleName, List<Long> phoneNumber){
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.phoneNumber = phoneNumber;
        }
        public String getFullName() {
            return lastName + " " + firstName + " " + middleName;
        }
        public List<Long> getPhoneNumber() {
            return phoneNumber;
        }
    }

    public static void printPhoneBook(Map<String, List<Long>> phoneBookMap) {
        for (Map.Entry<String, List<Long>> entry : phoneBookMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

                   }
    }

    public static Map<String, List<Long>> readPhoneBookFromFile(String filename) throws IOException {
        Map<String, List<Long>> phoneBookMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine())!= null){
                String[] parts = line.split (" ");
                if (parts.length == 4) {
                    String fullName = parts [0]+ " " + parts[1] + " " + parts[2];
                    List<Long> phoneNumber = Arrays.asList(Long.parseLong(parts[3])); 
                    

                    if (fullName !=null){
                         phoneBookMap.put(fullName, phoneNumber);
                    }

                }
            }
        }
        return phoneBookMap;

    }

    // public static Map<String, List<Long>> sortPhoneBookByNumber(Map<String, List<Long>> phoneBookMap) {
    //         // Преобразуем Map в список Map.Entry
    //         List<Map.Entry<String, List<Long>>> entryList = new ArrayList<>(phoneBookMap.entrySet());
            
    //         // Сортируем список с использованием Comparator, который сравнивает номера телефонов по длине
    //         entryList.sort(new Comparator<Map.Entry<String, List<Long>>>() {
    //             @Override
    //             public int compare(Map.Entry<String, List<Long>> entry1, Map.Entry<String, List<Long>> entry2) {
    //                 return Long.compare(entry1.getValue().size(), entry2.getValue().size());
    //                                 }
    //         });
            
    //         // Собираем отсортированные данные в LinkedHashMap для сохранения порядка
    //         Map<String, List<Long>> sortedPhoneBookMap = new LinkedHashMap<>();
    //         for (Map.Entry<String, List<Long>> entry : entryList) {
    //             sortedPhoneBookMap.put(entry.getKey(), entry.getValue());

    //         }
            
    //         return sortedPhoneBookMap;
    //     }



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
            String filename = "M:\\Lessons-HW-Specialization\\Java-Basic_API\\java_project_Yastrebov_A\\attestation\\initial_phonebook.txt";
    
            try {
                // Map<String, List<String>> phoneBookMap = readPhoneBookFromFile(filename);
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


}
