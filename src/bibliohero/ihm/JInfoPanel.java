package bibliohero.ihm;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JInfoPanel extends JPanel
{
	private JTabbedPane onglets;
	
	public JInfoPanel()
	{
		super();
		setLayout(new BorderLayout());
		onglets = new JTabbedPane(JTabbedPane.BOTTOM);
		this.add(onglets, BorderLayout.CENTER);
	}
}
