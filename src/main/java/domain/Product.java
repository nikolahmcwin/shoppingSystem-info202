/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author peani371
 */
public class Product {

    @NotNull(message = "ID must be provided.")
    @NotBlank(message = "ID must be provided.")
    @Length(min = 1, max = 20, message = "ID must contain between one and 20 characters.")
    private String productID;

    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min = 2, max = 50, message = "Name must contain between two and fifty characters.")
    private String name;
    
    private String description;
    
    @NotNull(message = "Category must be provided.")
    @NotBlank(message = "Category must be provided.")
    @Length(min = 2, max = 50, message = "Category must contain between two and fifty characters.")
    private String category;

    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be zero or greater.")
    @Max(value = 9999.00, message = "Price must be between 0 and 9,999.00" )
    private BigDecimal price;

    @NotNull(message = "Quantity must be provided.")
    @NotNegative(message = "Quantity must be zero or greater.")
    @Max(value = 99999.00, message = "Quantity must be between 0 and 99,999.00")
    private Integer quantityInStock;

    public Product() {
        // Empty default constructor
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return productID + ", " + name;
    }

}
