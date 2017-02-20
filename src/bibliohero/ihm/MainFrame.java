package bibliohero.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
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
	private JMenu menuPersonnage2;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("BiblioHero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 378);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFich = new JMenu("Fichier");
		menuBar.add(menuFich);
		
		JMenuItem nouveauPersonnage = new JMenuItem("Nouveau Personnage");
		menuFich.add(nouveauPersonnage);
		
		JMenuItem saveState = new JMenuItem("Sauvegarder");
		menuFich.add(saveState);
		
		JSeparator separatorFichierImport = new JSeparator();
		menuFich.add(separatorFichierImport);
		
		JMenuItem importDatabase = new JMenuItem("Importer");
		menuFich.add(importDatabase);
		
		JMenuItem exportDatabase = new JMenuItem("Exporter");
		menuFich.add(exportDatabase);
		
		JSeparator separatorFichierQuitter = new JSeparator();
		menuFich.add(separatorFichierQuitter);
		
		JMenuItem quitter = new JMenuItem("Quitter");
		menuFich.add(quitter);
		
		JMenu menuEdit = new JMenu("Edition");
		menuBar.add(menuEdit);
		
		JMenu menuView = new JMenu("Affichage");
		menuBar.add(menuView);
		
		JMenu menuTeam = new JMenu("Equipe");
		menuBar.add(menuTeam);
		
		JMenu menuPersonnage1 = new JMenu("Personnage 1");
		menuTeam.add(menuPersonnage1);
		
		menuPersonnage2 = new JMenu("Personnage 2");
		menuTeam.add(menuPersonnage2);
		
		JMenu menuParam = new JMenu("Paramètres");
		menuBar.add(menuParam);
		
		JMenu menuHlp = new JMenu("Aides");
		menuBar.add(menuHlp);
		
		JMenuItem menuAide = new JMenuItem("Aide");
		menuHlp.add(menuAide);
		
		JSeparator separatorAideAPropos = new JSeparator();
		menuHlp.add(separatorAideAPropos);
		
		JMenuItem menuAPropos = new JMenuItem("A Propos");
		menuHlp.add(menuAPropos);
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
		equipeTable = new JTable();
		equipeTable.setFillsViewportHeight(true);
		equipeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		equipeTable.setShowVerticalLines(false);
		equipeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nom", "Race", "Classe", "Niveau"},
				{"Personnage 1", "Humain", "Guerrier", "1"},
				{"Personnage 2", "Elfe", "Magicien", "1"},
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
				GridBagLayout gblOngletPersonnage = new GridBagLayout();
				gblOngletPersonnage.columnWidths = new int[] {138, 102};
				gblOngletPersonnage.rowHeights = new int[]{16, 16, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0};
				gblOngletPersonnage.columnWeights = new double[]{0.0, 0.0};
				gblOngletPersonnage.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				ongletPersonnage.setLayout(gblOngletPersonnage);
				
				JLabel lblPersonnage = new JLabel("nom du personnage");
				lblPersonnage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbcLblPersonnage = new GridBagConstraints();
				gbcLblPersonnage.gridwidth = 2;
				gbcLblPersonnage.fill = GridBagConstraints.BOTH;
				gbcLblPersonnage.insets = new Insets(0, 0, 5, 0);
				gbcLblPersonnage.gridx = 0;
				gbcLblPersonnage.gridy = 0;
				ongletPersonnage.add(lblPersonnage, gbcLblPersonnage);
				
				JProgressBar barreDeVie = new JProgressBar();
				barreDeVie.setFont(new Font("Tahoma", Font.PLAIN, 11));
				barreDeVie.setBackground(Color.RED);
				barreDeVie.setForeground(new Color(0, 128, 0));
				barreDeVie.setStringPainted(true);
				barreDeVie.setValue(90);
				barreDeVie.setString("PV : 80 / 100");
				GridBagConstraints gbcBarreDeVie = new GridBagConstraints();
				gbcBarreDeVie.fill = GridBagConstraints.BOTH;
				gbcBarreDeVie.insets = new Insets(0, 0, 5, 5);
				gbcBarreDeVie.gridx = 0;
				gbcBarreDeVie.gridy = 1;
				ongletPersonnage.add(barreDeVie, gbcBarreDeVie);
				
				JLabel lblNiveau = new JLabel("Niveau : 1");
				GridBagConstraints gbcLblNiveau = new GridBagConstraints();
				gbcLblNiveau.insets = new Insets(0, 0, 5, 0);
				gbcLblNiveau.gridx = 1;
				gbcLblNiveau.gridy = 1;
				ongletPersonnage.add(lblNiveau, gbcLblNiveau);
				
				JLabel raceLbl = new JLabel("Race :");
				GridBagConstraints gbcRaceLbl = new GridBagConstraints();
				gbcRaceLbl.insets = new Insets(0, 0, 5, 5);
				gbcRaceLbl.gridx = 0;
				gbcRaceLbl.gridy = 2;
				ongletPersonnage.add(raceLbl, gbcRaceLbl);
				
				JLabel raceValue = new JLabel("Nom de la race");
				GridBagConstraints gbcRaceValue = new GridBagConstraints();
				gbcRaceValue.insets = new Insets(0, 0, 5, 0);
				gbcRaceValue.gridx = 1;
				gbcRaceValue.gridy = 2;
				ongletPersonnage.add(raceValue, gbcRaceValue);
				
				JLabel classeLbl = new JLabel("Classe :");
				GridBagConstraints gbcClasseLbl = new GridBagConstraints();
				gbcClasseLbl.insets = new Insets(0, 0, 5, 5);
				gbcClasseLbl.gridx = 0;
				gbcClasseLbl.gridy = 3;
				ongletPersonnage.add(classeLbl, gbcClasseLbl);
				
				JLabel classeValue = new JLabel("nom de la classe");
				GridBagConstraints gbcClasseValue = new GridBagConstraints();
				gbcClasseValue.insets = new Insets(0, 0, 5, 0);
				gbcClasseValue.gridx = 1;
				gbcClasseValue.gridy = 3;
				ongletPersonnage.add(classeValue, gbcClasseValue);
				
				JLabel genreValue = new JLabel("genre du personnage");
				GridBagConstraints gbcGenreValue = new GridBagConstraints();
				gbcGenreValue.insets = new Insets(0, 0, 5, 5);
				gbcGenreValue.gridx = 0;
				gbcGenreValue.gridy = 4;
				ongletPersonnage.add(genreValue, gbcGenreValue);
				
				JLabel sexValue = new JLabel("sexe du personnage");
				GridBagConstraints gbcSexValue = new GridBagConstraints();
				gbcSexValue.insets = new Insets(0, 0, 5, 0);
				gbcSexValue.gridx = 1;
				gbcSexValue.gridy = 4;
				ongletPersonnage.add(sexValue, gbcSexValue);
				
				JLabel lblExp = new JLabel("Exp : 000 000 000 000 xp");
				GridBagConstraints gbcLblExp = new GridBagConstraints();
				gbcLblExp.insets = new Insets(0, 0, 5, 5);
				gbcLblExp.gridx = 0;
				gbcLblExp.gridy = 5;
				ongletPersonnage.add(lblExp, gbcLblExp);
				
				JLabel lblExpAvailable = new JLabel("restante : 000 000 xp ");
				GridBagConstraints gbcLblExpAvailable = new GridBagConstraints();
				gbcLblExpAvailable.insets = new Insets(0, 0, 5, 0);
				gbcLblExpAvailable.gridx = 1;
				gbcLblExpAvailable.gridy = 5;
				ongletPersonnage.add(lblExpAvailable, gbcLblExpAvailable);
				
				JLabel atribut1Name = new JLabel("Attribut 1 :");
				GridBagConstraints gbcAtribut1Name = new GridBagConstraints();
				gbcAtribut1Name.insets = new Insets(0, 0, 5, 5);
				gbcAtribut1Name.gridx = 0;
				gbcAtribut1Name.gridy = 6;
				ongletPersonnage.add(atribut1Name, gbcAtribut1Name);
				
				JLabel valAtt1 = new JLabel("Valeur 1");
				GridBagConstraints gbcValAtt1 = new GridBagConstraints();
				gbcValAtt1.insets = new Insets(0, 0, 5, 0);
				gbcValAtt1.gridx = 1;
				gbcValAtt1.gridy = 6;
				ongletPersonnage.add(valAtt1, gbcValAtt1);
				
				JLabel attribut2Name = new JLabel("Attribut 2 :");
				GridBagConstraints gbcAttribut2Name = new GridBagConstraints();
				gbcAttribut2Name.insets = new Insets(0, 0, 5, 5);
				gbcAttribut2Name.gridx = 0;
				gbcAttribut2Name.gridy = 7;
				ongletPersonnage.add(attribut2Name, gbcAttribut2Name);
				
				JLabel valAtt2 = new JLabel("Valeur 2");
				GridBagConstraints gbcValAtt2 = new GridBagConstraints();
				gbcValAtt2.insets = new Insets(0, 0, 5, 0);
				gbcValAtt2.gridx = 1;
				gbcValAtt2.gridy = 7;
				ongletPersonnage.add(valAtt2, gbcValAtt2);
				
				JLabel attribut3Name = new JLabel("Attribut 3 :");
				GridBagConstraints gbcAttribut3Name = new GridBagConstraints();
				gbcAttribut3Name.insets = new Insets(0, 0, 5, 5);
				gbcAttribut3Name.gridx = 0;
				gbcAttribut3Name.gridy = 8;
				ongletPersonnage.add(attribut3Name, gbcAttribut3Name);
				
				JLabel valAtt3 = new JLabel("Valeur 3");
				GridBagConstraints gbcValAtt3 = new GridBagConstraints();
				gbcValAtt3.insets = new Insets(0, 0, 5, 0);
				gbcValAtt3.gridx = 1;
				gbcValAtt3.gridy = 8;
				ongletPersonnage.add(valAtt3, gbcValAtt3);
				
				JLabel attribut4Name = new JLabel("Attribut 4 :");
				GridBagConstraints gbcAttribut4Name = new GridBagConstraints();
				gbcAttribut4Name.insets = new Insets(0, 0, 5, 5);
				gbcAttribut4Name.gridx = 0;
				gbcAttribut4Name.gridy = 9;
				ongletPersonnage.add(attribut4Name, gbcAttribut4Name);
				
				JLabel valAtt4 = new JLabel("Valeur 4");
				GridBagConstraints gbcValAtt4 = new GridBagConstraints();
				gbcValAtt4.insets = new Insets(0, 0, 5, 0);
				gbcValAtt4.gridx = 1;
				gbcValAtt4.gridy = 9;
				ongletPersonnage.add(valAtt4, gbcValAtt4);
				
				JLabel attribut5Name = new JLabel("Attribut 5 :");
				GridBagConstraints gbcAttribut5Name = new GridBagConstraints();
				gbcAttribut5Name.insets = new Insets(0, 0, 5, 5);
				gbcAttribut5Name.gridx = 0;
				gbcAttribut5Name.gridy = 10;
				ongletPersonnage.add(attribut5Name, gbcAttribut5Name);
				
				JLabel valAtt5 = new JLabel("valeur 5");
				GridBagConstraints gbcValAtt5 = new GridBagConstraints();
				gbcValAtt5.insets = new Insets(0, 0, 5, 0);
				gbcValAtt5.gridx = 1;
				gbcValAtt5.gridy = 10;
				ongletPersonnage.add(valAtt5, gbcValAtt5);
				
				JLabel attribut6Name = new JLabel("Attribut 6 :");
				GridBagConstraints gbcAttribut6Name = new GridBagConstraints();
				gbcAttribut6Name.insets = new Insets(0, 0, 5, 5);
				gbcAttribut6Name.gridx = 0;
				gbcAttribut6Name.gridy = 11;
				ongletPersonnage.add(attribut6Name, gbcAttribut6Name);
				
				JLabel valAtt6 = new JLabel("valeur 6");
				GridBagConstraints gbcValAtt6 = new GridBagConstraints();
				gbcValAtt6.insets = new Insets(0, 0, 5, 0);
				gbcValAtt6.gridx = 1;
				gbcValAtt6.gridy = 11;
				ongletPersonnage.add(valAtt6, gbcValAtt6);
				
				JLabel attribut7Name = new JLabel("Attribut 7 :");
				GridBagConstraints gbcAttribut7Name = new GridBagConstraints();
				gbcAttribut7Name.insets = new Insets(0, 0, 5, 5);
				gbcAttribut7Name.gridx = 0;
				gbcAttribut7Name.gridy = 12;
				ongletPersonnage.add(attribut7Name, gbcAttribut7Name);
				
				JLabel valAtt7 = new JLabel("valeur 7");
				GridBagConstraints gbcValAtt7 = new GridBagConstraints();
				gbcValAtt7.insets = new Insets(0, 0, 5, 0);
				gbcValAtt7.gridx = 1;
				gbcValAtt7.gridy = 12;
				ongletPersonnage.add(valAtt7, gbcValAtt7);
				
				JLabel attribut8Name = new JLabel("Attribut 8 :");
				GridBagConstraints gbcAttribut8Name = new GridBagConstraints();
				gbcAttribut8Name.insets = new Insets(0, 0, 0, 5);
				gbcAttribut8Name.gridx = 0;
				gbcAttribut8Name.gridy = 13;
				ongletPersonnage.add(attribut8Name, gbcAttribut8Name);
				
				JLabel valAtt8 = new JLabel("valeur 8");
				GridBagConstraints gbcValAtt8 = new GridBagConstraints();
				gbcValAtt8.gridx = 1;
				gbcValAtt8.gridy = 13;
				ongletPersonnage.add(valAtt8, gbcValAtt8);
		
		JPanel ongletsSorts = new JPanel();
		onglets.addTab("Grimoire", null, ongletsSorts, null);
		ongletsSorts.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboSort = new JComboBox();
		comboSort.setModel(new DefaultComboBoxModel(new String[] {"Illusion", "Invocation", "Destruction"}));
		ongletsSorts.add(comboSort, BorderLayout.NORTH);
		
		JButton lancerSort = new JButton("Lancer le sort");
		ongletsSorts.add(lancerSort, BorderLayout.SOUTH);
		
		JList listSort = new JList();
		listSort.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Object[] value = {"Déguisement","Brouillard","Flash"};
		listSort.setListData(value);
		ongletsSorts.add(listSort, BorderLayout.CENTER);
		JPopupMenu popUpMenuSort = new JPopupMenu();
		addPopup(listSort, popUpMenuSort);
		
		JMenuItem popUpMenuLancerSort = new JMenuItem("Lancer");
		popUpMenuSort.add(popUpMenuLancerSort);
		
		JPanel ongletInventaire = new JPanel();
		onglets.addTab("Inventaire", null, ongletInventaire, null);
		ongletInventaire.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboInventaire = new JComboBox();
		comboInventaire.setModel(new DefaultComboBoxModel(new String[] {"Sac à dos", "Equipé", "Coffre"}));
		ongletInventaire.add(comboInventaire, BorderLayout.NORTH);
		
		JList listInv = new JList();
		listInv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Object[] valueInv = {"Repas","Repas","Gourde","Épée du chaos"};
		listInv.setListData(valueInv);
		ongletInventaire.add(listInv, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(listInv, popupMenu);
		
		JMenuItem popUpMenuUse = new JMenuItem("Utiliser /Équiper");
		popupMenu.add(popUpMenuUse);
		
		JMenu popUpMenuGive = new JMenu("Donner à");
		popupMenu.add(popUpMenuGive);
		
		JMenuItem popUpMenuPersonnage1 = new JMenuItem("personnage 1");
		popUpMenuGive.add(popUpMenuPersonnage1);
		
		JMenuItem popUpMenuDesc = new JMenuItem("Description");
		popupMenu.add(popUpMenuDesc);
		
		JSeparator separatorActionJeter = new JSeparator();
		popupMenu.add(separatorActionJeter);
		
		JMenuItem popUpMenuJeter = new JMenuItem("Jeter");
		popupMenu.add(popUpMenuJeter);
		
		JPanel actionInventaire = new JPanel();
		ongletInventaire.add(actionInventaire, BorderLayout.SOUTH);
		actionInventaire.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRichesse = new JLabel("Richesse : 0 pièces d'or");
		actionInventaire.add(lblRichesse, BorderLayout.SOUTH);
		lblRichesse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblRichesse.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton utiliseObjet = new JButton("Utiliser / équiper");
		actionInventaire.add(utiliseObjet);
		
		JButton descObject = new JButton("observer l'objet");
		actionInventaire.add(descObject, BorderLayout.NORTH);
		
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
		view.setForeground(Color.BLACK);
		view.setEnabled(false);
		view.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StyledDocument doc = view.getStyledDocument();
		MutableAttributeSet sa = new SimpleAttributeSet();
		StyleConstants.setAlignment(sa, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, 0, sa, true);
		view.setText("L'aventure de votre personnage commence ici, au fil des paragraphes, vous  pourrez développer ses caractéristiques. Voici les choix possibles de  classe, ne vous inquiétez pas encore, il vous est possible de creer une équipe de personnages au fil du temps. Vous pouvez choisir parmi les classes de guerrier, mages, prètres, voleurs et bien d'autres. Ce text n'est qu'une ébaucheafinde présenter une interface plutôt contractuelle de la future version PC du jeu BiblioHero.");
		zoneAffichage.add(view, BorderLayout.CENTER);
		
		JPanel zoneChoixEvenement = new JPanel();
		horizonEvenement.setRightComponent(zoneChoixEvenement);
		zoneChoixEvenement.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton eventChoix0 = new JButton("Evènement 0");
		zoneChoixEvenement.add(eventChoix0);
		
		JButton eventChoix1 = new JButton("Evènement 1");
		zoneChoixEvenement.add(eventChoix1);
		
		JButton eventChoix2 = new JButton("Evènement 2");
		zoneChoixEvenement.add(eventChoix2);
		
		JButton eventChoix3 = new JButton("Evènement 3");
		zoneChoixEvenement.add(eventChoix3);
		
		JButton eventChoix4 = new JButton("Evènement 4");
		zoneChoixEvenement.add(eventChoix4);
		
		JButton eventChoix5 = new JButton("Evènement 5");
		zoneChoixEvenement.add(eventChoix5);
		
		JButton eventChoix6 = new JButton("Evènement 6");
		eventChoix6.setEnabled(false);
		zoneChoixEvenement.add(eventChoix6);
		
		JButton eventChoix7 = new JButton("Evènement 7");
		eventChoix7.setEnabled(false);
		zoneChoixEvenement.add(eventChoix7);
		
		JPanel contexte = new JPanel();
		contenuAventure.add(contexte, BorderLayout.SOUTH);
		contexte.setLayout(new BorderLayout(0, 0));
		
		JComboBox contextuel = new JComboBox();
		contextuel.setModel(new DefaultComboBoxModel(new String[] {"Fouiller", "Se reposer", "Fuir", "Fuir Aventure"}));
		contexte.add(contextuel, BorderLayout.CENTER);
		
		JButton validCOntext = new JButton("valider");
		contexte.add(validCOntext, BorderLayout.EAST);
		
		JLabel zoneDeJeu = new JLabel("Titre de l'aventure en cours");
		zoneDeJeu.setHorizontalAlignment(SwingConstants.CENTER);
		zoneDeJeu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contenuAventure.add(zoneDeJeu, BorderLayout.NORTH);
	}
	
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
