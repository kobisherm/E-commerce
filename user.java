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
	public void registerUser()
	{
		
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