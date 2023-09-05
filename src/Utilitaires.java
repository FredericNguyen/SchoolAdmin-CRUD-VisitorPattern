import javax.swing.JOptionPane;

public class Utilitaires{
    public static boolean validerDate(int jour, int mois, int annee){
        final boolean valide = true;
        final int[][] jours = {
            {0,31,29,31,30,31,30,31,31,30,31,30,31},
            {0,31,28,31,30,31,30,31,31,30,31,30,31}
        };
        if(annee <=0 || mois < 0 || jour <= 0)
            return !valide;
        else{
            int bisc = (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0 ? 0 : 1; 
            if(mois >=1 && mois <= 12)
                return  (jour >= 1) && (jour <= jours[bisc][mois]);
            else 
                return !valide; 
        }
    } 
    public static void trieTableauCodePersonnelMatiere(String[] resultat, int index){
        for(int i = 0 ; i < resultat.length - 1; i++)
            for(int j=0 ; j < resultat.length - i - 1; j++){
                int nb1 = Integer.parseInt(resultat[j].substring(index));
                int nb2 = Integer.parseInt(resultat[j+1].substring(index));
                if(nb1 > nb2){
                    String temp = resultat[j];
                    resultat[j] = resultat[j+1];
                    resultat[j+1] = temp;
                }
            }
    }
    public static void afficheMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title,JOptionPane.WARNING_MESSAGE);  
    } 
}
