package bibliohero.ihm.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CombatFrame extends JFrame
{
	private JInfoPanel equipeJoueur;
	private JPanelEquipe equipeAdverse;

	public CombatFrame() throws Exception
	{
		setTitle("Combat en cours");
		equipeJoueur = new JInfoPanel();
		this.getContentPane().add(equipeJoueur, BorderLayout.WEST);
		equipeAdverse = new JPanelEquipe();
		this.getContentPane().add(equipeAdverse, BorderLayout.EAST);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelDeAdverse = new JPanel();
		panelDeAdverse.setPreferredSize(new Dimension(40, 40));
		panelDeAdverse.setMinimumSize(new Dimension(40, 40));
		panelDeAdverse.setBackground(Color.RED);
		panel.add(panelDeAdverse, BorderLayout.CENTER);
		panelDeAdverse.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Dé Value");
		lblNewLabel.setMaximumSize(new Dimension(42, 40));
		lblNewLabel.setMinimumSize(new Dimension(42, 40));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelDeAdverse.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panelDeAdverse.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Dés de l'adversaire :");
		panel_1.add(lblNewLabel_2);

		JPanel panelInfoCombat = new JPanel();
		panelDeAdverse.add(panelInfoCombat, BorderLayout.SOUTH);
		panelInfoCombat.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("Descriptif du combat :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoCombat.add(lblNewLabel_4, BorderLayout.NORTH);

		JTextArea textAreaDescriptif = new JTextArea();
		textAreaDescriptif.setFont(new Font("Monospaced", Font.PLAIN, 10));
		textAreaDescriptif.setLineWrap(true);
		textAreaDescriptif.setRows(3);
		textAreaDescriptif.setWrapStyleWord(true);
		textAreaDescriptif.setText("le combat est sur le point de commencer entre les protagonistes");
		panelInfoCombat.add(textAreaDescriptif, BorderLayout.CENTER);

		JPanel panelImgSeparator = new JPanel();
		panelInfoCombat.add(panelImgSeparator, BorderLayout.SOUTH);
		panelImgSeparator.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("Tour actuel : 0");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panelImgSeparator.add(lblNewLabel_5, BorderLayout.NORTH);

		JPanel panelImg = new JPanel();
		panelImgSeparator.add(panelImg, BorderLayout.CENTER);

		JPanel panelDeJoueur = new JPanel();
		panelDeJoueur.setMinimumSize(new Dimension(40, 40));
		panelDeJoueur.setBackground(Color.BLUE);
		panel.add(panelDeJoueur, BorderLayout.SOUTH);
		panelDeJoueur.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Dé Value");
		lblNewLabel_1.setMaximumSize(new Dimension(42, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelDeJoueur.add(lblNewLabel_1, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Lancer / Stopper");
		panelDeJoueur.add(btnNewButton, BorderLayout.SOUTH);

		JPanel labelDJ = new JPanel();
		panelDeJoueur.add(labelDJ, BorderLayout.NORTH);

		JLabel lblNewLabel_3 = new JLabel("Dés des personnages");
		labelDJ.add(lblNewLabel_3);

	}
}
