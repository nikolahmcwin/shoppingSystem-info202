package dao;

import domain.Customer;
import domain.Product;
import domain.Sale;
import domain.SaleItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleJdbcDAO implements SaleDAO {

    private static final String url = "jdbc:h2:tcp://localhost:9047/project;IFEXISTS=TRUE";

    @Override
    public void save(Sale sale) {

        Connection con = JdbcConnection.getConnection(url);
        try {
            try (
                    PreparedStatement insertSaleStmt = con.prepareStatement(
                            "INSERT INTO SALE(SaleDate, Status, CustomerID) VALUES (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement insertSaleItemStmt = con.prepareStatement(
                            "INSERT INTO SALEITEM(Quantity, Price, ProductID, SaleID) VALUES (?, ?, ?, ?)");
                    PreparedStatement updateProductStmt = con.prepareStatement(
                            "UPDATE PRODUCT SET quantity=? WHERE PID=?");) {

                // Turn off auto-commit which effectively starts a new transaction.
                con.setAutoCommit(false);

                Customer customer = sale.getCustomer();

                // #### save the sale ### //
                // add a date to the sale if one doesn't already exist
                if (sale.getDate() == null) {
                    sale.setDate(new Date());
                }

                // convert sale date into java.sql.Timestamp
                Date date = sale.getDate();
                Timestamp timestamp = new Timestamp(date.getTime());

                // ****
                // write code here that saves the timestamp and username in the
                // sale table using the insertSaleStmt statement.
                // ****
                // INSERT INTO SALE(SaleDate, Status, CustomerID) VALUES (? ? ?)" 
                insertSaleStmt.setTimestamp(1, timestamp);
                insertSaleStmt.setString(2, "received");
                insertSaleStmt.setInt(3, customer.getPersonID());
                
//                System.out.println("**************");
//                System.out.println(insertSaleStmt);
//                System.out.println("**************");
//                System.out.println();
                  
                
                insertSaleStmt.executeUpdate();
                
                // get the auto-generated sale ID from the database
                ResultSet rs = insertSaleStmt.getGeneratedKeys();

                Integer saleId = null;

                if (rs.next()) {
                    saleId = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated Sale ID");
                }

                Collection<SaleItem> items = sale.getItems();

                for (SaleItem item : items) {

                    Product product = item.getProduct();

                    // ****
                    // write code here that saves the sale item
                    // using the insertSaleItemStmt statement.
                    //"INSERT INTO SALEITEM(Quantity, Price, ProductID, SaleID) VALUES (? ? ? ?)");

                    insertSaleItemStmt.setInt(1, item.getQuantityPurchased());
                    insertSaleItemStmt.setBigDecimal(2, product.getPrice());
                    insertSaleItemStmt.setString(3, product.getProductID());
                    insertSaleItemStmt.setInt(4, saleId);
                    
                    insertSaleItemStmt.executeUpdate();
                    
                    // ****
                    // ****
                    // write code here that updates the product quantity using
                    // the updateProductStmt statement.
                    // ****
                    // "UPDATE PRODUCT SET VALUE quantity=? WHERE productID=?"
                    Integer newQuantity = product.getQuantityInStock();
                    newQuantity -= item.getQuantityPurchased();
                    updateProductStmt.setInt(1, newQuantity);
                    updateProductStmt.setString(2, product.getProductID());
                    
                    updateProductStmt.executeUpdate();
                    
                }

                // commit the transaction
                con.setAutoCommit(true);
            }
        } catch (SQLException ex) {

            Logger.getLogger(SaleJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                // something went wrong so rollback
                con.rollback();

                // turn auto-commit back on
                con.setAutoCommit(true);

                // and throw an exception to tell the user something bad happened
                throw new DAOException(ex.getMessage(), ex);
            } catch (SQLException ex1) {
                throw new DAOException(ex1.getMessage(), ex1);
            }

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SaleJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
