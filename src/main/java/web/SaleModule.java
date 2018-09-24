/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.SaleDAO;
import domain.Customer;
import domain.Product;
import domain.Sale;
import domain.SaleItem;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jooby.Jooby;
import org.jooby.Status;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author peani371
 */
public class SaleModule extends Jooby {

    public SaleModule(SaleDAO dao) {

        post("/api/sales", (req, rsp) -> {

            Sale sale = req.body(Sale.class);
            dao.save(sale);
            rsp.status(Status.CREATED);

            // Send email to confirm shopping done!
            CompletableFuture.runAsync(() -> {

                Email email = new SimpleEmail();
                email.setHostName("localhost");
                email.setSmtpPort(2525);

                try {

                    // Pull customer
                    Customer customer = sale.getCustomer();

                    // Set email message
                    String message = "Hi " + customer.getFirstName() + " "
                            + customer.getSurname() + ",\n\n"
                            + "Thank you for your order. Your order number is: "
                            + sale.getSaleID() + ". The details we have received"
                            + " are: \n\n";

                    for (SaleItem s : sale.getItems()) {
                        Product p = s.getProduct();
                        message += "\t" + s.getQuantityPurchased() + " " +
                                p.getName() + " for $" + s.getItemTotal() + "\n";
                    }
                    message +=  "\n\nSummary:\n" + sale.getItems().size() +
                            " items total, at $" + sale.getTotal() + 
                            ", purchased " + sale.getDate() + ".\n";
                    message += "\n\nKind regards,\nDihickies and Widgets Shop.";

                    email.setFrom("orders@doohickies.com");
                    email.setSubject("Order Confirmation - Doohickies and Widgets Shop");
                    email.setMsg(message);
                    email.addTo(customer.getEmailAddress());
                    email.send();
                } catch (EmailException ex) {
                    Logger.getLogger(SaleModule.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
        });

        /*
        Customer customer = req.body().to(Customer.class);
            custDao.save(customer);
            rsp.status(Status.CREATED);
         */
    }

}
