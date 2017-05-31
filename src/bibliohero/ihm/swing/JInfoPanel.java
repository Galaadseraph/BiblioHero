package bibliohero.ihm.swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JInfoPanel extends JPanel
{
	private JTabbedPane onglets;
	private JPanelStock ongletSorts;
	private JPanelStock ongletInventaire;
	private JPanelPersonnage ongletPersonnage;
	private JPanelEquipe ongletEquipe;
	private JPanel ongletSettings;
	
	public JInfoPanel()
	{
		super();
		setLayout(new BorderLayout());
		onglets = new JTabbedPane(JTabbedPane.BOTTOM);
		this.add(onglets, BorderLayout.CENTER);
		this.ongletEquipe = new JPanelEquipe();
		try
		{
			this.ongletPersonnage = new JPanelPersonnage();
			this.ongletInventaire = new JPanelStock(0);
			this.ongletSorts = new JPanelStock(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		this.ongletSettings = new JPanel();
		this.onglets.add(ongletEquipe);
		this.onglets.add(ongletPersonnage);
		this.onglets.add(ongletInventaire);
		this.onglets.add(ongletSorts);
		this.onglets.add(ongletSettings);
		this.onglets.addTab("Equipe", null, ongletEquipe);
		this.onglets.addTab("Personnage", null, ongletPersonnage);
		this.onglets.addTab("Inventaire", null, ongletInventaire);
		this.onglets.addTab("Grimoire", null, ongletSorts);
		this.onglets.addTab("Paramètre", null, ongletSettings);
	}
}
