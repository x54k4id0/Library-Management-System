package Projet;
import java.util.ArrayList;
import java.util.Scanner;

 

public class Main {
    static int tailleEtude =0;
    static int tailleProf =0;
    static int tailleLivre =0;
    static int tailleMaga =0;
    static int tailleDic =0;
    static int tailleEmpEtud =0;
    static int tailleEmpProf =0;
    static Etudiant[] Etude = new Etudiant[100];
    static Professeur[] Prof = new Professeur[100];
    static Livre[] Liv = new Livre[100];
    static Magazine[] Mag = new Magazine[100];
    static Dictionnaire[] Dico = new Dictionnaire[100];
    static Emprunte[] empEtud = new Emprunte[100];
    static Emprunte[] empProf = new Emprunte[100];


    // Fonction de recherche

    public static void Recherche(String Identif){
        for(Personne item : Etude)
            if(item instanceof Personne){
                Personne perss = item;
                if(perss.getIdentif().equals(Identif)){
                    System.out.println("\n---------------------------------");
                    item.Affichage();
                    System.out.println("---------------------------------");
                    return;
                }
            }
        for(Personne item : Prof)
            if(item instanceof Personne){
                Personne perss = item;
                if(perss.getIdentif().equals(Identif)){
                    System.out.println("\n---------------------------------");
                    item.Affichage();
                    System.out.println("---------------------------------");
                    return;
                }
            }
        System.out.println("\n Erreur Id que vous avez entre n'existe pas dans la liste");
    }


    //Supprimer Emprunte Professeur
    public static boolean Supprime_Empr_Proffeseur(String CIN,String Titre){
        boolean Var = false;
        Emprunte[] test = new Emprunte[100];
        for(int i = 0; i< tailleEmpProf; i++) {
            if ((!CIN.equals(empProf[i].getCode_Emprunteur())) && (!Titre.equals(empProf[i].getCode_Document())) ) {
                test[i]= empProf[i];
            } else {
                Var = true;
            }
        }
        empProf = test;
        return Var;
    }

    //Supprimer Emprunte Etudiant
    public static boolean Supprime_Empr_Etudient(String CNE,String Titre){
        boolean Var = false;
        Emprunte[] test = new Emprunte[100];
        for(int i = 0; i< tailleEmpEtud; i++) {
            if ((!CNE.equals(empEtud[i].getCode_Emprunteur())) && (!Titre.equals(empEtud[i].getCode_Document())) ) {
                test[i]= empEtud[i];
            } else {
                Var = true;
            }
        }
        empEtud = test;
        return Var;
    }




    // Affichage Emprunte Professeur

    public static void Affiche_Emp_Professeur(){

        for(int i = 0; i< tailleEmpProf; i++){
            if(empProf[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Emprunte Numero : "+i+" :\n");
            empProf[i].Affichage();
            System.out.println("======================================");
        }
    }

    // Affichage Emprunte Etudiant

    public static void Affiche_Emp_Etudiant(){

        for(int i = 0; i< tailleEmpEtud; i++){
            if(empEtud[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Emprunte Numero : "+i+" :\n");
            empEtud[i].Affichage();
            System.out.println("======================================");
        }
    }

    // Ajoute Emprunte Etudiant
    public static void Ajoute_Emprunte_Etudiant(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Donner CNE de l'etudiant : ");
        String CNE = Sc.next();
        System.out.print("Donner le titre du document : ");
        String titre = Sc.next();
        Emprunte emprunte = new Emprunte(CNE,titre);
        empEtud[tailleEmpEtud] = emprunte;
        tailleEmpEtud++;
    }

    // Ajoute Emprunte Professeur
    public static void Ajoute_Emprunte_Professeur(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Donner CIN de Professeur : ");
        String CIN = Sc.next();
        System.out.print("Donner titre du Documment : ");
        String titre = Sc.next();
        Emprunte emprunte = new Emprunte(CIN,titre);
        empProf[tailleEmpProf] = emprunte;
        tailleEmpProf++;
    }

    //Affichage menu Emprunte
    public static void Menu_Emprunte(){
        Scanner Sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Le Menu principal : ");
            System.out.println("\n=======================================================");
            System.out.println("[1]  ==> Ajouter Emprunte Etudiant ");
            System.out.println("[2]  ==> Ajouter Emprunte Professeur ");
            System.out.println("[3]  ==> Afficher Emprunte Etudiant");
            System.out.println("[4]  ==> Afficher Emprunte Professeur");
            System.out.println("[5]  ==> Supprimer Emprunte Etudiant");
            System.out.println("[6]  ==> Supprimer Emprunte Professeur");
            System.out.println("[7]  ==> Quitter ");
            System.out.println("=======================================================");
            System.out.print("\nEntrez votre choix :");
            choix = Sc.nextInt();
            switch (choix){
                case 1 : Ajoute_Emprunte_Etudiant(); break;
                case 2 : Ajoute_Emprunte_Professeur(); break;
                case 3 : Affiche_Emp_Etudiant();break;
                case 4 : Affiche_Emp_Professeur();break;
                case 5 :
                    System.out.print("Donner CNE de l'etudiant : ");
                    String CNE = Sc.next();
                    System.out.print("Donner le titre du document : ");
                    String Titre = Sc.next();
                    boolean test = Supprime_Empr_Etudient(CNE,Titre);
                    if(test == true)
                        System.out.println("Suppression avec succès !!");
                    else
                        System.out.println("Ce numero n'existe pas dans la list");
                    break;
                case 6 :
                    System.out.print("Donner le CIN du professeur : ");
                    String CIN = Sc.next();
                    System.out.print("Donner le titre du document : ");
                    String TitreE = Sc.next();
                    boolean testE = Supprime_Empr_Etudient(CIN,TitreE);
                    if(testE == true)
                        System.out.println("Suppression avec succès !!");
                    else
                        System.out.println("Ce numero n'existe pas dans la list");
                    break;
                default: break;
            }
            System.out.println("\n\n\n\n\n\n");
        } while (choix != 7);
    }


    //Supprimer Livre
    public static boolean Supprime_Livre(String titre){
        boolean Var = false;
        Livre[] test = new Livre[100];
        for(int i = 0; i< tailleLivre; i++) {
            if (!titre.equals(Liv[i].getTitre())) {
                test[i]=Liv[i];
            } else {
                Var = true;
            }
        }
        Liv = test;
        return Var;
    }

    //Supprimer Magazine
    public static boolean Supprime_Magazine(String titre){
        boolean Var = false;
        Magazine[] test = new Magazine[100];
        for(int i = 0; i< tailleMaga; i++) {
            if (!titre.equals(Mag[i].getTitre())) {
                test[i]=Mag[i];
            } else {
                Var = true;
            }
        }
        Mag = test;
        return Var;
    }

    //Supprimer Dictionnaire
    public static boolean Supprime_Dictionnaire(String titre){
        boolean Var = false;
        Dictionnaire[] test = new Dictionnaire[100];
        for(int i = 0; i< tailleDic; i++) {
            if (!titre.equals(Dico[i].getTitre())) {
                test[i]=Dico[i];
            } else {
                Var = true;
            }
        }
        Dico = test;
        return Var;
    }

    // Affichage Livre

    public static void Affiche_Livre(){

        for(int i = 0; i< tailleLivre; i++){
            if(Liv[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Livre Numero : "+i+" :\n");
            Liv[i].Affichage();
            System.out.println("======================================");
        }
    }

    // Affichage Magazine

    public static void Affiche_Magazine(){

        for(int i = 0; i< tailleMaga; i++){
            if(Mag[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Magazine Numero : "+i+" :\n");
            Mag[i].Affichage();
            System.out.println("======================================");
        }
    }
    // Affichage Dictionnaire

    public static void Affiche_Dictionnaire(){

        for(int i = 0; i< tailleDic; i++){
            if(Dico[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Dictionnaire Numero : "+i+" :\n");
            Dico[i].Affichage();
            System.out.println("======================================");
        }
    }

    // Ajouter Livre
    public static void Ajoute_Livre(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Titre : ");
        String Titre = Sc.next();
        ArrayList<String> auteur = new ArrayList<String>();
        System.out.print("Nombre des auteurs : ");
        int Nb_auteur = Sc.nextInt();
        for(int i=0;i<Nb_auteur;i++){
            System.out.print("Auteur Numero "+(i+1)+" : ");
            String Aut = Sc.next();
            auteur.add(Aut);
        }
        System.out.print("Editeur : ");
        String Editeur = Sc.next();
        System.out.print("Annee : ");
        int Annee = Sc.nextInt();
        System.out.print("nbExemplaires : ");
        int nbExemplaires = Sc.nextInt();
        System.out.print("Nb_page : ");
        int Nb_page = Sc.nextInt();
        System.out.print("type : ");
        String type = Sc.next();
        System.out.print("tome : ");
        String tome = Sc.next();
        Livre livre = new Livre(Titre,auteur,Editeur,Annee,nbExemplaires,Nb_page,type,tome);
        Liv[tailleLivre] = livre;
        tailleLivre++;
    }

    // Ajouter Magazine
    public static void Ajoute_Magazine(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Titre : ");
        String Titre = Sc.next();
        ArrayList<String> auteur = new ArrayList<String>();
        System.out.print("Nombre des auteurs : ");
        int Nb_auteur = Sc.nextInt();
        for(int i=0;i<Nb_auteur;i++){
            System.out.print("Auteur Numero "+(i+1)+" : ");
            String Aut = Sc.next();
            auteur.add(Aut);
        }
        System.out.print("Editeur : ");
        String Editeur = Sc.next();
        System.out.print("Annee : ");
        int Annee = Sc.nextInt();
        System.out.print("nbExemplaires : ");
        int nbExemplaires = Sc.nextInt();
        System.out.print("Per : ");
        String Per = Sc.next();
        System.out.print("mois : ");
        String mois = Sc.next();
        System.out.print("Jour : ");
        int Jour = Sc.nextInt();
        Magazine magazine = new Magazine(Titre,auteur,Editeur,Annee,nbExemplaires,Per,mois,Jour);
        Mag[tailleMaga] = magazine;
        tailleMaga++;
    }

    // Ajoute Dictionnaire
    public static void Ajoute_Dictionnaire(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Titre : ");
        String Titre = Sc.next();
        ArrayList<String> auteur = new ArrayList<String>();
        System.out.print("Nombre des auteurs : ");
        int Nb_auteur = Sc.nextInt();
        for(int i=0;i<Nb_auteur;i++){
            System.out.print("Auteur Numero "+(i+1)+" : ");
            String Aut = Sc.next();
            auteur.add(Aut);
        }
        System.out.print("Editeur : ");
        String Editeur = Sc.next();
        System.out.print("Annee : ");
        int Annee = Sc.nextInt();
        System.out.print("nbExemplaires : ");
        int nbExemplaires = Sc.nextInt();
        System.out.print("Langue : ");
        String Langue = Sc.next();
        System.out.print("Nombre de Tome : ");
        int Nb_Tome = Sc.nextInt();
        Dictionnaire dictionnaire = new Dictionnaire(Titre,auteur,Editeur,Annee,nbExemplaires,Langue,Nb_Tome);
        Dico[tailleDic] = dictionnaire;
        tailleDic++;
    }

    //Affichage menu Document
    public static void Menu_Document(){
        Scanner Sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Le Menu principal : ");
            System.out.println("\n=======================================================");
            System.out.println("[1]  ==> Ajouter Livre ");
            System.out.println("[2]  ==> Ajouter Magazine ");
            System.out.println("[3]  ==> Ajouter Dictionnaire ");
            System.out.println("[4]  ==> Afficher Livre ");
            System.out.println("[5]  ==> Afficher Magazine ");
            System.out.println("[6]  ==> Afficher Dictionnaire ");
            System.out.println("[7]  ==> Supprimer Livre ");
            System.out.println("[8]  ==> Supprimer Magazine ");
            System.out.println("[9]  ==> Supprimer Dictionnaire ");
            System.out.println("[10]  ==> Quitter ");
            System.out.println("=======================================================");
            System.out.print("\nEntrez votre choix :");
            choix = Sc.nextInt();
            switch (choix){
                case 1 : Ajoute_Livre(); break;
                case 2 : Ajoute_Magazine(); break;
                case 3 : Ajoute_Dictionnaire();break;
                case 4 : Affiche_Livre();break;
                case 5 : Affiche_Magazine();break;
                case 6 : Affiche_Dictionnaire();break;
                case 7 : System.out.print("Donner le titre du Livre a supprimer : ");
                    String Titre = Sc.next();
                    boolean test = Supprime_Livre(Titre);
                    if(test == true)
                        System.out.println("Suppression avec succès");
                    else
                        System.out.println("Ce numero n'existe pas dans la list");
                    break;
                case 8 : System.out.print("Donner le titre du Magazine a supprimer : ");
                    String Titree = Sc.next();
                    boolean teste = Supprime_Magazine(Titree);
                    if(teste == true)
                        System.out.println("Suppression avec succès !!");
                    else
                        System.out.println("Ce numero n'existe pas dans la list");
                    break;
                case 9 : System.out.print("Donner le titre du Dictionnaire a supprimer : ");
                    String Titreee = Sc.next();
                    boolean testee = Supprime_Dictionnaire(Titreee);
                    if(testee == true)
                        System.out.println("Suppression avec succès !!");
                    else
                        System.out.println("Ce numero n'existe pas dans la list");
                    break;
                default: break;
            }
            System.out.println("\n\n\n\n\n\n");
        } while (choix != 10);
    }

    //Supprimer Etudiant
    public static boolean Supprime_Etudient(String cne){
        boolean Var = false;
        Etudiant[] test = new Etudiant[100];
        for(int i = 0; i< tailleEtude; i++) {
            if (!cne.equals(Etude[i].getCNE())) {
                test[i]=Etude[i];
            } else {
                Var = true;
            }
        }
        Etude = test;
        return Var;
    }

    //Supprimer Professeur
    public static boolean Supprime_Professeur(String cin){
        boolean Var = false;
        Professeur[] test = new Professeur[100];
        for(int i = 0; i< tailleProf; i++) {
            if (!cin.equals(Prof[i].getCIN())) {
                test[i]=Prof[i];
            } else {
                Var = true;
            }
        }
        Prof = test;
        return Var;
    }

    // Ajoute Etudiant
    public static void Ajoute_Etudiant(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Numéro identifient : ");
        String Identif = Sc.next();
        System.out.print("Nom : ");
        String Nom = Sc.next();
        System.out.print("Prenom : ");
        String Prenom = Sc.next();
        System.out.print("Age : ");
        int Age = Sc.nextInt();
        System.out.print("Adresse : ");
        String Adresse = Sc.next();
        System.out.print("Numero : ");
        int Numero = Sc.nextInt();
        System.out.print("CNE : ");
        String CNE = Sc.next();
        Etudiant etud = new Etudiant(Identif,Nom,Prenom,Age,Adresse,Numero,CNE);
        Etude[tailleEtude] = etud;
        tailleEtude++;
    }
    // Ajoute Professeur
    public static void Ajoute_Professeur(){
        Scanner Sc = new Scanner(System.in);
        System.out.print("Numéro identifient : ");
        String Identif = Sc.next();
        System.out.print("Nom : ");
        String Nom = Sc.next();
        System.out.print("Prenom : ");
        String Prenom = Sc.next();
        System.out.print("Age : ");
        int Age = Sc.nextInt();
        System.out.print("Adresse : ");
        String Adresse = Sc.next();
        System.out.print("Numero : ");
        int Numero = Sc.nextInt();
        System.out.print("Departement : ");
        String Departement = Sc.next();
        System.out.print("CIN : ");
        String CIN = Sc.next();
        Professeur P = new Professeur(Identif,Nom,Prenom,Age,Adresse,Numero,Departement,CIN);
        Prof[tailleProf] = P;
        tailleProf++;
    }
    // Affichage Etudiant

    public static void Affiche_Etudiant(){

        for(int i = 0; i< tailleEtude; i++){
            if(Etude[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Etudiant Numero : "+i+" :\n");
            Etude[i].Affichage();
            System.out.println("======================================");
        }
    }

    // Affichage Professeur

    public static void Affiche_Professeur(){
        for(int i = 0; i< tailleProf; i++){
            if(Prof[i]==null)
                return;
            System.out.println("\n======================================");
            System.out.println("Professeur Numero : "+i+" :\n");
            Prof[i].Affichage();
            System.out.println("======================================");
        }
    }


    //Affichage menu Adherent
    public static void Menu_Adherent(){
        Scanner Sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Le Menu principal : ");
            System.out.println("\n=======================================================");
            System.out.println("[1]  ==> Ajouter Etudiant ");
            System.out.println("[2]  ==> Ajouter Professeur ");
            System.out.println("[3]  ==> Afficher Etudiant ");
            System.out.println("[4]  ==> Afficher Professeur ");
            System.out.println("[5]  ==> Supprimer Etudiant ");
            System.out.println("[6]  ==> Supprimer Professeur ");
            System.out.println("[7]  ==> Rechercher Etudiant ou Professeur ");
            System.out.println("[8]  ==> Quitter ");
            System.out.println("=======================================================");
            System.out.print("\nEntrez votre choix :");
            choix = Sc.nextInt();
            switch (choix){
                case 1 : Ajoute_Etudiant(); break;
                case 2 : Ajoute_Professeur(); break;
                case 3 : Affiche_Etudiant();break;
                case 4 : Affiche_Professeur();break;
                case 5 : System.out.print("Donner le CNE de l'Etudiant a supprimer : ");
                         String CNE = Sc.next();
                         boolean test = Supprime_Etudient(CNE);
                         if(test == true)
                             System.out.println("Suppression avec succès !!");
                         else
                             System.out.println("ce numero n'existe pas dans la list");
                         break;
                case 6 : System.out.print("Donner CIN de Professeur a supprimer : ");
                         String CIN = Sc.next();
                         boolean teste = Supprime_Professeur(CIN);
                         if(teste == true)
                         System.out.println("Suppression avec succès !!");
                         else
                         System.out.println("ce numero n'existe pas dans la list");
                         break;
                case 7 : System.out.print("Donner Identif de l'etudient ou Professeur : ");
                         String Identif = Sc.next();
                         Recherche(Identif);
                         break;
                default: break;
            }
            System.out.println("\n\n\n\n\n\n");
        } while (choix != 8);
    }

    // main
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Le Menu principal :");
            System.out.println("\n=======================================================");
            System.out.println("[1]  ==> Gestion des Adherents ");
            System.out.println("[2]  ==> Gestion des Documents ");
            System.out.println("[3]  ==> Gestion des Empruntes ");
            System.out.println("[4]  ==> Quitter ");
            System.out.println("=======================================================");
            System.out.print("\nEntrez votre choix :");
            choix = Sc.nextInt();
            switch (choix){
                case 1 : Menu_Adherent();break;
                case 2 : Menu_Document();break;
                case 3 : Menu_Emprunte();break;
                default:break;
            }
            System.out.println("\n\n\n\n\n\n");
        } while (choix != 4);

    }
}
