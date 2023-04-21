package model;

import java.util.*;

public class Comptable {
    // Attributs
    private double totalDesDons;

    private HashMap<String, ModeDePaiement> modePaiements;

    // Constructeurs
    public Comptable(double totalDesDons) {
        this.totalDesDons = totalDesDons;
        modePaiements = new HashMap<String, ModeDePaiement>() ;
    }

    //Methodes
    private void CreerModesPaiements()
    {
        modePaiements.put("argent", new ModeDePaiement( "Argent", 0));
        modePaiements.put("debit" , new ModeDePaiement( "Carte de debit", 0.01));
        modePaiements.put("credit", new ModeDePaiement( "Carte de credit", 0.03));
    }

    private void AjouterFactureATotalDon(Facture facture)
    {
        this.totalDesDons += CalculerDonFacture(facture);
    }

    private double CalculerDonFacture(Facture facture)
    {
        return ModeDePaiement.POURCENTAGE * (facture.getTotalAvecTaxes() - (facture.getTotalAvecTaxes() *  facture.getModeDePaiement().getFrais()));
    }

    public HashMap<String, ModeDePaiement> getModePaiements() {
        return modePaiements;
    }

    //Accesseur et mutateur
    public void setModePaiements(HashMap<String, ModeDePaiement> modePaiements) {
        this.modePaiements = modePaiements;
    }

    public double getTotalDesDons() {
        return totalDesDons;
    }

    public void setTotalDesDons(double totalDesDons) {
        this.totalDesDons = totalDesDons;
    }
}
