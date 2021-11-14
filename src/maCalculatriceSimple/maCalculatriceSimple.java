package maCalculatriceSimple;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class maCalculatriceSimple {
	  JPanel contenuFen�tre;
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
		 
		 contenuFen�tre = new JPanel();
		  BorderLayout disposition1 = new BorderLayout();
		  contenuFen�tre.setLayout(disposition1);
		  
		  JFormattedTextField champAffichage = new JFormattedTextField();
		  champAffichage.setHorizontalAlignment(JFormattedTextField.RIGHT);
		  contenuFen�tre.add("North", champAffichage);
	  
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
		  contenuFen�tre.add("Center", panneauChiffres);
	  
		  panneauOperations = new JPanel();
		  GridLayout disposition3 = new GridLayout(4,1);
		  panneauOperations.setLayout(disposition3);
        
		  panneauOperations.add(boutonPlus);
		  panneauOperations.add(boutonMoins);
		  panneauOperations.add(boutonMultiplier);
		  panneauOperations.add(boutonDiviser);
		  contenuFen�tre.add(panneauOperations, BorderLayout.EAST);
	  
		  JFrame frame = new JFrame("Calculatrice");
		  frame.setContentPane(contenuFen�tre);
		  
		  frame.pack();
		  
		  frame.setVisible(true);
	  }
	  
	  public static void main(String[] args) {
		  maCalculatriceSimple calc = new maCalculatriceSimple();
	  }
}
