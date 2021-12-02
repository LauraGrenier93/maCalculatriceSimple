package maCalculatriceSimple;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MoteurCalcul implements ActionListener {
    
  MaCalculatriceSimple parent; 
  char actionSelectionnee = ' '; 
    
  double resultatCourant = 0;
  double ancienneValeur;

  NumberFormat formatNombres = NumberFormat.getInstance(); 

  MoteurCalcul(MaCalculatriceSimple parent) {
    this.parent = parent;
  }
 
  public void actionPerformed(ActionEvent evenement) {
       
    JButton boutonClique = (JButton) evenement.getSource();
    String texteChampAffichage = parent.champAffichage.getText();

    double valeurAffichee = 0;

    if (!"".equals(texteChampAffichage)) {
      valeurAffichee = formatNombres.parse(texteChampAffichage, new ParsePosition(0)).doubleValue();
    }
    Object sourceEvenement = evenement.getSource();

    if (sourceEvenement == parent.boutonPlus) {
        actionSelectionnee = '+';
        resultatCourant = valeurAffichee;
        parent.champAffichage.setText("");
    } 
    else if (sourceEvenement == parent.boutonMoins) {
	    actionSelectionnee = '-';
	    resultatCourant = valeurAffichee;
	    parent.champAffichage.setText("");
    } 
    else if (sourceEvenement == parent.boutonDiviser) {
	    actionSelectionnee = '/';
	    resultatCourant = valeurAffichee; 
	    parent.champAffichage.setText("");
    } 
    else if (sourceEvenement == parent.boutonMultiplier) {
		actionSelectionnee = '*'; 
		resultatCourant = valeurAffichee;
		parent.champAffichage.setText("");
    }
    else if (sourceEvenement == parent.boutonEgale) {
      if (actionSelectionnee == '+') {
       resultatCourant += valeurAffichee;
      } 
      else if (actionSelectionnee == '-') { 
      resultatCourant -= valeurAffichee;
      } 
      else if (actionSelectionnee == '/') {
    	double ancienneValeur = resultatCourant;
        resultatCourant /= valeurAffichee;;
        if(String.valueOf(resultatCourant) == "Infinity") {
        	JOptionPane.showConfirmDialog(null,
                    "Impossible de diviser par z�ro, votre ancien r�sultat est de " + ancienneValeur,
                    "Pour information",
                    JOptionPane.PLAIN_MESSAGE);
        	 resultatCourant = ancienneValeur;
        }
      } 
      else if (actionSelectionnee == '*') {
      resultatCourant *= valeurAffichee;
      }
      parent.champAffichage.setText(formatNombres.format(resultatCourant));
    } 
	else {           
	  String libelleBoutonClique = boutonClique.getText();
	  if(libelleBoutonClique == "," && texteChampAffichage.indexOf(",")== 1) {
			JOptionPane.showConfirmDialog(null,
                    "Impossible d'avoir un chiffre avec plus d'une virgule, votre ancien r�sultat est de " + texteChampAffichage,
                    "Pour information",
                    JOptionPane.PLAIN_MESSAGE);
			parent.champAffichage.setText(texteChampAffichage);
	  } else if (libelleBoutonClique == "c"){
			  resultatCourant = 0;
			  parent.champAffichage.setText("");
	  }else {
		  parent.champAffichage.setText(texteChampAffichage + libelleBoutonClique);
	  }
    }
  }
}