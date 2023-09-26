import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Hobby
 */
class HobbyTest {

    private static Hobby hobby;
    /**
     * Sets up the bench for the tests:
     * Create a hobby
     */
    @BeforeEach
    public void setUp()
    {
        hobby = new Hobby("Photography");
    }

    // Rubrik: Testa skapa Hobby
    // Förväntat resultat: Hobby objekt
    // Test saknades i underlag
    /**
     * Tests that a Hobby object is created correctly
     * Asserts getter equals data given to the Person constructor
     * Test is positive
     * TestId: Not given from test basis
     */
    @Test
    public void testCreateHobby()
    {
        assertEquals("Photography", hobby.getName());
    }
}