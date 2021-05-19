package Projet;

public class Personne {

    //les attributs

    private String Identif;
    private String Nom;
    private String Prenom;
    private int Age;
    private String Adresse;
    private int Numero;
    private int Max_Emprunte;

    //les Accesseurs

    public String getIdentif(){
        return Identif;
    }
    public String getNom(){
        return Nom;
    }
    public String getPrenom(){
        return Prenom;
    }
    public int getAge(){
        return Age;
    }
    public String getAdresse(){
        return Adresse;
    }
    public int getNumero(){
        return Numero;
    }
    public int getMax_Emprunte(){return Max_Emprunte;}

    //les Modificateurs.

    public void setIdentif(String Identif) { this.Identif =Identif; }
    public void setNom(String Nom){
        this.Nom=Nom;
    }
    public void setPrenom(String Prenom){
        this.Prenom=Prenom;
    }
    public void setAge(int Age){
        this.Age=Age;
    }
    public void setAdresse(String Adresse){
        this.Adresse=Adresse;
    }
    public void setNumero(int Numero){
        this.Numero=Numero;
    }
    public void setMax_Emprunte(int Emprunte){this.Max_Emprunte = Emprunte;}

    //les constructeurs

    public Personne(String Identif,String Nom,String Prenom,int Age,String Adresse,int Numero){
        this.setIdentif(Identif);
        this.setNom(Nom);
        this.setPrenom(Prenom);
        this.setAge(Age);
        this.setAdresse(Adresse);
        this.setNumero(Numero);
        this.Max_Emprunte = 3;
    }
    public Personne(Personne Per){
        Identif = Per.Identif;
        Nom = Per.Nom;
        Prenom = Per.Prenom;
        Age = Per.Age;
        Adresse = Per.Adresse;
        Numero = Per.Numero;
        Max_Emprunte = 1;
    }

    //Affichage
    public void Affichage(){
        System.out.println("Numéro identifient : "+getIdentif());
        System.out.println("Nom : "+getNom());
        System.out.println("Prenom : "+getPrenom());
        System.out.println("Age : "+getAge());
        System.out.println("Adresse : "+getAdresse());
        System.out.println("Numero : "+getNumero());
        System.out.println("Max emprunte : "+getMax_Emprunte());
    }



}
