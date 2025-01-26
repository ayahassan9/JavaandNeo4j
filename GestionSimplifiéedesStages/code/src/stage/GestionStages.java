package stag;
import stag.models.Stage;
import java.util.ArrayList;
public class GestionStages implements Gestion<Stage> {
    private ArrayList<Stage> stages = new ArrayList<>();
    public void ajouter(Stage stage) {
        stages.add(stage);
    }
    public void supprimer(String titre) {
        stages.removeIf(s -> s.getTitre().equalsIgnoreCase(titre));
    }
    public void affiche() {
        if (stages.isEmpty()) {
            System.out.println("Aucun stage enregistré.");
        } else {
            for (Stage s : stages) {
                s.affiche();
            }
        }
    }
    public int nombreTotalStages() {
        return stages.size();
    }
    public Stage rechercherParTitre(String titre) {
        for (Stage s : stages) {
            if (s.getTitre().equalsIgnoreCase(titre)) {
                return s;
            }
        }
        return null;
    }
}