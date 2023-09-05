public interface VisitorAccessInterf {
    public Personne visiter(LesPersonnels personnels, String id); //pour obtenir une personne etudiant ou enseignant a partir de son code
    public Matiere visiter(LesMatieres matieres, String id);  //pour obtenir une matiere a partir de son code 
    public ExamMatiere visiter(LesExamens examens, String id); //pour trouver un examen a partir de son code
    public int visiter(ExamMatiere exam, String id); // pour cherher la note d'un etudiant dans un examen 
    public String[] visiter(LesMatieres matieres);
    public String[] visiter(LesExamens examens);
    public String[] visiter(LesMatieres matieres,int info); 
    public String[] visiter(LesPersonnels personnels, boolean etudiant);
    public String[] visiter(GestionEtablissement etablissement);
    public String[] visiter(LesPersonnels personnels, Matiere matiere);
}
