public class Etudiant extends Personne{
    private static int generateurCode;
    private String specialite;
    public Etudiant(){
        super();
    }
    public Etudiant(String nom, String prenom, Date dt, String tel, String specialite){
        super("Etd" + generateurCode++, nom,prenom,dt,tel);
        this.specialite = specialite;
    }
    public void setSpecialite(String specialite){
        this.specialite = specialite;
    }
    public String getSpecialite(){
        return specialite;
    }
    public static void setSequenceNb(int nb){
        generateurCode = nb;
    }
    public static int getSequenceNb(){
        return generateurCode;
    }
    public boolean equals(Object autreEtd){
        if(autreEtd instanceof Etudiant)
            return getCode().equalsIgnoreCase(((Etudiant) autreEtd).getCode());
        else
            return false;
    }
    public String toString(){
        return "Etudiant: " + super.toString(); 
    }
}
