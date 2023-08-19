import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    @Test
    public void testRegisterUserWithValidInput() {
        User user = new User("test5@gmail.com", "Password@12354");
        assertTrue(user.registerUser());
    }

    @Test
    public void testRegisterUserWithInvalidEmail() {
        User user = new User("invalid-email", "Password@123");
        assertFalse(user.registerUser());
    }

    @Test
    public void testRegisterUserWithWeakPassword() {
        User user = new User("test@example.com", "weakpass");
        assertFalse(user.registerUser());
    }

    @Test
    public void testLoginWithValidCredentials() {
        User user = new User("test@gmail.com", "Password@12354");
        user.registerUser();
        assertTrue(user.login());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        User user = new User("ye", "hey");
        assertFalse(user.login());
    }
}