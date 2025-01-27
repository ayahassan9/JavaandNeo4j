package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener {

    // Déclaration des composants de l'interface
    JTable table;                // Table pour afficher les informations des employés
    Choice cemployeeId;          // Liste déroulante pour sélectionner un ID d'employé
    JButton search, print, update, back; // Boutons pour rechercher, imprimer, mettre à jour et revenir à la page d'accueil

    // Constructeur
    ViewEmployee() {
        // Définir la couleur de fond de la fenêtre
        getContentPane().setBackground(Color.WHITE);

        // Désactiver le gestionnaire de disposition par défaut pour positionner les composants manuellement
        setLayout(null);

        // Label pour rechercher un employé par ID
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);  // Positionner le label
        add(searchlbl);

        // Liste déroulante pour sélectionner un ID d'employé
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20); // Positionner la liste déroulante
        add(cemployeeId);

        // Remplir la liste déroulante avec les IDs d'employés récupérés depuis la base de données
        try {
            Conn c = new Conn();  // Connexion à la base de données
            ResultSet rs = c.s.executeQuery("SELECT id FROM employe");  // Récupérer les IDs des employés
            while (rs.next()) {
                cemployeeId.add(rs.getString("id")); // Ajouter chaque ID à la liste déroulante
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Création d'une table pour afficher les données des employés
        table = new JTable();

        // Charger les données de la table à partir de la base de données
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM employe"); // Récupérer toutes les données des employés
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Utiliser DbUtils pour convertir les données en modèle de table
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ajouter un panneau défilant pour la table afin de pouvoir afficher plusieurs lignes
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);  // Positionner le panneau
        add(jsp);

        // Bouton pour rechercher un employé par son ID
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);  // Positionner le bouton
        search.addActionListener(this);    // Ajouter l'action de recherche
        add(search);

        // Bouton pour imprimer la table
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);  // Positionner le bouton
        print.addActionListener(this);     // Ajouter l'action d'impression
        add(print);

        // Bouton pour mettre à jour un employé
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);  // Positionner le bouton
        update.addActionListener(this);     // Ajouter l'action de mise à jour
        add(update);

        // Bouton pour revenir à l'écran principal
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);   // Positionner le bouton
        back.addActionListener(this);      // Ajouter l'action pour revenir à l'écran principal
        add(back);

        // Paramètres de la fenêtre
        setSize(900, 700);  // Définir la taille de la fenêtre
        setLocation(300, 100); // Positionner la fenêtre à une certaine position sur l'écran
        setVisible(true);     // Afficher la fenêtre
    }

    // Gestion des événements des boutons
    public void actionPerformed(ActionEvent ae) {
        // Si le bouton "Search" est cliqué
        if (ae.getSource() == search) {
            // Requête SQL pour rechercher un employé par son ID
            String query = "SELECT * FROM employe WHERE id = ?";
            try {
                Conn c = new Conn();
                PreparedStatement pstmt = c.c.prepareStatement(query);  // Préparer la requête
                pstmt.setString(1, cemployeeId.getSelectedItem());  // Utiliser l'ID sélectionné dans la liste déroulante
                ResultSet rs = pstmt.executeQuery();  // Exécuter la requête
                table.setModel(DbUtils.resultSetToTableModel(rs));  // Mettre à jour la table avec les résultats
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la recherche : " + e.getMessage());
            }
        }
        // Si le bouton "Print" est cliqué
        else if (ae.getSource() == print) {
            try {
                table.print();  // Imprimer la table
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'impression : " + e.getMessage());
            }
        }
        // Si le bouton "Update" est cliqué
        else if (ae.getSource() == update) {
            setVisible(false);  // Fermer la fenêtre actuelle
            new UpdateEmployee(cemployeeId.getSelectedItem());  // Ouvrir la fenêtre pour mettre à jour l'employé sélectionné
        }
        // Si le bouton "Back" est cliqué
        else if (ae.getSource() == back) {
            setVisible(false);  // Fermer la fenêtre actuelle
            new Home();  // Ouvrir la page d'accueil
        }
    }

    // Méthode principale pour exécuter le programme
    public static void main(String[] args) {
        new ViewEmployee();  // Créer une instance de la fenêtre "ViewEmployee"
    }
}
