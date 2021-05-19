package Projet;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Bibliotheque {

    //les attributs

    private static int taill = 1;
    private Document[] ListeDocuments = new Document[taill];
    private Personne[] ListeEmprunteurs = new Personne[taill];

    //les Accesseurs

    public Document getDocument(int indice){
        if(indice <= taill){
            return this.ListeDocuments[indice];
        }
        return this.ListeDocuments[0];
    }

    public Personne getEmprunteurs(int indice){
        if(indice <= taill){
            return this.ListeEmprunteurs[indice];
        }
        return this.ListeEmprunteurs[0];
    }

    public int getTaill(){ return taill;}

    //les Modificateurs.

    public void setListeDocuments(Document Doc){
        this.ListeDocuments[taill-1] = Doc;
    }

    public void setListeEmprunteurs(Personne Per){
        this.ListeEmprunteurs[taill-1] = Per;
    }

    //constructeur

    public Bibliotheque(Personne Per,Document Doc){
        this.setListeEmprunteurs(Per);
        this.setListeDocuments(Doc);
        taill++;
    }

    //Affichage

    public void Affichage(){
        for(int i=0 ; i< this.getTaill() ; i++){
            System.out.println("Nom l'emprenteur : "+this.ListeEmprunteurs[i]);
            System.out.println("Nom du Document : "+this.ListeDocuments[i]);
            System.out.println("\n");
        }
    }

    //fonction 1

    public Document[] getDocumentsByEditeur(String Editeur){
        int taill_doc = 1;
        Document[] Doc = new Document[100];
        for(int i=0 ; i<this.getTaill();i++){
            if(getDocument(i).getEditeur().equals(Editeur)){
                Doc[taill_doc-1]=getDocument(i);
                taill_doc++;
            }
        }
        return Doc;
    }

    //fonction 2

    public Document getDocumentsbyISBN(int isbn){
        for(int i=0 ; i<this.getTaill();i++){
            if( getDocument(i).getISBN() == isbn){
                return getDocument(i);
            }
        }
        return null;
    }

    //fonction 3

    public Document[] getDocumentsByAuteur(String auteur){
        int taill_doc = 1;
        Document[] Doc = new Document[100];
        for(int i=0 ; i<this.getTaill();i++){
            for(int j=0 ; j<this.getDocument(i).getAuteur().size() ; j++){
                if(getDocument(i).getAuteur().get(j).equals(auteur)){
                    Doc[taill_doc-1]=getDocument(i);
                    taill_doc++;
                }
            }
        }
        return Doc;
    }

    //fonction 4

    public Document[] getDocumentsByTitre(String titre){
        int taill_doc = 1;
        Document[] Doc = new Document[100];
        for(int i=0 ; i<this.getTaill();i++){
            if(getDocument(i).getTitre().equals(titre)){
                Doc[taill_doc-1]=getDocument(i);
                taill_doc++;
            }
        }
        return Doc;
    }

    // fonction 5

    public Etudiant getEtudiantByCne(String cne){
        for(int i=0; i<taill ; i++){
            if (getEmprunteurs(i) instanceof Etudiant) {
                Etudiant e = (Etudiant) getEmprunteurs(i);
                if(e.getCNE().equals(cne))
                    return e;
            }
        }
        return null;
    }

    // fonction 6

    public Professeur getProfesseurByCin(String cin){
        for(int i=0; i<taill ; i++){
            if (getEmprunteurs(i) instanceof Professeur) {
                Professeur p = (Professeur) getEmprunteurs(i);
                if(p.getCIN().equals(cin))
                    return p;
            }
        }
        return null;
    }

    // fonction 7

    public boolean SupprimerDocument(String titre){
        boolean Var = false;
        List result = new LinkedList();
        for(Document item : ListeDocuments)
            if(!titre.equals(item.getTitre())){
                result.add(item);
            }
            else{
                Var = true;
            }
        ListeDocuments = (Document[]) result.toArray(ListeDocuments);
        return Var;
    }

    // fonction 8

    public boolean SupprimerEtudiant(String cne){
        boolean Var = false;
        List result = new LinkedList();
        for(Personne item : ListeEmprunteurs)
            if(item instanceof Etudiant){
                Etudiant e = (Etudiant) item;
                if(!cne.equals(e.getCNE())){
                    result.add(item);
                }
                else{
                    Var = true;
                }
            }
        ListeEmprunteurs = (Personne[]) result.toArray(ListeEmprunteurs);
        return Var;
    }

    // fonction 9

    public boolean SupprimerProfesseur(String cin){
        boolean Var = false;
        List result = new LinkedList();
        for(Personne item : ListeEmprunteurs)
            if(item instanceof Professeur){
                Professeur p = (Professeur) item;
                if(!cin.equals(p.getCIN())){
                    result.add(item);
                }
                else{
                    Var = true;
                }
            }
        ListeEmprunteurs = (Personne[]) result.toArray(ListeEmprunteurs);
        return Var;
    }

    //fonction 10

    public boolean AjouterDocument(Document d){
        // changer 100 par MAX
        if(taill < 100){
            taill++;
            this.setListeDocuments(d);
            return true;
        }
        return false;
    }

    // fonction 11

    public boolean AjouterAdherent(Personne a){
        // changer 100 par MAX
        if(taill < 100){
            taill++;
            this.setListeEmprunteurs(a);
            return true;
        }
        return false;
    }

    // fonction 12

    public Document[] TrierAnneeAsc(){
        List result = new LinkedList();

        for(Document item : ListeDocuments)
            result.add(item);

        Collections.sort(result);
        return (Document[]) result.toArray(ListeDocuments);
    }

    //function 13

    public Document[] TrierAnneeDesc(){
        List result = new LinkedList();

        for(Document item : ListeDocuments)
            result.add(item);

        Collections.sort(result, Collections.reverseOrder());
        return (Document[]) result.toArray(ListeDocuments);
    }


    //function 14

    public Livre[] getLivrebyType(String type){
        int taill_livre = 1;
        Livre[] ktab = new Livre[100];
        for(int i=0; i<taill ; i++){
            if (getDocument(i) instanceof Livre) {
                Livre l = (Livre) getDocument(i);
                if(l.getType().equals(type)){
                    ktab[taill_livre-1]= (Livre) getDocument(i);
                    taill_livre++;
                }
            }
        }
        return ktab;
    }



}
