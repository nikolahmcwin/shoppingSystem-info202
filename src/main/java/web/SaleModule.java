/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import dao.SaleDAO;
import domain.Sale;
import org.jooby.Jooby;
import org.jooby.Status;


/**
 *
 * @author peani371
 */
public class SaleModule extends Jooby {

    public SaleModule(SaleDAO dao) {

        /*
        get("/api/customers/:username", (req) -> {
            String username = req.param("username").value();
            Customer c = custDao.getCustomer(username);
            if (c == null) {
                throw new Err(Status.NOT_FOUND);
            }
            c.setPassword(null);
            return c;
        });*/
        
        post("/api/sales", (req, rsp) -> {
            Sale sale = req.body().to(Sale.class);
            System.out.println(sale.toString());
            dao.save(sale);
            rsp.status(Status.CREATED);
        });
    }

}
