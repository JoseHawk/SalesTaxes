package com.larachronicles.salestaxes.main;

import com.larachronicles.salestaxes.Models.Product;
import com.larachronicles.salestaxes.enums.*;
import static com.larachronicles.salestaxes.helpers.PriceCalculationHelper.printReceipt;
import java.math.BigDecimal;


/**
 * Main class used for the purpose of this project
 * @author Jose Lara
 */
public class Main {
    
    public static void main (String args[]){
        
        //Input 1
        Product book = new Product("book", new BigDecimal("12.49"), ProductType.BOOK, ProductOrigin.REGIONAL);
        Product musicCD = new Product("music CD", new BigDecimal("14.99"), ProductType.OTHER, ProductOrigin.REGIONAL);
        Product chocolateBar = new Product("chocolate bar", new BigDecimal("0.85"), ProductType.FOOD, ProductOrigin.REGIONAL);
        
        System.out.println("\n Output 1: ");
        printReceipt(book, musicCD, chocolateBar);
        
        //Input 2
        Product chocolateBox = new Product("box of cholates", new BigDecimal ("10.00"), ProductType.FOOD, ProductOrigin.IMPORTED);
        Product perfumeBottle = new Product("bottle of perfume", new BigDecimal("47.50"), ProductType.OTHER, ProductOrigin.IMPORTED);
        
        System.out.println("\n Output 2: ");
        printReceipt(chocolateBox, perfumeBottle);
        
        //Input 3
        Product perfumeBottle2 = new Product("bottle of perfume", new BigDecimal("27.99"), ProductType.OTHER, ProductOrigin.IMPORTED);
        Product perfumeBottle3 = new Product("bottle of perfume", new BigDecimal("18.99"), ProductType.OTHER, ProductOrigin.REGIONAL);
        Product headachePills = new Product("packet of headache pills", new BigDecimal("9.75"), ProductType.MEDICINE, ProductOrigin.REGIONAL);
        Product chocolates = new Product("chocolates", new BigDecimal("11.25"), ProductType.FOOD, ProductOrigin.IMPORTED);
        
        System.out.println("\n Output 3: ");
        printReceipt(perfumeBottle2, perfumeBottle3, headachePills, chocolates);
    }
    
}
