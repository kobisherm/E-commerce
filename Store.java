import Products.Product;
import Products.productInfo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Store Class
 * @since 1.0 2023-08
 * @author Ian Valle
 * Description: 
 * The store class is what holds the products and user data.
 * It provides methods for searching products, retrieving product information,
 * getting products by category, and updating product stock.
 */
public class Store {

    private ArrayList<productInfo> productList; // list of available products
    private HashMap<String, User> userDatabase; // database of users

    /**
     * Constructor to create a Store object with an empty product list and user database.
     */
    public Store() {
        productList = Product.allProducts;
        userDatabase = new HashMap<>();
    }

    /**
     * A function to search for through each product and product desciption usinga keyword.
     * @param keyword The keyword to search for.
     * @return An ArrayList of productInfo objects that match the keyword.
     */
    public ArrayList<productInfo> searchProduct(String keyword) {
        ArrayList<productInfo> searchResults = new ArrayList<>();
        for (productInfo product : productList) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    /**
     * Gets a product by its unique product ID.
     * @param productID The product ID to search for.
     * @return The productInfo object corresponding to the given product ID, or null if not found.
     */
    public productInfo getProductByID(String productID) {
        for (productInfo product : productList) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Gets products by their category.
     * @param category The category to search for.
     * @return An ArrayList of productInfo objects that belong to the given category.
     */
    public ArrayList<productInfo> getProductByCategory(String category) {
        ArrayList<productInfo> categoryProducts = new ArrayList<>();
        for (productInfo product : productList) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    /**
     * Updates the stock quantity of a product based on its ID.
     * @param productID The ID of the product to update.
     * @param newQuantity The new stock quantity to set.
     */
    public void updateStock(String productID, int newQuantity) {
        productInfo product = getProductByID(productID);
        if (product != null) {
            String newQuantityStr = Integer.toString(newQuantity);
            product.setStockQuantity(newQuantityStr);
        }
    }
}