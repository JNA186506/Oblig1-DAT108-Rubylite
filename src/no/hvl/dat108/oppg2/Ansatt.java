package no.hvl.dat108.oppg2;

public class Ansatt {

    private String fornavn;
    private String etternavn;
    private Kjonn kjonn;
    private String stilling;
    private double aarslonn;

    public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, double aarslonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = aarslonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public Kjonn getKjonn() {
        return kjonn;
    }

    public void setKjonn(Kjonn kjonn) {
        this.kjonn = kjonn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public double getAarslonn() {
        return aarslonn;
    }

    public void setAarslonn(double aarslonn) {
        this.aarslonn = aarslonn;
    }

    @Override
    public String toString() {
        return "Ansatt{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", kjonn=" + kjonn +
                ", stilling='" + stilling + '\'' +
                ", aarslonn=" + aarslonn +
                '}';
    }
}