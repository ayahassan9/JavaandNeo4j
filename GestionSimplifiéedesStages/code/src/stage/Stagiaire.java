package stag.models;
public class Stagiaire extends Personne {
    private String nvEtude;
    public Stagiaire(String nom, String prenom, String nvEtude) {
        super(nom, prenom);
        this.nvEtude = nvEtude;
    }
    public String getNvEtude() {
        return nvEtude;
    }
    public void setNvEtude(String nvEtude) {
        this.nvEtude = nvEtude;
    }
    public void affiche() {
        System.out.println("Nom : " + nom + ", Prénom : " + prenom + ", Niveau d'étude : " + nvEtude);
    }
}