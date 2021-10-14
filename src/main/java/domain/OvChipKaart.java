package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "ov_chipkaart")
public class OvChipKaart {
    @Id
    @Column(name = "kaart_nummer")
    int kaartNummer;

    @Column(name = "geldig_tot")
    Date geldigTot;

    int klasse;
    double saldo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reiziger_id")
    Reiziger reiziger;

//    @Column(name = "reiziger_id")
//    int reizigerId;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ov_chipkaart_product",
            joinColumns = {
                    @JoinColumn(name = "kaart_nummer", referencedColumnName = "kaart_nummer",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_nummer", referencedColumnName = "product_nummer",
                            nullable = false, updatable = false)})
    private List<Product> products;



    public OvChipKaart(){}
    public OvChipKaart(int kaartNummer,Date geldigTot,int klasse,double saldo){
        this.kaartNummer=kaartNummer;
        this.geldigTot=geldigTot;
        this.klasse=klasse;
        this.saldo=saldo;




    }



    public OvChipKaart(int kaartNummer,Date geldigTot,int klasse,double saldo,Reiziger reiziger){
        this.kaartNummer=kaartNummer;
        this.geldigTot=geldigTot;
        this.klasse=klasse;
        this.saldo=saldo;
        this.reiziger=reiziger;



    }


    public void setKaartNummer(int kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

//    public int getReizigerId() {
//        return reizigerId;
//    }
//
//    public void setReizigerId(int reizigerId) {
//        this.reizigerId = reizigerId;
//    }

    public int getKaartNummer() {
        return kaartNummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Product>getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){

        products.add(product);
        product.addOVchipkaart(this);
    }

    @Override
    public String toString() {
        return "OvChipKaart{" +
                "kaartNummer=" + kaartNummer +
                ", geldigTot=" + geldigTot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reizigerId=" + reiziger.getReiziger_id() +
                ", products=" + "products" +
                '}';
    }
}
