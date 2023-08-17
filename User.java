import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Davit Sargsyan
 * @since 1.0 (2023-07)
 * 
 * User class represents a user in the application
 * <p>
 * This class is responsible for managing user's information
 * and interacting with the user's shopping cart.
 * </p>
 * 
 */


//comment
public class User {
	private String userID;
	private String email;
	private String password;
	private boolean isRegistered;
	private ShoppingCart cart;
	private static final String EMAIL_PATTERN = 
        "^[a-zA-Z0-9_+&*-]+(?:\\."+
        "[a-zA-Z0-9_+&*-]+)*@" + 
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
        "A-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * Constructor of User class constructs a new user with the
	 * given email and password.
	 */
	public User(String email, String password)
	{
		this.email = email;
		this.password = password;
		/**
		 * @param isRegistered : Indicates if the user is registered or not
		 */
		this.isRegistered = false; // Initially false, we will change this to true after a user registers succesfully
		/**
		 * @param cart : Represents the shopping cart if the user
		 */
		this.cart = new ShoppingCart();
	}
	
	public ShoppingCart getShoppingCart()
	{
		return cart;
	}
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * 
	 * boolean registerUser()
	 * <p>
	 * This method registers a new user by assigning them a unique ID,
	 * an email provided by the user and password provided by the user
	 * All the information gets written to a file named users.txt
	 * which helps keep track of users + is essential for login functionality.
	 * This function works with register class which represents the registration page
	 * and takes care of all the GUI requirements of that page.
	 * This function is called from within register class.
	 * Since this comment was added later, I have also added ways to check
	 * for email to be of valid format and for password to be of valid format.
	 * Also we check if the user exists or not based on the email with which they sign up with. 
	 * </p>
	 * @return true if registration was successful, otherwise false
	 * 
	 */
	public boolean registerUser()
	{
		// Validate email
        if (!isValidEmail(this.email)) {
            System.out.println("Invalid email format");
            return false;
        }
        
        // Validate password
        if (!isValidPassword(this.password)) {
            System.out.println("Password must meet the criteria");
            return false;
        }
        
        // Check for duplicate users
        if (isUserExist(this.email)) {
            System.out.println("User already exists with this email.");
            return false;
        }


		this.userID = UUID.randomUUID().toString();
		this.isRegistered = true;

		try {
			FileWriter writer = new FileWriter("users.txt", true);
			File file = new File("users.txt");
			System.out.println("File is located at: " + file.getAbsolutePath());
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			bufferedWriter.write(userID + "," + email + "," + password);
			bufferedWriter.newLine(); // We add a new line after entering one user's info

			bufferedWriter.close(); // Need to close after registering a user
		} catch (IOException e){
			e.printStackTrace();
			return false;
		}

		return true;
		
	}
	
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * 
	 * boolean login()
	 * <p>
	 * This method logs a user in by reading the users.txt file
	 * If the user exists they are prompted to the home page of our application.
	 * Otherwise they are told that there is a user name or password mismatch.
	 * This function works with login page class and is called from within that class. 
	 * </p>
	 * @return true if registration was successful, otherwise false
	 * 
	 */
	public boolean login()
	{
		String line;
		String search = this.email + "," + this.password;

		try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))){
			while((line = br.readLine()) != null){
				if(line.contains(search)){
					//Found match!
					return true;
				}
			}
		} catch (IOException e){
			System.out.println("Error reading users.txt file");
			e.printStackTrace();
		}


		return false;
	}


	private boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


     private boolean isValidPassword(String password) {
        // Password should be at least 8 characters,
        // contain at least one digit, one lower case,
        // one upper case, and one special character.
        
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        return password.matches(passwordPattern);
    }
    
    private boolean isUserExist(String email) {
                String line;
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))){
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                // Check if the line has enough parts (at least 3) to be a valid record
                if (parts.length >= 3) {
                    String emailFromFile = parts[1].trim();
                    if (emailFromFile.equals(email)) {
                        // Found a match, this user exists
                        return true;
                    }
                }
            }
        } catch (IOException e){
            System.out.println("Error reading users.txt file");
            e.printStackTrace();
        }
        // If we reach this point, no matching user was found
        return false;
    }

	
}