package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Comptable;
import model.Facture;
import model.ModeDePaiement;

public class ApplicationController extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Facturation");

        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../view/Application.fxml"));

        Scene scene = new Scene(fxmlLoader1.load());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private double pourcentageTaxes;

    private ModeDePaiement modeDePaiement;

    public void Deroulement()
    {
        Comptable comptable = new Comptable();
        comptable.CreerFacture();
        Facture facture = new Facture();
        comptable.SetNomFacture();
        comptable.SetTotalSansTaxeFacture();
        comptable.SetModePaiementFacture();
        comptable.EntrerFacture();
        comptable.AjouterFactureAuTotal();
    }


    private void GetPourcentageTaxes()
    {

    }
}
