/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peani371
 */
public class DaoTest {

    //private ProductDAOInterface dao = new ProductListDAO();
    private final ProductDAOInterface dao =
            new ProductDatabase("jdbc:h2:tcp://localhost:9047/project-testing");

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

    @Test
    public void testDaoSave() {
        
        // ensure that retrieving before saving does not find anything
        Product r = dao.searchForProduct("3");
        assertNull("Product should not yet exist.", r);
        
        // save the product using DAO
        dao.saveProduct(prodThree);

        // retrieve the same product via DAO
        Product retrieved = dao.searchForProduct("3");

        // ensure that the product we saved is the one we got back
        assertEquals("Retrieved product should be the same",
                prodThree, retrieved);
    }

    @Test
    public void testDaoDelete() {
        // delete the product via the DAO
        dao.deleteProduct(prodOne);

        // try to retrieve the deleted product
        Product retrieved = dao.searchForProduct("1");

        // ensure that the student was not retrieved (should be null)
        assertNull("Product should no longer exist", retrieved);
    }

    @Test
    public void testDaoGetAll() {
        Collection<Product> products = dao.getProducts();

        // ensure the result includes the two saved products
        assertTrue("prodOne should exist", products.contains(prodOne));
        assertTrue("prodTwo should exist", products.contains(prodTwo));

        // ensure the result ONLY includes the two saved products
        assertEquals("Only 2 products in result", 2, products.size());

        // find prodOne - result is not a map, so we have to scan for it
        for (Product p : products) {
            if (p.equals(prodOne)) {

                // ensure that all of the details were correctly retrieved
                assertEquals(prodOne.getProductID(), p.getProductID());
                assertEquals(prodOne.getName(), p.getName());
                assertEquals(prodOne.getDescription(), p.getDescription());
                assertEquals(prodOne.getCategory(), p.getCategory());
                assertEquals(prodOne.getPrice(), p.getPrice());
                assertEquals(prodOne.getQuantityInStock(), p.getQuantityInStock());
            }
        }
    }

    @Test
    public void testDaoFindById() {
        // get prodOne using findById method
        Product retrieved = dao.searchForProduct("1");

        // assert that you got back prodOne, and not another product
        assertEquals("Product found should be ProdOne", retrieved, prodOne);

        // assert that prodOne's details were properly retrieved
        assertEquals(prodOne.getProductID(), retrieved.getProductID());
        assertEquals(prodOne.getName(), retrieved.getName());
        assertEquals(prodOne.getDescription(), retrieved.getDescription());
        assertEquals(prodOne.getCategory(), retrieved.getCategory());
        assertEquals(prodOne.getPrice(), retrieved.getPrice());
        assertEquals(prodOne.getQuantityInStock(), retrieved.getQuantityInStock());
        
        // call getById using a non-existent ID
        Product retrievedNull = dao.searchForProduct("10");
        
        // assert that the result is null
        assertNull("ProdTen should not exist", retrievedNull);
    }
    
    @Test
    public void testDaoEditProduct() {

        // ensure that retrieving before saving has old values
        Product retrieved = dao.searchForProduct("1");
        assertEquals("name1", retrieved.getName());
        assertEquals("cat1", retrieved.getCategory());
        
        // Change some values
        prodOne.setName("NewName");
        prodOne.setCategory("NewCategory");
        
        // Check the values were properly updated
        assertEquals(prodOne.getName(), "NewName");
        assertEquals(prodOne.getCategory(), "NewCategory");
        
        // save the updated product using DAO
        dao.saveProduct(prodOne);

        // retrieve the same product via DAO
        retrieved = dao.searchForProduct("1");
        assertEquals("Retrieved product should be the same",
                prodOne, retrieved);
        
        // assert that prodOne's details were properly retrieved
        assertEquals(prodOne.getProductID(), retrieved.getProductID());
        assertEquals(prodOne.getName(), retrieved.getName());
        assertEquals(prodOne.getDescription(), retrieved.getDescription());
        assertEquals(prodOne.getCategory(), retrieved.getCategory());
        assertEquals(prodOne.getPrice(), retrieved.getPrice());
        assertEquals(prodOne.getQuantityInStock(), retrieved.getQuantityInStock());

    }
    
    @Test
    public void testDaoGetAllCategories() {
        Collection<String> categories = dao.getCategories();

        // ensure the result includes the two saved products
        assertTrue("prodOne category should exist", categories.contains(prodOne.getCategory()));
        assertTrue("prodTwo category should exist", categories.contains(prodTwo.getCategory()));

        // ensure the result ONLY includes the two saved products
        assertEquals("Only 2 categories in result", 2, categories.size());
        
        // add a new category and check that now exists
        dao.saveProduct(prodThree);
        categories = dao.getCategories();
        
        // ensure the result now includes three categories
        assertEquals("3 categories in result should exist", 3, categories.size());
        assertTrue("prodThree category should exist", 
                categories.contains(prodThree.getCategory()));
    }
    
    @Test
    public void testDaoGetProductByCategory() {
        
        // Test an existing category returns all products in it
        Collection<Product> results = 
                dao.filterProductCategory(prodOne.getCategory());
        assertEquals("1 product should exist in results", 1, results.size());
        assertTrue("prodOne category should exist", results.contains(prodOne));
        
        // Add a new prod to existing category and test it is found
        prodThree.setCategory("cat1");
        dao.saveProduct(prodThree);
        results = dao.filterProductCategory(prodOne.getCategory());
        assertEquals("2 products should exist in results", 2, results.size());
        assertTrue("prodOne category should exist", results.contains(prodOne));
        assertTrue("prodOneopy category should exist", results.contains(prodThree));
        
        // test retrieving non existing category gives null
        results = dao.filterProductCategory("nonexisting");
        assertEquals("0 products should exist in results", 0, results.size());
    }
}
