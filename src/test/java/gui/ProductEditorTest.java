/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOInterface;
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

/**
 *
 * @author peani371
 */
public class ProductEditorTest {

    private DAOInterface dao;
    private DialogFixture fixture;
    private Robot robot;

    public ProductEditorTest() {
    }

    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(100);

        Collection<String> categories = new HashSet<>();
        categories.add("cat1");
        categories.add("NewCategory");

        // create a mock for the DAO
        dao = mock(DAOInterface.class);

        // stub the getMajors method to return the test majors
        when(dao.getCategories()).thenReturn(categories);

    }

    @After
    public void tearDown() {
        fixture.cleanUp();
    }

    @Test
    public void testEdit() {
        Product prod1 = new Product("1", "name1", "desc1", "cat1",
                new BigDecimal("11.00"), new Integer("22"));

        ProductEditor dialog = new ProductEditor(null, true, prod1, dao);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        // verify that the UI componenents contains the student's details
        fixture.textBox("txtID").requireText("1");
        fixture.textBox("txtName").requireText("name1");
        fixture.textBox("txtDescription").requireText("desc1");
        fixture.comboBox("txtCategory").requireSelection("cat1");
        fixture.textBox("txtPrice").requireText("11.00");
        fixture.textBox("txtQuantity").requireText("22");

        // edit the name and major
        fixture.textBox("txtName").selectAll().deleteText().enterText("Jim");
        fixture.comboBox("txtCategory").selectItem("NewCategory");

        // click the save button
        fixture.button("buttonSave").click();

        // create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);

        // verify that the DAO.save method was called, and capture the passed student
        verify(dao).saveProduct(argument.capture());

        // retrieve the passed student from the captor
        Product editedProduct = argument.getValue();

        // check that the changes were saved
        assertEquals("Ensure the name was changed", "Jim", editedProduct.getName());
        assertEquals("Ensure the major was changed", "NewCategory", editedProduct.getCategory());
    }

    @Test
    public void testSave() {
        // create the dialog passing in the mocked DAO
        ProductEditor dialog = new ProductEditor(null, true, dao);

        // use AssertJ to control the dialog
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        // enter some details into the UI components
        fixture.textBox("txtID").enterText("2");
        fixture.textBox("txtName").enterText("name2");
        fixture.textBox("txtDescription").enterText("desc2");
        fixture.comboBox("txtCategory").selectItem("cat1");
        fixture.textBox("txtPrice").enterText("11");
        fixture.textBox("txtQuantity").enterText("22");

        // click the save button
        fixture.button("buttonSave").click();

        // create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);

        // verify that the DAO.save method was called, and capture the passed student
        verify(dao).saveProduct(argument.capture());

        // retrieve the passed student from the captor
        Product savedProduct = argument.getValue();

        // check that the Product was saved
        assertEquals("Ensure the ID was saved", "2", savedProduct.getProductID());
        assertEquals("Ensure the name was saved", "name2", savedProduct.getName());
        assertEquals("Ensure the description was saved", "desc2", savedProduct.getDescription());
        assertEquals("Ensure the category was saved", "cat1", savedProduct.getCategory());
        assertEquals("Ensure the price was saved", new BigDecimal("11"), savedProduct.getPrice());
        assertEquals("Ensure the quantity was saved",  new Integer("22"), savedProduct.getQuantityInStock());
    }

}
