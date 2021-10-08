package domain;


import javax.persistence.*;

@Entity
@Table(name = "adres")
public class Adres {
    @Id
    @Column(name = "adres_id")
private int id;
private String straat;
private String postcode;
private String woonplaats;
private String huisnummer;
private int reiziger_id;




@Transient
private Reiziger reiziger;




public Adres(){}
public Adres(int id,String woonplaats,String huisnummer,String postcode,String straat,int reiziger_id){
    this.id=id;
    this.woonplaats=woonplaats;
    this.huisnummer=huisnummer;
    this.postcode=postcode;
    this.straat=straat;
    this.reiziger_id=reiziger_id;

}



    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setReiziger_id(int reiziger_id) {
        this.reiziger_id = reiziger_id;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    @Override
    public String toString() {
        return "domain.Adres{" +
                "id=" + id +
                ", straat='" + straat + '\'' +
                ", postcode='" + postcode + '\'' +
                ", woonplaats='" + woonplaats + '\'' +
                ", huisnummer='" + huisnummer + '\'' +
                ", reiziger_id=" + reiziger_id +
                '}';
    }


}
