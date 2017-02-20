package bibliohero.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CUI extends JFrame 
{
	private JPanel backPanel;
	private JTextField command;
	private JTextArea view;

	/**
	 * Create the frame.
	 */
	public CUI() 
	{
		backPanel = new JPanel();
		backPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backPanel.setLayout(new BorderLayout(0, 0));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(backPanel);
		
		command = new JTextField();
		command.setBackground(Color.BLACK);
		command.setFont(new Font("Consolas", Font.PLAIN, 12));
		command.setColumns(80);
		
		view = new JTextArea();
		view.setText("texte de test");
		view.setForeground(Color.WHITE);
		view.setBackground(Color.BLACK);
		view.setFont(new Font("Consolas", Font.PLAIN, 12));
		view.setEnabled(false);
		view.setColumns(80);
		view.setRows(25);
		backPanel.add(command, BorderLayout.SOUTH);
		backPanel.add(view, BorderLayout.CENTER);
	}
	
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

}
