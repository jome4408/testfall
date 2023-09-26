import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Person
 */
class PersonTest {

    private static Person person;
    private static Person person2;
    private static Person person3;

    // Testbänken är uppsatt baserat på underlaget för testerna.
    /**
     * Sets up the bench for the tests:
     * Create one person with two(2) hobbies
     * Create one person with no(0) hobbies
     * Create one person with six(6) hobbies
     * Add relation from person 1 to person 2
     * Add relation from person 1 to person 3
     */
    @BeforeEach
    public void setUp()
    {
        person = new Person("Alice", "1234567890", "123 Main St", LocalDate.parse("1990-01-01"));
        person.addHobby(new Hobby("Reading"));
        person.addHobby(new Hobby("Cooking"));

        person2 = new Person("Charlie", "5555555555", "789 Oak St", LocalDate.parse("1998-10-20"));

        person3 = new Person("Chalice", "1234555555", "456 Maok St", LocalDate.parse("1994-05-10"));
        person3.addHobby(new Hobby("Fishing"));
        person3.addHobby(new Hobby("Coding"));
        person3.addHobby(new Hobby("Cooking"));
        person3.addHobby(new Hobby("Running"));
        person3.addHobby(new Hobby("Jumping"));
        person3.addHobby(new Hobby("Climbing"));

        person.addRelation(person2, "Colleague");
        person.addRelation(person3, "Best friend");
    }

    // Underlag:
    // Rubrik: Skapa ett Person objekt
    // Förväntat resultat: Information om nya objektet Person skrivs ut på korrekt sätt
    // Förändringar: Kontrollera getters istället för utskrift mot konsol
    /**
     * Tests that a Person object is created correctly
     * Asserts getters equals data given to the Person constructor
     * Test is positive
     * TestId: T01_01
     */
    @Test
    public void testCreatePerson()
    {
        assertEquals("Alice", person.getName());
        assertEquals("1234567890", person.getPhoneNumber());
        assertEquals("123 Main St", person.getAddress());
        assertEquals("1990-01-01", person.getBirthdate().toString());
    }

    // Underlag:
    // Rubrik: Visa alla hobbys av en Person
    // Förväntat resultat: Alla hobbys skrivs ut
    // Förändringar: Jämför storleken på ArrayList istället för utskrift mot konsol
    /**
     * Tests that hobbies added to person is added
     * Asserts number of added hobbies is equal to returned ArrayList from getter
     * Test is positive
     * TestId: T01_03
     */
    @Test
    public void testAddHobbies()
    {
        assertEquals(2, person.getHobbies().size());
    }

    // Rubrik: Testa hämta hobby från person utan hobbies
    // Förväntat resultat: Storleken på hobby-listan är 0
    // Test saknades i underlag
    /**
     * Tests getter for hobbies for a person with no hobbies returns 0
     * Asserts returned ArrayList from getter is equal to 0
     * Test is positive
     * TestId: Not given from test basis
     */
    @Test
    public void testGetEmptyHobbies()
    {
        assertEquals(0, person2.getHobbies().size());
    }

    // Rubrik: Testa lägga till för många hobbies
    // Förväntat resultat: Endast de fem första hobbies läggs till
    // Test saknades i underlag

    /**
     * Tests adding more than the maximum amount of hobbies (5)
     * Asserts only five hobbies exist
     * TestId: Not given from test basis
     * Test is negative
     */
    @Test
    public void testMaxHobbies()
    {
        assertEquals(5, person3.getHobbies().size());
    }

    // Rubrik: Testa lägga till en relation
    // Förväntat resultat: Kontakterna sparas i person-objektets relationslista
    // Test saknades i underlag, men bygger på ett test som finns i annan klass (AddressBookTest),
    // för att söka på kategorier
    /**
     * Tests adding relations between a person and another person works as intended
     * Asserts name of person that the relation ship is added to is equal to the person objects
     * name in the correct order of the relations-list
     * TestId: Not given from test basis
     * Test is positive
     */
    @Test
    public void testAddRelation()
    {
        assertEquals("Charlie", person.getRelations().get(0).getPerson2().getName());
        assertEquals("Chalice", person.getRelations().get(1).getPerson2().getName());
    }
}