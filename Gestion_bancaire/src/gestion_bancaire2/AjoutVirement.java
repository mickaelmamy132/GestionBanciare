/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gestion_bancaire2;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author mickael
 */
public class AjoutVirement extends javax.swing.JDialog {

    /**
     * Creates new form AjoutVirement
     */
        Connection conn;
        PreparedStatement preparer;
        PreparedStatement Dediteur;
        PreparedStatement Beneficiaire;
        PreparedStatement modifDediteur;
        PreparedStatement modifBeneficiaire;
        ResultSet resultat;
    public AjoutVirement(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JComboBox();
        //JComboBox dropdown = new JComboBox<>();
        java.util.Date currentDate = new java.util.Date();
        // Afficher la date dans le champ jcalendar
        date.setDate(currentDate); 



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        montant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ACCEPTER = new javax.swing.JButton();
        btn_refus = new javax.swing.JButton();
        deroulante = new javax.swing.JComboBox<>();
        deroulante2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" numCompte");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("numCompte");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("montant");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("date de transfer");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VIREMENT");

        ACCEPTER.setBackground(new java.awt.Color(0, 0, 0));
        ACCEPTER.setForeground(new java.awt.Color(255, 255, 255));
        ACCEPTER.setText("ACCEPTER");
        ACCEPTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACCEPTERActionPerformed(evt);
            }
        });

        btn_refus.setBackground(new java.awt.Color(0, 0, 0));
        btn_refus.setForeground(new java.awt.Color(255, 255, 255));
        btn_refus.setText("RETOUR");
        btn_refus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refusActionPerformed(evt);
            }
        });

        deroulante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choisissez" }));

        deroulante2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choisissez" }));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("(ARIARY)");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(dediteur)");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("(beneficier)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deroulante, 0, 190, Short.MAX_VALUE)
                    .addComponent(montant, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(deroulante2, 0, 190, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(107, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ACCEPTER)
                        .addGap(92, 92, 92)
                        .addComponent(btn_refus)
                        .addGap(82, 82, 82))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deroulante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deroulante2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ACCEPTER)
                    .addComponent(btn_refus))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refusActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== this.btn_refus)
        {
            this.dispose();
        }
    }//GEN-LAST:event_btn_refusActionPerformed

    public void JComboBox()
    {
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
           preparer = conn.prepareStatement("SELECT * FROM CLIENT");
           resultat = preparer.executeQuery();
            while (resultat.next()) 
            {
              String numCompte = resultat.getString("numCompte");
              deroulante.addItem(numCompte);
              deroulante2.addItem(numCompte);
            }
        } 
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
}
    private void ACCEPTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACCEPTERActionPerformed
        // TODO add your handling code here:
        Date dtt = date.getDate();
        // Créer un format de date souhaité
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        // Formater la date en une chaîne de caractères
        String formattedDate = dateFormat.format(dtt);
     
        
     try
        {
            if (deroulante.getSelectedItem().toString().isEmpty() || deroulante2.getSelectedItem().toString().isEmpty() || montant.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "veuillez remplir tout les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
             else if (deroulante.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un dediteur.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
             else if (deroulante2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un beneficiaire.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else if (!montant.getText().matches("\\d+(\\.\\d+)?"))
            {
               JOptionPane.showMessageDialog(null, "Le champ 'soldet' doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Récupération du montant du débiteur
            Dediteur = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            Dediteur.setString(1, deroulante.getSelectedItem().toString());
            resultat = Dediteur.executeQuery();
             int Debiteurs = 0;
            while (resultat.next()) 
            {
                 Debiteurs = resultat.getInt("SOLDET");
            }
            
            if ( Debiteurs <=0 )
            {
                // Affichez une fenêtre d'alerte
            JOptionPane.showMessageDialog(null, "Desoler votre solde est insuffisante pour faire une transaction.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            preparer = conn.prepareStatement("INSERT INTO virement(numCompte,numCompt,montant,dateTransfert) values(?,?,?,?)"); 
            preparer.setString(1,deroulante.getSelectedItem().toString());
            preparer.setString(2,deroulante2.getSelectedItem().toString());
            preparer.setFloat(3,Float.parseFloat(montant.getText()));
            preparer.setString(4,formattedDate);
            int rowt = preparer.executeUpdate();
           
            
            // Récupération du montant du débiteur
            Dediteur = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            Dediteur.setString(1, deroulante.getSelectedItem().toString());
            resultat = Dediteur.executeQuery();
             int DebiteurActuel = 0;
            while (resultat.next()) 
            {
                 DebiteurActuel = resultat.getInt("SOLDET");
            } 
            
            //Récupération du montant du beneficiaire
            Beneficiaire = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            Beneficiaire.setString(1, deroulante2.getSelectedItem().toString());
            resultat = Beneficiaire.executeQuery();
            int BeneficiaireActuel = 0;
            while (resultat.next()) 
            {
                 BeneficiaireActuel = resultat.getInt("SOLDET");
            }
            
            //debut du transaction
            //modification du solde dediteur
            conn.setAutoCommit(false);
            
            modifDediteur = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET - ? WHERE numCompte = ?");
            modifDediteur.setFloat(1, Float.parseFloat(montant.getText()));
            modifDediteur.setString(2,deroulante.getSelectedItem().toString());
            modifDediteur.executeUpdate();
            
            //modification du solde beneficiaire
            modifBeneficiaire = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET + ? WHERE numCompte = ?");
            modifBeneficiaire.setFloat(1, Float.parseFloat(montant.getText()));
            modifBeneficiaire.setString(2,deroulante2.getSelectedItem().toString());
            modifBeneficiaire.executeUpdate();
            
            // Validation de la transaction
            conn.commit();
            
            // Mise à jour des montants
            DebiteurActuel -= Float.parseFloat(montant.getText());
            BeneficiaireActuel += Float.parseFloat(montant.getText());
             
            JOptionPane.showMessageDialog(null,"virement effectuer");
            
            TableVirement virement = new TableVirement();
            virement.voir_list_virement();
            
            deroulante.setSelectedIndex(0);
            deroulante2.setSelectedIndex(0);
            montant.setText("");
   

            
            }
            }
            
            
               
            
           
        }
        catch(SQLException e)
        {
            //System.out.println("erreur");
            e.printStackTrace();
        }
    }//GEN-LAST:event_ACCEPTERActionPerformed

    
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
            java.util.logging.Logger.getLogger(AjoutVirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutVirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutVirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutVirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutVirement dialog = new AjoutVirement(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ACCEPTER;
    private javax.swing.JButton btn_refus;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JComboBox<String> deroulante;
    private javax.swing.JComboBox<String> deroulante2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField montant;
    // End of variables declaration//GEN-END:variables

}
