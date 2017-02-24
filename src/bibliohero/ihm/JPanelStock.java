package bibliohero.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

//Panel d'inventaire et de grimoire
public class JPanelStock extends JPanel 
{
	private int panelType;
	private JComboBox selection;
	private JList listeObjet;
	private JPanelSouthStock panelSudGestion;
	private JPopupMenu popUpMenu;
	
	public JPanelStock(String type) throws Exception
	{
		super();
		if (type == "Stock")
			this.panelType = 0;
		else if (type == "Sorts")
			this.panelType = 1;
		else throw new Exception();
		init();
	}
	/**
	 * @wbp.parser.constructor
	 */
	public JPanelStock(int type) throws Exception
	{
		super();
		this.panelType = type;
		init();
	}
	
	public void reload()
	{
		if (panelType == 0)
		{
			selection.setModel(new DefaultComboBoxModel(new String[] {"Sac à dos", "Equipé", "Coffre"}));
		}
		if (panelType == 1)
			selection.setModel(new DefaultComboBoxModel(new String[] {"Illusion", "Invocation", "Destruction"}));
	}
	
	private void popUpMenuInit()
	{
		if (panelType == 0)
		{
			popUpMenu = new JPopupMenu();
			
			JMenuItem popUpMenuUse = new JMenuItem("Utiliser /Équiper");
			popUpMenu.add(popUpMenuUse);
			
			JMenu popUpMenuGive = new JMenu("Donner à");
			popUpMenu.add(popUpMenuGive);
			
			JMenuItem popUpMenuPersonnage1 = new JMenuItem("personnage 1");
			popUpMenuGive.add(popUpMenuPersonnage1);
			
			JMenuItem popUpMenuDesc = new JMenuItem("Description");
			popUpMenu.add(popUpMenuDesc);
			
			JSeparator separatorActionJeter = new JSeparator();
			popUpMenu.add(separatorActionJeter);
			
			JMenuItem popUpMenuJeter = new JMenuItem("Jeter");
			popUpMenu.add(popUpMenuJeter);
		}
		if (panelType == 1)
		{
			popUpMenu = new JPopupMenu();
			JMenuItem popUpMenuLancerSort = new JMenuItem("Lancer");
			popUpMenu.add(popUpMenuLancerSort);
			
		} 
	}
	
	public void loadliste()
	{
		if (panelType == 0)
		{
			Object[] value = {"Repas","Repas","Gourde","Épée du chaos"};
			listeObjet.setListData(value);
		}
		if (panelType == 1)
		{
			Object[] value = {"Déguisement","Brouillard","Flash"};
			listeObjet.setListData(value);
		}
	}
	
	public void init()
	{
		this.setLayout(new BorderLayout());
		selection = new JComboBox();
		reload();
		this.add(selection, BorderLayout.NORTH);
		listeObjet = new JList();
		listeObjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadliste();
		this.add(listeObjet, BorderLayout.CENTER);
		
		popUpMenuInit();
		addPopup(listeObjet, popUpMenu);
		panelSudGestion = new JPanelSouthStock(this.panelType);
		this.add(panelSudGestion, BorderLayout.SOUTH);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
