package Projet;

import java.util.ArrayList;

public class DictionnaireBilingue extends Dictionnaire{
    private int Nb_Lange;
    public int getNb_Lange(){ return Nb_Lange;}
    public void setNb_Lange(int Nb_Lange){ this.Nb_Lange=Nb_Lange; }
    public DictionnaireBilingue(String titre, ArrayList<String> auteur, String editor, int anne, int nbExemplaires, String Langue, int Nb_Tome, int Nb_lange) {
        super(titre, auteur, editor, anne, nbExemplaires, Langue, Nb_Tome);
        this.setNb_Lange(Nb_lange);
    }
    public void Affichage(){
        super.Affichage();
        System.out.println("Nombre de Langue: "+getNb_Lange());
    }
}
