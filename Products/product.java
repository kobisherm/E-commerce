package Products;

import java.util.*;
import java.io.*;

/**
 * Class Name: Product.java
 * Date:
 * @since 1.0 (2023-08)
 * @author Armon Lee
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Description: This class gives a list of products that
 * we have in our warehouse with their full item description.
 * Additionally, the class will be able to properly read and
 * store this info into our application to display for users to
 * see what’s in stock.
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Important Data Structures: 
 *    - allProducts - list of all products in productFile.txt
 *      and holds values containing their information like
 *      productID, name, price, description, category, size, 
 *      color, stockQuantity, image. These values are 
 *      categorized in the productInfo class
 */
public class Product {
    public static ArrayList <productInfo> allProducts = new ArrayList<productInfo>(); //list of products
    PrintStream prt = System.out;

    /**
     * loadProducts(String fn)
     * Date:
     * @since 1.0 (2023-08)
     * @author Armon Lee
     * @param fn - file that infomation about products and then read
     * in loadProducts(String fn) method
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
     * Description: Reads lines in from productFile and stores them in
     * proper variables by calling the productInfo constructor
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
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
     * print()
     * Date:
     * @since 1.0 (2023-08)
     * @author Armon Lee
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
     * Description: prints each product and their info onto terminal
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
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
