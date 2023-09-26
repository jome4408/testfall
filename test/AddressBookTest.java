import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AddressBook
 */
class AddressBookTest {

    private static AddressBook addressBook;

    /**
     * Sets up the bench for the tests:
     * Create AddressBook
     * Add three Person objects to the addressbook
     * Set a person to favorite
     */
    @BeforeEach
    public void setUp()
    {
        addressBook = new AddressBook();

        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();

        addressBook.addContact(new Person("Alice", "1234567890", "123 Main St", LocalDate.parse("1990-01-01")));
        addressBook.addContact(new Person("Charlie", "5555555555", "789 Oak St", LocalDate.of(1990, month, day)));
        addressBook.addContact(new Person("Charlie", "1234555555", "456 Maok St", LocalDate.of(1994, month, day)));

        addressBook.getContacts().get(2).setFavorite();

        addressBook.getContacts().get(0).addRelation(addressBook.getContacts().get(1), "Friend");
        addressBook.getContacts().get(0).addRelation(addressBook.getContacts().get(2), "Friend");
    }

    // Underlag:
    // Rubrik: Visa information om alla kontakter i AddressBook (AddressBook är tom)
    // Förväntat resultat: Ingen information skrivs ut
    // Förändringar: Jag anropar getContacts och jämför storleken på listan istället för utskrift mot konsol
    /**
     * Tests getting an empty addressbook
     * Asserts list is equal to 0
     * TestId: T01_02_2
     * Test is positive
     */
    @Test
    public void testGetEmptyAddressBook()
    {
        addressBook = new AddressBook();
        assertEquals(0, addressBook.getContacts().size());
    }

    // Underlag:
    // Rubrik: Vissa information om alla kontakter i AddressBook
    // Förväntat resultat: Information om Person skrivs ut på korrekt sätt
    // Förändringar: Kontrollera storleken på kontaktlistan istället för utskrift
    /**
     * Tests adding contacts to addressbook works correctly
     * Asserts its equal to number of added contacts
     * TestId: T01_02
     * Test is positive
     */
    @Test
    public void testAddContact()
    {
        assertEquals(3, addressBook.getContacts().size());
    }

    // Underlag
    // Rubrik: Fel vid inlägga av samma objekt två gånger
    // Förväntat resultat: Felmeddelande
    // Förändringar: Kolla att metoden returnerar false istället för felmeddelande
    /**
     * Tests adding a duplicate contact to the addressbook
     * Asserts duplicate contact is not added
     * TestId: T01_04
     * Test is negative
     */
    @Test
    public void testAddDuplicateContact()
    {
        assertFalse(addressBook.addContact(new Person("Alice", "1234567890", "123 Main St", LocalDate.parse("1990-01-01"))));
    }

    // Underlag:
    // Rubrik: Sök på namnet av en kontakt
    // Förväntat resultat: Information om rätt kontakt skrivs ut
    // Förändringar: Rätt kontakter returneras i en lista. Ex. söker man på charlie och det finns flera med samma namn
    //     får man båda.
    /**
     * Tests that searching contacts gets the expected Person objects
     * Asserts returned Person objects name is equal to search
     * TestId: T02_01
     * Test is positive
     */
    @Test
    public void testSearchContact()
    {
        assertEquals(2, addressBook.searchContact("Charlie").size());
    }

    // Underlag:
    // Rubrik: Redigera information om befintlig kontakt
    // Förväntat resultat: Ny information om kontakten visas
    /**
     * Tests modifying name of a contact
     * Asserts name is updated in addressbook
     * TestId: T02_02
     * Test is positive
     */
    @Test
    public void testModifyContactName()
    {
        addressBook.modifyContactName(addressBook.getContacts().get(0), "Blice");
        assertEquals("Blice", addressBook.getContacts().get(0).getName());
    }

    // Underlag:
    // Rubrik: Lägg in en kontakt som favorit
    // Förväntat resultat: Informationen visar att kontakten är en favorit
    /**
     * Tests setting a contact as favorite works correctly
     * Asserts contact is favorite
     * TestId: T02_03
     * Test is positive
     */
    @Test
    public void testSetFavorite()
    {
        assertTrue(addressBook.getContacts().get(2).getFavorite());
    }

    // Underlag:
    // Rubrik: Söka på kategori
    // Förväntat resultat: Alla kontakter inom den kategori visas
    // Förändringar: Ny klass Relation lades till för att lägga till relationer mellan personer
    //              och sökmetod i AddressBook
    /**
     * Tests searching the description of a relationship for a Person
     * Asserts returned person-list contains the correct persons
     * TestId: T02_04
     * Test is positive
     */
    @Test
    public void testSearchRelationDescription()
    {
        assertEquals(addressBook.getContacts().get(1).getName(),
                addressBook.searchRelationDescription(addressBook.getContacts().get(0), "Friend").get(0).getName());
        assertEquals(addressBook.getContacts().get(2).getName(),
                addressBook.searchRelationDescription(addressBook.getContacts().get(0), "Friend").get(1).getName());
    }

    // Underlag:
    // Rubrik: Påminnelse på födelsedag
    // Förväntat resultat: Att meddelande om att en kontakt fyller år visas
    // Förändringar: Vi returnerar listan med personer som fyller år istället för att visa mot konsol
    /**
     * Tests that contacts having a birthday today works
     * Asserts number of contacts with a birthday today is equal to returned list
     * TestId: T02_05
     * Test is positive
     */
    @Test
    public void testBirthdayReminder()
    {
        assertEquals(2, addressBook.birthdayReminder().size());
    }
}