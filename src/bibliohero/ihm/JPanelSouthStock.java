package bibliohero.ihm;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelSouthStock extends JPanel
{
	private int type;
	private JLabel lblRichesse;
	private JButton utilisation;
	private JButton description;

	public JPanelSouthStock(int type)
	{
		super();
		this.type = type;
		init();
	}
	
	private void init()
	{
		this.setLayout(new BorderLayout());
		if (type == 0)
		{
			lblRichesse = new JLabel("Richesse : 0 pièces d'or");
			this.add(lblRichesse, BorderLayout.SOUTH);
			lblRichesse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblRichesse.setHorizontalAlignment(SwingConstants.CENTER);
			utilisation = new JButton("Utiliser / équiper");
			this.add(utilisation);
			description = new JButton("observer l'objet");
			this.add(description, BorderLayout.NORTH);
		}
		else
		{
			utilisation = new JButton("Lancer le sort");
			this.add(utilisation, BorderLayout.SOUTH);
		}
	}
}
