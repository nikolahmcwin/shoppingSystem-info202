/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import domain.Customer;
import org.jooby.Status;
import dao.CustomerDAOInterface;
import dao.DAOException;
import org.jooby.Err;

/**
 *
 * @author peani371
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerDAOInterface custDao) {
        get("/api/customers/:username", (req) -> {
            String username = req.param("username").value();
            Customer c = custDao.getCustomer(username);
            if (c == null) {
                throw new Err(Status.NOT_FOUND);
            }
            c.setPassword(null);
            return c;
        });

        post("/api/register", (req, rsp) -> {
            Customer customer = req.body().to(Customer.class);
            try {
                custDao.save(customer);
                rsp.status(Status.CREATED);
            } catch (DAOException d) {
                rsp.status(Status.FORBIDDEN);
                rsp.send("Username or email address already in use. Try again.");
                //DAOException(ex.getMessage(), ex);
            }
            
        });
    }
}
