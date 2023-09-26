/**
 * A relation between a person and another person with a description of the relation
 */
public class Relation {
    private Person person1;
    private Person person2;
    private String description;

    public Relation(Person person1, Person person2, String description)
    {
        this.person1 = person1;
        this.person2 = person2;
        this.description = description;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return person1 + "has relation: " + description + "with "+ person2;
    }
}
