import java.util.TreeSet;
import java.io.Serializable;
public class ExamMatiere implements VisitableInsertionNoteExam, VisitableAccessNote, Serializable{
    private Matiere matiere;
    private TreeSet<ResultatExam> resultats;
    public ExamMatiere(Matiere matiere){
        this.matiere = matiere;
        resultats = new TreeSet<ResultatExam>(); //on cree l'arbre binaire
    }
    public Matiere getMatiere(){
        return matiere;
    }
    public TreeSet<ResultatExam> getResultats(){
        return resultats;
    }
    public void accept(VisitorInsertionInterf visiteur, Etudiant etd, int note){
        visiteur.visiter(this,etd,note);
    }
    public int accept(VisitorAccessInterf visiteur, String code){
        return visiteur.visiter(this,code);
    }
}
