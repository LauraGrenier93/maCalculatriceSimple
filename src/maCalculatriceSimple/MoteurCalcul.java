package maCalculatriceSimple;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;

import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MoteurCalcul implements ActionListener {
    
  MaCalculatriceSimple parent; 
  char actionS�lectionn�e = ' '; 
    
  double r�sultatCourant = 0;
  double ancienneValeur;

  NumberFormat formatNombres = NumberFormat.getInstance(); 

  MoteurCalcul(MaCalculatriceSimple parent) {
    this.parent = parent;
  }
 
  public void actionPerformed(ActionEvent �v�nement) {
       
    JButton boutonCliqu� = (JButton) �v�nement.getSource();
    String texteChampAffichage = parent.champAffichage.getText();

    double valeurAffich�e = 0;

    if (!"".equals(texteChampAffichage)) {
      valeurAffich�e = formatNombres.parse(texteChampAffichage, new ParsePosition(0)).doubleValue();
    }
    Object sourceEv�nement = �v�nement.getSource();

    if (sourceEv�nement == parent.boutonPlus) {
        actionS�lectionn�e = '+';
        r�sultatCourant = valeurAffich�e;
        parent.champAffichage.setText("");
    } 
    else if (sourceEv�nement == parent.boutonMoins) {
	    actionS�lectionn�e = '-';
	    r�sultatCourant = valeurAffich�e;
	    parent.champAffichage.setText("");
    } 
    else if (sourceEv�nement == parent.boutonDiviser) {
	    actionS�lectionn�e = '/';
	    r�sultatCourant = valeurAffich�e; 
	    parent.champAffichage.setText("");
    } 
    else if (sourceEv�nement == parent.boutonMultiplier) {
		actionS�lectionn�e = '*'; 
		r�sultatCourant = valeurAffich�e;
		parent.champAffichage.setText("");
    }
    else if (sourceEv�nement == parent.boutonEgale) {
      if (actionS�lectionn�e == '+') {
       r�sultatCourant += valeurAffich�e;
      } 
      else if (actionS�lectionn�e == '-') { 
      r�sultatCourant -= valeurAffich�e;
      } 
      else if (actionS�lectionn�e == '/') {
    	double ancienneValeur = r�sultatCourant;
        r�sultatCourant /= valeurAffich�e;;
        if(String.valueOf(r�sultatCourant) == "Infinity") {
        	JOptionPane.showConfirmDialog(null,
                    "Impossible de diviser par z�ro, votre ancien r�sultat est de " + ancienneValeur,
                    "Pour information",
                    JOptionPane.PLAIN_MESSAGE);
        	 r�sultatCourant = ancienneValeur;
        }
      } 
      else if (actionS�lectionn�e == '*') {
      r�sultatCourant *= valeurAffich�e;
      }
      parent.champAffichage.setText(formatNombres.format(r�sultatCourant));
    } 
	else {           
	  String libell�BoutonCliqu� = boutonCliqu�.getText();
	  if(libell�BoutonCliqu� == "," && texteChampAffichage.indexOf(",")== 1) {
			JOptionPane.showConfirmDialog(null,
                    "Impossible d'avoir un chiffre avec plus d'une virgule, votre ancien r�sultat est de " + texteChampAffichage,
                    "Pour information",
                    JOptionPane.PLAIN_MESSAGE);
			parent.champAffichage.setText(texteChampAffichage);
	  } else if (libell�BoutonCliqu� == "c"){
			  r�sultatCourant = 0;
			  parent.champAffichage.setText("");
	  }else {
		  parent.champAffichage.setText(texteChampAffichage + libell�BoutonCliqu�);
	  }
    }
  }
}