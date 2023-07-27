/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gestion_bancaire2;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mickael
 */
public class TableRendre extends javax.swing.JInternalFrame {

    /**
     * Creates new form TableRendre
     */
    String type ="";
    Connection conn;
    PreparedStatement st;
    PreparedStatement recherche;
    PreparedStatement Taux;
    ResultSet resultat;
    public TableRendre() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        voir_list_rendre();
       JComboBox();
       colorerTable();
    }
    
    public void colorerTable() {
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Appelez la méthode de la superclasse pour obtenir le composant par défaut
            java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Définissez la couleur de fond pour les lignes impaires sur une couleur personnalisée
            if (row % 2 == 0) {
                //cellComponent.setBackground(Color.LIGHT_GRAY);
                cellComponent.setBackground(Color.LIGHT_GRAY);
            } else {
                // Définissez la couleur de fond pour les lignes paires sur une autre couleur personnalisée
                cellComponent.setBackground(Color.WHITE);
            }

            // Retournez le composant mis à jour
            return cellComponent;
        }
    };

    // Appliquez le rendu personnalisé à toutes les colonnes de votre JTable
    for (int i = 0; i < Table_Rendre.getColumnCount(); i++) {
        Table_Rendre.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    }
}
 
public void searchType() {
    try {
        String[] renduColumns = {"num_rendu", "num_compte", "nom et prenom", "situation", "rest_payé", "date_rendu"};
        DefaultTableModel model = new DefaultTableModel(null, renduColumns);
        String query = "SELECT DISTINCT rendre.num_rendu, rendre.num_pret, CLIENT.NOM, CLIENT.PRENOM, rendre.situation, rendre.rest_payé, rendre.date_rendu FROM rendre JOIN CLIENT ON rendre.num_pret = CLIENT.numCompte ";

        if (type.equals("tout payer")) {
            query += "WHERE rendre.situation = 'tout payer'";
        } else if (type.equals("payer une part")) {
            query += "WHERE rendre.situation = 'payer une part' AND NOT EXISTS (SELECT * FROM rendre WHERE rendre.num_pret = rendre.num_pret AND rendre.situation = 'tout payé')";
        } else if (type.equals("pas encore payer")){
            query += "WHERE rendre.situation = 'pas encore payer'";
        }

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        recherche = conn.prepareStatement(query);
        resultat = recherche.executeQuery();

        while (resultat.next()) {
            String num_pret = resultat.getString("num_rendu");
            String numCompte = resultat.getString("num_pret");
            String nom = resultat.getString("NOM");
            String prenom = resultat.getString("PRENOM");
            String nomComplet = nom + " " + prenom;
            String montant = resultat.getString("situation");
            String rest = resultat.getString("rest_payé");
            String date_pret = resultat.getString("date_rendu");

            Object[] rowData = {num_pret, numCompte, nomComplet, montant, rest, date_pret};
            model.addRow(rowData);
        }

        Table_Rendre.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    
    
    
    
 public void JComboBox()
    {
        
 
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
           st = conn.prepareStatement("SELECT numCompte FROM CLIENT");
           resultat = st.executeQuery();
            while (resultat.next()) 
            {
              String numCompte = resultat.getString("numCompte");
              numRendu.addItem(numCompte);
            }
        } 
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
}

    public void voir_list_rendre()
    {
        int Compter;
         try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("SELECT CLIENT.NOM,CLIENT.PRENOM,RENDRE.num_rendu,RENDRE.num_pret,RENDRE.situation,RENDRE.rest_payé,RENDRE.date_rendu FROM RENDRE JOIN CLIENT ON CLIENT.numCompte = RENDRE.num_pret ORDER BY num_rendu DESC");
            resultat = st.executeQuery();
            
            ResultSetMetaData RSMD = resultat.getMetaData();
            Compter = RSMD.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Table_Rendre.getModel();
            dft.setRowCount(0);
            
            while (resultat.next())
            {
                Vector v2 = new Vector();
                
                for (int i = 1 ; i<= Compter; i++)
                {
                    String nom = resultat.getString("CLIENT.NOM");
                    String prenom = resultat.getString("CLIENT.PRENOM");
                    String nomComplet = nom+" "+prenom;
                    
                    v2.add(resultat.getString("RENDRE.num_rendu"));
                    v2.add(resultat.getString("RENDRE.num_pret"));
                    v2.add(nomComplet);
                    v2.add(resultat.getString("RENDRE.situation"));
                    v2.add(resultat.getString("RENDRE.rest_payé"));
                    v2.add(resultat.getString("RENDRE.date_rendu"));
                }
                dft.addRow(v2);
            }
            
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Rendre = new javax.swing.JTable();
        AjoutRendre = new javax.swing.JButton();
        Situation = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Reste = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateRendre = new javax.swing.JTextField();
        Effacer = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        numRendu = new javax.swing.JComboBox<>();
        payerPart = new javax.swing.JRadioButton();
        toutpayer = new javax.swing.JRadioButton();
        pasencorePayer = new javax.swing.JRadioButton();

        Table_Rendre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "num_rendu", "num_compte", "nom et prenom", "situation", "rest_payé", "date_rendu"
            }
        ));
        Table_Rendre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_RendreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Rendre);

        AjoutRendre.setIcon(new javax.swing.ImageIcon("D:\\Mon_Dossier\\NetBeansProjects\\Gestion_bancaire2\\icons8-plus-30.png")); // NOI18N
        AjoutRendre.setText("Rendre");
        AjoutRendre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutRendreActionPerformed(evt);
            }
        });

        jLabel1.setText("NUM_PRET");

        jLabel2.setText("SITUATION");

        jLabel3.setText("RESTE_PAYER");

        jLabel4.setText("DATE_RENDU");

        Effacer.setBackground(new java.awt.Color(0, 0, 0));
        Effacer.setForeground(new java.awt.Color(255, 255, 255));
        Effacer.setText("EFFACER");
        Effacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EffacerActionPerformed(evt);
            }
        });

        Annuler.setBackground(new java.awt.Color(0, 0, 0));
        Annuler.setForeground(new java.awt.Color(255, 255, 255));
        Annuler.setText("ANNULER");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        numRendu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        buttonGroup1.add(payerPart);
        payerPart.setText("payer une part");
        payerPart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payerPartMouseClicked(evt);
            }
        });
        payerPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payerPartActionPerformed(evt);
            }
        });
        payerPart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                payerPartKeyPressed(evt);
            }
        });

        buttonGroup1.add(toutpayer);
        toutpayer.setText("tout payer");
        toutpayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toutpayerMouseClicked(evt);
            }
        });
        toutpayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toutpayerActionPerformed(evt);
            }
        });

        buttonGroup1.add(pasencorePayer);
        pasencorePayer.setText("pas encore payer");
        pasencorePayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pasencorePayerMouseClicked(evt);
            }
        });
        pasencorePayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasencorePayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(numRendu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Situation, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateRendre, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reste, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AjoutRendre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payerPart)
                        .addGap(12, 12, 12)
                        .addComponent(pasencorePayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toutpayer)
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Effacer)
                .addGap(127, 127, 127)
                .addComponent(Annuler)
                .addGap(254, 254, 254))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AjoutRendre)
                    .addComponent(payerPart)
                    .addComponent(toutpayer)
                    .addComponent(pasencorePayer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numRendu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Situation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(Reste, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateRendre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Annuler)
                    .addComponent(Effacer))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjoutRendreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutRendreActionPerformed
        // TODO add your handling code here:
        AjoutRendre rendre = new AjoutRendre(new javax.swing.JFrame(), true);
        rendre.setVisible(true);
    }//GEN-LAST:event_AjoutRendreActionPerformed

    private void Table_RendreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_RendreMouseClicked
        // TODO add your handling code here:      
         DefaultTableModel model = (DefaultTableModel) Table_Rendre.getModel();
        int selectedIndex = Table_Rendre.getSelectedRow();
        int num = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
        float num1 = Float.parseFloat(model.getValueAt(selectedIndex,4).toString());
        
        numRendu.setSelectedItem(model.getValueAt(selectedIndex,1).toString());
        Situation.setText(model.getValueAt(selectedIndex,3).toString());
        Reste.setText(model.getValueAt(selectedIndex,4).toString());
        dateRendre.setText(model.getValueAt(selectedIndex,5).toString());
    }//GEN-LAST:event_Table_RendreMouseClicked

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // TODO add your handling code here:
        numRendu.setSelectedIndex(0);
        Situation.setText("");
        Reste.setText("");
        dateRendre.setText("");
    }//GEN-LAST:event_AnnulerActionPerformed

    private void EffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EffacerActionPerformed
        // TODO add your handling code here:
         try
        {
            DefaultTableModel model = (DefaultTableModel) Table_Rendre.getModel();
            int selectedIndex = Table_Rendre.getSelectedRow();
            int num = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());   
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("DELETE FROM RENDRE WHERE num_rendu=? AND num_pret= ?");
            st.setInt(1, num);
            st.setString(2, numRendu.getSelectedItem().toString());
            int row = st.executeUpdate();
            JOptionPane.showMessageDialog(null,"suppression effectuer");
            
            numRendu.setSelectedIndex(0);
            Situation.setText("");
            Reste.setText("");
            dateRendre.setText("");
            
            voir_list_rendre();
                  
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        } 
    }//GEN-LAST:event_EffacerActionPerformed

    private void payerPartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payerPartMouseClicked
        // TODO add your handling code here:
        searchType();
    }//GEN-LAST:event_payerPartMouseClicked

    private void payerPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payerPartActionPerformed
        // TODO add your handling code here:
        type = "payer une part";
        
    }//GEN-LAST:event_payerPartActionPerformed

    private void pasencorePayerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasencorePayerMouseClicked
        // TODO add your handling code here:
        searchType();
        
    }//GEN-LAST:event_pasencorePayerMouseClicked

    private void pasencorePayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasencorePayerActionPerformed
        // TODO add your handling code here:
        type = "pas encore payer";
        
    }//GEN-LAST:event_pasencorePayerActionPerformed

    private void toutpayerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toutpayerMouseClicked
        // TODO add your handling code here:
        searchType();
    }//GEN-LAST:event_toutpayerMouseClicked

    private void toutpayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toutpayerActionPerformed
        // TODO add your handling code here:
        type = "tout payer";
        
    }//GEN-LAST:event_toutpayerActionPerformed

    private void payerPartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payerPartKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_payerPartKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjoutRendre;
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Effacer;
    private javax.swing.JTextField Reste;
    private javax.swing.JTextField Situation;
    private javax.swing.JTable Table_Rendre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dateRendre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> numRendu;
    private javax.swing.JRadioButton pasencorePayer;
    private javax.swing.JRadioButton payerPart;
    private javax.swing.JRadioButton toutpayer;
    // End of variables declaration//GEN-END:variables
}
