package com.larachronicles.salestaxes.helpers;

import com.larachronicles.salestaxes.Models.Product;
import com.larachronicles.salestaxes.enums.*;
import java.math.BigDecimal;
/**
 * Helper class for the price calculation
 * @author Jose Lara
 */
public class PriceCalculationHelper {
    
    /**
     * Helper method used to print the receipt for a list of products, including the final price
     * of each one, the final total amount of taxes and th final total amount of price.
     * @param products List of products to print the receipt.
     */
    public static void printReceipt(Product... products) {
        
        BigDecimal totalPriceShopping = BigDecimal.ZERO;
        BigDecimal totalTaxesShopping = BigDecimal.ZERO;
        
        for (Product product : products) {
            
            BigDecimal totalPriceProduct = calculateTotalPrice(product);
            totalPriceShopping = totalPriceShopping.add(totalPriceProduct);
            totalTaxesShopping = totalTaxesShopping.add(calculateTotalTaxes(product));
            
            if (product.getProductOrigin() == ProductOrigin.IMPORTED) {
                System.out.println("1 imported " + product.getName() + ": " + totalPriceProduct);
            }else {
                System.out.println("1 "+ product.getName() + ": " + totalPriceProduct);
            }
        }
        
        System.out.println("Sales Taxes: " + totalTaxesShopping);
        System.out.println("Total: " + totalPriceShopping);
    }

    /**
     * Method used to calculate the final price of the product after including the taxes.
     * @param product The product which we want to calculate its total price.
     * @return The total price.
     */
    protected static BigDecimal calculateTotalPrice(Product product) {
        
        return product.getPrice().add(calculateTotalTaxes(product));
    }
    
    /**
     * Method used to calculate the total taxes.
     * @param product The product which we want to calculate its taxes.
     * @return The total amount of taxes.
     */
    protected static BigDecimal calculateTotalTaxes(Product product) {
        
        return roundUpTotalTaxes(calculateProductTypeTax(product).add(calculateProductOriginTax(product)));
    }
    
    /**
     * Method used to round up to the nearest 0.05.
     * @param taxes The total amount of taxes.
     * @return The final tax rate.
     */
    protected static BigDecimal roundUpTotalTaxes(BigDecimal taxes) {
        
        return (taxes.divide(new BigDecimal("0.05"))).setScale(0,BigDecimal.ROUND_CEILING).multiply(new BigDecimal("0.05"));
    }
    
    /**
     * Method to calculate the taxes for the product according to its type.
     * @param product The product to calculate the taxes.
     * @return The taxes amount.
     */
    protected static BigDecimal calculateProductTypeTax(Product product) {
        
        BigDecimal taxes = BigDecimal.ZERO;
        
        switch (product.getProductType()) {
                
            case BOOK:
            case FOOD:
            case MEDICINE:
            {
                break;
            }
             case OTHER:
            {
                taxes = product.getPrice().divide(BigDecimal.TEN);
                break;
            }
            default:
            {
                throw new IllegalArgumentException("No valid product type");
            }
        }
        
        return taxes;
    }
    
    /**
     * Method to calculate the taxes for the product according to its origin.
     * @param product The product to calculate the taxes.
     * @return The taxes amount.
     */
    protected static BigDecimal calculateProductOriginTax(Product product) {
        
        BigDecimal taxes = BigDecimal.ZERO;
        
        switch (product.getProductOrigin()) {
            
            case REGIONAL:
            {
                break;
            }
            case IMPORTED:
            {
                taxes = product.getPrice().divide(BigDecimal.valueOf(20));
                break;
            }
            default:
            {
                throw new IllegalArgumentException("No valid product origin");
            }
        }
        
        return taxes;
    }
}
