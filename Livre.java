package Projet;

import java.util.ArrayList;

public class Livre extends Document{

    //les attributs

    private int Nombre_de_page;
    private String Type;
    private String Tome;

    //les Accesseurs

    public int getNombre_de_page(){ return Nombre_de_page;}
    public String getType(){return Type;}
    public String getTome(){return Tome;}

    //les Modificateurs.

    public void setNombre_de_page(int Nb_page ){
        this.Nombre_de_page=Nb_page;
    }
    public void setType(String type){
        this.Type=type;
    }
    public void setTome(String tome){
        this.Tome=tome;
    }

    //les constructeurs

    public Livre(String titre, ArrayList<String> auteur, String editor, int anne, int nbExemplaires, int Nb_page, String type, String tome) {
        super(titre, auteur, editor, anne, nbExemplaires);
        this.setNombre_de_page(Nb_page);
        this.setType(type);
        this.setTome(tome);
    }

    //Affichage

    public void Affichage(){
        super.Affichage();
        System.out.println("Nombre de page : "+getNombre_de_page());
        System.out.println("Type de livre : "+getType());
        System.out.println("Tome de livre : "+getTome());
    }
}
