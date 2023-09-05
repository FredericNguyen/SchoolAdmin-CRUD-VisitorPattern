public class Enseignant extends Personne{
    private static int generateurCode;
    private Diplome diplome;
    public Enseignant(){
        super();
    }
    public Enseignant(String nom, String prenom, String tel, Date dt, Diplome diplome){
        super("Prof"+generateurCode++,nom,prenom,dt,tel);
        this.diplome = diplome;
    }
    public void setDiplome(Diplome diplome){
        this.diplome = diplome;
    }
    public Diplome getDiplome(){
        return diplome;
    }
    public static void setSequenceNb(int nb){
        generateurCode = nb;
    }
    public static int getSequenceNb(){
        return generateurCode;
    }
    public String toString(){
        return "Enseignant: " + super.toString(); 
    }
}
