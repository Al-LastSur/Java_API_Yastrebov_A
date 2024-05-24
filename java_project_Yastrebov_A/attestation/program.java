package attestation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import attestation.PhoneBookEntry;

public class program {
    public static void main(String[] args) {
    //    works only woth full address to the file
        String filename = "M:\\Lessons-HW-Specialization\\Java-Basic_API\\java_project_Yastrebov_A\\attestation\\initial_phonebook.txt"; 
       
       try {
        List<PhoneBookEntry> phoneBookEntries = readPhoneBookFromFile(filename);
        System.out.println("Phonebook before sorting: ");;
        printPhoneBook(phoneBookEntries);
        // Note: Phonebook is in English - so the order is sorted accordingly;
        sortPhonebook(phoneBookEntries);

        System.out.println("\nPhonebook after sorting: ");
        printPhoneBook(phoneBookEntries);
       } catch (IOException e) {
        System.out.println("Error reading phonebook" + e.getMessage());
       }
       
    //     // optional to see the initial phonebook in a terminal
    //    try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
    //     String line;
    //     while ((line = reader.readLine())!= null){
    //         System.out.println(line);
    //     }
    //    } catch (IOException e) {
    //     System.err.println("Error reading file: " + e.getMessage());
    //    }
       

    }
    public static List<PhoneBookEntry> readPhoneBookFromFile (String filename) throws IOException {
        List<PhoneBookEntry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine())!= null){
                String[] parts = line.split (" ");
                if (parts.length == 4) {
                    entries.add(new PhoneBookEntry(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        }
     return entries;  
}

// method to sort phonobook entries by lastname, firstname and middlename
public static void sortPhonebook(List<PhoneBookEntry> entries){
    Collections.sort(entries, new Comparator<PhoneBookEntry>() {
        @Override
        public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
           int lastNameComparison = o1.getLastName().compareTo(o2.getLastName());
           if (lastNameComparison != 0){
            return lastNameComparison;
           }
           int firstNameComparison = o1.getFirstName().compareTo(o2.getFirstName());
           if (firstNameComparison!= 0){
            return firstNameComparison;
           }
            return o1.getMiddleName().compareTo(o2.getMiddleName());
        }
    });
}

public static void printPhoneBook(List<PhoneBookEntry> entries){
    for (PhoneBookEntry entry : entries) {
        System.out.println(entry);
    }
}

}





