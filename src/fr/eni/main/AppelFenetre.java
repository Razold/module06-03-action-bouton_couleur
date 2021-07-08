package fr.eni.main;

import javax.swing.SwingUtilities;

import fr.eni.ihm.GestionListeFrame;

public class AppelFenetre {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GestionListeFrame mpf= new GestionListeFrame();
				mpf.setVisible(true);//nécessaire pour que l'interface graphique soit visible!!!
			}
		
		});
	}

}
