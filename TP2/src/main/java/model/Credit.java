package model;

public class Credit implements ModeDePaiement {

    // Attribut
    private double frais;

    // Constructeur complet
    public Credit(double frais) {
        this.frais = frais;
    }

    // Accesseurs et mutateurs
    @Override
    public double getFrais() {
        return 0;
    }

    @Override
    public void setFrais(double frais) {

    }
}