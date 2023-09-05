import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class VisitorChargementImpl implements VisitorChargementInterf{
    private static VisitorChargementInterf instance = null;
    private VisitorChargementImpl(){
        super();
    }
    public static VisitorChargementInterf getInstance(){
        if(instance == null)
            instance = new VisitorChargementImpl();
        return instance;
    }
    private void chargerMatieres(GestionEtablissement etablissement){
        File f = new File(FICHIER_MATIERES);
        String title = "Chargement du fichier texte des matières";
        try{
            if(f.exists()){
                BufferedReader r = null;
                r = new BufferedReader(new FileReader(f));
                String line = r.readLine();
                while( line != null){
                    String[] matiere = line.split(";");
                    Matiere objMatiere = new Matiere(matiere[0], matiere[1], Integer.parseInt(matiere[2]));
                    etablissement.getLesMatieres().accept(VisitorInsertionImpl.getInstance(),objMatiere);
                    line = r.readLine();
                } 
                r.close(); 
            }
            else 
                Utilitaires.afficheMessage("Fichier Texte de mati\u00E8res non trouv\u00E9",title); 
        }catch(Exception e){
            Utilitaires.afficheMessage(e.getMessage(), title); 
        }
    }
    private void chargerProfesseurs(GestionEtablissement etablissement){
        File f = new File(FICHIER_PROFESSEURS);
        String title = "Chargement du fichier texte des enseignants";
        try{
            if(f.exists()){
                BufferedReader r = null;
                r = new BufferedReader(new FileReader(f));
                String line = r.readLine();
                while( line != null){
                    String[] prof = line.split(";");
                    Date dNaiss  = new Date(Integer.parseInt(prof[2]), Integer.parseInt(prof[3]), Integer.parseInt(prof[4]));
                    Diplome diplome = new Diplome(prof[6],prof[7],prof[8],Integer.parseInt(prof[9]));
                    Enseignant enseignant = new Enseignant(prof[0],prof[1],prof[5],dNaiss,diplome);
                    etablissement.getLesPersonnels().accept(VisitorInsertionImpl.getInstance(),enseignant);
                    for(int i=10; i < prof.length ; i++){
                        Matiere m = etablissement.getLesMatieres().accept(VisitorAccessImpl.getInstance(),prof[i]);
                        enseignant.getMatieres().add(m);
                    }
                    line = r.readLine();
                } 
                r.close(); 
            }
            else 
                Utilitaires.afficheMessage("Fichier Texte de Professeurs non trouv\u00E9",title); 
        }catch(Exception e){
            Utilitaires.afficheMessage(e.getMessage(),title); 
        }
    }
    private void chargerEtudiants(GestionEtablissement etablissement){
        String title = "Chargement du fichier texte des etudiants";
        File f = new File(FICHIER_ETUDIANTS);
        try{
            if(f.exists()){
                BufferedReader r = null;
                r = new BufferedReader(new FileReader(f));
                String line = r.readLine();
                while( line != null){
                    String[] etd = line.split(";");
                    Date dNaiss  = new Date(Integer.parseInt(etd[2]), Integer.parseInt(etd[3]), Integer.parseInt(etd[4]));
                    Etudiant etudiant = new Etudiant(etd[0],etd[1],dNaiss,etd[5],etd[6]);
                    etablissement.getLesPersonnels().accept(VisitorInsertionImpl.getInstance(),etudiant);
                    for(int i=7; i < etd.length ; i++)
                        etudiant.getMatieres().add(etablissement.getLesMatieres().getMatieres().get(etd[i]));
                    line = r.readLine();
                } 
                r.close(); 
            }
            else 
                Utilitaires.afficheMessage("Fichier Texte etudiants non trouv\u00E9", title); 
        }catch(Exception e){
            Utilitaires.afficheMessage(e.getMessage(),title); 
        }
    }
    private void chargerNotes(GestionEtablissement etablissement){
        String title = "Chargement du fichier texte des notes";
        File f = new File(FICHIER_NOTES);
        try{
            if(f.exists()){
                BufferedReader r = null;
                r = new BufferedReader(new FileReader(f));
                String line = r.readLine();
                VisitorAccessInterf visiteurAccess = VisitorAccessImpl.getInstance();
                VisitorInsertionInterf visiteurInsertion = VisitorInsertionImpl.getInstance();
                while( line != null){
                    int indice = line.indexOf(";");
                    String[] notes = line.substring(indice+1).split(";");
                    String codeEtd = line.substring(0,indice);
                    Etudiant etd = (Etudiant)etablissement.getLesPersonnels().accept(visiteurAccess,codeEtd);
                    for(int i=0; i < notes.length ; i=i+2){
                        Matiere m = etablissement.getLesMatieres().accept(visiteurAccess, notes[i]);
                        etablissement.getLesExamens().accept(visiteurInsertion, m);
                        ExamMatiere exam = etablissement.getLesExamens().accept(visiteurAccess,notes[i]);
                        exam.accept(visiteurInsertion,etd, Integer.parseInt(notes[i+1]));
                    }
                    line = r.readLine();
                } 
                r.close(); 
            }
            else 
                Utilitaires.afficheMessage("Fichier Texte de mati\\u00E8res non trouv\u00E9", title); 
        }catch(Exception e){
            Utilitaires.afficheMessage(
                    "Probleme de lecture d'un fichiers Texte des mati\u00E8res",title); 
            }
    }
    public void visiter(GestionEtablissement etablissement){
        File fMatiere = new File(FICHIER_MATIERES_OBJ);
        File fPersonne = new File(FICHIER_PERSONNES_OBJ);
        File fNotes = new File(FICHIER_EXAMENS_OBJ);
        File fichierSeqNb = new File(FICHIER_SEQUENCE_NB);
             
        if(fMatiere.exists() && fPersonne.exists() && fNotes.exists())
            try{
                if(fichierSeqNb.exists()){
                    BufferedReader r = new BufferedReader(new FileReader(fichierSeqNb));
                    String line = r.readLine();
                    String[] tokens = line.split(";");
                    Etudiant.setSequenceNb(Integer.parseInt(tokens[0]));
                    Enseignant.setSequenceNb(Integer.parseInt(tokens[1]));
                    r.close(); 
                }
                else{ 
                    throw new Exception("Fichier de numeros de sequence introuvable");}
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fMatiere));
                etablissement.setMatieres((LesMatieres)ois.readObject());
                ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(fPersonne));
                etablissement.setPersonnels((LesPersonnels)ois1.readObject());
                ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(fNotes));
                etablissement.setExamens((LesExamens)ois2.readObject());
                ois.close();
                ois1.close();
                ois2.close();
            }catch(Exception e){
                Utilitaires.afficheMessage(e.getMessage(),"Chargement fichiers objets"); 
            }
        else{
            Etudiant.setSequenceNb(1);
            Enseignant.setSequenceNb(1); 
            chargerMatieres(etablissement);
            chargerProfesseurs(etablissement);
            chargerEtudiants(etablissement);
            chargerNotes(etablissement);
        }  
    }
}
