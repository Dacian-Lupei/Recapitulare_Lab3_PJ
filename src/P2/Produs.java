package P2;

import java.time.LocalDate;

public class Produs {
    private String nume;
    private float pret;
    private int cantitate;
    private LocalDate data_expirarii;

    public Produs(String nume, float pret, int cantitate, LocalDate data_expirarii) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirarii = data_expirarii;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getData_expirarii() {
        return data_expirarii;
    }

    public void setData_expirarii(LocalDate data_expirarii) {
        this.data_expirarii = data_expirarii;
    }

    @Override
    public String toString(){
        return ("Nume: " + nume + ", pret: " + pret + ", cantitate: " + cantitate + ", Data expirarii: " + data_expirarii);
    }

    public static double incasare = 0.0;
}
