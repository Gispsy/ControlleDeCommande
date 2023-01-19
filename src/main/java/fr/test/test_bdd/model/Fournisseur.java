package fr.test.test_bdd.model;

public class Fournisseur {
    private String nomfou;
    private String numfou;

    public Fournisseur(String nomfou, String numfou) {
        this.nomfou = nomfou;
        this.numfou = numfou;
    }

    public String getNomfou() {
        return nomfou;
    }

    public void setNomfou(String nomfou) {
        this.nomfou = nomfou;
    }

    public String getNumfou() {
        return numfou;
    }

    public void setNumfou(String numfou) {
        this.numfou = numfou;
    }

    @Override
    public String toString(){
        return nomfou;
    }
}
