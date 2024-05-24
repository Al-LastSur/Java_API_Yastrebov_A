package attestation;

public class PhoneBookEntry {
        
    private String lastName;
    private String firstName;
    private String middleName;
    private String phoneNumber;

    
    public PhoneBookEntry (String lastName, String firstName, String middleName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
    }
        public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String toString(){
        return lastName + " " + firstName + " " + middleName + " " + phoneNumber;
    }

}
