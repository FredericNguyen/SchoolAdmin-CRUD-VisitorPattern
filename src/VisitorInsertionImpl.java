import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.Iterator;

public class VisitorInsertionImpl implements VisitorInsertionInterf{
    private static VisitorInsertionInterf instance = null;
    private VisitorInsertionImpl(){
        super();
    }
    public static VisitorInsertionInterf getInstance(){
        if(instance == null)
            instance = new VisitorInsertionImpl();
        return instance;
    }
    public void visiter(LesPersonnels personnels, Personne p){
        personnels.getPersonnels().put(p.getCode(),p);
    }
    public void visiter(LesMatieres matieres, Matiere m){
        HashMap<String, Matiere> dic = matieres.getMatieres();
        if(dic.values().contains(m))
            JOptionPane.showMessageDialog(null, "Matiere existe deja", "Insertion Matiere",JOptionPane.WARNING_MESSAGE); 
        else
            dic.put(m.getCode(),m);
    }
    public boolean visiter(LesExamens examens, Matiere m){
        String code = m.getCode();
        if(!examens.getExamens().containsKey(code)){
            ExamMatiere exam = new ExamMatiere(m);
            examens.getExamens().put(code, exam);
            return true;
        }
        else return false;
    }
    public void visiter(ExamMatiere exam, Etudiant etd, int note){
        //ResultatExam ex = new ResultatExam(etd, note);
        boolean insere = exam.getResultats().add(new ResultatExam(etd, note));
        if(!insere){
            int reponse;
			reponse = JOptionPane.showConfirmDialog(null, "Ce resultat existe deja. Voulez vous changer la note?", "Insertion une note", JOptionPane.YES_NO_OPTION);
			if(reponse == JOptionPane.YES_OPTION){
                Iterator<ResultatExam> itr = exam.getResultats().iterator();
                boolean fin = false;
                while(itr.hasNext() && !fin){
                    ResultatExam resultat = itr.next();
                    if(etd.equals(resultat.getEtudiant())){
                        resultat.setNote(note);
                        fin = true;
                    }
                }       
            }
        }
    }
    public void visiter(Personne p, Matiere m){
        //permet d'ajouter une matiere a une personne
        p.getMatieres().add(m);
    }
}
    

