package com.larachronicles.salestaxes.helpers;

import com.larachronicles.salestaxes.Models.Product;
import com.larachronicles.salestaxes.enums.*;
import static com.larachronicles.salestaxes.helpers.PriceCalculationHelper.*;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for PriceCalculationHelper
 * @author Jose Lara
 */
public class PriceCalculationHelperTests {
    
    // Mock objects
    
    private final Product importedBook = new Product("book", new BigDecimal("10"), ProductType.BOOK, ProductOrigin.IMPORTED);
    private final Product regionalOther = new Product("other", new BigDecimal("10"), ProductType.OTHER, ProductOrigin.REGIONAL);
    private final Product importedOther = new Product("other", new BigDecimal("10"), ProductType.OTHER, ProductOrigin.IMPORTED);
    private final Product invalidType = new Product("book", new BigDecimal("10"), ProductType.DEFAULT, ProductOrigin.REGIONAL);
    private final Product invalidOrigin = new Product("book", new BigDecimal("10"), ProductType.BOOK, ProductOrigin.DEFAULT);
    
    
    // Test methods
    
    @Test
    public final void whenProductIsBookCalculateProductTypeTax() {
        Assert.assertTrue("Equals",calculateProductTypeTax(importedBook) == BigDecimal.ZERO);
    }
    
    @Test
    public final void whenProductIsOtherCalculateProductTypeTax() {
        Assert.assertEquals(0, calculateProductTypeTax(regionalOther).compareTo(new BigDecimal("1")));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenProductIsInvalidTypeCalculateProductTypeTaxt() {
        calculateProductTypeTax(invalidType);
    }
    
    @Test
    public final void whenProductIsRegionalCalculateProductOriginTax() {
        Assert.assertEquals(0, calculateProductOriginTax(regionalOther).compareTo(new BigDecimal("0")));
    }
    
    @Test
    public final void whenProductIsImportedCalculateProductOriginTax() {
        Assert.assertEquals(0, calculateProductOriginTax(importedBook).compareTo(new BigDecimal("0.5")));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenProductIsInvalidOriginCalculateProductTypeTaxt() {
        calculateProductOriginTax(invalidOrigin);
    }
    
    @Test
    public final void whenPositiveNumberRoundTotalTaxes() {
        Assert.assertEquals(0, roundUpTotalTaxes(new BigDecimal("0.931111")).compareTo(new BigDecimal("0.95")));
    }
    
    @Test
    public final void whenNegativeNumberRoundTotalTaxes() {
        Assert.assertEquals(0, roundUpTotalTaxes(new BigDecimal("-0.921111")).compareTo(new BigDecimal("-0.90")));
    }
    
    @Test
    public final void whenImportedOtherProductCalculateTotalTaxes() {
        Assert.assertEquals(0, calculateTotalTaxes(importedOther).compareTo(new BigDecimal("1.5")));
    }
    
    @Test
    public final void whenImportedOtherProductCalculateTotalPrice() {
        Assert.assertEquals(0, calculateTotalPrice(importedOther).compareTo(new BigDecimal("11.5")));
    }
}
