import java.util.HashMap;
import java.io.Serializable;
public class LesPersonnels implements VisitableInsertionPersonnel, VisitableAccessPersonne, Serializable{
    private HashMap<String, Personne> personnels;
    public LesPersonnels() {
        personnels = new HashMap<String,Personne>();
    }
    HashMap<String, Personne> getPersonnels(){
        return personnels;
    }
    public void accept(VisitorInsertionInterf visiteur, Personne p){
        visiteur.visiter(this,p);
    }
    public Personne accept(VisitorAccessInterf visiteur, String id){
        return visiteur.visiter(this,id);
    }
    public String[] accept(VisitorAccessInterf visiteur, Matiere matiere){
        return visiteur.visiter(this,matiere);
    }
    public String[] accept(VisitorAccessInterf visiteur, boolean etudiant){
        return visiteur.visiter(this,etudiant);
    }
    // public String[] accept(LesPersonnels personnels, Matiere m){
    //     return visiter
    // }
}
