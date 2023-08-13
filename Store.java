import Products.productInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class Store 
{
    private ArrayList<productInfo> productList;
    private HashMap<String, User> userDatabase;

    public Store() 
    {
        productList = new ArrayList<>();//list of products
        userDatabase = new HashMap<>(); //hashamp of userdatabase
    }

    public ArrayList<productInfo> searchProduct(String keyword) 
    {
        ArrayList<productInfo> searchResults = new ArrayList<>();
        for (productInfo product : productList) // checks every product in the product list
        {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||  product.getDescription().toLowerCase().contains(keyword.toLowerCase())) // checks if the provided keyword matches the descripton or the product
                 {
                searchResults.add(product); // adds to the array of the search results
            }
        }
        return searchResults; // will return the array
    }

    public productInfo getProductByID(String productID)
     {
        for (productInfo product : productList) { //loops through the products until the end of the list
            if (product.getProductID().equals(productID)) // if the product id is equal to the item
            {
                return product;
            }
        }
        return null;
    }

    public ArrayList<productInfo> getProductByCategory(String category) 
    {
        ArrayList<productInfo> categoryProducts = new ArrayList<>();
        for (productInfo product : productList) { //loops through the products until the end of the list
            if (product.getCategory().equalsIgnoreCase(category)) 
            {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    public void updateStock(String productID, int newQuantity) // will update the stock of the product
    {
     productInfo product = getProductByID(productID);
      if (product != null) {
        String newQuantityStr = Integer.toString(newQuantity); // convert int to string
        product.setStockQuantity(newQuantityStr); //sets the new quantity
    }
}
}