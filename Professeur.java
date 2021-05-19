package Projet;

public class Professeur extends Personne{
    private String Departement ;
    private String CIN ;
    public String getDepartement(){
        return Departement;
    }
    public String getCIN(){
        return CIN;
    }
    public void setDepartement(String Departement) { this.Departement =Departement; }
    public void setCIN(String CIN) { this.CIN =CIN; }
    public Professeur(String Identif, String Nom, String Prenom, int Age, String Adresse, int Numero, String Departement, String CIN) {
        super(Identif, Nom, Prenom, Age, Adresse, Numero);
        super.setMax_Emprunte(5);
        this.setDepartement(Departement);
        this.setCIN(CIN);
    }
    public void Affichage(){
        System.out.println("Departement : "+getDepartement());
        System.out.println("CIN : "+getCIN());
        super.Affichage();
    }
}
