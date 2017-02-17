package bibliohero.IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CUI extends JFrame {

	private JPanel BackPanel;
	private JTextField Command;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CUI frame = new CUI();
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
	public CUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		BackPanel = new JPanel();
		BackPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		BackPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(BackPanel);
		
		Command = new JTextField();
		Command.setBackground(Color.BLACK);
		Command.setFont(new Font("Consolas", Font.PLAIN, 12));
		BackPanel.add(Command, BorderLayout.SOUTH);
		Command.setColumns(80);
		
		JTextArea View = new JTextArea();
		View.setText("texte de test");
		View.setForeground(Color.WHITE);
		View.setBackground(Color.BLACK);
		View.setFont(new Font("Consolas", Font.PLAIN, 12));
		View.setEnabled(false);
		View.setColumns(80);
		View.setRows(25);
		BackPanel.add(View, BorderLayout.CENTER);
	}

}
