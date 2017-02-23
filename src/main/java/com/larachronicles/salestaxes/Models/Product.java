package com.larachronicles.salestaxes.Models;

import com.larachronicles.salestaxes.enums.*;
import java.math.BigDecimal;

/**
 * Class for instantiate an object that represents a Product
 * @author Jose Lara
 */
public class Product {
    
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private ProductOrigin productOrigin;
    
    /**
    * Constructor.
    * 
    * @param name Name of the product
    * @param price Price of the product
    * @param applicableTaxRate Applicable tax rate of the product
    * @param productOrigin Origin of the product
    */
    public Product(String name, BigDecimal price, ProductType productType, ProductOrigin productOrigin){
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.productOrigin = productOrigin;
    }
    
    /**
     * Setter method for name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for price
     * @param price 
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Setter method for productType
     * @param productType 
     */
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    /**
     * Setter method for productOrigin
     * @param productOrigin 
     */
    public void setProductOrigin(ProductOrigin productOrigin) {
        this.productOrigin = productOrigin;
    }

    /**
     * Getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for price
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Getter method for productType
     * @return productType
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Getter method for productOrigin
     * @return productOrigin
     */
    public ProductOrigin getProductOrigin() {
        return productOrigin;
    }
    
    /**
     * Describe the product
     * @return product description
     */
    @Override
    public String toString() {
        return "Product{" + "Name=" + name + ", Price=" + price + ", Product type=" + productType + ", Product origin=" + productOrigin + '}';
    }
}
