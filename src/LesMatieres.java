import java.util.HashMap;
import java.io.Serializable;
public class LesMatieres implements VisitableInsertionMatiere, VisitableAccessMatiere, Serializable{
   private HashMap<String, Matiere> matieres;
   public LesMatieres(){
        matieres = new HashMap<String, Matiere>();
   } 
   public HashMap<String, Matiere> getMatieres(){
        return matieres;
   } 
   public Matiere accept(VisitorAccessInterf visiteur, String id){
        return visiteur.visiter(this, id);
   }
    public void accept(VisitorInsertionInterf visiteur, Matiere m) {
        visiteur.visiter(this,m);
    }
    public String[] accept(VisitorAccessInterf visiteur){
       return visiteur.visiter(this);
    }
    public String[] accept(VisitorAccessInterf visiteur, int ifo){
          return visiteur.visiter(this,0);
    }
}
