package model;

public class ModeDePaiement{

    public static final double POURCENTAGE = 0.02;


    public String nom;

    public double frais;

    public ModeDePaiement(String nom, double frais)
    {
        this.nom = nom;
        this.frais = frais;
    };

}
