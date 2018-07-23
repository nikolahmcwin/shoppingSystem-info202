package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Customer customer;
    private List<SaleItem> saleItems = new ArrayList<>();

    public String getSaleID() {
        return saleID;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Sale{" + "saleID=" + saleID + ", date=" + date 
                + ", status=" + status + '}';
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        
        // Loop through each saleItem, and pull out the price, adding to total
        //for (SaleItem item : saleItems) {
        saleItems.forEach((item) -> {
            total.add(item.getItemTotal());
        });
        
        return total;
    }

    public void addItem(SaleItem item) {
        saleItems.add(item);
    }

}
