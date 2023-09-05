import java.util.TreeSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VisitorCalculMoyenneImpl implements VisitorCalculMoyenneInterf{
    private static VisitorCalculMoyenneInterf instance = null;
    private VisitorCalculMoyenneImpl(){
        super();
    }
    public static VisitorCalculMoyenneInterf getInstance(){
        if(instance == null)
            instance = new VisitorCalculMoyenneImpl();
        return instance;
    }
    private String[] calculerligneTable(VisitorAccessInterf visiteur, GestionEtablissement etablissement, String codeEtd, ArrayList<String> cleMatieresExam, 
                                    int sommeCoefficient){
        int colonnes = 4 + cleMatieresExam.size();
        String[] resultat = new String[colonnes];
        int sum = 0;
        Etudiant etudiant = (Etudiant)etablissement.getLesPersonnels().getPersonnels().get(codeEtd);
        resultat[0] = codeEtd;
        resultat[1]  = etudiant.getNom();
        resultat[2] = etudiant.getPrenom();
        int i=3;
            //on calcul la somme des notes des examen de l'etudiant
        for(String cleMat :  cleMatieresExam){
            int note = etablissement.getLesExamens().getExamens().get(cleMat).accept(visiteur, codeEtd);
            resultat[i++] = note + "";
            sum += note * etablissement.getLesMatieres().getMatieres().get(cleMat).getCoefficient();   
        }
        DecimalFormat df = new DecimalFormat("0.00"); // import java.text.DecimalFormat;
        resultat[i] = df.format((double)sum/sommeCoefficient);
        return resultat; 
    }
    public double visiter(ExamMatiere exam){
        //methode qui calcule la moyenne des notes des etudiants dans un examen
        TreeSet<ResultatExam> resultatsMatiere = exam.getResultats();
        Iterator<ResultatExam> iterator = resultatsMatiere.iterator();
        double sum = 0;
        int counter = 0;
        while(iterator.hasNext()){
            sum += iterator.next().getNote();
            counter++;
        }
        return sum/counter;
    } 
    public String[][] visiter(GestionEtablissement etablissement){
        Set<String> cleMatieres = etablissement.getLesExamens().getExamens().keySet();
        ArrayList<String> cleMatieresExam = new ArrayList<String>();
        for(String keyMat :  cleMatieres)
            //if(etablissement.getLesExamens().getExamens().containsKey(keyMat))
                cleMatieresExam.add(keyMat);
        HashSet<String> cleEtudiants = new HashSet<String>();
        for(String key : etablissement.getLesPersonnels().getPersonnels().keySet())
            if(key.toUpperCase().startsWith("ETD")){
                cleEtudiants.add(key);
            }
        String[][] resultat = new String[cleEtudiants.size()][];
        int index = 0;
        //int colonnes = 4 + cleMatieresExam.size();
        int sommeCoeff = 0; //la somme de toutes les matieres des examens
        for(String codeMat :  cleMatieresExam)
            sommeCoeff += etablissement.getLesMatieres().getMatieres().get(codeMat).getCoefficient();
        VisitorAccessInterf visiteur = VisitorAccessImpl.getInstance();
        for(String keyEtd : cleEtudiants){
            //int sum = 0;
            //Etudiant etudiant = (Etudiant)etablissement.getLesPersonnels().getPersonnels().get(keyEtd);
            //resultat[index] = new String[colonnes];
            resultat[index] = calculerligneTable(visiteur,etablissement,keyEtd,
                    cleMatieresExam,sommeCoeff);
            // resultat[index][0] = keyEtd;
            // resultat[index][1]  = etudiant.getNom();
            // resultat[index][2] = etudiant.getPrenom();
            // int i=3;
            // //on calcul la somme des notes des examen de l'etudiant
            // for(String cleMat :  cleMatieresExam){
            //     //if(etablissement.getLesExamens().getExamens().containsKey(cleMat)){
            //     int note = etablissement.getLesExamens().getExamens().get(cleMat).accept(visiteur, keyEtd);
            //     resultat[index][i++] = note + "";
            //     sum += note * etablissement.getLesMatieres().getMatieres().get(cleMat).getCoefficient();
                
            // }
            // DecimalFormat df = new DecimalFormat("0.00"); // import java.text.DecimalFormat;
            // resultat[index][i] = df.format((double)sum/sommeCoeff);
            index++;
        }
        //on tire le tableau selon le numero de chaque etudiants
        for(int i = 0 ; i < resultat.length - 1; i++)
            for(int j=0 ; j < resultat.length - i - 1; j++){
                int nb1 = Integer.parseInt(resultat[j][0].substring(3));
                int nb2 = Integer.parseInt(resultat[j+1][0].substring(3));
                if( nb1 > nb2){
                    String[] temp = resultat[j];
                    resultat[j] = resultat[j+1];
                    resultat[j+1] = temp;
                }
            }
        return resultat;
        
    } 
    public String[][] visiter(GestionEtablissement etablissement, String codeEtudiant){
        Set<String> cleMatieres = etablissement.getLesExamens().getExamens().keySet();
        ArrayList<String> cleMatieresExam = new ArrayList<String>();
        for(String keyMat :  cleMatieres)
            cleMatieresExam.add(keyMat);
        HashSet<String> cleEtudiants = new HashSet<String>();
        for(String key : etablissement.getLesPersonnels().getPersonnels().keySet())
            if(key.toUpperCase().startsWith("ETD")){
                cleEtudiants.add(key);
            }
        int sommeCoeff = 0; //la somme des coefficients de toutes les matieres des examens
        for(String codeMat :  cleMatieresExam)
            sommeCoeff += etablissement.getLesMatieres().getMatieres().get(codeMat).getCoefficient();
        String[][] resultat = new String[1][];
        VisitorAccessInterf visiteur = VisitorAccessImpl.getInstance();
        resultat[0] = calculerligneTable(visiteur,etablissement,codeEtudiant,cleMatieresExam,sommeCoeff);   
        return resultat;
    } 
    public String[][] visiter(LesExamens examens){
        String[][] resultats = new String[examens.getExamens().size()][3];
        int counter = 0; 
        DecimalFormat df = new DecimalFormat("0.00"); // import java.text.DecimalFormat;
        for(ExamMatiere exam : examens.getExamens().values()){
            resultats[counter][0] = exam.getMatiere().getCode();
            resultats[counter][1] = exam.getMatiere().getDesc();
            resultats[counter][2] = df.format(visiter(exam)) + "";
            counter++;  
        }
        return resultats;
    }    
}

