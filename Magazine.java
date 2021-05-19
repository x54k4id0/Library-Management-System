package Projet;

import java.util.ArrayList;

public class Magazine extends Document{

    //les attributs

    private String periodicite;
    private String Mois_edition;
    private int Jour;

    //les Accesseurs

    public String getPeriodicite(){ return periodicite;}
    public String getMois(){return Mois_edition;}
    public int getJour(){return Jour;}

    //les Modificateurs.

    public void setPeriodicite(String per ){
        this.periodicite=per;
    }
    public void setMois(String mois){
        this.Mois_edition=mois;
    }
    public void setJour(int Jour){
        this.Jour=Jour;
    }

    //les constructeurs

    public Magazine(String titre, ArrayList<String> auteur, String editor, int anne, int nbExemplaires, String Per, String mois, int Jour) {
        super(titre, auteur, editor, anne, nbExemplaires);
        this.setPeriodicite(Per);
        this.setMois(mois);
        this.setJour(Jour);
    }

    //Affichage

    public void Affichage(){
        super.Affichage();
        System.out.println("Periodicite de Magazine : "+getPeriodicite());
        System.out.println("Periodicite de Magazine : "+getMois());
        System.out.println("Jour : "+getJour());
    }
}
