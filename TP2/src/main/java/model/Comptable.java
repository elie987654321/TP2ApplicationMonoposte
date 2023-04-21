package model;

public class Comptable {

    // Attributs
    private double totalDesDons;
    private Facture currentFacture;

    // Constructeurs
    public Comptable() {

    }

    public Comptable(double totalDesDons, Facture currentFacture) {
        this.totalDesDons = totalDesDons;
        this.currentFacture = currentFacture;
    }

    // Accesseurs et mutateurs
    public Total getTotalDesDons() {
        return totalDesDons;
    }

    public void setTotalDesDons(Total totalDesDons) {
        this.totalDesDons = totalDesDons;
    }

    public Facture getCurrentFacture() {
        return currentFacture;
    }

    public void setCurrentFacture(Facture currentFacture) {
        this.currentFacture = currentFacture;
    }


    public void EntrerFacture()
    {
        total.EntrerFacture();
    }

    public void AjouterFactureAuTotal() {
        total.AjouterFactureAuTotal();
    }

}
