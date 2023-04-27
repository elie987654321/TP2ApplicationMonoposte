package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

import javax.swing.*;
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

    //sert aussi de bouton annuler
    @FXML
    private Button valider;

    private boolean infosValidees;

    private Comptable comptable;

    ArrayList<String> modesPaiementString;

    //La longuer de la boite quand on clique sur la choice box s'adapte au text a l'interieur.
    // On ajoute du text pour avoir la bonne taille, trop petit sinon
    private String textFixChoiceBox = "                               ";

    HashMap<String, ModeDePaiement> modesPaiementMap;

    private void HandleButtonClickValider(ActionEvent event)
    {
        if(infosValidees == false)
        {
            if((nomAcheteur.getText() != "") && ChaineValide(totalSansTaxe.getText()) && ChaineValide(taxesApplicables.getText()) && (! modePaiement.getSelectionModel().isEmpty()))
            {
                setInputEditable(false);
                infosValidees = true;
                valider.setText("annuler");
                ajouter.setDisable(false);
                totalAvecTaxes.setText(Double.toString (Double.parseDouble(totalSansTaxe.getText().replace(",", ".")) + Double.parseDouble(taxesApplicables.getText().replace(",", "."))));
            }
            else
            {
                textErreur.setText("Veuillez entrer des informations valides");
                textErreur.setVisible(true);
            }
        }
        else
        {
            infosValidees = false;
            ajouter.setDisable(true);
            totalAvecTaxes.setText("Inconnus");
            valider.setText("Valider");
            setInputEditable(true);
        }
    }



    private void HandleBoutonClickAjouter(ActionEvent event)
    {

        Facture factureAEntrer = new Facture();
        if((nomAcheteur.getText() != "") && ChaineValide(totalSansTaxe.getText()) && ChaineValide(taxesApplicables.getText()) && (! modePaiement.getSelectionModel().isEmpty()))
        {
            textErreur.setVisible(false);
            Facture facture = new Facture();

            String stringAvantFix = modePaiement.getValue().toString();
            stringAvantFix = stringAvantFix.replace(" " ,"");

            facture.setNomDeLAcheteur(nomAcheteur.getText());
            facture.setTotalSansTaxes(Double.parseDouble(totalSansTaxe.getText().replace(",", ".")));
            facture.setTaxesApplicables(Double.parseDouble(taxesApplicables.getText().replace(",", ".")));
            facture.setTotalAvecTaxes(Double.parseDouble(totalAvecTaxes.getText().replace(",", ".")));
            facture.setModeDePaiement(modesPaiementMap.get(stringAvantFix));

            comptable.AjouterFactureATotalDon(facture);
            totalDons.setText(comptable.getTotalDesDons() + "$");
            valider.setText("Valider");
            ajouter.setDisable(true);
            infosValidees = false;
            resetAllValues();
            setInputEditable(true);
        }
        else
        {
            textErreur.setVisible(true);
        }
  }

  public void setInputEditable(boolean value)
  {
      nomAcheteur.setEditable(value);
      totalSansTaxe.setEditable(value);
      taxesApplicables.setEditable(value);
  }

  public void resetAllValues()
  {
      nomAcheteur.setText("");
      totalSansTaxe.setText("");
      taxesApplicables.setText("");
      totalAvecTaxes.setText("Inconnus");
      modePaiement.setValue(null);
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
                        characteres[i] == '9'  ||
                        characteres[i] == ','
                    )
            )
            {
                charInvalide = true;
            }
          i++;
      }

      char virgule = ',';
      int count = 0;

      for (int j = 0; j < chaine.length(); j++) {
          if (chaine.charAt(j) == virgule) {
              count++;
          }
      }

      if(count > 1 || charInvalide == true)
      {
          return false;
      }
      else
      {
          return true;
      }
  }

    public ApplicationGraphicalController()
    {

    }
    @FXML
    public void initialize()
    {
        comptable = new Comptable();

        ajouter.setOnAction(this::HandleBoutonClickAjouter);
        valider.setOnAction(this::HandleButtonClickValider);

        comptable.CreerModesPaiements();
        modesPaiementMap = comptable.getModePaiements();
        modesPaiementString = new ArrayList<String>();
        modesPaiementString.addAll(modesPaiementMap.keySet());

        for(int i = 0; i < modesPaiementString.size(); i++)
        {
            modePaiement.getItems().add(modesPaiementString.get(i) + textFixChoiceBox);
        }

        ajouter.setDisable(true);
        totalAvecTaxes.setEditable(false);
        totalAvecTaxes.setText("Inconnus");
    }
}
