package Projet;

import java.util.ArrayList;

public class Manga extends Livre{
    public Manga(String titre, ArrayList<String> auteur, String editor, int anne, int nbExemplaires, int Nb_page, String type, String tome) {
        super(titre, auteur, editor, anne, nbExemplaires, Nb_page, type, tome);
    }
}
