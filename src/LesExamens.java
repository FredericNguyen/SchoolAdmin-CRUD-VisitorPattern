import java.util.HashMap;
import java.io.Serializable;
public class LesExamens implements VisitableInsertionExam, VisitableAccess, 
                            VisitableListeMoyennesExams, Serializable{
    private HashMap<String, ExamMatiere> exams;
    public LesExamens() {
        exams = new HashMap<String, ExamMatiere>();
    }
    public HashMap<String, ExamMatiere> getExamens(){
        return exams;
    }
    public boolean accept(VisitorInsertionInterf visiteur, Matiere m){
        return visiteur.visiter(this,m);
    }
    public ExamMatiere accept(VisitorAccessInterf visiteur,  String idMatiere){
        return visiteur.visiter(this, idMatiere);
    }
    public String[] accept(VisitorAccessInterf visiteur){
        //retourne l'entete a afficher
        return visiteur.visiter(this);
    }
    public String[][] accept(VisitorCalculMoyenneInterf visiteur){
        return visiteur.visiter(this);
    }
    public String[][] accept(VisitorCalculMoyenneInterf visiteur, String codeEtd){
        return null;
    }
   public String[] accept(VisitorAccessInterf visiteur, int info){
        return null;
    }
}
