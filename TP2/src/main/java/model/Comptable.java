package model;

import java.util.*;

public class Comptable {

    // Attributs
    private double totalDesDons;
    private Facture currentFacture;

    private HashMap<String, ModeDePaiement> modePaiements;

    // Constructeurs
    public Comptable() {

    }

    public Comptable(double totalDesDons, Facture currentFacture) {
        this.totalDesDons = totalDesDons;
        this.currentFacture = currentFacture;
        modePaiements = new HashMap<String, ModeDePaiement>() ;
    }


    private void CreerModesPaiements()
    {
        modePaiements.put("argent", new ModeDePaiement( "Argent", 0));
        modePaiements.put("debit" , new ModeDePaiement( "Carte de debit", 0.01));
        modePaiements.put("credit", new ModeDePaiement( "Carte de credit", 0.03));
    }

    private void AjouterATotalDon()
    {
        
    }

    private double CalculerDonFacture(Facture facture)
    {
        return ModeDePaiement.POURCENTAGE * (facture.totalAvecTaxes - (facture.totalAvecTaxes *  facture.modeDePaiement.frais));
    }
}
