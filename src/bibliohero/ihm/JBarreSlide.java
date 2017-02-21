package bibliohero.ihm;

import java.awt.Color;

import javax.swing.JProgressBar;

public class JBarreSlide extends JProgressBar
{
	private int type;
	
	public JBarreSlide(String type) throws Exception 
	{
		super();
		if (type =="PV")
			this.type =0;
		else if (type =="Mana")
			this.type = 1;
		else throw new Exception ();
		init();
	}
	/**
	 * @wbp.parser.constructor
	 */
	public JBarreSlide(int type)throws Exception 
	{
		super();
		if ((type <0 )||(type >1))
			throw new Exception ();
		else this.type = type;
		init();
	}
	
	private void init()
	{
		if (type == 0)
		{
			setBackground(Color.RED);
			setForeground(new Color(0, 128, 0));
		}
		else if (type == 1)
		{
			setBackground(Color.BLACK);
			setForeground(Color.BLUE);
		}
		setStringPainted(true);
	}
	
	public String getType()
	{
		if (type == 0)
			return "PV";
		else return "Magie";
	}
	
	public void setType(String value) throws Exception
	{
		if (value =="PV")
				setType(0);
		else if (value =="Mana")
				setType(1);
		else throw new Exception();
	}
	public void setType(int value) throws Exception
	{
		if ((value <0 )||(value >1))
			throw new Exception();
		else type = value;
	}

	@Override
	public void setValue(int value)
	{
		super.setValue(value);
		this.setString(String.valueOf(value));
	}
	
	@Override
	public void setString(String value)
	{
		this.progressString = this.getType() + " : ";
		this.progressString += (value + " / " + this.getMaximum());
	}
}
