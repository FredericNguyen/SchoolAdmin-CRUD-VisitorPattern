public interface VisitableListeMoyennesExams {
    public String[][] accept(VisitorCalculMoyenneInterf visiteur);
    public String[][] accept(VisitorCalculMoyenneInterf visiteur, String codeEtd);   
}
