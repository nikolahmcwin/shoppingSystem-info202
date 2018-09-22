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

        post("/api/sales", (req, rsp) -> {
            System.out.println("\n\n\n\n\n\n" + "*******    trying to saddd");

            Sale sale = req.body(Sale.class);
            System.out.println("\n\n\n\n\n\n" + "*******" + sale.toString());
            dao.save(sale);
            rsp.status(Status.CREATED);
        });
        
        /*
        Customer customer = req.body().to(Customer.class);
            custDao.save(customer);
            rsp.status(Status.CREATED);
        */
    }

}
