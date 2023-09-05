import java.io.Serializable;
public class Matiere  implements Serializable{

    private String desc;
    private String code;
    private int coefficient;


    public Matiere(){
        super();
    }
    public Matiere(String code, String desc, int coefficient){
        this.code = code;
        this.desc = desc;
        this.coefficient = coefficient;
    }
    public String getDesc(){
        return desc;
    }
    public String getCode(){
        return code;
    }
    public int getCoefficient(){
        return coefficient;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }
    public boolean equals(Object o){
        if(o instanceof Matiere){
            Matiere autre = (Matiere)o;
            return autre.code.equalsIgnoreCase(code);
        }
        else
            return false;     
    }
    public String toString(){
        return "Matiere: " + code + "/" + desc + "/" + coefficient;
    }
}

