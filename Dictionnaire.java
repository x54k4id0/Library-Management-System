package Projet;

import java.util.ArrayList;

public class Dictionnaire extends Document{

    //les attributs

    private String Langue;
    private int Nb_Tome;

    //les Accesseurs

    public String getLangue(){return Langue;}
    public int getNb_Tome(){return Nb_Tome;}

    //les Modificateurs.

    public void setLangue(String Langue){
        this.Langue=Langue;
    }
    public void setNb_Tome(int Nb_Tome){
        this.Nb_Tome=Nb_Tome;
    }

    //les constructeurs

    public Dictionnaire(String titre, ArrayList<String> auteur, String editor, int anne, int nbExemplaires, String Langue, int Nb_Tome) {
        super(titre, auteur, editor, anne, nbExemplaires);
        this.setLangue(Langue);
        this.setNb_Tome(Nb_Tome);
    }

    //Affichage

    public void Affichage(){
        super.Affichage();
        System.out.println("Langue de Dictionnaire : "+getLangue());
        System.out.println("Nombre de tomes : "+getNb_Tome());
    }
}