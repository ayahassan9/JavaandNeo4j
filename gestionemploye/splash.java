package employe.management.system;

// Importation des bibliothèques nécessaires
import javax.swing.*; // Pour les composants Swing comme JFrame, JLabel, JButton
import java.awt.*;    // Pour les mises en page et les couleurs
import java.awt.event.*; // Pour la gestion des événements

// Déclaration de la classe `Splash` qui hérite de `JFrame` et implémente `ActionListener`
public class Splash extends JFrame implements ActionListener {

    // Constructeur de la classe `Splash`
    Splash() {
        // Configuration de la fenêtre (plein écran sans bordure)
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Rend la fenêtre plein écran
        setUndecorated(true); // Supprime les bordures de la fenêtre

        // Charger l'image d'arrière-plan
        JLabel background = new JLabel(); // Label pour contenir l'image d'arrière-plan
        background.setLayout(new BorderLayout()); // Utilise une disposition BorderLayout

        // Ajouter un en-tête au nord de la fenêtre
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM", JLabel.CENTER); // Texte centré
        heading.setFont(new Font("SansSerif", Font.BOLD, 50)); // Police et taille de l'en-tête
        heading.setForeground(Color.WHITE); // Texte en blanc pour contraster avec l'arrière-plan
        background.add(heading, BorderLayout.NORTH); // Ajout de l'en-tête dans le label d'arrière-plan

        // Ajouter un bouton pour continuer
        JButton clickHere = new JButton("CLICK HERE TO CONTINUE"); // Création du bouton
        clickHere.setFont(new Font("Arial", Font.BOLD, 20)); // Définition de la police et de la taille du texte
        clickHere.setBackground(new Color(0, 102, 204)); // Couleur de fond (bleu élégant)
        clickHere.setForeground(Color.WHITE); // Couleur du texte du bouton
        clickHere.setFocusPainted(false); // Désactive l'effet de focus sur le bouton
        clickHere.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Marges internes pour le bouton
        clickHere.addActionListener(this); // Associe un écouteur d'événements au bouton

        // Ajouter le bouton dans un panneau pour le centrer
        JPanel buttonPanel = new JPanel(); // Création d'un panneau pour contenir le bouton
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // Fond transparent
        buttonPanel.add(clickHere); // Ajoute le bouton au panneau
        background.add(buttonPanel, BorderLayout.SOUTH); // Ajoute le panneau de bouton en bas de l'arrière-plan

        // Ajouter l'arrière-plan à la fenêtre
        add(background); // Ajoute le label contenant tout à la fenêtre

        // Rendre la fenêtre visible
        setVisible(true);

        // Charger l'image après que la fenêtre ait été rendue
        SwingUtilities.invokeLater(() -> loadImage(background)); // Charge l'image dans un thread distinct pour éviter de bloquer l'interface utilisateur
    }

    // Méthode pour charger et redimensionner l'image d'arrière-plan
    private void loadImage(JLabel imageLabel) {
        try {
            // Charger l'image depuis le chemin spécifié
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/page1.jpg"));

            // Vérifie si l'image est valide avant de tenter le redimensionnement
            if (icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
                // Redimensionner l'image pour qu'elle corresponde à la taille de la fenêtre
                Image image = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(image);
                imageLabel.setIcon(scaledIcon); // Définir l'icône redimensionnée comme arrière-plan
            } else {
                System.out.println("Erreur : L'image est invalide.");
            }
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de charger l'image."); // Message d'erreur si l'image ne peut pas être chargée
            e.printStackTrace(); // Affiche les détails de l'exception
        }
    }

    // Méthode appelée lorsqu'une action est effectuée (par exemple, clic sur le bouton)
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); // Masque la fenêtre actuelle
        new Login(); // Lance une nouvelle fenêtre `Login` (supposée être définie ailleurs)
    }

    // Point d'entrée principal du programme
    public static void main(String[] args) {
        new Splash(); // Crée et affiche la fenêtre Splash
    }
}
