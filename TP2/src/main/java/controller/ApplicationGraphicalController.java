package controller;

import javafx.fxml.*;
import model.ModeDePaiement;

import java.awt.*;

public class ApplicationGraphicalController {


    @FXML
    String nomAcheteur;

    @FXML
    ModeDePaiement modePaiement;

    @FXML
    TextField totalSansTaxe;

    @FXML
    TextField taxesApplicables;

    @FXML
    TextField totalAvecTaxes;


    public ApplicationGraphicalController()
    {
    }
}
