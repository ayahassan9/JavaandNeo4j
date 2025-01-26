package stag.models;
import java.util.ArrayList;
public class Stage {
    private String titre;
    private int duree;
    private ArrayList<Stagiaire> stagiaires;
    public Stage(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;
        this.stagiaires = new ArrayList<>();
    }
    public String getTitre() {
        return titre;
    }
    public int getDuree() {
        return duree;
    }
    public void ajouterStagiaire(Stagiaire stagiaire) {
        stagiaires.add(stagiaire);
    }
    public ArrayList<Stagiaire> getStagiaires() {
        return stagiaires;
    }
    public void affiche() {
        System.out.println("Stage : " + titre + ", Durée : " + duree);
        if (stagiaires.isEmpty()) {
            System.out.println("Aucun stagiaire associé.");
        } else {
            for (Stagiaire s : stagiaires) {
                s.affiche();
            }
        }
    }
}