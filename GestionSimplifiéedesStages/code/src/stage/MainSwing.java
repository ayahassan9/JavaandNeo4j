package stag;
import stag.models.Stagiaire;
import stag.models.Stage;
import javax.swing.*;
import java.awt.*;
public class MainSwing {
    private static final Gestionstagiaires gestionStagiaires = new Gestionstagiaires();
    private static final GestionStages gestionStages = new GestionStages();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion des Stagiaires et Stages");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        JButton btnAjouterStagiaire = new JButton( "Ajouter un stagiaire");
        JButton btnSupprimerStagiaire = new JButton("Supprimer un stagiaire");
        JButton btnAfficherStagiaires = new JButton("Afficher tous les stagiaires");
        JButton btnAjouterStage = new JButton("Ajouter un stage");
        JButton btnAssocier = new JButton("Associer un stagiaire à un stage");
        JButton btnAfficherStages = new JButton("Afficher tous les stages");
        JButton btnQuitter = new JButton("Quitter");
        buttonPanel.add(btnAjouterStagiaire);
        buttonPanel.add(btnSupprimerStagiaire);
        buttonPanel.add(btnAfficherStagiaires);
        buttonPanel.add(btnAjouterStage);
        buttonPanel.add(btnAssocier);
        buttonPanel.add(btnAfficherStages);
        buttonPanel.add(btnQuitter);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

        btnAjouterStagiaire.addActionListener(e -> ajouterStagiaire(frame, textArea));
        btnSupprimerStagiaire.addActionListener(e -> supprimerStagiaire(frame, textArea));
        btnAfficherStagiaires.addActionListener(e -> afficherStagiaires(textArea));
        btnAjouterStage.addActionListener(e -> ajouterStage(frame, textArea));
        btnAssocier.addActionListener(e -> associerStagiaireStage(frame, textArea));
        btnAfficherStages.addActionListener(e -> afficherStages(textArea));
        btnQuitter.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
    private static void ajouterStagiaire(JFrame frame, JTextArea textArea) {
        String nom = JOptionPane.showInputDialog(frame, "Nom du stagiaire :");
        String prenom = JOptionPane.showInputDialog(frame, "Prénom du stagiaire :");
        String nvEtude = JOptionPane.showInputDialog(frame, "Niveau d'étude :");
        if (nom == null || prenom == null || nvEtude == null || nom.isEmpty() || prenom.isEmpty() || nvEtude.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        gestionStagiaires.ajouter(new Stagiaire(nom, prenom, nvEtude));
        textArea.append("Stagiaire ajouté : " + nom + " " + prenom + " (" + nvEtude + ")\n");
    }
    private static void supprimerStagiaire(JFrame frame, JTextArea textArea) {
        String nom = JOptionPane.showInputDialog(frame, "Nom supprimer :");
        if (nom == null || nom.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Le nom est obligatoire.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        gestionStagiaires.supprimer(nom);
        textArea.append("Stagiaire supprimé : " + nom + "\n");
    }
    private static void afficherStagiaires(JTextArea textArea) {
        textArea.append("--- Liste des stagiaires ---\n");
        gestionStagiaires.affiche();
    }
    private static void ajouterStage(JFrame frame, JTextArea textArea) {
        String titre = JOptionPane.showInputDialog(frame, "Titre du stage :");
        String dureeStr = JOptionPane.showInputDialog(frame, "Durée du stage (en jours) :");
        if (titre == null || dureeStr == null || titre.isEmpty() || dureeStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int duree = Integer.parseInt(dureeStr);
            gestionStages.ajouter(new Stage(titre, duree));
            textArea.append("Stage ajouté : " + titre + " (" + duree + " jours)\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "La durée doit être un nombre entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void associerStagiaireStage(JFrame frame, JTextArea textArea) {
        String titre = JOptionPane.showInputDialog(frame, "Titre du stage :");
        String nomStagiaire = JOptionPane.showInputDialog(frame, "Nom du stagiaire :");

        Stage stage = gestionStages.rechercherParTitre(titre);
        Stagiaire stagiaire = gestionStagiaires.rechercherParNom(nomStagiaire);
        if (stage == null || stagiaire == null) {
            JOptionPane.showMessageDialog(frame, "Stage ou stagiaire introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        stage.ajouterStagiaire(stagiaire);
        textArea.append("Stagiaire " + stagiaire.getNom() + " travaille: " + stage.getTitre() + "\n");
    }
    private static void afficherStages(JTextArea textArea) {
        textArea.append("--- Liste des stages ---\n");
        gestionStages.affiche();
    }
}