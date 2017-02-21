package bibliohero.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class JPanelEvent extends JPanel
{
	private JPanel zoneChoixEvent;
	private JPanel contexte;
	private JComboBox<String> contextuel;
	private JButton validContext;
	
	//Constructeur vide, utilisation interdite hors du lancement d'origine
	public JPanelEvent()
	{
		super();
		setLayout(new BorderLayout());
		zoneChoixEvent = new JPanel();
		zoneChoixEvent.setLayout(new GridLayout(0, 4, 0, 0));
		contexte = new JPanel();
		contexte.setLayout(new BorderLayout());
		init();
		Box VerticalBox = Box.createVerticalBox();
		VerticalBox.add(Box.createVerticalStrut(3));
		VerticalBox.add(zoneChoixEvent);
		VerticalBox.add(Box.createVerticalStrut(3));
		VerticalBox.add(contexte);
		//this.add(zoneChoixEvent, BorderLayout.CENTER);
		//this.add(contexte, BorderLayout.SOUTH);
		this.add(VerticalBox, BorderLayout.SOUTH);
	}
	
	//Initialiseur vide, utilisation interdite hors du lancement d'origine
	private void init()
	{
		for (int i = 0; i < 8; i++)
		{
			zoneChoixEvent.add(new JEventButton("Evenement "+ i));
		}
		contextuel= new JComboBox<String>();
		validContext = new JButton("Valider");
		contexte.add(contextuel, BorderLayout.CENTER);
		contexte.add(validContext, BorderLayout.EAST);
	}
	
	public void initEventX(int numButton, String textAffichable){initEventX(numButton, textAffichable, false);}
	public void initEventX(int numButton, String textAffichable, boolean enabled)
	{
		((JEventButton)zoneChoixEvent.getComponent(numButton)).reInit(textAffichable, enabled);
	}
}
