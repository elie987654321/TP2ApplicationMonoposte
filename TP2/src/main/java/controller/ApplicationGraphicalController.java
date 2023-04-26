package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

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
    Text textErreur;

    @FXML
    private Text totalDons;

    @FXML
    private Button ajouter;

    private Comptable comptable;


    ArrayList<String> modesPaiementString;

    //La longuer de la boite quand on clique sur la choice box s'adapte au text a l'interieur.
    // On ajoute du text pour avoir la bonne taille, trop petit sinon
    private String textFixChoiceBox = "                               ";

    HashMap<String, ModeDePaiement> modesPaiementMap;

    private void HandleBoutonClickAjouter(ActionEvent event)
    {
        Facture factureAEntrer = new Facture();
        if((nomAcheteur.getText() != "") && ChaineValide(totalSansTaxe.getText()) && ChaineValide(taxesApplicables.getText()) && ChaineValide(totalAvecTaxes.getText()))
        {
            textErreur.setVisible(false);
            Facture facture = new Facture();

            String stringAvantFix = modePaiement.getValue().toString();
            stringAvantFix = stringAvantFix.replace(" " ,"");

            facture.setNomDeLAcheteur(nomAcheteur.getText());
            facture.setTotalSansTaxes(Double.parseDouble(totalSansTaxe.getText()));
            facture.setTaxesApplicables(Double.parseDouble(taxesApplicables.getText()));
            facture.setTotalAvecTaxes(Double.parseDouble(totalAvecTaxes.getText()));
            facture.setModeDePaiement(modesPaiementMap.get(stringAvantFix));

            comptable.AjouterFactureATotalDon(facture);
            totalDons.setText(comptable.getTotalDesDons() + "$");
        }
        else
        {
            textErreur.setVisible(true);
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
        return 0;
    }

    public ApplicationGraphicalController()
    {

    }
    @FXML
    public void initialize()
    {
        comptable = new Comptable();

        ajouter.setOnAction(this::HandleBoutonClickAjouter);

        comptable.CreerModesPaiements();
        modesPaiementMap = comptable.getModePaiements();
        modesPaiementString = new ArrayList<String>();
        modesPaiementString.addAll(modesPaiementMap.keySet());

        for(int i = 0; i < modesPaiementString.size(); i++)
        {
            modePaiement.getItems().add(modesPaiementString.get(i) + textFixChoiceBox);
        }
    }
}
