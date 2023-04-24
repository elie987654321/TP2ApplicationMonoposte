package controller;

import javafx.fxml.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Facture;
import model.ModeDePaiement;

import java.awt.*;

public class ApplicationGraphicalController {
    @FXML
    private TextField nomAcheteur;

    @FXML
    private ChoiceBox modePaiement;

    @FXML
    private TextField totalSansTaxe;

    @FXML
    private TextField taxesApplicables;

    @FXML
    private TextField totalAvecTaxes;

    private ModeDePaiement modePaiementEnum;

    private Facture facture;

    public ApplicationGraphicalController()
    {

    }
}
