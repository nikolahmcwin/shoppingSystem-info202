package domain;

import java.math.BigDecimal;

/**
 *
 * @author peani371
 */
public class SaleItem {
	
	private Integer quantityPurchased;
	private BigDecimal salePrice;

	public Integer getQuantityPurchased() {
		return quantityPurchased;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "SaleItem{" + "quantityPurchased=" + quantityPurchased + ", salePrice=" + salePrice + '}';
	}
	
	public BigDecimal getItemTotal() {
		return null;
	}
	
	
	
}
