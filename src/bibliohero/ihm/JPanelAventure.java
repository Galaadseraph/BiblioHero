package bibliohero.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class JPanelAventure extends JPanel
{
	private String sautLigne;
	private JLabel labelTitre;
	private JTextPane view;
	private JPanelEvent evenements;
	
	public JPanelAventure()
	{
		sautLigne = System.getProperty("line.separator");
		setLayout(new BorderLayout());
		labelTitre = new JLabel();
		labelTitre.setText("Titre de l'aventure");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		evenements = new JPanelEvent();
		view = new JTextPane();
		view.setFont(new Font("Tahoma", Font.PLAIN, 14));
		view.setForeground(Color.WHITE);
		view.setBackground(Color.LIGHT_GRAY);
		view.setRequestFocusEnabled(false);
		view.setDisabledTextColor(Color.WHITE);
		view.setEnabled(false);
		view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		view.setText("L'aventure de votre personnage commence ici, au fil des paragraphes, vous  pourrez développer ses caractéristiques."
				+ sautLigne + "Voici les choix possibles de classe, ne vous inquiétez pas encore, il vous est possible de creer une équipe de personnages au fil du temps. "
						+ "Vous pouvez choisir parmi les classes de guerrier, mages, prètres, voleurs et bien d'autres. "
						+ sautLigne + "Ce text n'est qu'une ébauche afin de présenter une interface plutôt contractuelle de la future version PC du jeu BiblioHero.");
		this.add(labelTitre, BorderLayout.NORTH);
		this.add(view, BorderLayout.CENTER);
		this.add(evenements, BorderLayout.SOUTH);
	}
}
