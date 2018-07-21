package domain;

import java.math.BigDecimal;

/**
 *
 * @author peani371
 */
public class SaleItem {
	
	private Integer quantityPurchased;
	private BigDecimal salePrice;
	private Product saleProduct;
	private Sale sale;

	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public Product getSaleProduct() {
		return saleProduct;
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

	public void setSaleProduct(Product saleProduct) {
		this.saleProduct = saleProduct;
	}

	public void setSaleID(Sale sale) {
		this.sale = sale;
	}

	@Override
	public String toString() {
		return "SaleItem{" + "quantityPurchased=" + quantityPurchased + 
				  ", salePrice=" + salePrice + ", saleProduct=" + saleProduct 
				  + ", sale=" + sale + '}';
	}
	
	public BigDecimal getItemTotal() {
		BigDecimal quantity = new BigDecimal(quantityPurchased);
		BigDecimal itemTotal = quantity.multiply(salePrice);
		return itemTotal;
	}

	
	
	
}
