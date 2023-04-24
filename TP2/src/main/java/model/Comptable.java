package model;

import java.util.*;


public class Comptable {

    // Attributs
    private double totalDesDons;
    private HashMap<String, ModeDePaiement> modePaiements;

    // Constructeur par défaut
    public Comptable() {
        this.totalDesDons = 0.00;
        modePaiements = new HashMap<String, ModeDePaiement>();
    }

     // Accesseurs et mutateurs
    public HashMap<String, ModeDePaiement> getModePaiements() {
        return modePaiements;
    }

    public void setModePaiements(HashMap<String, ModeDePaiement> modePaiements) {
        this.modePaiements = modePaiements;
    }

    public double getTotalDesDons() {
        return totalDesDons;
    }

    public void setTotalDesDons(double totalDesDons) {
        this.totalDesDons = totalDesDons;
    }

    // Methodes
    private Facture creerUneFacture(){
        return new Facture();
    }

    public void CreerModesPaiements()
    {
        modePaiements.put("argent", new ModeDePaiement( "Argent", 0));
        modePaiements.put("debit" , new ModeDePaiement( "Carte de debit", 0.01));
        modePaiements.put("credit", new ModeDePaiement( "Carte de credit", 0.03));
    }

    public void AjouterFactureATotalDon(Facture facture)
    {
        this.totalDesDons += CalculerDonFacture(facture);
    }

    public double CalculerDonFacture(Facture facture)
    {
        return ModeDePaiement.POURCENTAGE * (facture.getTotalAvecTaxes() - (facture.getTotalAvecTaxes() *  facture.getModeDePaiement().getFrais()));
    }
}
