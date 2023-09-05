import java.io.Serializable;
public class ResultatExam implements Comparable<ResultatExam>, Serializable{
    private Etudiant etd;
    private int note;
    public ResultatExam(){
        super();
    }
    public ResultatExam(Etudiant etd, int note){
        this.etd = etd;
        this.note = note;
    }
    public Etudiant getEtudiant(){
        return etd;
    }
    public int getNote(){
        return note;
    }
    public void setNote(int note){
        this.note = note;
    }
    public void setEtudiant(Etudiant etd){
        this.etd = etd;
    }
    public String toString(){
        return etd.toString() + "/Note: " + note;
    }
    public int compareTo(ResultatExam autreResultat){
        if(etd.equals(autreResultat.etd))
            return 0;   
        else
            if(note < autreResultat.note)
                return -1;
            else
                return 1;
    }
}

