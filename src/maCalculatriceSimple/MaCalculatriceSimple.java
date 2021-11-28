package maCalculatriceSimple;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

public class MaCalculatriceSimple {
	  JPanel contenuFenêtre = new JPanel();
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
	  JButton boutonReset = new JButton("c");

	  MaCalculatriceSimple() {
		 
		  BorderLayout disposition1 = new BorderLayout();
		  contenuFenêtre.setLayout(disposition1);
		  
		  champAffichage.setHorizontalAlignment(JFormattedTextField.RIGHT);
		  contenuFenêtre.add("North", champAffichage);
	  
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
		  contenuFenêtre.add("Center", panneauChiffres);
	  
		  GridLayout disposition3 = new GridLayout(5,1);
		  panneauOperations.setLayout(disposition3);
		  
		  panneauOperations.add(boutonReset);
		  panneauOperations.add(boutonPlus);
		  panneauOperations.add(boutonMoins);
		  panneauOperations.add(boutonMultiplier);
		  panneauOperations.add(boutonDiviser);
		  contenuFenêtre.add(panneauOperations, BorderLayout.EAST);
	  
		  JFrame frame = new JFrame("Calculatrice");
		  
		  frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		  
		  frame.setContentPane(contenuFenêtre);
		  
		  frame.pack();
		  
		  frame.setVisible(true);
		  
		  MoteurCalcul moteurCalcul = new MoteurCalcul(this);
		  
		  for(JButton chiffre: boutonsChiffres) {
			  chiffre.addActionListener(moteurCalcul);
		  }
		  boutonReset.addActionListener(moteurCalcul);
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