import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Piter", "Parker", "1234567890", "Address");

        service.addContact(c);
    }

    @Test
    void testAddNullContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    void testDuplicateId() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "Piter", "Parker", "1234567890", "Address");
        Contact c2 = new Contact("1", "Gojo", "Satoru", "1234567890", "Address");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Denis", "Smith", "1234567890", "Address");

        service.addContact(c);
        service.deleteContact("1");

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("1");
        });
    }

    @Test
    void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Piter", "Parker", "1234567890", "Address");

        service.addContact(c);
        service.updateFirstName("1", "Gojo");

        assertEquals("Gojo", c.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Piter", "Parker", "1234567890", "Address");

        service.addContact(c);
        service.updateLastName("1", "Smith");

        assertEquals("Smith", c.getLastName());
    }

    @Test
    void testUpdatePhoneValid() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Piter", "Parker", "1234567890", "Address");

        service.addContact(c);
        service.updatePhone("1", "0987654321");

        assertEquals("0987654321", c.getPhone());
    }

    @Test
    void testUpdatePhoneInvalid() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Denis", "Smith", "1234567890", "Address");

        service.addContact(c);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("1", "123");
        });
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Piter", "Parker", "1234567890", "Address");

        service.addContact(c);
        service.updateAddress("1", "New Address");

        assertEquals("New Address", c.getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Ghost");
        });
    }
}