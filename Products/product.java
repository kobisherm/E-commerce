package Products;
import java.util.*;
import java.io.*;

public class product {
    ArrayList <productInfo> list = new ArrayList<productInfo>();
    PrintStream prt = System.out;
    
    public void loadProducts(String fn) {
        //product variables
        String productID, name, price, description, category, size, color, stockQuantity;
        int numberOfProducts = 3;

        try{
            Scanner inf = new Scanner(new File(fn));

            //read values
            for(int i = 1; i <= numberOfProducts; i++){
            productID = inf.nextLine();
            name = inf.nextLine();
            price = inf.nextLine();
            description = inf.nextLine();
            category = inf.nextLine();
            size = inf.nextLine();
            color = inf.nextLine();
            stockQuantity = inf.nextLine();
            productInfo info = new productInfo(productID, name, price, description, category, size, color, stockQuantity);
            list.add(info);
            }

            inf.close();
        }catch (Exception e){prt.printf("\n\tRead Error! %s", e);}

        print();
    }

    void print() {
        for (productInfo info : list) {
            prt.println("Product ID: " + info.getProductID());
            prt.println("Name: " + info.getName());
            prt.println("Price: " + info.getPrice());
            prt.println("Description: " + info.getDescription());
            prt.println("Category: " + info.getCategory());
            prt.println("Size: " + info.getSize());
            prt.println("Color: " + info.getColor());
            prt.println("Stock Quantity: " + info.getStockQuantity());
            prt.println();
        }
    }
}
