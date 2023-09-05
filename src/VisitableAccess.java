public interface VisitableAccess {
    public ExamMatiere accept(VisitorAccessInterf visiteur, String id);
    public String[] accept(VisitorAccessInterf visiteur); 
    public String[] accept(VisitorAccessInterf visiteur, int info) ;
}

