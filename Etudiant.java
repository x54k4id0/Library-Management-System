package Projet;

public class Etudiant extends Personne{
    private String CNE;
    public String getCNE(){
        return CNE;
    }
    public void setCNE(String CNE) { this.CNE =CNE; }
    public Etudiant(String Identif, String Nom, String Prenom, int Age, String Adresse, int Numero,String CNE) {
        super(Identif, Nom, Prenom, Age, Adresse, Numero);
        super.setMax_Emprunte(3);
        this.setCNE(CNE);
    }
    public void Affichage(){
        System.out.println("CNE : "+getCNE());
        super.Affichage();
    }
}
