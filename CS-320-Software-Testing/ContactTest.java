import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact c = new Contact("123", "Piter", "Parker", "1234567890", "Address");
        assertEquals("123", c.getContactId());
        assertEquals("Piter", c.getFirstName());
        assertEquals("Parker", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("Address", c.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Piter", "Parker", "1234567890", "Address");
        });
    }

    @Test
    void testInvalidIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Piter", "Parker", "1234567890", "Address");
        });
    }

    @Test
    void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Parker", "1234567890", "Address");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Christopher", "Parker", "1234567890", "Address");
        });
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Piter", null, "1234567890", "Address");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Piter", "VeryLongName", "1234567890", "Address");
        });
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Piter", "Parker", null, "Address");
        });
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Piter", "Parker", "12345", "Address");
        });
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Piter", "Parker", "1234567890", null);
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Piter", "Parker", "1234567890",
                    "This address is definitely more than thirty characters");
        });
    }

    @Test
    void testSetFirstName() {
        Contact c = new Contact("123", "Piter", "Parker", "1234567890", "Address");
        c.setFirstName("Gojo");
        assertEquals("Gojo", c.getFirstName());
    }

    @Test
    void testSetLastName() {
        Contact c = new Contact("123", "Piter", "Parker", "1234567890", "Address");
        c.setLastName("Smith");
        assertEquals("Smith", c.getLastName());
    }

    @Test
    void testSetPhone() {
        Contact c = new Contact("123", "Piter", "Parker", "1234567890", "Address");
        c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());
    }

    @Test
    void testSetAddress() {
        Contact c = new Contact("123", "Piter", "Parker", "1234567890", "Address");
        c.setAddress("New Address");
        assertEquals("New Address", c.getAddress());
    }
}