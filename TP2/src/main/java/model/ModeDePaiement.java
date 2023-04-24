package model;

public class ModeDePaiement{

    // Attributs
    public static final double POURCENTAGE = 0.02;
    private String nom;
    private double frais;

    // Constructeur avec paramètres
    public ModeDePaiement(String nom, double frais)
    {
        this.nom = nom;
        this.frais = frais;
    }

    // Accesseurs et mutateurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

}
