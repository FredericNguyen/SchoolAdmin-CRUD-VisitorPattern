import java.util.ArrayList;
import java.io.Serializable;
public abstract class Personne implements  VisitableInsertionMatierePersonne, Serializable{
    private String  code;
    private String nom;
    private String prenom;
    private Date dateNais;
    private String tel;
    protected  ArrayList<Matiere> matieres;
    public Personne(){
        super();
    }
    public Personne(String code, String nom, String prenom, Date dateNais,String tel){
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.tel = tel;
        matieres = new ArrayList<Matiere>();
    }
    public void accept(VisitorInsertionInterf visiteur, Matiere m){
        visiteur.visiter(this,m);
    }
    public String getCode(){
        return code;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getTelephone(){
        return tel;
    }
    public String getDateNaissance(){
        return dateNais.toString();
    }
    public ArrayList<Matiere> getMatieres(){
        return matieres;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setTelephone(String tel){
        this.tel = tel;
    }
    public void setDateNais(int jour, int mois, int annee){
        try{
            this.dateNais = new Date(jour, mois, annee);
        }catch(Exception e){
            System.out.println("Date invalide-creation de date impossible!");
        }
    }
    public boolean equals(Object autrePersonne){
        if(this instanceof Etudiant && autrePersonne instanceof Etudiant){
            return code.equalsIgnoreCase(((Etudiant) autrePersonne).getCode());
        }
       if(this instanceof Enseignant && autrePersonne instanceof Enseignant){
            return code.equalsIgnoreCase(((Enseignant) autrePersonne).getCode());
        } 
        else return false;
    }
    public String toString(){
        return code + "/" + nom + "/" + prenom + "/" + tel ;
    }
}

