public class GestionEtablissement implements VisitableChargementInterf, VisitableCalculListeNotes{
    private String nomEtablissement;
    private LesExamens lesExamens;
	private LesMatieres lesMatieres;
	private LesPersonnels lesPersonnels;
    
	public GestionEtablissement(String nomEtablissement){
        this.nomEtablissement = nomEtablissement;
        lesExamens = new LesExamens();
        lesMatieres = new LesMatieres();
        lesPersonnels = new LesPersonnels();
        //on ivite le visiteur de chargement pour intialiser les examens, les matieres et les personnels
        //a partir des fichiers textes 
        accept(VisitorChargementImpl.getInstance());
			
	}
	public void setMatieres(LesMatieres lesMatieres){
		this.lesMatieres = lesMatieres;
	}
	public void setExamens(LesExamens lesExamens){
		this.lesExamens = lesExamens;
	}
	public void setPersonnels(LesPersonnels lesPersonnels){
		this.lesPersonnels = lesPersonnels;
	}
	public void accept(VisitorSauvegardeInterf visiteur){
		visiteur.visiter(this);
	}
	public void accept(VisitorChargementInterf visiteur){
		visiteur.visiter(this);
	}
	public String[][] accept(VisitorCalculMoyenneInterf visiteur){
		return visiteur.visiter(this);
	}
	public String[][] accept(VisitorCalculMoyenneInterf visiteur, String codeEtd){
		return visiteur.visiter(this,codeEtd);
	}
	public String[] accept(VisitorAccessInterf visiteur){
		return visiteur.visiter(this);
	}
	public LesPersonnels getLesPersonnels(){return lesPersonnels;}
	public LesMatieres getLesMatieres(){return lesMatieres;}
	public LesExamens getLesExamens(){return lesExamens;}
}
