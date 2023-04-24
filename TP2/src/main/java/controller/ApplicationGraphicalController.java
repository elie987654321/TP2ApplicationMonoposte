package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.*;
import org.w3c.dom.Text;

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

    @FXML
    private Button ajouter;

    private Comptable comptable;

    private void HandleBoutonClickAjouter(ActionEvent eventHandler)
    {
        Facture factureAEntrer = new Facture();
        if(ChaineValide(totalSansTaxe.getText()) && ChaineValide(totalAvecTaxes.getText()) && ChaineValide(totalAvecTaxes.getText()))
        {

        }
  }

  public boolean ChaineValide(String chaine)
  {
      if(chaine == "" || chaine == null)
      {
          return false;
      }

      boolean charInvalide = false;
      char[] characteres = chaine.toCharArray();
      int i = 0;

      while(charInvalide == false && i < characteres.length)
      {
            if(
                    !(
                        characteres[i] == '0'  ||
                        characteres[i] == '1'  ||
                        characteres[i] == '2'  ||
                        characteres[i] == '3'  ||
                        characteres[i] == '4'  ||
                        characteres[i] == '5'  ||
                        characteres[i] == '6'  ||
                        characteres[i] == '7'  ||
                        characteres[i] == '8'  ||
                        characteres[i] == '9'
                    )
            )
            {
                charInvalide = true;
            }
          i++;
      }

      if(charInvalide == true)
      {
          return false;
      }
      else
      {
          return true;
      }
  }

    public int ApplicationController()
    {

    }

    public ApplicationGraphicalController()
    {

    }

    public void Initialize()
    {
        comptable = new Comptable();

        ajouter.setOnAction(this::HandleBoutonClickAjouter);


    }
}
