package fr.eni.ihm;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestionListeFrame extends JFrame {
	
	private JPanel panneauPrincipal;
	private JLabel label;
	private JTextField textField;
	private List liste;
	private JButton bAjout;
	private JButton bVider;
	
	public GestionListeFrame() {
		super("Gestion de String ");
	
		gestionComposants();//On initialise les différents paramètres
		
		this.setSize(800,200);//Autre maniere de faire une fenêtre rectangulaire en interface graphique
		this.setLocationRelativeTo(null);//position la fenêtre dans l'écran mettre null la positionne au centre
		this.setResizable(false);//Interdire le redimensionnement de la fenêtre par l'utilisateur
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//On supprime l'instance de la fenêtre 	
	}
	
	private void gestionComposants() {
		//Création des différents éléments dont le panneau dans lequel tout les autres éléments seront intégré
		panneauPrincipal = new JPanel();	
		
		label = new JLabel("Texte à ajouter : ");
		textField = new JTextField(10);//Champ de saisie avec longueur de 10
		liste = new List(5);
		bAjout = new JButton("Ajouter");
		bVider = new JButton("Vider");
		this.getContentPane().add(panneauPrincipal);//Renvoyer le panneau courant pour ensuite rajouter dessus le panneau créé
		
		//ajout des différents éléments au panneau
		panneauPrincipal.add(label);
		panneauPrincipal.add(textField);
		panneauPrincipal.add(bAjout);
		panneauPrincipal.add(liste);
		panneauPrincipal.add(bVider);
		
		bAjout.addActionListener(new BoutonAjouterActionListener());//détecte un clique sur le bouton 
		bVider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				liste.removeAll();//On vide entièrement la liste
			}
			
		});
	}
	
	class BoutonAjouterActionListener implements ActionListener{//Permet de définir les action à effectueur en fonction de l'action sur le bouton

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String chaine= textField.getText();//récupérer le contenu du champ de saisie lorsque l'on appuie sur le bouton ajouter
			if(chaine.trim().length() > 0) {//on vérifie qu'il y a au moins un caractère hors espace
				liste.add(chaine);//on ajoute la saisie récupérer à la liste
								  //La liste étant affichée sur le côté
			}
			textField.setText("");//On met un texte vide à la place de la saise dans le champs de saisie une fois que le texte est ajouté dans la liste
			System.out.println("Bouton ajouter clique");
		}
		
	}


}
