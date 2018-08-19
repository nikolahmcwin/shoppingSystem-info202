/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peani371
 */
public class DaoTest {

    private DAOInterface dao = new ProductListDAO();

    private Product prodOne;
    private Product prodTwo;
    private Product prodThree;

    public DaoTest() {
    }

    @Before
    public void setUp() {

        this.prodOne = new Product("1", "name1", "desc1", "cat1",
                new BigDecimal("11.00"), new Integer("22"));
        this.prodTwo = new Product("2", "name2", "desc2", "cat2",
                new BigDecimal("33.00"), new Integer("44"));
        this.prodThree = new Product("3", "name3", "desc3", "cat3",
                new BigDecimal("55.00"), new Integer("66"));

        // save the products
        dao.saveProduct(prodOne);
        dao.saveProduct(prodTwo);
        // Note: Intentionally not saving prodThree
    }

    @After
    public void tearDown() {
        dao.deleteProduct(prodOne);
        dao.deleteProduct(prodTwo);
        dao.deleteProduct(prodThree);
    }

}
