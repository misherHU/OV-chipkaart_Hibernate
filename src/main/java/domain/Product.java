package domain;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "product")
public class Product {
    @Id
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private double prijs;


    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<OvChipKaart> ovChipKaarts;


    public Product(){}
    public Product(int product_nummer,String naam,String beschrijving,double prijs){
        this.prijs=prijs;
        this.product_nummer=product_nummer;
        this.naam=naam;
        this.beschrijving=beschrijving;
    }
    public Product(int product_nummer, String naam, String beschrijving, double prijs, List<OvChipKaart> ovChipKaarts){
        this(product_nummer,naam,beschrijving,prijs);
        this.ovChipKaarts=ovChipKaarts;
    }



    public void addOVchipkaart(OvChipKaart ovChipKaart){
        ovChipKaarts.add(ovChipKaart);
    }


    public List<OvChipKaart> getOvChipKaarts() {
        return ovChipKaarts;
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_nummer=" + product_nummer +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
