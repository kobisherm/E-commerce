import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

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
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * Constructor of User class constructs a new user with the
	 * given email and password.
	 * 
	 * 
	 * 
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
	 * </p>
	 * @return true if registration was successful, otherwise false
	 * 
	 */
	public boolean registerUser()
	{
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
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * 
	 * void logout()
	 * <p>
	 * This method logs out the current user, clears session data
	 * and redirects the user to login page.
	 * </p>
	 * @return nothing
	 * 
	 */
	public void logout()
	{
		this.email = null;
	    this.password = null;
	    this.isRegistered = false;
	}
	
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * 
	 * void addToCart()
	 * <p>
	* This function should add items to the user's cart
	 * This function is not implemented yet
	 * </p>
	 * @return nothing as of now
	 * 
	 */
	public void addToCart()
	{
		
	}
	
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * 
	 * void removeFromCart()
	 * <p>
	 * This function should remove items from the user's cart
	 * This function is not implemented yet
	 * </p>
	 * @return nothing as of now
	 * 
	 */
	public void removeFromCart()
	{
		
	}
	
	
	/**
	 * @author Davit Sargsyan
	 * @since 1.0 (2023-07)
	 * 
	 * void checkout()
	 * <p>
	 * This function should let the current user check out.
	 * This function is not implemented yet
	 * </p>
	 * @return nothing as of now
	 */
	public void checkout()
	{
		
	}
	
}