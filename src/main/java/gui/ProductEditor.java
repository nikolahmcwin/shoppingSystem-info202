/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductListDAO;
import java.math.BigDecimal;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.awt.Window;
import java.util.Collection;

/**
 *
 * @author peani371
 */
public class ProductEditor extends javax.swing.JDialog {

    private ProductListDAO pStore = new ProductListDAO();
    private SimpleListModel categoryDisplay = new SimpleListModel();
    private Product newProd = new Product();

    /**
     * Creates new form ProductEditor
     */
    public ProductEditor(Window parent, boolean modal) {
        super(parent);
        super.setModal(modal);
        initComponents();
        txtCategory.setEditable(true);
        
        // Pull out all categories of products and add to the Combo to display
        Collection<String> allCategories = pStore.getCategories();
        categoryDisplay.updateItems(allCategories);
        txtCategory.setModel(categoryDisplay);
    }
    
    /**
    * Second constructor for Product editor that takes a product
    */
    public ProductEditor(Window parent, boolean modal, Product productToEdit) {
        
        this(parent, modal);
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
        txtPrice.setText(String.valueOf(price));
        txtQuantity.setText(String.valueOf(quantity));
        
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
        txtQuantity = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        txtCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelID.setText("Product ID");

        labelName.setText("Name");

        labelDesciption.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescriptionScrollPane.setViewportView(txtDescription);

        labelCategory.setText("Category");

        labelPrice.setText("Price");

        labelQuantity.setText("Quantity in Stock");

        buttonSave.setText("Save");
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

        txtCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                    .addComponent(txtID)
                    .addComponent(txtName)
                    .addComponent(txtDescriptionScrollPane)
                    .addComponent(txtQuantity)
                    .addComponent(txtPrice)
                    .addComponent(txtCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
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
                    .addComponent(txtDescriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategory)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        // Pull out the text from the entry fields
        String inputID = txtID.getText();
        String inputName = txtName.getText();
        String inputDescription = txtDescription.getText();
        String inputCategory = (String) txtCategory.getSelectedItem();
        String inputPrice = txtPrice.getText();
        String inputQuantity = txtQuantity.getText();

        // Convert the two numbers from their String representation
        Integer intQuantity = new Integer(inputQuantity);
        BigDecimal bdPrice = new BigDecimal(inputPrice);

        // Create a new Product instance
        //Product newProd = new Product();

        // Set all the Product fields to those from the form
        newProd.setProductID(inputID);
        newProd.setName(inputName);
        newProd.setDescription(inputDescription);
        newProd.setCategory(inputCategory);
        newProd.setPrice(bdPrice);
        newProd.setQuantityInStock(intQuantity);

        // Print the new Product to the console, confirming entry
        System.out.println(newProd.toString());

        // Save the product into the DAO
        pStore.saveProduct(newProd);
        
        // Close the dialog to confirm product is saved
        dispose();
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductEditor dialog = new ProductEditor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

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
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
