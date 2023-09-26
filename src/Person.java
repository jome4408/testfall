import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String phoneNumber;
    private String address;
    private LocalDate birthdate;
    private List<Hobby> hobbies;
    private boolean isFavorite = false;

    public List<Relation> getRelations() {
        return relations;
    }

    private List<Relation> relations = new ArrayList<>();

    public Person(String name, String phoneNumber, String address, LocalDate birthdate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthdate = birthdate;
        this.hobbies = new ArrayList<>();
    }

    /**
     * Modified for testing purposes
     * Add a hobby to hobbies
     * @param hobby the hobby to add
     * @return true if added, false if not
     */
    public boolean addHobby(Hobby hobby) {
        if (hobbies.size() == 5) {
            return false;
        }
        hobbies.add(hobby);
        return true;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        StringBuilder hobbyList = new StringBuilder();
        for (Hobby hobby : hobbies) {
            hobbyList.append(hobby).append(", ");
        }

        return "Name: " + name + "\nPhone: " + phoneNumber + "\nAddress: " + address + "\nBirthdate: " + birthdate +
                "\nHobbies: " + (hobbies.isEmpty() ? "None" : hobbyList.substring(0, hobbyList.length() - 2)) + "\n";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setFavorite() {
        isFavorite = true;
    }

    public void removeFavorite() {
        isFavorite = false;
    }

    public boolean getFavorite()
    {
        return isFavorite;
    }

    /**
     * Adds a one way relationship between this person object and given other person object
     * @param person the person to add the relation for
     * @param description the description of the relation
     */
    public void addRelation(Person person, String description) {
        relations.add(new Relation(this, person, description));
    }
}
