package Projet;

import java.util.ArrayList;

public class Document {

    //les attributs

    private static int ISBN = 0;
    private String titre;
    private ArrayList<String> auteur = new ArrayList<String>();
    private String editeur;
    private int annee;
    private int nbExemplaires;

    //les Accesseurs

    public int getISBN(){
        return ISBN;
    }
    public String getTitre(){
        return titre;
    }
    public ArrayList<String> getAuteur(){
        return auteur;
    }
    public String getEditeur(){
        return editeur;
    }
    public int getAnnee(){
        return annee;
    }
    public int getNbExemplaires(){
        return nbExemplaires;
    }

    //les Modificateurs.

    public void setTitre(String titre) {
        this.titre =titre;
    }
    public void setAuteur(ArrayList<String> Auteur){
        if( Auteur.size() <= 5){
            for(String i: Auteur) {
                this.auteur.add(i);
            }
        }
    }
    public void setEditeur(String editeur){
        this.editeur=editeur;
    }
    public void setAnnee(int annee){
        this.annee=annee;
    }
    public void setNbExemplaires(int nbExemplaires){
        this.nbExemplaires=nbExemplaires;
    }

    //les constructeurs

    public Document(String titre, ArrayList<String> auteur, String editeur, int annee, int nbExemplaires){
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setEditeur(editeur);
        this.setAnnee(annee);
        this.setNbExemplaires(nbExemplaires);
        ISBN++;
    }
    public Document(Document Doc){
        titre =Doc.titre;
        annee = Doc.annee;
        auteur = Doc.auteur;
        editeur = Doc.editeur;
        nbExemplaires = Doc.nbExemplaires;
        ISBN++;
        this.incrementer();
    }
    //Affichage
    public void Affichage(){
        System.out.println("Numéro ISBN : "+getISBN());
        System.out.println("Titre de Document : "+getTitre());
        System.out.print("Auteurs de Document : ");
        for(String i : auteur )
            System.out.print(i+ " | ");
        System.out.print("\n");
        System.out.println("Editeur de document : "+getEditeur());
        System.out.println("Annee d’edition de Document : "+getAnnee());
        System.out.println("Nombre d'exemplaires : "+getNbExemplaires());
    }

    //Message de distructeur
    public void finalize() {
        System.out.println("Distruction faite !!");
        this.decrementer();
    }

    // incrémenter et de décrémenter
    public void incrementer(){
        this.nbExemplaires++;
    }
    public void decrementer(){
        this.nbExemplaires--;
    }
}
