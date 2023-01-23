package fr.test.test_bdd.model;

public class Fournisseur {
    private String nomfou;
    private String numfou;
    private String ruefou;
    private String posfou;
    private String vilfou;
    private String confou;
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

    public String getRuefou() {
        return ruefou;
    }

    public void setRuefou(String ruefou) {
        this.ruefou = ruefou;
    }

    public String getPosfou() {
        return posfou;
    }

    public void setPosfou(String posfou) {
        this.posfou = posfou;
    }

    public String getVilfou() {
        return vilfou;
    }

    public void setVilfou(String vilfou) {
        this.vilfou = vilfou;
    }

    public String getConfou() {
        return confou;
    }

    public void setConfou(String confou) {
        this.confou = confou;
    }
}
