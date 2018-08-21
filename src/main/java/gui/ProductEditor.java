/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOException;
import dao.DAOInterface;
import dao.ProductDatabase;
import java.math.BigDecimal;
import domain.Product;
import gui.helpers.SimpleListModel;
import gui.helpers.ValidationHelper;
import java.awt.Window;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author peani371
 */
public class ProductEditor extends javax.swing.JDialog {

    //private final ProductDatabase pStore = new ProductDatabase();
    private final DAOInterface pStore;
    private final SimpleListModel categoryDisplay = new SimpleListModel();
    private Product newProd = new Product();
    private final ValidationHelper validHelp = new ValidationHelper();

    /**
     * Creates new form ProductEditor
     *
     * @param parent
     * @param modal
     * @param dao
     */
    public ProductEditor(Window parent, boolean modal, DAOInterface dao) {
        super(parent);
        super.setModal(modal);
        pStore = dao;
        initComponents();
        txtCategory.setEditable(true);

        // Pull out all categories of products and add to the Combo to display
        Collection<String> allCategories = pStore.getCategories();
        categoryDisplay.updateItems(allCategories);
        txtCategory.setModel(categoryDisplay);

        // add a formatter to the price text field
        validHelp.addTypeFormatter(txtPrice, "#0.00", BigDecimal.class);
        validHelp.addTypeFormatter(txtQuantity, "#0", Integer.class);
    }

    /**
     * Second constructor for Product editor that takes a product
     *
     * @param parent
     * @param modal
     * @param productToEdit
     * @param dao
     */
    public ProductEditor(Window parent, boolean modal, Product productToEdit, 
            DAOInterface dao) {

        this(parent, modal, dao);
        this.newProd = productToEdit;

        // Pull the Product details out
        String id = newProd.getProductID();
        String name = newProd.getName();
        String description = newProd.getDescription();
        String category = newProd.getCategory();
        BigDecimal price = newProd.getPrice();
        Integer quantity = newProd.getQuantityInStock();

        // Set the GUI components to be the Product details
        txtID.setText(id);
        txtName.setText(name);
        txtDescription.setText(description);
        txtCategory.setSelectedItem(category);
        txtPrice.setValue(price);
        txtQuantity.setValue(quantity);

        // Set product ID to be uneditable
        txtID.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        labelDesciption = new javax.swing.JLabel();
        txtDescriptionScrollPane = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        labelCategory = new javax.swing.JLabel();
        labelPrice = new javax.swing.JLabel();
        labelQuantity = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        txtCategory = new javax.swing.JComboBox<>();
        txtPrice = new javax.swing.JFormattedTextField();
        txtQuantity = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("editorDialog"); // NOI18N

        labelID.setText("Product ID");

        txtID.setName("txtID"); // NOI18N

        labelName.setText("Name");

        txtName.setName("txtName"); // NOI18N

        labelDesciption.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setName("txtDescription"); // NOI18N
        txtDescriptionScrollPane.setViewportView(txtDescription);

        labelCategory.setText("Category");

        labelPrice.setText("Price");

        labelQuantity.setText("Quantity in Stock");

        buttonSave.setText("Save");
        buttonSave.setName("buttonSave"); // NOI18N
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        txtCategory.setName("txtCategory"); // NOI18N

        txtPrice.setName("txtPrice"); // NOI18N

        txtQuantity.setName("txtQuantity"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelQuantity)
                    .addComponent(labelPrice)
                    .addComponent(labelCategory)
                    .addComponent(labelDesciption)
                    .addComponent(labelName)
                    .addComponent(labelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID)
                            .addComponent(txtName)
                            .addComponent(txtDescriptionScrollPane)
                            .addComponent(txtCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDesciption)
                    .addComponent(txtDescriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategory)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        try {
            // Pull out the text from the entry fields
            String inputID = txtID.getText();
            String inputName = txtName.getText();
            String inputDescription = txtDescription.getText();
            String inputCategory = (String) txtCategory.getSelectedItem();
            BigDecimal inputPrice = (BigDecimal) txtPrice.getValue();
            Integer inputQuantity = (Integer) txtQuantity.getValue();

            // Set all the Product fields to those from the form
            newProd.setProductID(inputID);
            newProd.setName(inputName);
            newProd.setDescription(inputDescription);
            newProd.setCategory(inputCategory);
            newProd.setPrice(inputPrice);
            newProd.setQuantityInStock(inputQuantity);

            boolean addingNewProduct = txtID.isEditable();

            Product checkProd = pStore.searchForProduct(inputID);
            if (addingNewProduct && checkProd != null) {
                // We are attempting to edit a product ID that already exists
                // and we have created a new product (not simply edited an existing)
                JOptionPane.showMessageDialog(this, "You have entered "
                        + "a Product ID already in use. You must enter a different "
                        + "Product ID.", "Product ID error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // Save the product into the DAO if it is a valid value
                if (validHelp.isObjectValid(newProd)) {
                    pStore.saveProduct(newProd);
                    dispose();

                    // Print the new Product to the console, confirming entry
                    System.out.println(newProd.toString());
                }
            }
        } catch (DAOException ex) {
           
            JOptionPane.showMessageDialog(this, " Database exception thrown: " 
                    + ex.getMessage(), "Database exception",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelDesciption;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JComboBox<String> txtCategory;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JScrollPane txtDescriptionScrollPane;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JFormattedTextField txtPrice;
    private javax.swing.JFormattedTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
