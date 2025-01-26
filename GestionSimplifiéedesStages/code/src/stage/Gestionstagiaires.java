package stag;
import stag.models.Stagiaire;
import java.util.ArrayList;
public class Gestionstagiaires implements Gestion<Stagiaire> {
    private ArrayList<Stagiaire> stagiaires = new ArrayList<>();
    public void ajouter(Stagiaire stagiaire) {
        stagiaires.add(stagiaire);
    }
    public void supprimer(String nom) {
        stagiaires.removeIf(s -> s.getNom().equalsIgnoreCase(nom));
    }
    public void affiche() {
        if (stagiaires.isEmpty()) {
            System.out.println("Aucun stagiaire enregistré.");
        } else {
            for (Stagiaire s : stagiaires) {
                s.affiche();
            }
        }
    }
    public Stagiaire rechercherParNom(String nom) {
        for (Stagiaire s : stagiaires) {
            if (s.getNom().equalsIgnoreCase(nom)) {
                return s;
            }
        }
        return null;
    }
}