package domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author peani371
 */
public class Sale {
	
	private String saleID;
	// Is this the correct format to use for Dates?
	private Date date;
	// Would status be better off as a boolean?
	private String status;

	public String getSaleID() {
		return saleID;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setSaleID(String saleID) {
		this.saleID = saleID;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Sale{" + "saleID=" + saleID + ", date=" + date + ", status=" + status + '}';
	}
	
	public BigDecimal getTotal() {
		
		return null;
	}
	
	public void addItem() {
		
	}
	
}
