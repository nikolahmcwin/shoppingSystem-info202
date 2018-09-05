package gui;

import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import dao.ProductDAOInterface;
import gui.helpers.SimpleListModel;

/**
 *
 * @author peani371
 */
public class ProductViewAllTest {

    private ProductDAOInterface dao;
    private DialogFixture fixture;
    private Robot robot;

    private Product prodOne;
    private Product prodTwo;
    private Product prodThree;

    public ProductViewAllTest() {
    }

    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(75);

        this.prodOne = new Product("1", "name1", "desc1", "cat1",
                new BigDecimal("11.00"), new Integer("22"));
        this.prodTwo = new Product("2", "name2", "desc2", "cat2",
                new BigDecimal("33.00"), new Integer("44"));
        this.prodThree = new Product("3", "name3", "desc3", "cat3",
                new BigDecimal("55.00"), new Integer("66"));

        Collection<Product> products = new HashSet<>();
        products.add(prodOne);
        products.add(prodTwo);
        
        // create a mock for the DAO
	dao = mock(ProductDAOInterface.class);
        when(dao.getProducts()).thenReturn(products);
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
        
        SimpleListModel model = (SimpleListModel) fixture.list("lstProducts").target().getModel();

        // check the contents
        assertTrue("list contains the expected product", model.contains(prodOne));
        assertEquals("list contains the correct number of products", 2, model.getSize());
    }

}
