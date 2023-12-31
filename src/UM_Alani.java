import java.util.ArrayList;
import java.util.List;

public class UM_Alani
{

    //Alan_Adi, Il_Adlari, Ilan_Yili
    private String Alan_Adi;
    private List<String> Il_Adlari = new ArrayList<>();
    private int Ilan_Yili;
    private List<String> discription;
    public UM_Alani(String Alan_Adi,List<String> Il_Adlari,int Ilan_Yili , List<String> discription)
    {
        this.Alan_Adi = Alan_Adi;
        this.Il_Adlari = Il_Adlari;
        this.Ilan_Yili = Ilan_Yili;
        this.discription = discription;
    }
    public String getAlan_Adi() {
        return Alan_Adi;
    }

    public void setAlan_Adi(String alan_Adi) {
        Alan_Adi = alan_Adi;
    }

    public List<String> getIl_Adlari() {
        return Il_Adlari;
    }

    public void setIl_Adlari(List<String> il_Adlari) {
        Il_Adlari = il_Adlari;
    }


    public int getIlan_Yili() {
        return Ilan_Yili;
    }

    public void setIlan_Yili(int ilan_Yili) {
        Ilan_Yili = ilan_Yili;
    }
    public List<String> getDiscription(){
        return discription;
    }
    public void setDiscription(List<String> dis){
        discription = dis;
    }
    public String toString(){
        //String stringDis =String.join(" ", discription.toArray(new String[0]));
        return String.format("%s %s %d",Alan_Adi , UtilityBox.ListToString(Il_Adlari) , this.Ilan_Yili );
    }

}
