package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {
        // Configurer la fenêtre
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        getContentPane().setBackground(new Color(245, 245, 245)); // Couleur d'arrière-plan claire

        // Créer le conteneur principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Ajouter des marges
        mainPanel.setBackground(new Color(245, 245, 245));

        // Ajouter l'en-tête
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM", JLabel.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 50));
        heading.setForeground(new Color(34, 34, 34)); // Gris foncé
        mainPanel.add(heading, BorderLayout.NORTH);

        // Ajouter une image
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        // Ajouter un bouton
        JButton clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setFont(new Font("Arial", Font.BOLD, 20));
        clickHere.setBackground(new Color(34, 139, 34)); // Vert
        clickHere.setForeground(Color.WHITE);
        clickHere.setFocusPainted(false);
        clickHere.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        clickHere.addActionListener(this);

        // Conteneur pour centrer le bouton
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(clickHere);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajouter le conteneur principal à la fenêtre
        add(mainPanel);

        // Afficher la fenêtre
        setVisible(true);

        // Charger et redimensionner l'image après que la fenêtre soit rendue
        loadImage(imageLabel);
    }

    // Méthode pour charger et redimensionner l'image
    private void loadImage(JLabel imageLabel) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/gestion.jpg"));
            Image image = icon.getImage().getScaledInstance(getWidth() - 100, getHeight() - 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            imageLabel.setIcon(scaledIcon);
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de charger l'image.");
            e.printStackTrace();
        }
    }

    // ActionListener pour le bouton
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    // Point d'entrée principal
    public static void main(String[] args) {
        new Splash();
    }
}
