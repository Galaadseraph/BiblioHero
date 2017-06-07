package bibliohero.ihm.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class JPanelEquipe extends JPanel
{
	private JLabel nomEquipe;
	private JTable tablePerso;
	
	public JPanelEquipe()
	{
		this.setLayout(new BorderLayout());
		
		nomEquipe = new JLabel("Nom de l'équipe actuelle");
		nomEquipe.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nomEquipe.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(nomEquipe, BorderLayout.NORTH);
		tablePerso = new JTable();
		tablePerso.setFillsViewportHeight(true);
		tablePerso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablePerso.setShowVerticalLines(false);
		init();
		this.add(tablePerso, BorderLayout.CENTER);
	}
	
	private void init()
	{
		tablePerso.setModel(new DefaultTableModel(
				new Object[][] {
					{"Nom", "Race", "Classe", "Niveau"},
					{"Personnage 1", "Humain", "Guerrier", "1"},
					{"Personnage 2", "Elfe", "Magicien", "1"},
				},
				new String[] {"Nom", "Race", "Classe", "Niveau"}
			) {
				Class[] columnTypes = new Class[] 
				{
					String.class, Object.class, Object.class, Object.class
				};
				@Override
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tablePerso.getColumnModel().getColumn(2).setPreferredWidth(64);
			tablePerso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePerso.setValueAt("Nom", 0, 0);
			tablePerso.setValueAt("Race", 0, 1);
			tablePerso.setValueAt("Classe", 0, 2);
			tablePerso.setValueAt("Personnage 1", 1, 0);
			tablePerso.setValueAt("Humain", 1, 1);
			tablePerso.setValueAt("Guerrier", 1, 2);
	}

}
