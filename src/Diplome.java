import java.io.Serializable;
public class Diplome implements Serializable{
    private String titre;
    private String specialite;
    private String universite;
    private int anneeObtention;

    public Diplome(){
        super();
    } 
    public Diplome(String titre, String specialite, String universite, int anneeObtention){
        this.titre = titre;
        this.specialite = specialite;
        this.universite = universite;
        this.anneeObtention = anneeObtention;
    }
    public String getTitre(){
        return titre;
    }
    public String getUniversite(){
        return universite;
    }
    public String getSpecialite(){
        return specialite;
    }
    public int getAnneeObtention(){
        return anneeObtention;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public void setUniversite(String universite){
        this.universite = universite;
    }
    public void setAnneeObtention(int anneeObtention){
        this.anneeObtention = anneeObtention;
    }
    public void setSpecialiye(String specialite){
        this.specialite = specialite;
    }
    public String toString(){
        return "Diplome: " + titre + "/" + universite + "/" + anneeObtention;
    }   
}
