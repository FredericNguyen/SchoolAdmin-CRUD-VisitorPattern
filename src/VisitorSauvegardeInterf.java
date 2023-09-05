public interface VisitorSauvegardeInterf {
    static final String FICHIER_MATIERES_OBJ = "ProjetFinalAlgo\\\\src\\donnees\\matieres.obj";
    static final String FICHIER_PERSONNES_OBJ = "ProjetFinalAlgo\\\\src\\donnees\\Personnes.obj";
    static final String FICHIER_EXAMENS_OBJ = "ProjetFinalAlgo\\\\src\\donnees\\Examens.obj";
    static final String FICHIER_SEQUENCE_NB = "ProjetFinalAlgo\\\\src\\donnees\\SequenceNb.txt";

    public void visiter(GestionEtablissement etablissement);

}
