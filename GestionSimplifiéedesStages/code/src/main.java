package stag;
import stag.models.Stagiaire;
import stag.models.Stage;
import java.util.Scanner;
public class Main {
    private static final Gestionstagiaires gestionStagiaires = new Gestionstagiaires();
    private static final GestionStages gestionStages = new GestionStages();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> ajouterStagiaire(scanner);
                case 2 -> supprimerStagiaire(scanner);
                case 3 -> gestionStagiaires.affiche();
                case 4 -> ajouterStage(scanner);
                case 5 -> associerStagiaireStage(scanner);
                case 6 -> gestionStages.affiche();
                case 7 -> rechercherStagiaire(scanner);
                case 8 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 8);
    }
    private static void afficherMenu() {
        System.out.println("\n--- Menu Gestion  ---");
        System.out.println("1. Ajouter un stagiaire");
        System.out.println("2. Supprimer un stagiaire");
        System.out.println("3. Afficher tous les stagiaires");
        System.out.println("4. Ajouter un stage");
        System.out.println("5. Associer un stagiaire à un stage");
        System.out.println("6. Afficher tous les stages");
        System.out.println("7. Rechercher un stagiaire");
        System.out.println("8. Quitter");
        System.out.print("Votre choix : ");
    }
    private static void ajouterStagiaire(Scanner scanner) {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Niveau d'étude : ");
        String nvEtude = scanner.nextLine();

        gestionStagiaires.ajouter(new Stagiaire(nom, prenom, nvEtude));
        System.out.println("Stagiaire ajouté !");
    }
    private static void supprimerStagiaire(Scanner scanner) {
        System.out.print("Nom du stagiaire à supprimer : ");
        String nom = scanner.nextLine();
        gestionStagiaires.supprimer(nom);
        System.out.println("Stagiaire supprimé  !");
    }
    private static void ajouterStage(Scanner scanner) {
        System.out.print("Titre du stage : ");
        String titre = scanner.nextLine();
        System.out.print("Durée (en j) : ");
        int duree = scanner.nextInt();
        scanner.nextLine();

        gestionStages.ajouter(new Stage(titre, duree));
        System.out.println("Stage ajouté !");
    }
    private static void associerStagiaireStage(Scanner scanner) {
        System.out.print("Titre du stage : ");
        String titre = scanner.nextLine();
        System.out.print("Nom du stagiaire : ");
        String nom = scanner.nextLine();

        Stage stage = gestionStages.rechercherParTitre(titre);
        Stagiaire stagiaire = gestionStagiaires.rechercherParNom(nom);
        if (stage != null && stagiaire != null) {
            stage.ajouterStagiaire(stagiaire);
            System.out.println("Stagiaire associé au stage !");
        } else {
            System.out.println("Stage ou stagiaire introuvable.");
        }
    }
    private static void rechercherStagiaire(Scanner scanner) {
        System.out.print("Nom du stagiaire à rechercher : ");
        String nom = scanner.nextLine();
        Stagiaire stagiaire = gestionStagiaires.rechercherParNom(nom);
        if (stagiaire != null) {
            stagiaire.affiche();
        } else {
            System.out.println("Stagiaire introuvable.");
        }
    }
}
