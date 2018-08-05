/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDatabase;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author peani371
 */
public class ProductViewer extends javax.swing.JDialog {

    private final ProductDatabase pStore = new ProductDatabase();
    private final SimpleListModel productDisplay = new SimpleListModel();
    private final SimpleListModel categoryDisplay = new SimpleListModel();

    /**
     * Creates new form ProductViewer
     *
     * @param parent
     * @param modal
     */
    public ProductViewer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Pull out all products stored and add to the List to display
        Collection<Product> allProducts = pStore.getProducts();
        productDisplay.updateItems(allProducts);
        listProductDisplay.setModel(productDisplay);

        // Pull out all categories of products and add to the Combo to display
        Collection<String> allCategories = pStore.getCategories();
        categoryDisplay.updateItems(allCategories);
        comboCategoryFilter.setModel(categoryDisplay);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSearchByID = new javax.swing.JLabel();
        labelCategoryFilter = new javax.swing.JLabel();
        buttonSearch = new javax.swing.JButton();
        comboCategoryFilter = new javax.swing.JComboBox<>();
        txtSearchID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProductDisplay = new javax.swing.JList<>();
        buttonEdit = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelSearchByID.setText("Search by ID");

        labelCategoryFilter.setText("Category Filter");

        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        comboCategoryFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryFilterActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listProductDisplay);

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSearchByID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCategoryFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCategoryFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClose, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSearchByID)
                    .addComponent(buttonSearch)
                    .addComponent(txtSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategoryFilter)
                    .addComponent(comboCategoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEdit)
                    .addComponent(buttonDelete)
                    .addComponent(buttonClose))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed

        if (!listProductDisplay.isSelectionEmpty()) {
            // Pull the selected product out of the JList
            Product selectedProd = listProductDisplay.getSelectedValue();

            // Ask the user to confirm their deletion
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you"
                    + " wish to delete the Product: " + selectedProd.toString()
                    + "?", "Confirm deletion", JOptionPane.INFORMATION_MESSAGE);

            // Check whether the user confirmed
            if (result == JOptionPane.YES_OPTION) {

                // Delete the product
                pStore.deleteProduct(selectedProd);

                // Update the JList to reflect the changes
                Collection<Product> updatedProducts = pStore.getProducts();
                productDisplay.updateItems(updatedProducts);
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed

        if (!listProductDisplay.isSelectionEmpty()) {
            // Pull the selected product out of the JList
            Product selectedProd = listProductDisplay.getSelectedValue();

            // Open a product editor dialog
            ProductEditor editProduct = new ProductEditor(this, true, selectedProd);
            editProduct.setLocationRelativeTo(this);
            editProduct.setVisible(true);

            // Update the JList to reflect the changes
            Collection<Product> updatedProducts = pStore.getProducts();
            productDisplay.updateItems(updatedProducts);

            // Also update the ComboBox in case categories have changed
            Collection<String> newCategories = pStore.getCategories();
            categoryDisplay.updateItems(newCategories);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // Pull out the ID to search for
        String searchedID = txtSearchID.getText();

        if (searchedID.isEmpty()) {
            // None selected, simply display all products
            Collection<Product> allProducts = pStore.getProducts();
            productDisplay.updateItems(allProducts);
        } else {
            // Update the JList to dislay only the search
            Product searchedProduct = pStore.searchForProduct(searchedID);
            productDisplay.updateItems(searchedProduct);
        }
       
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void comboCategoryFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryFilterActionPerformed
        // Pull out whichever category is selected
        String categorySelected
                = (String) comboCategoryFilter.getSelectedItem();

        // Filter products on that category
        Collection<Product> categoryFilteredProducts
                = pStore.filterProductCategory(categorySelected);

        // Update the JList to display only those products
        productDisplay.updateItems(categoryFilteredProducts);
    }//GEN-LAST:event_comboCategoryFilterActionPerformed

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
            java.util.logging.Logger.getLogger(ProductViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductViewer dialog = new ProductViewer(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox<String> comboCategoryFilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCategoryFilter;
    private javax.swing.JLabel labelSearchByID;
    private javax.swing.JList<Product> listProductDisplay;
    private javax.swing.JTextField txtSearchID;
    // End of variables declaration//GEN-END:variables
}
