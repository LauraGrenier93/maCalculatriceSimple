package maCalculatriceSimple;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

public class MaCalculatriceSimple {
	  JPanel contenuFen�tre = new JPanel();
	  JPanel panneauChiffres = new JPanel();
	  JPanel panneauOperations = new JPanel();
	  JFormattedTextField champAffichage = new JFormattedTextField();
	  JButton[] boutonsChiffres = new JButton[10];
	  JButton boutonPlus = new JButton("+");
	  JButton boutonMoins = new JButton("-");
	  JButton boutonMultiplier = new JButton("*");
	  JButton boutonDiviser = new JButton("/");
	  JButton boutonVirgule = new JButton(",");
	  JButton boutonEgale = new JButton("=");

	  MaCalculatriceSimple() {
		 
		  BorderLayout disposition1 = new BorderLayout();
		  contenuFen�tre.setLayout(disposition1);
		  
		  champAffichage.setHorizontalAlignment(JFormattedTextField.RIGHT);
		  contenuFen�tre.add("North", champAffichage);
	  
		 for (int numeroBouton = 0; numeroBouton < 10; numeroBouton++){
	            boutonsChiffres[numeroBouton] = new JButton(Integer.toString(numeroBouton));
	        }

		  GridLayout disposition2 = new GridLayout(4, 3); 
		  panneauChiffres.setLayout(disposition2);

	      for (int numeroBouton = 1; numeroBouton < 10; numeroBouton++){
	            panneauChiffres.add(boutonsChiffres[numeroBouton]);
	        }
	      panneauChiffres.add(boutonsChiffres[0]);
		  panneauChiffres.add(boutonVirgule);
		  panneauChiffres.add(boutonEgale);
		  contenuFen�tre.add("Center", panneauChiffres);
	  
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
		  
		  MoteurCalcul moteurCalcul = new MoteurCalcul(this);
		  
		  for(JButton chiffre: boutonsChiffres) {
			  chiffre.addActionListener(moteurCalcul);
		  }
		  
		  boutonPlus.addActionListener(moteurCalcul);
		  boutonMoins.addActionListener(moteurCalcul);
		  boutonMultiplier.addActionListener(moteurCalcul);
		  boutonDiviser.addActionListener(moteurCalcul);
		  boutonVirgule.addActionListener(moteurCalcul);
		  boutonEgale.addActionListener(moteurCalcul);
	  }
	  
	  public static void main(String[] args) {
		  new MaCalculatriceSimple();
	  }
}