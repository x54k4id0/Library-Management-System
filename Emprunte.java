package Projet;

public class Emprunte {
    private String Code_Emprunteur;
    private String Code_Document;
    public String getCode_Emprunteur(){
        return Code_Emprunteur;
    }
    public String getCode_Document(){
        return Code_Document;
    }
    public void setCode_Emprunteur(String A){
        this.Code_Emprunteur=A;
    }
    public void setCode_Document(String A){
        this.Code_Document=A;
    }
    public Emprunte(String Code_Emprunteur, String Code_Document){
        this.setCode_Emprunteur(Code_Emprunteur);
        this.setCode_Document(Code_Document);
    }
    public void Affichage(){
        System.out.println("Code_Emprunteur : "+getCode_Emprunteur());
        System.out.println("Code_Document : "+getCode_Document());
    }
}
