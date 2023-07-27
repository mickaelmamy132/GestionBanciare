/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gestion_bancaire2;

//import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.Element;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;





/**
 *
 * @author mickael
 */
public class TableVirement extends javax.swing.JInternalFrame {

    /**
     * Creates new form TableVirement
     */
    Connection conn;
    PreparedStatement st;
    PreparedStatement dediteur;
    PreparedStatement beneficiaire; 
    PreparedStatement modifDediteur;
    PreparedStatement modifBeneficiaire;
    ResultSet resultat;
    public TableVirement() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        voir_list_virement();
        colorerTable();
        //JComboBox();
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
    for (int i = 0; i < Table_Virement.getColumnCount(); i++) {
        Table_Virement.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    }
}
    /*
    public void JComboBox()
    {
        
 
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
           st = conn.prepareStatement("SELECT * FROM CLIENT");
           resultat = st.executeQuery();
            while (resultat.next()) 
            {
              String numCompte = resultat.getString("numCompte");
              modifNum2.addItem(numCompte);
            }
        } 
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
}*/
    
     public void voir_list_virement()
    {
        int Compter;
         try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("SELECT c1.Nom AS Nom1, c1.Prenom AS Prenom1, c2.Nom AS Nom2, c2.Prenom AS Prenom2, v.numCompte, v.numCompt, v.montant, v.dateTransfert,v.idvirement FROM VIREMENT v JOIN CLIENT c1 ON c1.numCompte = v.numCompte JOIN CLIENT c2 ON c2.numCompte = v.numCompt ORDER BY dateTransfert DESC");
            resultat = st.executeQuery();
            
            ResultSetMetaData RSMD = resultat.getMetaData();
            Compter = RSMD.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Table_Virement.getModel();
            dft.setRowCount(0);
            
            while (resultat.next())
            {
                Vector v2 = new Vector();
                
                for (int i = 1 ; i<= Compter; i++)
                {
                    String nom = resultat.getString("Nom1");
                    String prenom = resultat.getString("Prenom1");
                    String nomcomplet = nom+" "+prenom;
                    
                    String nom2 = resultat.getString("Nom2");
                    String prenom2 = resultat.getString("Prenom2");
                    String nomcomplet2 = nom2+" "+prenom2;
                    
                    v2.add(resultat.getString("v.numCompte"));
                    v2.add(nomcomplet);
                    v2.add(resultat.getString("v.numCompt"));
                    v2.add(nomcomplet2);
                    v2.add(resultat.getString("v.montant"));
                    v2.add(resultat.getString("v.dateTransfert"));
                    v2.add(resultat.getString("v.idvirement"));
                }
                dft.addRow(v2);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Virement = new javax.swing.JTable();
        nouveauVirement = new javax.swing.JButton();
        modifMont = new javax.swing.JTextField();
        modifDate = new javax.swing.JTextField();
        modifier = new javax.swing.JButton();
        effacer = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PDF = new javax.swing.JButton();

        Table_Virement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "numCompte", "nom et prenom", "numCompte", "nom et prenom", "montant", "date", "idvirement"
            }
        ));
        Table_Virement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_VirementMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Virement);

        nouveauVirement.setIcon(new javax.swing.ImageIcon("D:\\Mon_Dossier\\NetBeansProjects\\Gestion_bancaire2\\icons8-plus-30.png")); // NOI18N
        nouveauVirement.setText("Virement");
        nouveauVirement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouveauVirementActionPerformed(evt);
            }
        });

        modifier.setBackground(new java.awt.Color(0, 0, 0));
        modifier.setForeground(new java.awt.Color(255, 255, 255));
        modifier.setText("MODIFIER");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        effacer.setBackground(new java.awt.Color(0, 0, 0));
        effacer.setForeground(new java.awt.Color(255, 255, 255));
        effacer.setText("EFFACER");
        effacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerActionPerformed(evt);
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

        jLabel3.setText("montant");

        jLabel4.setText("dateTransfer");

        PDF.setBackground(new java.awt.Color(0, 0, 0));
        PDF.setForeground(new java.awt.Color(255, 255, 255));
        PDF.setText("GENERER PDF");
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nouveauVirement)
                .addGap(656, 656, 656))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(modifier))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modifMont, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(effacer)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(modifDate, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(Annuler)
                                .addGap(56, 56, 56)
                                .addComponent(PDF)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nouveauVirement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifMont, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifier)
                    .addComponent(effacer)
                    .addComponent(Annuler)
                    .addComponent(PDF))
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nouveauVirementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouveauVirementActionPerformed
        // TODO add your handling code here:
       AjoutVirement virement = new AjoutVirement(new javax.swing.JFrame(), true);
       virement.setVisible(true);
    }//GEN-LAST:event_nouveauVirementActionPerformed

    private void Table_VirementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_VirementMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) Table_Virement.getModel();
        int selectedIndex = Table_Virement.getSelectedRow();
  
     /*   modifNum.addItem(model.getValueAt(selectedIndex,0).toString());
        modifNum2.addItem(model.getValueAt(selectedIndex,2).toString());
        modifNum2.setSelectedItem(model.getValueAt(selectedIndex,2).toString());*/
        modifMont.setText(model.getValueAt(selectedIndex,4).toString());
        modifDate.setText(model.getValueAt(selectedIndex,5).toString());
        
    }//GEN-LAST:event_Table_VirementMouseClicked

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:
         try
        {
            DefaultTableModel model = (DefaultTableModel) Table_Virement.getModel();
            int selectedIndex = Table_Virement.getSelectedRow();
            
            String num = (model.getValueAt(selectedIndex,0).toString());
            String num2 = (model.getValueAt(selectedIndex,2).toString());
            String id = (model.getValueAt(selectedIndex,6).toString());
            
             // Récupération du montant du débiteur
            dediteur = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            dediteur.setString(1, num);
            resultat = dediteur.executeQuery();
             int DebiteurActuel = 0;
            while (resultat.next()) 
            {
                 DebiteurActuel = resultat.getInt("SOLDET");
            } 
            
            //Récupération du montant du beneficiaire
            beneficiaire = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            beneficiaire.setString(1, num2);
            resultat = beneficiaire.executeQuery();
            int BeneficiaireActuel = 0;
            while (resultat.next()) 
            {
                 BeneficiaireActuel = resultat.getInt("SOLDET");
            }
            
            //recuperer l'ancien montant envoyer
            st = conn.prepareStatement("SELECT montant FROM VIREMENT WHERE idvirement = ?");
            st.setString(1, id);
            resultat = st.executeQuery();
            float montant = 0;
            while(resultat.next())
            {
                montant = resultat.getFloat("montant");
            }
            
            float dedit = DebiteurActuel + montant;
            float benefi = BeneficiaireActuel - montant;
            
            conn.setAutoCommit(false);
            
            modifDediteur = conn.prepareStatement("UPDATE CLIENT SET SOLDET = ? WHERE numCompte = ?");
            modifDediteur.setFloat(1,dedit );
            modifDediteur.setString(2,num);
            modifDediteur.executeUpdate();
            
            //modification du solde beneficiaire
            modifBeneficiaire = conn.prepareStatement("UPDATE CLIENT SET SOLDET = ? WHERE numCompte = ?");
            modifBeneficiaire.setFloat(1, benefi);
            modifBeneficiaire.setString(2,num2);
            modifBeneficiaire.executeUpdate();
            
            // Validation de la transaction
            conn.commit();
            
             
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("UPDATE VIREMENT SET montant=?,dateTransfert=? WHERE idvirement = ?");
            st.setFloat(1,Float.parseFloat(modifMont.getText()));
            st.setString(2,modifDate.getText());
            st.setString(3, id);
            int RT = st.executeUpdate();
            
            conn.setAutoCommit(false);
            
            modifDediteur = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET - ? WHERE numCompte = ?");
            modifDediteur.setFloat(1, Float.parseFloat(modifMont.getText()));
            modifDediteur.setString(2,num);
            modifDediteur.executeUpdate();
            
            //modification du solde beneficiaire
            modifBeneficiaire = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET + ? WHERE numCompte = ?");
            modifBeneficiaire.setFloat(1, Float.parseFloat(modifMont.getText()));
            modifBeneficiaire.setString(2,num2);
            modifBeneficiaire.executeUpdate();
            
            // Validation de la transaction
            conn.commit();
            JOptionPane.showMessageDialog(null,"modification valider");
            
            modifMont.setText("");
            modifDate.setText("");
            
            voir_list_virement();
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }   
    }                                        

    private void EffacerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }//GEN-LAST:event_modifierActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // TODO add your handling code here:
   
        modifMont.setText("");
        modifDate.setText(""); 
    }//GEN-LAST:event_AnnulerActionPerformed

    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed
        
// TODO add your handling code here:
        
        // Informations du client et du prêt
         // Création de la boîte de dialogue JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        
        // Filtrer uniquement les fichiers avec l'extension .pdf
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers PDF", "pdf");
        fileChooser.setFileFilter(filter);
        
        // Afficher la boîte de dialogue de sélection de fichier
        int result = fileChooser.showSaveDialog(null);
        
        // Vérifier si l'utilisateur a sélectionné un fichier et a appuyé sur le bouton "Enregistrer"
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtenir le chemin d'accès sélectionné par l'utilisateur
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            
            try 
            {
                // Utiliser le chemin d'accès pour générer le fichier PDF
                genererPDF(filePath);
            } catch (SQLException ex) {
                Logger.getLogger(TableVirement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        
    }//GEN-LAST:event_PDFActionPerformed

    private void effacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerActionPerformed
        // TODO add your handling code here:
        try
        {
            DefaultTableModel model = (DefaultTableModel)Table_Virement.getModel();
            int selectedIndex = Table_Virement.getSelectedRow();

            String num = (model.getValueAt(selectedIndex,6).toString());
            //String num2 = (model.getValueAt(selectedIndex,2).toString());

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            st = conn.prepareStatement("DELETE FROM VIREMENT WHERE idvirement=?");
            st.setString(1, num);
            int reponse = st.executeUpdate();
            JOptionPane.showMessageDialog(null,"suppression effectuer");

            modifMont.setText("");
            modifDate.setText("");

            voir_list_virement();

        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }
    }//GEN-LAST:event_effacerActionPerformed

    public void genererPDF(String filePath) throws SQLException {
        
        
            DefaultTableModel model = (DefaultTableModel)Table_Virement.getModel();
            int selectedIndex = Table_Virement.getSelectedRow();
            
            String num = (model.getValueAt(selectedIndex,0).toString());
            String num2 = (model.getValueAt(selectedIndex,2).toString());
            String id = (model.getValueAt(selectedIndex,6).toString());
            
            
            // Récupération du montant du débiteur
            st = conn.prepareStatement("SELECT NOM,PRENOM,SOLDET FROM CLIENT WHERE numCompte = ?");
            st.setString(1,num );
            resultat = st.executeQuery();
            float soldet1 = 0;
            String nom = "";
            String prenom = "";
            String nomcomplet1 ="";
            while (resultat.next()) 
            {
                 soldet1 = resultat.getFloat("SOLDET");
                 nom = resultat.getString("NOM");
                 prenom = resultat.getString("PRENOM");
                 nomcomplet1 = nom+" "+prenom;
            } 
            
            
            // Récupération du montant du beneficaire
            st = conn.prepareStatement("SELECT NOM,PRENOM,SOLDET FROM CLIENT WHERE numCompte = ?");
            st.setString(1, num2);
            resultat = st.executeQuery();
            float soldet2 = 0;
            String nom2 = "";
            String prenom2 = "";
            String nomcomplet2 ="";
            while (resultat.next()) 
            {
                 soldet2 = resultat.getFloat("SOLDET");
                 nom2 = resultat.getString("NOM");
                 prenom2 = resultat.getString("PRENOM");
                 nomcomplet2 = nom2+" "+prenom2;
                 
            }
            
           //System.out.println(soldet1);
           //System.out.println(soldet2);
      
            String nomBanque = "Banque BFV";
            String montante = modifMont.getText();
            String numCompte1 = num;
            String numCompte2 = num2;
            
            // Chemin de destination du fichier PDF
            String filePathf = filePath ;
            
            // Création du document PDF
            Document document = new Document();
            
            try {
                // Création d'un écrivain PDF
                PdfWriter.getInstance(document, new FileOutputStream(filePathf));
                
                // Ouverture du document
                document.open();
                
                // Ajout du contenu au document
                Font fontTitre = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
                Paragraph banque = new Paragraph(nomBanque, fontTitre);
                banque.setAlignment(Element.ALIGN_CENTER);
                document.add(banque);
                
                Paragraph date = new Paragraph(modifDate.getText(), fontTitre);
                date.setAlignment(Element.ALIGN_CENTER);
                document.add(date);
                
                Paragraph titre = new Paragraph("AVIS DE VIREMENT N°0" +id+ "", fontTitre);
                titre.setAlignment(Element.ALIGN_CENTER);
                document.add(titre);
                
                
                document.add(Chunk.NEWLINE);
                
                Paragraph contenu = new Paragraph();
                contenu.add("\n\n");
                contenu.add("N° de compte : " + numCompte1 + "(dediteur)\n");
                contenu.add("nom : "+ nomcomplet1 + "\n");
                contenu.add("Solde actuel : " + soldet1 + " Ar\n");
                contenu.add("\n");
                contenu.add("A\n");
                contenu.add("\n");
                contenu.add("N° de compte client : " + numCompte2 + "(beneficiaire)\n");
                contenu.add("nom : "+ nomcomplet2 + "\n");
                contenu.add("Montant : " +montante + " Ar\n");
                contenu.add("solde actuel : " +soldet2 + " Ar\n");
                document.add(contenu);
                
                // Fermeture du document
                document.close();
                
                System.out.println("Fichier PDF généré avec succès !");
                JOptionPane.showMessageDialog(null,"Fichier PDF généré avec succès !");
                modifMont.setText("");
                modifDate.setText(""); 
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        }         
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton PDF;
    private javax.swing.JTable Table_Virement;
    private javax.swing.JButton effacer;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField modifDate;
    private javax.swing.JTextField modifMont;
    private javax.swing.JButton modifier;
    private javax.swing.JButton nouveauVirement;
    // End of variables declaration//GEN-END:variables
}
