package maCalculatriceSimple;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MoteurCalcul implements ActionListener {
    
  MaCalculatriceSimple parent; 
  char actionSélectionnée = ' '; 
    
  double résultatCourant = 0;
  double ancienneValeur;

  NumberFormat formatNombres = NumberFormat.getInstance(); 

  MoteurCalcul(MaCalculatriceSimple parent) {
    this.parent = parent;
  }
 
  public void actionPerformed(ActionEvent événement) {
       
    JButton boutonCliqué = (JButton) événement.getSource();
    String texteChampAffichage = parent.champAffichage.getText();

    double valeurAffichée = 0;

    if (!"".equals(texteChampAffichage)) {
      valeurAffichée = formatNombres.parse(texteChampAffichage, new ParsePosition(0)).doubleValue();
    }
    Object sourceEvénement = événement.getSource();

    if (sourceEvénement == parent.boutonPlus) {
        actionSélectionnée = '+';
        résultatCourant = valeurAffichée;
        parent.champAffichage.setText("");
    } 
    else if (sourceEvénement == parent.boutonMoins) {
	    actionSélectionnée = '-';
	    résultatCourant = valeurAffichée;
	    parent.champAffichage.setText("");
    } 
    else if (sourceEvénement == parent.boutonDiviser) {
	    actionSélectionnée = '/';
	    résultatCourant = valeurAffichée; 
	    parent.champAffichage.setText("");
    } 
    else if (sourceEvénement == parent.boutonMultiplier) {
		actionSélectionnée = '*'; 
		résultatCourant = valeurAffichée;
		parent.champAffichage.setText("");
    }
    else if (sourceEvénement == parent.boutonEgale) {
      if (actionSélectionnée == '+') {
       résultatCourant += valeurAffichée;
      } 
      else if (actionSélectionnée == '-') { 
      résultatCourant -= valeurAffichée;
      } 
      else if (actionSélectionnée == '/') {
    	double ancienneValeur = résultatCourant;
        résultatCourant /= valeurAffichée;;
        if(String.valueOf(résultatCourant) == "Infinity") {
        	JOptionPane.showConfirmDialog(null,
                    "Impossible de diviser par zéro, votre ancien résultat est de " + ancienneValeur,
                    "Pour information",
                    JOptionPane.PLAIN_MESSAGE);
        	 résultatCourant = ancienneValeur;
        }
      } 
      else if (actionSélectionnée == '*') {
      résultatCourant *= valeurAffichée;
      }
      parent.champAffichage.setText(formatNombres.format(résultatCourant));
    } 
	else {           
	  String libelléBoutonCliqué = boutonCliqué.getText();
	  if(libelléBoutonCliqué == "," && texteChampAffichage.indexOf(",")== 1) {
			JOptionPane.showConfirmDialog(null,
                    "Impossible d'avoir un chiffre avec plus d'une virgule, votre ancien résultat est de " + texteChampAffichage,
                    "Pour information",
                    JOptionPane.PLAIN_MESSAGE);
			parent.champAffichage.setText(texteChampAffichage);
	  } else if (libelléBoutonCliqué == "c"){
			  résultatCourant = 0;
			  parent.champAffichage.setText("");
	  }else {
		  parent.champAffichage.setText(texteChampAffichage + libelléBoutonCliqué);
	  }
    }
  }
}