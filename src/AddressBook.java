import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Person> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }


    //Method extended for preventing duplicate entries
    public boolean addContact(Person person) {

        //Search contacts for a Person with the exact same entries for all its variables as person
        for (Person contact : contacts) {
            if (contact.getName().equals(person.getName()) &&
                    contact.getBirthdate().equals(person.getBirthdate()) &&
                    contact.getPhoneNumber().equals(person.getPhoneNumber()) &&
                    contact.getAddress().equals(person.getAddress())) {
                return false;
            }
        }
        contacts.add(person);
        return true;
    }

    /**
     * Method implemented for testing, making the list accessible.
     * Get the list of persons
     *
     * @return the List
     */
    public List<Person> getContacts() {
        return contacts;
    }

    /**
     * Method implemented for testing, making searching for contacts (by name) possible
     * Search contacts for a contact with a given name
     *
     * @param name the name to search
     * @return list of persons matching the search
     */
    public List<Person> searchContact(String name) {
        List<Person> persons = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getName().equalsIgnoreCase(name)) {
                persons.add(person);
            }
        }
        return persons;
    }

    /**
     * Test method implemented for modifying contact name in contacts
     *
     * @param personToModify the contact to modify
     * @param nameToSet      the name to be set
     */
    public void modifyContactName(Person personToModify, String nameToSet) {
        for (Person person : contacts) {
            if (person.equals(personToModify)) {
                person.setName(nameToSet);
            }
        }
    }

    public void displayContacts() {
        for (Person person : contacts) {
            System.out.println(person);
        }
    }

    /**
     * Search for a persons relations given the relations description
     * @param person the person whom has the relation
     * @param description the description to search
     * @return list of related persons matching the description
     */
    public List<Person> searchRelationDescription(Person person, String description) {
        List<Person> foundRelations = new ArrayList<>();

        for (Relation relation : person.getRelations()) {
            if (relation.getDescription().equals(description)) {
                foundRelations.add(relation.getPerson2());
            }
        }
        return foundRelations;
    }

    /**
     * Checks contacts for people having a birthday match for todays date
     * If month and day of Person objects in contacts matches todays local date they are added to the list
     * @return list of Person objects with a birthday match
     */
    public List<Person> birthdayReminder() {
        List<Person> partyPeople = new ArrayList<>();
        for (Person contact : contacts)
        {
            if(contact.getBirthdate().getDayOfMonth() == LocalDate.now().getDayOfMonth()
            && contact.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue())
            {
                partyPeople.add(contact);
            }
        }
        return partyPeople;
    }
}