/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gestion_bancaire2;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;

/**
 *
 * @author mickael
 */

public class AjoutRendre extends javax.swing.JDialog {

    /**
     * Creates new form AjoutRendre
     */
    Connection conn;
    PreparedStatement preparer;
    PreparedStatement preteur;
    PreparedStatement client;
    PreparedStatement Client;
    PreparedStatement date;
    PreparedStatement email;
    PreparedStatement reste;
    PreparedStatement resteE;
    PreparedStatement daterendre;
    ResultSet resultat;
    public AjoutRendre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        deroulante_Rendre();
        // Obtenir la date actuelle
        java.util.Date currentDate = new java.util.Date();
        // Afficher la date dans le champ jcalendar
        DateRendre.setDate(currentDate);
        
    }

    public void deroulante_Rendre()
    {
 
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
           preparer = conn.prepareStatement("SELECT * FROM rendre WHERE rest_payé >'0'");
           resultat = preparer.executeQuery();
            while (resultat.next()) 
            {
              //String num_Compte = resultat.getString("num_pret");
              String num_Compte = resultat.getString("num_pret");
              String num_rendu = resultat.getString("num_rendu");
              String C_r = num_rendu+"-"+num_Compte;
              NumPrete.addItem(C_r);
            }
        } 
        catch (SQLException e) 
        {
                e.printStackTrace();
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        MontPayer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        AjoutRendre = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        NumPrete = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        DateRendre = new com.toedter.calendar.JDateChooser();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Remboursement");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("date ");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("montant a payé");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("numero de compte");

        AjoutRendre.setBackground(new java.awt.Color(0, 0, 0));
        AjoutRendre.setForeground(new java.awt.Color(255, 255, 255));
        AjoutRendre.setText("EFFECTUER");
        AjoutRendre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutRendreActionPerformed(evt);
            }
        });

        annuler.setBackground(new java.awt.Color(0, 0, 0));
        annuler.setForeground(new java.awt.Color(255, 255, 255));
        annuler.setText("ANNULER");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        NumPrete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choisissez" }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ARIARY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MontPayer, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(NumPrete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateRendre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(AjoutRendre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(annuler)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumPrete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MontPayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(DateRendre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AjoutRendre)
                    .addComponent(annuler))
                .addGap(0, 120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()== this.annuler)
        {
            this.dispose();
            TableRendre clt = new TableRendre();
            //clt.voir_liste_pret();
        }
    }//GEN-LAST:event_annulerActionPerformed

    private void AjoutRendreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutRendreActionPerformed
        // TODO add your handling code here: 
        Date dt = DateRendre.getDate();
        // Créer un format de date souhaité
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        // Formater la date en une chaîne de caractères
        String formattedDate = dateFormat.format(dt);
        
        String selectedItem = NumPrete.getSelectedItem().toString();
        int separatorIndex = selectedItem.indexOf("-");
        String num_rendu = selectedItem.substring(0, separatorIndex).trim();
        String num_pret = selectedItem.substring(separatorIndex + 1).trim();


        
        /*
        DefaultTableModel model = (DefaultTableModel) Table_Rendre.getModel();
        int selectedIndex = Table_Rendre.getSelectedRow();
        int num = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());   
        */
        
       try
        {
            float mont = 0.0f;
            if (NumPrete.getSelectedItem().toString().isEmpty() || MontPayer.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, "veuillez remplir tout les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
             else if (NumPrete.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else if (!MontPayer.getText().matches("\\d+(\\.\\d+)?"))
            {
               JOptionPane.showMessageDialog(null, "Le champ 'soldet a payer' doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            
            else
            {
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
             preparer = conn.prepareStatement("select rest_payé from rendre where num_rendu = ?");
             preparer.setString(1,num_rendu);
             resultat = preparer.executeQuery();
             int rest = 0;
             mont = Float.parseFloat(MontPayer.getText());
             while (resultat.next()) 
            {
                 rest = resultat.getInt("rest_payé");
            }
             
             
            
            if (rest > mont)
            {
                 //recuperer le reste en cas si il avais
            reste = conn.prepareStatement("SELECT rest_payé FROM RENDRE WHERE num_rendu = ?");
            reste.setString(1, num_rendu);
            resultat = reste.executeQuery();
            int resteprete = 0;
            while (resultat.next()) 
            {
                 resteprete = resultat.getInt("rest_payé");
            } 
            float montant_a_payer = mont;
            float reste_payer = resteprete-montant_a_payer ;
            String situation= ("payer une part");
            
            //UPDATE RENDRE SET situation = ?, rest_payé = ? WHERE num_rendu = ? AND num_pret = ?            
            reste = conn.prepareStatement("UPDATE RENDRE SET situation = ?, rest_payé = ?,date_rendu = ?  WHERE num_rendu = ?");
            reste.setString(1, situation);
            reste.setFloat(2,reste_payer);
            reste.setString(3,formattedDate);
             reste.setString(4, num_rendu);
            reste.executeUpdate();
            
            conn.setAutoCommit(false);
             //Récupération le solde client
            preteur = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            preteur.setString(1, num_pret);
            resultat = preteur.executeQuery();
            int compteClient = 0;
            while (resultat.next()) 
            {
                 compteClient = resultat.getInt("SOLDET");
            }
            
            Client = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET - ? WHERE numCompte = ?");
            Client.setFloat(1, montant_a_payer);
            Client.setString(2,num_pret);
            Client.executeUpdate();
            
            conn.commit();
            
            compteClient -= Float.parseFloat(MontPayer.getText());
            
            
            //EFFECTUER L'INSERTION DANS LE TABLE RENDRE
            
            TableVirement virement = new TableVirement();
            virement.voir_list_virement();
            
            
            //envoi_Email_rendre();
            
            
            NumPrete.setSelectedIndex(0);
            MontPayer.setText("");
            
            JOptionPane.showMessageDialog(null,"remboursement effectuer");

            }
            
            
            if (rest == mont)
            {
                 //recuperer le reste en cas si il avais
            reste = conn.prepareStatement("SELECT rest_payé FROM RENDRE WHERE num_rendu = ?");
            reste.setString(1, num_rendu);
            resultat = reste.executeQuery();
            int resteprete = 0;
            while (resultat.next()) 
            {
                 resteprete = resultat.getInt("rest_payé");
            } 
            float montant_a_payer = mont;
            float reste_payer = resteprete-montant_a_payer ;
            String situation= ("tout payer");
            
            //UPDATE RENDRE SET situation = ?, rest_payé = ? WHERE num_rendu = ? AND num_pret = ?            
            reste = conn.prepareStatement("UPDATE RENDRE SET situation = ?, rest_payé = ?,date_rendu = ? WHERE num_rendu = ?");
            reste.setString(1, situation);
            reste.setFloat(2,reste_payer);
            reste.setString(3,formattedDate );
             reste.setString(4, num_rendu);
            reste.executeUpdate();
            
            conn.setAutoCommit(false);
             //Récupération le solde client
            preteur = conn.prepareStatement("SELECT SOLDET FROM CLIENT WHERE numCompte = ?");
            preteur.setString(1, num_pret);
            resultat = preteur.executeQuery();
            int compteClient = 0;
            while (resultat.next()) 
            {
                 compteClient = resultat.getInt("SOLDET");
            }
            
            Client = conn.prepareStatement("UPDATE CLIENT SET SOLDET = SOLDET - ? WHERE numCompte = ?");
            Client.setFloat(1, montant_a_payer);
            Client.setString(2,num_pret);
            Client.executeUpdate();
            
            conn.commit();
            
            compteClient -= mont;
            
            
            //EFFECTUER L'INSERTION DANS LE TABLE RENDRE
            
            TableVirement virement = new TableVirement();
            virement.voir_list_virement();
            
            
            //envoi_Email_rendre();
            
            
            NumPrete.setSelectedIndex(0);
            MontPayer.setText("");
            
            JOptionPane.showMessageDialog(null,"remboursement effectuer");
            
            }
            
            if ( rest <= 0 )
            {
            // Affichez une fenêtre d'alerte
            JOptionPane.showMessageDialog(null, "vous avez dejas tout payer votre dernier prêt.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            }
             
           
        }
        catch(SQLException e)
        {
         
            e.printStackTrace();
        }
    }//GEN-LAST:event_AjoutRendreActionPerformed

    public void envoi_Email_rendre() throws SQLException 
    {
        // date du pret
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        date = conn.prepareStatement("SELECT * FROM PRETER ORDER BY num_pret DESC LIMIT 1");
        resultat = date.executeQuery();
        String date="";//date du pret
        while (resultat.next()) 
        {
           date = resultat.getString("datepret");
        }
        
        // date du rendu
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        daterendre = conn.prepareStatement("SELECT * FROM RENDRE ORDER BY num_rendu DESC LIMIT 1");
        resultat = daterendre.executeQuery();
        String dateRendre="";//date du pret
        while (resultat.next()) 
        {
           dateRendre = resultat.getString("date_rendu");
        }
        
        // Obtenez la date du pret
        // Convertissez la date du prêt en objet LocalDate
        String datePret = date;
        LocalDate datePretObj = LocalDate.parse(datePret);
        
        // Obtenez la date du rend
        // Convertissez la date du rend en objet LocalDate
        String daterend = dateRendre;
        LocalDate dateRend4 = LocalDate.parse(daterend);
                
         // format de la date correspond à "yyyy-MM-dd"
     
        int dureePret = 30;// Durée du prêt en jours
        
        //Calculez la date d'échéance
        LocalDate dateEcheance = datePretObj.plusDays(dureePret);

        // Calculez le nombre de jours restants
        long joursRestantpayer = ChronoUnit.DAYS.between(datePretObj, dateEcheance);

        //System.out.println("Nombre de jours restants : " + joursRestants);
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        resteE = conn.prepareStatement("SELECT * FROM RENDRE ORDER BY num_rendu DESC LIMIT 1");
        resultat = resteE.executeQuery();
        float rest2 = 0;//email du client
        while (resultat.next()) 
        {
           rest2 = resultat.getFloat("rest_payé");
        }
        //obtenir email client
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
        email = conn.prepareStatement("SELECT * FROM CLIENT WHERE numCompte=?");
        email.setString(1,NumPrete.getSelectedItem().toString());
        resultat = email.executeQuery();
        String emailclient = "";//email du client
        String nom = "";
        String prenom = "";
        String nomclient ="";
        while (resultat.next()) 
        {
           emailclient = resultat.getString("EMAIL");
           nom = resultat.getString("NOM");
           prenom = resultat.getString("PRENOM");
           nomclient = nom+" "+prenom;
        }
        
        // Paramètres SMTP du fournisseur de messagerie
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "andrianaivomicke@gmail.com";
        String password = "mkzfaqidfvsnnoeg";

        // Configuration des propriétés
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Création de la session avec l'authentification
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            // Créez un objet MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Définir l'expéditeur et les destinataires
            message.setFrom(new InternetAddress("andrianaivomicke@gmail.com")); // Remplacez par votre adresse e-mail
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailclient)); // Adresse e-mail du client

            // Définir le sujet du message
            message.setSubject("Notification de prêt");

            // Construire le contenu du message
            String contenuMessage = "Cher " +nomclient+ ",\n\n";
            contenuMessage += "Il vous reste " + joursRestantpayer + " jours pour rembourser votre prêt.\n";
            contenuMessage += "Le montant reste à rendre est de " + rest2 + " Ar.\n\n";
            contenuMessage += "Cordialement,\n";
            contenuMessage += "Votre banque";

            // Définir le contenu du message
            message.setText(contenuMessage);

            // Envoyer le message
            Transport.send(message);

                System.out.println("E-mail de notification envoyé avec succès !");
            } 
        
        catch (MessagingException e) 
        {
        System.out.println("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    }
    
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
            java.util.logging.Logger.getLogger(AjoutRendre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutRendre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutRendre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutRendre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutRendre dialog = new AjoutRendre(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton AjoutRendre;
    private com.toedter.calendar.JDateChooser DateRendre;
    private javax.swing.JTextField MontPayer;
    private javax.swing.JComboBox<String> NumPrete;
    private javax.swing.JButton annuler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
