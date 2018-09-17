package domain;

import java.math.BigDecimal;

/**
 *
 * @author peani371
 */
public class SaleItem {

    private Integer quantityPurchased;
    private BigDecimal salePrice;
    private Product product;
    private Sale sale;

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public Product getProduct() {
        return product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public void setProduct(Product saleProduct) {
        this.product = saleProduct;
    }

    public void setSaleID(Sale sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "SaleItem{" + "quantityPurchased=" + quantityPurchased
                + ", salePrice=" + salePrice;
    }

    public BigDecimal getItemTotal() {
        BigDecimal quantity = new BigDecimal(quantityPurchased);
        return quantity.multiply(salePrice);
    }

}
