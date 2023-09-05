import java.text.SimpleDateFormat;
import java.util.*;
import java.io.Serializable;
public class Date implements Serializable{
    private int jour, mois, an;
    public Date(){
        //la date actuel dans le local du systeme
          Calendar cal = Calendar.getInstance();
          jour = cal.get(Calendar.DAY_OF_MONTH);
          mois = cal.get(Calendar.MONTH) + 1; //Dans calender les mois commencent a partir de 0
          an = cal.get(Calendar.YEAR);
    }
    public Date(int jour, int mois, int annee) throws Exception{
        if(Utilitaires.validerDate(jour,mois,annee)){
            this.jour = jour;
            this.mois = mois;
            this.an = annee;
        }
        else 
            throw new Exception("Cette date est invalide");
    }
    public boolean dateApres(Date date) {
        int year = date.an;
        int day = date.jour;
        int month = date.mois;
        if(year > an) return true;
        else
            if(year < an) return false;
            else
                if(month > mois) return true;
                else
                    if(month < mois) return false;
                    else return day > jour;
    }
    public int getJour(){
        return jour;
    }
    public int getMois(){
        return mois;
    }
    public int getAnnee(){
        return an;
    }
    public String toString(){
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format((new GregorianCalendar(an, mois-1, jour)).getTime());
    }
}