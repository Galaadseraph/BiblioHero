package bibliohero.ihm.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contenuPrincipal;
	private JTable equipeTable;
	private JMenu menuPersonnage2;

	/**
	 * Create the frame.
	 */
	public MainFrame() throws Exception
	{
		setMinimumSize(new Dimension(640, 480));
		setMaximizedBounds(new Rectangle(0, 0, 800, 600));
		setTitle("BiblioHero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 480);
		
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
		contenuPrincipal.setMinimumSize(new Dimension(630, 440));
		contenuPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenuPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(contenuPrincipal);
		
		JInfoPanel contenuInfo = new JInfoPanel();
		contenuPrincipal.add(contenuInfo, BorderLayout.WEST);
		
		JPanelAventure contenuAventure = new JPanelAventure();
		contenuPrincipal.add(contenuAventure, BorderLayout.CENTER);
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
