package maCalculatriceSimple;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class maCalculatriceSimple {
	  JPanel contenuFenêtre;
	  JTextField champAffichage;	  
	  JButton[] boutonsChiffres = new JButton[10];
	  JButton boutonVirgule;
	  JButton boutonPlus;
	  JButton boutonMoins;
	  JButton boutonMultiplier;
	  JButton boutonDiviser;
	  JButton boutonEgale;
	  JPanel panneauChiffres;
	  JPanel panneauOperations;
	  
	  maCalculatriceSimple() {
		 
		 contenuFenêtre = new JPanel();
		  BorderLayout disposition1 = new BorderLayout();
		  contenuFenêtre.setLayout(disposition1);
		  
		  JFormattedTextField champAffichage = new JFormattedTextField();
		  champAffichage.setHorizontalAlignment(JFormattedTextField.RIGHT);
		  contenuFenêtre.add("North", champAffichage);
	  
		 for (int numeroBouton = 0; numeroBouton < 10; numeroBouton++){
	            boutonsChiffres[numeroBouton] = new JButton(Integer.toString(numeroBouton));
	        }
		  boutonPlus = new JButton("+");
		  boutonMoins = new JButton("-");
		  boutonMultiplier = new JButton("*");
		  boutonDiviser = new JButton("/");
		  boutonVirgule = new JButton(",");
		  boutonEgale = new JButton("=");
		  
		  panneauChiffres = new JPanel();
		  GridLayout disposition2 = new GridLayout(4, 3); 
		  panneauChiffres.setLayout(disposition2);

	      for (int numeroBouton = 1; numeroBouton < 10; numeroBouton++){
	            panneauChiffres.add(boutonsChiffres[numeroBouton]);
	        }
	      panneauChiffres.add(boutonsChiffres[0]);
		  panneauChiffres.add(boutonVirgule);
		  panneauChiffres.add(boutonEgale);
		  contenuFenêtre.add("Center", panneauChiffres);
	  
		  panneauOperations = new JPanel();
		  GridLayout disposition3 = new GridLayout(4,1);
		  panneauOperations.setLayout(disposition3);
        
		  panneauOperations.add(boutonPlus);
		  panneauOperations.add(boutonMoins);
		  panneauOperations.add(boutonMultiplier);
		  panneauOperations.add(boutonDiviser);
		  contenuFenêtre.add(panneauOperations, BorderLayout.EAST);
	  
		  JFrame frame = new JFrame("Calculatrice");
		  frame.setContentPane(contenuFenêtre);
		  
		  frame.pack();
		  
		  frame.setVisible(true);
	  }
	  
	  public static void main(String[] args) {
		  maCalculatriceSimple calc = new maCalculatriceSimple();
	  }
}
