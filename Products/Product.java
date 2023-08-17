package Products;

import java.util.*;
import java.io.*;

/**
 * <p>
 * Class Name: Product.java<br>
 * @since 1.0 (2023-08)<br>
 * @author Armon Lee<br>
 * Description: This class gives a list of products that<br>
 * we have in our warehouse with their full item description.<br>
 * Additionally, the class will be able to properly read and<br>
 * store this info into our application to display for users to<br>
 * see what’s in stock.<br>
 * Important Data Structures: <br>
 *    - allProducts - list of all products in productFile.txt<br>
 *      and holds values containing their information like<br>
 *      productID, name, price, description, category, size, <br>
 *      color, stockQuantity, image. These values are <br>
 *      categorized in the productInfo class<br>
 * </p>
 */
public class Product {
    public static ArrayList <productInfo> allProducts = new ArrayList<productInfo>(); //list of products
    PrintStream prt = System.out;

    /**
     * <p>
     * loadProducts(String fn)<br>
     * @since 1.0 (2023-08)<br>
     * @author Armon Lee<br>
     * @param fn - file that infomation about products and then read<br>
     * in loadProducts(String fn) method<br>
     * Description: Reads lines in from productFile and stores them in<br>
     * proper variables by calling the productInfo constructor<br>
     * </p>
     */
    public void loadProducts(String fn) {
        //product variables
        String productID, name, price, description, category, size, color, stockQuantity, image;
        int numberOfProducts = 15;

        try{
            Scanner inf = new Scanner(new File(fn)); //opens productFile

            //read values in productFile
            for(int i = 1; i <= numberOfProducts; i++){
                productID = inf.nextLine();
                name = inf.nextLine();
                price = inf.nextLine(); //convert to double
                description = inf.nextLine();
                category = inf.nextLine();
                size = inf.nextLine();
                color = inf.nextLine();
                stockQuantity = inf.nextLine();
                image = inf.nextLine();
                //Stores each product and their info in productInfo constructor
                productInfo info = new productInfo(productID, name, Double.parseDouble(price), description, category, size, color, stockQuantity, image);
                //add to array of allProducts
                allProducts.add(info);
            }

            //closes file
            inf.close();
        }catch (Exception e){prt.printf("\n\tRead Error! %s", e);}
        //}catch (Exception e){e.printStackTrace();}

        print();
    }

    /**
     * <p>
     * print()<br>
     * @since 1.0 (2023-08)<br>
     * @author Armon Lee<br>
     * Description: prints each product and their info onto terminal<br>
     * </p>
     */
    void print() {
        for (productInfo info : allProducts) {
            prt.println("Product ID: " + info.getProductID());
            prt.println("Name: " + info.getName());
            prt.println("Price: " + info.getPrice());
            prt.println("Description: " + info.getDescription());
            prt.println("Category: " + info.getCategory());
            prt.println("Size: " + info.getSize());
            prt.println("Color: " + info.getColor());
            prt.println("Stock Quantity: " + info.getStockQuantity());
            prt.println("Image: " + info.getImage());
            prt.println();
        }
    }
}
