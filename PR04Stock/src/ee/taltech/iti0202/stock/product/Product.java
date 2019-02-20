package ee.taltech.iti0202.stock.product;
import ee.taltech.iti0202.stock.exceptions.StockException;

import java.util.ArrayList;
import java.util.List;

/*
Kui on tegemist objektiga, siis private String name; või private int number;
Kui on tegemist klassimuutujaga, siis private static String name;
 */

public class Product {

    private String name;
    private static int nextIDaddOne = 1;
    private int price;
    private static int identificationNumber = 0;
    private int productID;


    public Product(String name, int price) throws StockException {
        this.name = name;
        this.price = price;
        this.productID = getNextId();


    }

    public static int getNextId() {
        identificationNumber += nextIDaddOne;
        return identificationNumber;
    }

    public int getId() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}