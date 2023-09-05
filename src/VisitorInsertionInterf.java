public interface VisitorInsertionInterf{
    public void visiter(LesPersonnels personnels, Personne p);
    public void visiter(LesMatieres matieres, Matiere m);
    public boolean visiter(LesExamens exams, Matiere m);
    public void visiter(ExamMatiere exam, Etudiant etd, int note);
    public void visiter(Personne p,Matiere m);
}