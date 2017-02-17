package bibliohero.IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainFrame extends JFrame {

	private JPanel contenuPrincipal;
	private JTable equipeTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("BiblioHero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 378);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contenuPrincipal = new JPanel();
		contenuPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenuPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(contenuPrincipal);
		
		JPanel contenuInformatif = new JPanel();
		contenuPrincipal.add(contenuInformatif, BorderLayout.WEST);
		
		JTabbedPane onglets = new JTabbedPane(JTabbedPane.BOTTOM);
		onglets.setMinimumSize(new Dimension(500, 500));
		
		JPanel ongletEquipe = new JPanel();
		onglets.addTab("Equipe", null, ongletEquipe, null);
		ongletEquipe.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Nom de l'équipe actuelle");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ongletEquipe.add(lblNewLabel, BorderLayout.NORTH);
		
		//DefaultTableModel model = new DefaultTableModel();
		//model.setColumnIdentifiers(entetes);
		equipeTable = new JTable();
		equipeTable.setFillsViewportHeight(true);
		equipeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		equipeTable.setShowVerticalLines(false);
		equipeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nom", "Race", "Classe", "Niveau"},
				{"Personnage 1", "Humain", "Guerrier", "1"},
				{"Personnage 2", "Elfe", "Magicien", "1"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nom", "Race", "Classe", "Niveau"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class
			};
			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		equipeTable.getColumnModel().getColumn(2).setPreferredWidth(64);
		equipeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		equipeTable.setValueAt("Nom", 0, 0);
		equipeTable.setValueAt("Race", 0, 1);
		equipeTable.setValueAt("Classe", 0, 2);
		equipeTable.setValueAt("Personnage 1", 1, 0);
		equipeTable.setValueAt("Humain", 1, 1);
		equipeTable.setValueAt("Guerrier", 1, 2);
		
		ongletEquipe.add(equipeTable, BorderLayout.CENTER);
		contenuInformatif.setLayout(new BorderLayout(0, 0));
		contenuInformatif.add(onglets);
		
				
				JPanel ongletPersonnage = new JPanel();
				onglets.addTab("Personnage", null, ongletPersonnage, null);
				GridBagLayout gbl_ongletPersonnage = new GridBagLayout();
				gbl_ongletPersonnage.columnWidths = new int[] {138, 102};
				gbl_ongletPersonnage.rowHeights = new int[]{16, 16, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_ongletPersonnage.columnWeights = new double[]{0.0, 0.0};
				gbl_ongletPersonnage.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				ongletPersonnage.setLayout(gbl_ongletPersonnage);
				
				JLabel nomPersonnage = new JLabel("nom du personnage");
				nomPersonnage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				nomPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_nomPersonnage = new GridBagConstraints();
				gbc_nomPersonnage.gridwidth = 2;
				gbc_nomPersonnage.fill = GridBagConstraints.BOTH;
				gbc_nomPersonnage.insets = new Insets(0, 0, 5, 0);
				gbc_nomPersonnage.gridx = 0;
				gbc_nomPersonnage.gridy = 0;
				ongletPersonnage.add(nomPersonnage, gbc_nomPersonnage);
				
				JProgressBar barreDeVie = new JProgressBar();
				barreDeVie.setFont(new Font("Tahoma", Font.PLAIN, 11));
				barreDeVie.setBackground(Color.RED);
				barreDeVie.setForeground(new Color(0, 128, 0));
				barreDeVie.setStringPainted(true);
				barreDeVie.setValue(90);
				barreDeVie.setString("PV : 80 / 100");
				GridBagConstraints gbc_barreDeVie = new GridBagConstraints();
				gbc_barreDeVie.fill = GridBagConstraints.BOTH;
				gbc_barreDeVie.insets = new Insets(0, 0, 5, 5);
				gbc_barreDeVie.gridx = 0;
				gbc_barreDeVie.gridy = 1;
				ongletPersonnage.add(barreDeVie, gbc_barreDeVie);
				
				JLabel lblNiveau = new JLabel("Niveau : 1");
				GridBagConstraints gbc_lblNiveau = new GridBagConstraints();
				gbc_lblNiveau.insets = new Insets(0, 0, 5, 0);
				gbc_lblNiveau.gridx = 1;
				gbc_lblNiveau.gridy = 1;
				ongletPersonnage.add(lblNiveau, gbc_lblNiveau);
				
				JLabel raceLbl = new JLabel("Race :");
				GridBagConstraints gbc_raceLbl = new GridBagConstraints();
				gbc_raceLbl.insets = new Insets(0, 0, 5, 5);
				gbc_raceLbl.gridx = 0;
				gbc_raceLbl.gridy = 2;
				ongletPersonnage.add(raceLbl, gbc_raceLbl);
				
				JLabel raceValue = new JLabel("Nom de la race");
				GridBagConstraints gbc_raceValue = new GridBagConstraints();
				gbc_raceValue.insets = new Insets(0, 0, 5, 0);
				gbc_raceValue.gridx = 1;
				gbc_raceValue.gridy = 2;
				ongletPersonnage.add(raceValue, gbc_raceValue);
				
				JLabel classeLbl = new JLabel("Classe :");
				GridBagConstraints gbc_classeLbl = new GridBagConstraints();
				gbc_classeLbl.insets = new Insets(0, 0, 5, 5);
				gbc_classeLbl.gridx = 0;
				gbc_classeLbl.gridy = 3;
				ongletPersonnage.add(classeLbl, gbc_classeLbl);
				
				JLabel classeValue = new JLabel("nom de la classe");
				GridBagConstraints gbc_classeValue = new GridBagConstraints();
				gbc_classeValue.insets = new Insets(0, 0, 5, 0);
				gbc_classeValue.gridx = 1;
				gbc_classeValue.gridy = 3;
				ongletPersonnage.add(classeValue, gbc_classeValue);
				
				JLabel genreValue = new JLabel("genre du personnage");
				GridBagConstraints gbc_genreValue = new GridBagConstraints();
				gbc_genreValue.insets = new Insets(0, 0, 5, 5);
				gbc_genreValue.gridx = 0;
				gbc_genreValue.gridy = 4;
				ongletPersonnage.add(genreValue, gbc_genreValue);
				
				JLabel sexValue = new JLabel("sexe du personnage");
				GridBagConstraints gbc_sexValue = new GridBagConstraints();
				gbc_sexValue.insets = new Insets(0, 0, 5, 0);
				gbc_sexValue.gridx = 1;
				gbc_sexValue.gridy = 4;
				ongletPersonnage.add(sexValue, gbc_sexValue);
				
				JLabel atribut1Name = new JLabel("Attribut 1 :");
				GridBagConstraints gbc_atribut1Name = new GridBagConstraints();
				gbc_atribut1Name.insets = new Insets(0, 0, 5, 5);
				gbc_atribut1Name.gridx = 0;
				gbc_atribut1Name.gridy = 5;
				ongletPersonnage.add(atribut1Name, gbc_atribut1Name);
				
				JLabel valAtt1 = new JLabel("Valeur 1");
				GridBagConstraints gbc_valAtt1 = new GridBagConstraints();
				gbc_valAtt1.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt1.gridx = 1;
				gbc_valAtt1.gridy = 5;
				ongletPersonnage.add(valAtt1, gbc_valAtt1);
				
				JLabel attribut2Name = new JLabel("Attribut 2 :");
				GridBagConstraints gbc_attribut2Name = new GridBagConstraints();
				gbc_attribut2Name.insets = new Insets(0, 0, 5, 5);
				gbc_attribut2Name.gridx = 0;
				gbc_attribut2Name.gridy = 6;
				ongletPersonnage.add(attribut2Name, gbc_attribut2Name);
				
				JLabel valAtt2 = new JLabel("Valeur 2");
				GridBagConstraints gbc_valAtt2 = new GridBagConstraints();
				gbc_valAtt2.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt2.gridx = 1;
				gbc_valAtt2.gridy = 6;
				ongletPersonnage.add(valAtt2, gbc_valAtt2);
				
				JLabel attribut3Name = new JLabel("Attribut 3 :");
				GridBagConstraints gbc_attribut3Name = new GridBagConstraints();
				gbc_attribut3Name.insets = new Insets(0, 0, 5, 5);
				gbc_attribut3Name.gridx = 0;
				gbc_attribut3Name.gridy = 7;
				ongletPersonnage.add(attribut3Name, gbc_attribut3Name);
				
				JLabel valAtt3 = new JLabel("Valeur 3");
				GridBagConstraints gbc_valAtt3 = new GridBagConstraints();
				gbc_valAtt3.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt3.gridx = 1;
				gbc_valAtt3.gridy = 7;
				ongletPersonnage.add(valAtt3, gbc_valAtt3);
				
				JLabel attribut4Name = new JLabel("Attribut 4 :");
				GridBagConstraints gbc_attribut4Name = new GridBagConstraints();
				gbc_attribut4Name.insets = new Insets(0, 0, 5, 5);
				gbc_attribut4Name.gridx = 0;
				gbc_attribut4Name.gridy = 8;
				ongletPersonnage.add(attribut4Name, gbc_attribut4Name);
				
				JLabel valAtt4 = new JLabel("Valeur 4");
				GridBagConstraints gbc_valAtt4 = new GridBagConstraints();
				gbc_valAtt4.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt4.gridx = 1;
				gbc_valAtt4.gridy = 8;
				ongletPersonnage.add(valAtt4, gbc_valAtt4);
				
				JLabel attribut5Name = new JLabel("Attribut 5 :");
				GridBagConstraints gbc_attribut5Name = new GridBagConstraints();
				gbc_attribut5Name.insets = new Insets(0, 0, 5, 5);
				gbc_attribut5Name.gridx = 0;
				gbc_attribut5Name.gridy = 9;
				ongletPersonnage.add(attribut5Name, gbc_attribut5Name);
				
				JLabel valAtt5 = new JLabel("valeur 5");
				GridBagConstraints gbc_valAtt5 = new GridBagConstraints();
				gbc_valAtt5.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt5.gridx = 1;
				gbc_valAtt5.gridy = 9;
				ongletPersonnage.add(valAtt5, gbc_valAtt5);
				
				JLabel attribut6Name = new JLabel("Attribut 6 :");
				GridBagConstraints gbc_attribut6Name = new GridBagConstraints();
				gbc_attribut6Name.insets = new Insets(0, 0, 5, 5);
				gbc_attribut6Name.gridx = 0;
				gbc_attribut6Name.gridy = 10;
				ongletPersonnage.add(attribut6Name, gbc_attribut6Name);
				
				JLabel valAtt6 = new JLabel("valeur 6");
				GridBagConstraints gbc_valAtt6 = new GridBagConstraints();
				gbc_valAtt6.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt6.gridx = 1;
				gbc_valAtt6.gridy = 10;
				ongletPersonnage.add(valAtt6, gbc_valAtt6);
				
				JLabel attribut7Name = new JLabel("Attribut 7 :");
				GridBagConstraints gbc_attribut7Name = new GridBagConstraints();
				gbc_attribut7Name.insets = new Insets(0, 0, 5, 5);
				gbc_attribut7Name.gridx = 0;
				gbc_attribut7Name.gridy = 11;
				ongletPersonnage.add(attribut7Name, gbc_attribut7Name);
				
				JLabel valAtt7 = new JLabel("valeur 7");
				GridBagConstraints gbc_valAtt7 = new GridBagConstraints();
				gbc_valAtt7.insets = new Insets(0, 0, 5, 0);
				gbc_valAtt7.gridx = 1;
				gbc_valAtt7.gridy = 11;
				ongletPersonnage.add(valAtt7, gbc_valAtt7);
				
				JLabel attribut8Name = new JLabel("Attribut 8 :");
				GridBagConstraints gbc_attribut8Name = new GridBagConstraints();
				gbc_attribut8Name.insets = new Insets(0, 0, 0, 5);
				gbc_attribut8Name.gridx = 0;
				gbc_attribut8Name.gridy = 12;
				ongletPersonnage.add(attribut8Name, gbc_attribut8Name);
				
				JLabel valAtt8 = new JLabel("valeur 8");
				GridBagConstraints gbc_valAtt8 = new GridBagConstraints();
				gbc_valAtt8.gridx = 1;
				gbc_valAtt8.gridy = 12;
				ongletPersonnage.add(valAtt8, gbc_valAtt8);
		
		JPanel ongletInventaire = new JPanel();
		onglets.addTab("Inventaire", null, ongletInventaire, null);
		ongletInventaire.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sac à dos", "Equipé", "Coffre"}));
		ongletInventaire.add(comboBox, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Object value[] = {"Repas","Repas","Gourde 5/10","Épée du chaos"};
		list.setListData(value);
		ongletInventaire.add(list, BorderLayout.CENTER);
		
		JLabel lblRichesse = new JLabel("Richesse : 0 pièces d'or");
		lblRichesse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblRichesse.setHorizontalAlignment(SwingConstants.CENTER);
		ongletInventaire.add(lblRichesse, BorderLayout.SOUTH);
		
		JPanel ongletSettings = new JPanel();
		onglets.addTab("Parametres", null, ongletSettings, null);
		
		JPanel contenuAventure = new JPanel();
		contenuPrincipal.add(contenuAventure, BorderLayout.CENTER);
		contenuAventure.setLayout(new BorderLayout(0, 0));
		
		JSplitPane horizonEvenement = new JSplitPane();
		horizonEvenement.setContinuousLayout(true);
		horizonEvenement.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contenuAventure.add(horizonEvenement, BorderLayout.CENTER);
		
		JPanel zoneAffichage = new JPanel();
		horizonEvenement.setLeftComponent(zoneAffichage);
		zoneAffichage.setLayout(new BorderLayout(0, 0));
		
		JTextPane view = new JTextPane();
		view.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//StyledDocument doc = view.getStyledDocument();
		
		//view.setWrapStyleWord(true);
		//view.setLineWrap(true);
		StyledDocument doc = view.getStyledDocument();
		MutableAttributeSet sa = new SimpleAttributeSet();
		StyleConstants.setAlignment(sa, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, 0, sa, true);
		//view.getDocument().setParagraphAttributes(0,view.getText().length(),sa, false);
		//view.setLineWrap(true);
		//view.setWrapStyleWord(true);
		view.setText("L'aventure de votre personnage commence ici, au fil des paragraphes, vous  pourrez développer ses caractéristiques. Voici les choix possibles de  classe, ne vous inquiétez pas encore, il vous est possible de creer une équipe de personnages au fil du temps. Vous pouvez choisir parmi les classes de guerrier, mages, prètres, voleurs et bien d'autres. Ce text n'est qu'une ébaucheafinde présenter une interface plutôt contractuelle de la future version PC du jeu BiblioHero.");
		zoneAffichage.add(view, BorderLayout.CENTER);
		
		JPanel zoneChoixEvenement = new JPanel();
		horizonEvenement.setRightComponent(zoneChoixEvenement);
		zoneChoixEvenement.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton_5 = new JButton("New button");
		zoneChoixEvenement.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		zoneChoixEvenement.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		zoneChoixEvenement.add(btnNewButton_7);
		
		JButton btnNewButton_4 = new JButton("New button");
		zoneChoixEvenement.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("New button");
		zoneChoixEvenement.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		zoneChoixEvenement.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setEnabled(false);
		zoneChoixEvenement.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setEnabled(false);
		zoneChoixEvenement.add(btnNewButton_3);
		
		JLabel zoneDeJeu = new JLabel("Titre de l'aventure en cours");
		zoneDeJeu.setHorizontalAlignment(SwingConstants.CENTER);
		zoneDeJeu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contenuAventure.add(zoneDeJeu, BorderLayout.NORTH);
	}

}
