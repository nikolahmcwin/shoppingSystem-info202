package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author peani371
 */
public class Sale {

    private String saleID;
    private Date date;
    private String status;
    private Customer customer;
    private Collection<SaleItem> items = new ArrayList<>();

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

    public Collection<SaleItem> getItems() {
        return items;
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

    public void setItems(Collection<SaleItem> saleItems) {
        this.items = saleItems;
    }

    @Override
    public String toString() {
        return "Sale{" + "saleID=" + saleID + ", date=" + date 
                + ", status=" + status + '}';
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        
        // Loop through each saleItem, and pull out the price, adding to total
        for (SaleItem item : items) {
            total.add(item.getItemTotal());
        }
        
        return total;
    }

    public void addItem(SaleItem item) {
        items.add(item);
    }

}
