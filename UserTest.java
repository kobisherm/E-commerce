import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("test@example.com", "Password@123");
    }

    @Test
    public void testRegisterUserWithValidInput() {
        assertTrue(user.registerUser());
    }

    @Test
    public void testRegisterUserWithInvalidEmail() {
        user = new User("invalid-email", "Password@123");
        assertFalse(user.registerUser());
    }

    @Test
    public void testRegisterUserWithWeakPassword() {
        user = new User("test@example.com", "weakpass");
        assertFalse(user.registerUser());
    }

    @Test
    public void testLoginWithValidCredentials() {
        user.registerUser();
        assertTrue(user.login());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        assertFalse(user.login());
    }
}