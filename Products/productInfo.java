package Products;

/**
 * <p>
 * Class Name: productInfo.java<br>
 * @since 1.0 (2023-08)<br>
 * @author Armon Lee<br>
 * Description: store product variables and sets them to private<br>
 * </p>
 */
public class productInfo {
    
    private String productID;
    private String name;
    private double price;
    private String description;
    private String category;
    private String size;
    private String color;
    private String stockQuantity;
    private String image;

     public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    /**
     * <p>
     * productInfo()<br>
     * @param productID <br>
     * @param name <br>
     * @param price <br>
     * @param description <br>
     * @param category <br>
     * @param size <br>
     * @param color <br>
     * @param stockQuantity <br>
     * @param image <br>
     * Description - Public constructor the stores private variables<br>
     * that are collected from the reader. It can also be called <br>
     * throughout the program to get information about a certain<br>
     * product<br>
     * </p>
     */
    public productInfo(String productID, String name, double price, String description, String category, String size, String color, String stockQuantity, String image) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.size = size;
        this.color = color;
        this.stockQuantity = stockQuantity;
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public String getImage() {
        return image;
    }
}
