package bibliohero.ihm.swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JEventButton extends JButton implements ActionListener
{
	// TODO getset, init, constructeur
	public JEventButton()
	{
		super();
		reInit();
	}
	public JEventButton(String text)
	{
		super();
		setMinimumSize(new Dimension(400,400));
		reInit(text);
	}
	
	public void reInit(){this.reInit("");}
	public void reInit(String text){this.reInit(text, false);}
	public void reInit(String text, boolean enable)
	{
		setText(text);
		setEnabled(enable);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
	
	}
}
