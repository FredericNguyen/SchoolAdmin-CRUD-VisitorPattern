import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Arrays;
public class VisitorAccessImpl implements VisitorAccessInterf{
    private static VisitorAccessInterf instance = null;
    private VisitorAccessImpl(){
        super();
    }
    public static VisitorAccessInterf getInstance(){
        if(instance == null)
            instance = new VisitorAccessImpl();
        return instance;
    }
    public Personne visiter(LesPersonnels personnels, String id){
         return personnels.getPersonnels().get(id);
    }
    public Matiere visiter(LesMatieres matieres, String id){
         return matieres.getMatieres().get(id);
     } 
    public ExamMatiere visiter(LesExamens examens, String id){
        return examens.getExamens().get(id);
    }
    public int visiter(ExamMatiere exam, String id){
        Iterator<ResultatExam> itr = exam.getResultats().iterator();
        while(itr.hasNext()){
            ResultatExam res = itr.next();
            if(res.getEtudiant().getCode().equalsIgnoreCase(id))
                return res.getNote();
        }
        return 0; //retour 0 dans le cas ou pas d'etudiants ayant ce code dans cet examen
    }
     public String[] visiter(LesMatieres matieres){
        //obtenir la liste des entete du tableau liste nom matieres moyenne
         Set<String> set = matieres.getMatieres().keySet();
         Iterator<String> itr = set.iterator();
         int counter = 3; 
         String[] enteteListe = new String[set.size() + 4];
         enteteListe[0] = "Num\u00E9ro";
         enteteListe[1] = "Nom";
         enteteListe[2] = "Prénom";
         while(itr.hasNext()){
             String key = itr.next();
             enteteListe[counter++] = matieres.getMatieres().get(key).getDesc();
         }
         enteteListe[counter] = "Moyenne";
         return enteteListe;
    }
    public String[] visiter(GestionEtablissement etablissement){
        Set<String> set = etablissement.getLesMatieres().getMatieres().keySet();
        int nbColonnes = 4;
        for(String key: set)
            if(etablissement.getLesExamens().getExamens().containsKey(key))
                nbColonnes++;
        Iterator<String> itr = set.iterator();
        int counter = 3; 
        String[] enteteListe = new String[nbColonnes];
        enteteListe[0] = "Num\u00E9ro";
        enteteListe[1] = "Nom";
        enteteListe[2] = "Prénom";
        while(itr.hasNext()){
            String key = itr.next();
            if(etablissement.getLesExamens().getExamens().containsKey(key))
                enteteListe[counter++] = etablissement.getLesMatieres().getMatieres().get(key).getDesc();
        }
        enteteListe[counter] = "Moyenne";
        return enteteListe;
    }
    public String[] visiter(LesExamens examens){
        //retourne entete numero, matiere, moyenne
        String[] enteteListe = {"Code","Matiere","Moyenne"};
        return enteteListe;
    }
        //pour obtenir la liste des codes de matieres
    public String[] visiter(LesMatieres matieres, int info){
        //revoie la liste des codes des matieres
        Set<String> set = matieres.getMatieres().keySet();
        String[] resultat = new String[set.size()];
        int indice = 0;
        for (String code : set)
            resultat[indice++] = code;
        Arrays.sort(resultat);
        return resultat;
    } 
    public String[] visiter(LesPersonnels personnels, boolean etudiant){
        //renvoie la liste des codes des etudiants ou enseignant selon parametre etudiant
        String[] resultat;
        String prefix = etudiant ? "Etd" : "Prof";
        Set<String> set = personnels.getPersonnels().keySet();
        ArrayList<String> liste = new ArrayList<String>();
        int index = 0;
        for(String code: set)
            if(code.startsWith(prefix))
                liste.add(code);
        resultat = new String[liste.size()];
        for(String code: liste)
            resultat[index++] = code;
        Utilitaires.trieTableauCodePersonnelMatiere(resultat, etudiant ? 3 : 4);
        return resultat;
    }
    public String[] visiter(LesPersonnels personnels, Matiere matiere){
        //renvoie la liste des codes des etudiants d'une matiere
        ArrayList<String> liste = new ArrayList<String>(); 
        for(Personne p : personnels.getPersonnels().values())
            if(p instanceof Etudiant && p.getMatieres().contains(matiere))
                    liste.add(p.getCode());
        String[] resultat = new String[liste.size()];
        int counter = 0;
        for(String code: liste)
            resultat[counter++] = code;
        Utilitaires.trieTableauCodePersonnelMatiere(resultat,3);
        return resultat;
    }    
}
    
 

