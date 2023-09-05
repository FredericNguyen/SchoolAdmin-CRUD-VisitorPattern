import java.io.*;

import javax.swing.JOptionPane;
public class VisitorSauvegardeImpl implements VisitorSauvegardeInterf{
    private static VisitorSauvegardeInterf instance = null;
    private VisitorSauvegardeImpl(){
        super();
    }
    public static VisitorSauvegardeInterf getInstance(){
        if(instance == null)
            instance = new VisitorSauvegardeImpl();
        return instance;
    }
    public void visiter(GestionEtablissement etablissement){
        try{
            ObjectOutputStream oosMatieres = new ObjectOutputStream(new FileOutputStream(FICHIER_MATIERES_OBJ));
            ObjectOutputStream oosPersonnels = new ObjectOutputStream(new FileOutputStream(FICHIER_PERSONNES_OBJ));     
            ObjectOutputStream oosNotes = new ObjectOutputStream(new FileOutputStream(FICHIER_EXAMENS_OBJ));
            oosMatieres.writeObject(etablissement.getLesMatieres());
            oosPersonnels.writeObject(etablissement.getLesPersonnels());
            oosNotes.writeObject(etablissement.getLesExamens());
            oosMatieres.close();
            oosPersonnels.close();
            oosNotes.close();
            PrintWriter pr = new PrintWriter(new FileWriter(FICHIER_SEQUENCE_NB));
            pr.println(Etudiant.getSequenceNb() + ";" + Enseignant.getSequenceNb());
            pr.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme d'ecriture dans fichier d'objets",JOptionPane.WARNING_MESSAGE); 
        }
    }
}
