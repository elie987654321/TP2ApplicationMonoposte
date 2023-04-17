package model;

public class Comptable {
    Total total;
    Facture currentFacture;

    public void CreerFacture() {
    }

    public void SetNomFacture() {
        Facture.SetNom();
    }

    public void SetTotalSansTaxeFacture() {
        currentFacture.SetTotalSansTaxe();
    }

    public void SetModePaiementFacture() {
        currentFacture.SetModePaiement();
    }

    public void EntrerFacture()
    {
        total.EntrerFacture();
    }

    public void AjouterFactureAuTotal() {
        total.AjouterFactureAuTotal();
    }
}
