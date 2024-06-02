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
// import java.io.File;
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
// import java.util.List;
// import java.util.Map;

public class PhoneBook_task {
    public static class PhoneBookEntry{
        private String lastName; // identify separately lastname
        private String firstName; // identify first name
        private String middleName; // identfy middlename
        private List<String> phoneNumber; // identify number as the List of string numbers

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
            // Map<String, List<String>> phoneBookMap = readPhoneBookFromFile(filename);
            Map<String, String> phoneBookMap = readPhoneBookFromFile(filename);
            System.out.println("Phonebook before sorting: ");
            printPhoneBook(phoneBookMap);
            // Note: Phonebook is in English - so the order is sorted accordingly;

            System.out.println("Phonebook after sorting: ");

            printPhoneBook(sortPhoneBookByNumber(phoneBookMap));
    
        } catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }



    public static void printPhoneBook(Map<String, String> phoneBookMap) {
        for (Map.Entry<String, String> entry : phoneBookMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

                   }
    }


        public static Map<String, String> readPhoneBookFromFile(String filename) throws IOException {
            Map<String, String> phoneBookMap = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
                while ((line = reader.readLine())!= null){
                    String[] parts = line.split (" ");
                    if (parts.length == 4) {
                        String fullName = parts [0]+ " " + parts[1] + " " + parts[2]; 
                        String phoneNumber = parts[3];
                        if (fullName !=null){
                             phoneBookMap.put(fullName, phoneNumber);
                        }
                       
                        // addValueToMap(multiValueMap, fullName, phoneNumber);
                    }
                }
            }
            return phoneBookMap;
            // still cant make it take two or more values to one key
        }
    
        //      public static Map<String, String> sortPhoneBookByNumber(Map<String, String> phoneBookMap){
        //         Map<String, String> sortedPhoneBookMap = new HashMap<String, String>();
        //     for(Map.Entry<String, String> entry : phoneBookMap.entrySet()) {
        //         String key = entry.getKey();
        //         String value = entry.getValue();
        //         sortedPhoneBookMap.put(value, key);

        //     }
            
        //     return sortedPhoneBookMap;
        // }


        // sort from the smallest to the biggest
        // public static Map<String, String> sortPhoneBookByNumber(Map<String, String> phoneBookMap) {
        //     // Преобразуем Map в список Map.Entry
        //     List<Map.Entry<String, String>> entryList = new ArrayList<>(phoneBookMap.entrySet());
            
        //     // Сортируем список с использованием Comparator, который сравнивает номера телефонов по длине
        //     entryList.sort(new Comparator<Map.Entry<String, String>>() {
        //         @Override
        //         public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) {
        //             return Integer.compare(entry1.getKey().length(), entry2.getKey().length());
        //         }
        //     });
            
        //     // Собираем отсортированные данные в LinkedHashMap для сохранения порядка
        //     Map<String, String> sortedPhoneBookMap = new LinkedHashMap<>();
        //     for (Map.Entry<String, String> entry : entryList) {
        //         sortedPhoneBookMap.put(entry.getKey(), entry.getValue());
        //     }
            
        //     return sortedPhoneBookMap;
        // }
        public static Map<String, String> sortPhoneBookByNumber(Map<String, String> phoneBookMap) {
        // Преобразуем Map в список Map.Entry
        List<Map.Entry<String, String>> entryList = new ArrayList<>(phoneBookMap.entrySet());
        
        // Сортируем список с использованием Comparator, который сравнивает номера телефонов в обратном порядке
        entryList.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) {
                return entry2.getKey().compareTo(entry1.getKey()); // Сравнение в обратном порядке
            }
        });
        
        // Собираем отсортированные данные в LinkedHashMap для сохранения порядка
        Map<String, String> sortedPhoneBookMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : entryList) {
            sortedPhoneBookMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedPhoneBookMap;
    }


    
        // public static void main(String[] args) {
        //     Map<String, String> phoneBookMap = new HashMap<>();
        //     phoneBookMap.put("123", "Alice");
        //     phoneBookMap.put("45678", "Bob");
        //     phoneBookMap.put("12345", "Charlie");
        //     phoneBookMap.put("123456789", "Dave");
        //     phoneBookMap.put("12", "Eve");
    
        //     Map<String, String> sortedPhoneBookMap = sortPhoneBookByNumber(phoneBookMap);
    
        //     for (Map.Entry<String, String> entry : sortedPhoneBookMap.entrySet()) {
        //         System.out.println("Phone Number: " + entry.getKey() + ", Name: " + entry.getValue());
        //     }
        // }



     }
        
        

        

                

