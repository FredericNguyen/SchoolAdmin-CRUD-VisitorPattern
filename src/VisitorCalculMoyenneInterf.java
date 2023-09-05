public interface VisitorCalculMoyenneInterf {
    public double visiter(ExamMatiere exam);
    public String[][] visiter(GestionEtablissement etablissement);
    public String[][] visiter(GestionEtablissement etablissement, String codeEtd);
    public String[][] visiter(LesExamens examens);
}
