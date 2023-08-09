import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class User {
	private String userID;
	private String email;
	private String password;
	private boolean isRegistered;
	private ShoppingCart cart;
	
	// Constructor
	public User(String userID, String email, String password)
	{
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.isRegistered = true;
		this.cart = new ShoppingCart();
	}
	
	
	//Registers a new user with the application
	public boolean registerUser(String userID, String email, String password)
	{
		this.email = email;
		this.password = password;
		this.isRegistered = true;

		try {
			FileWriter writer = new FileWriter("users.txt", true);
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
	
	//Allows a registered user to login
	public void login()
	{
		
	}
	
	//Logs out the currently logged-in user
	public void logout()
	{
		
	}
	
	//Adds an item to the user's shopping cart
	public void addToCart()
	{
		
	}
	
	//Removes an item from the user's shopping cart
	public void removeFromCart()
	{
		
	}
	
	//Processes the purchase from the user's cart
	public void checkout()
	{
		
	}
	
}