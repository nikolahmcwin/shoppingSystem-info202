package gui;

import domain.Product;
import gui.helpers.SimpleListModel;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import dao.ProductDAOInterface;

/**
 *
 * @author peani371
 */
public class ProductViewerTest {

    private ProductDAOInterface dao;
    private DialogFixture fixture;
    private Robot robot;
    private Product prodOne;
    private Product prodTwo;

    public ProductViewerTest() {
    }

    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(100);

        // Mock the products
        Collection<Product> products = new TreeSet<>();

        prodOne = new Product("1", "name1", "desc1", "cat1",
                new BigDecimal("11.00"), new Integer("22"));
        prodTwo = new Product("2", "name2", "desc2", "cat2",
                new BigDecimal("33.00"), new Integer("44"));

        products.add(prodOne);
        products.add(prodTwo);

        dao = mock(ProductDAOInterface.class);
        when(dao.getProducts()).thenReturn(products);
        
        /*
        // Mock the categories too
        Collection<String> categories = new HashSet<>();
        categories.add("cat1");
        categories.add("NewCategory");
        when(dao.getCategories()).thenReturn(categories);

        // stub the deleteProduct method
        Mockito.doAnswer(new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                products.remove(prodOne);
                return null;
            }
        }).when(dao).deleteProduct(prodOne);
        */

    }

    @After
    public void tearDown() {
        fixture.cleanUp();
    }

    @Test
    public void testViewAllProducts() {
        // create the dialog passing in the mocked DAO
        ProductViewer dialog = new ProductViewer(null, true, dao);

        // use AssertJ to control the dialog
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        // get the model
        SimpleListModel model = (SimpleListModel) fixture.list("lstProducts").target().getModel();

        // check the contents
        assertTrue("list contains the expected product", model.contains(prodOne));
        assertEquals("list contains the correct number of products", 2, model.getSize());

    }
/*
    @Test
    public void testSearchByID() {
        // BONUS TASK
        
        //It should select a product in the report, click the edit
        //button, and then verify that the selected project is 
        //displayed in the editor dialog.
    }

    @Test
    public void testFilterByCategory() {
        // BONUS TASK
    }

    @Test
    public void testEditProduct() {
        // BONUS TASK
    }

    @Test
    public void testDeleteProduct() {
        // BONUS TASK
    }
*/
}
