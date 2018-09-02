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

/**
 *
 * @author peani371
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerDAOInterface custDao) {
        get("/api/customers/:username", (req) -> {
            String username = req.param("username").value();
            Customer c = custDao.getCustomer(username);
            c.setPassword(null);
            return c;
        });

        post("/api/register", (req, rsp) -> {
            Customer customer = req.body().to(Customer.class);
            custDao.save(customer);
            rsp.status(Status.CREATED);
        });
    }
}
