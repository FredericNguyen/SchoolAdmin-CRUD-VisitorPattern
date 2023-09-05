public interface VisitableAccessPersonne {
    public Personne accept(VisitorAccessInterf visiteur, String id);
    public String[] accept(VisitorAccessInterf visitor, boolean etudiant);
}
