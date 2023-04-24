package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.*;
public class ApplicationGraphicalController {
    @FXML
    private TextField nomAcheteur;

    private String nomAcheteurString;

    @FXML
    private ChoiceBox modePaiement;



    @FXML
    private TextField totalSansTaxe;

    private double totalSansTaxeDouble;

    @FXML
    private TextField taxesApplicables;

    private double taxesApplicablesDouble;

    @FXML
    private TextField totalAvecTaxes;

    private double totalAvecTaxesDouble;

    private Facture facture;

    private Comptable comptable;



    private void HandleBoutonClickAjouter(ActionEvent eventHandler)
    {

    }

    public ApplicationGraphicalController()
    {

    }

    public void Initialize()
    {
        Comptable comptable = new Comptable();
    }
}
