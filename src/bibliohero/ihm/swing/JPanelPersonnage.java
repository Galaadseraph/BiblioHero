package bibliohero.ihm.swing;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelPersonnage extends JPanel
{
	public JPanelPersonnage() throws Exception
	{
		this.setLayout(new GridBagLayout());
		//onglets.addTab("Personnage", null, ongletPersonnage, null);
		GridBagLayout gblOngletPersonnage = new GridBagLayout();
		gblOngletPersonnage.columnWidths = new int[] {138, 102};
		gblOngletPersonnage.rowHeights = new int[]{16, 16, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0};
		gblOngletPersonnage.columnWeights = new double[]{0.0, 0.0};
		gblOngletPersonnage.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gblOngletPersonnage);
	
		JLabel lblPersonnage = new JLabel("nom du personnage");
		lblPersonnage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcLblPersonnage = new GridBagConstraints();
		gbcLblPersonnage.gridwidth = 2;
		gbcLblPersonnage.fill = GridBagConstraints.BOTH;
		gbcLblPersonnage.insets = new Insets(0, 0, 5, 0);
		gbcLblPersonnage.gridx = 0;
		gbcLblPersonnage.gridy = 0;
		this.add(lblPersonnage, gbcLblPersonnage);
	
		JBarreSlide barreDeMana = new JBarreSlide(1);
		barreDeMana.setMaximum(10);
		barreDeMana.setValue(9);
		barreDeMana.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
		GridBagConstraints gbcBarreDeMana = new GridBagConstraints();
		gbcBarreDeMana.fill = GridBagConstraints.HORIZONTAL;
		gbcBarreDeMana.insets = new Insets(0, 0, 5, 5);
		gbcBarreDeMana.gridx = 0;
		gbcBarreDeMana.gridy = 1;
		this.add(barreDeMana, gbcBarreDeMana);
	
		JLabel lblNiveau = new JLabel("Niveau : 1");
		GridBagConstraints gbcLblNiveau = new GridBagConstraints();
		gbcLblNiveau.insets = new Insets(0, 0, 5, 0);
		gbcLblNiveau.gridx = 1;
		gbcLblNiveau.gridy = 1;
		this.add(lblNiveau, gbcLblNiveau);
	
		JBarreSlide barreDeVie = new JBarreSlide(0);
		barreDeVie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		barreDeVie.setValue(90);

		GridBagConstraints gbcBarreDeVie = new GridBagConstraints();
		gbcBarreDeVie.gridwidth = 2;
		gbcBarreDeVie.fill = GridBagConstraints.BOTH;
		gbcBarreDeVie.insets = new Insets(0, 0, 5, 5);
		gbcBarreDeVie.gridx = 0;
		gbcBarreDeVie.gridy = 2;
		this.add(barreDeVie, gbcBarreDeVie);
	
		JLabel raceValue = new JLabel("Nom de la race");
		GridBagConstraints gbcRaceValue = new GridBagConstraints();
		gbcRaceValue.insets = new Insets(0, 0, 5, 5);
		gbcRaceValue.gridx = 0;
		gbcRaceValue.gridy = 3;
		this.add(raceValue, gbcRaceValue);
	
		JLabel classeValue = new JLabel("nom de la classe");
		GridBagConstraints gbcClasseValue = new GridBagConstraints();
		gbcClasseValue.insets = new Insets(0, 0, 5, 0);
		gbcClasseValue.gridx = 1;
		gbcClasseValue.gridy = 3;
		this.add(classeValue, gbcClasseValue);
	
		JLabel genreValue = new JLabel("genre du personnage");
		GridBagConstraints gbcGenreValue = new GridBagConstraints();
		gbcGenreValue.insets = new Insets(0, 0, 5, 5);
		gbcGenreValue.gridx = 0;
		gbcGenreValue.gridy = 4;
		this.add(genreValue, gbcGenreValue);
	
		JLabel sexValue = new JLabel("sexe du personnage");
		GridBagConstraints gbcSexValue = new GridBagConstraints();
		gbcSexValue.insets = new Insets(0, 0, 5, 0);
		gbcSexValue.gridx = 1;
		gbcSexValue.gridy = 4;
		this.add(sexValue, gbcSexValue);
	
		JLabel lblExp = new JLabel("Exp : 000 000 000 000 xp");
		GridBagConstraints gbcLblExp = new GridBagConstraints();
		gbcLblExp.insets = new Insets(0, 0, 5, 5);
		gbcLblExp.gridx = 0;
		gbcLblExp.gridy = 5;
		this.add(lblExp, gbcLblExp);
	
		JLabel lblExpAvailable = new JLabel("restante : 000 000 xp ");
		GridBagConstraints gbcLblExpAvailable = new GridBagConstraints();
		gbcLblExpAvailable.insets = new Insets(0, 0, 5, 0);
		gbcLblExpAvailable.gridx = 1;
		gbcLblExpAvailable.gridy = 5;
		this.add(lblExpAvailable, gbcLblExpAvailable);
	
		JLabel atribut1Name = new JLabel("Attribut 1 :");
		GridBagConstraints gbcAtribut1Name = new GridBagConstraints();
		gbcAtribut1Name.insets = new Insets(0, 0, 5, 5);
		gbcAtribut1Name.gridx = 0;
		gbcAtribut1Name.gridy = 6;
		this.add(atribut1Name, gbcAtribut1Name);
	
		JLabel valAtt1 = new JLabel("Valeur 1");
		GridBagConstraints gbcValAtt1 = new GridBagConstraints();
		gbcValAtt1.insets = new Insets(0, 0, 5, 0);
		gbcValAtt1.gridx = 1;
		gbcValAtt1.gridy = 6;
		this.add(valAtt1, gbcValAtt1);
	
		JLabel attribut2Name = new JLabel("Attribut 2 :");
		GridBagConstraints gbcAttribut2Name = new GridBagConstraints();
		gbcAttribut2Name.insets = new Insets(0, 0, 5, 5);
		gbcAttribut2Name.gridx = 0;
		gbcAttribut2Name.gridy = 7;
		this.add(attribut2Name, gbcAttribut2Name);
	
		JLabel valAtt2 = new JLabel("Valeur 2");
		GridBagConstraints gbcValAtt2 = new GridBagConstraints();
		gbcValAtt2.insets = new Insets(0, 0, 5, 0);
		gbcValAtt2.gridx = 1;
		gbcValAtt2.gridy = 7;
		this.add(valAtt2, gbcValAtt2);
	
		JLabel attribut3Name = new JLabel("Attribut 3 :");
		GridBagConstraints gbcAttribut3Name = new GridBagConstraints();
		gbcAttribut3Name.insets = new Insets(0, 0, 5, 5);
		gbcAttribut3Name.gridx = 0;
		gbcAttribut3Name.gridy = 8;
		this.add(attribut3Name, gbcAttribut3Name);
	
		JLabel valAtt3 = new JLabel("Valeur 3");
		GridBagConstraints gbcValAtt3 = new GridBagConstraints();
		gbcValAtt3.insets = new Insets(0, 0, 5, 0);
		gbcValAtt3.gridx = 1;
		gbcValAtt3.gridy = 8;
		this.add(valAtt3, gbcValAtt3);
	
		JLabel attribut4Name = new JLabel("Attribut 4 :");
		GridBagConstraints gbcAttribut4Name = new GridBagConstraints();
		gbcAttribut4Name.insets = new Insets(0, 0, 5, 5);
		gbcAttribut4Name.gridx = 0;
		gbcAttribut4Name.gridy = 9;
		this.add(attribut4Name, gbcAttribut4Name);
	
		JLabel valAtt4 = new JLabel("Valeur 4");
		GridBagConstraints gbcValAtt4 = new GridBagConstraints();
		gbcValAtt4.insets = new Insets(0, 0, 5, 0);
		gbcValAtt4.gridx = 1;
		gbcValAtt4.gridy = 9;
		this.add(valAtt4, gbcValAtt4);
	
		JLabel attribut5Name = new JLabel("Attribut 5 :");
		GridBagConstraints gbcAttribut5Name = new GridBagConstraints();
		gbcAttribut5Name.insets = new Insets(0, 0, 5, 5);
		gbcAttribut5Name.gridx = 0;
		gbcAttribut5Name.gridy = 10;
		this.add(attribut5Name, gbcAttribut5Name);
	
		JLabel valAtt5 = new JLabel("valeur 5");
		GridBagConstraints gbcValAtt5 = new GridBagConstraints();
		gbcValAtt5.insets = new Insets(0, 0, 5, 0);
		gbcValAtt5.gridx = 1;
		gbcValAtt5.gridy = 10;
		this.add(valAtt5, gbcValAtt5);
	
		JLabel attribut6Name = new JLabel("Attribut 6 :");
		GridBagConstraints gbcAttribut6Name = new GridBagConstraints();
		gbcAttribut6Name.insets = new Insets(0, 0, 5, 5);
		gbcAttribut6Name.gridx = 0;
		gbcAttribut6Name.gridy = 11;
		this.add(attribut6Name, gbcAttribut6Name);
	
		JLabel valAtt6 = new JLabel("valeur 6");
		GridBagConstraints gbcValAtt6 = new GridBagConstraints();
		gbcValAtt6.insets = new Insets(0, 0, 5, 0);
		gbcValAtt6.gridx = 1;
		gbcValAtt6.gridy = 11;
		this.add(valAtt6, gbcValAtt6);
	
		JLabel attribut7Name = new JLabel("Attribut 7 :");
		GridBagConstraints gbcAttribut7Name = new GridBagConstraints();
		gbcAttribut7Name.insets = new Insets(0, 0, 5, 5);
		gbcAttribut7Name.gridx = 0;
		gbcAttribut7Name.gridy = 12;
		this.add(attribut7Name, gbcAttribut7Name);
	
		JLabel valAtt7 = new JLabel("valeur 7");
		GridBagConstraints gbcValAtt7 = new GridBagConstraints();
		gbcValAtt7.insets = new Insets(0, 0, 5, 0);
		gbcValAtt7.gridx = 1;
		gbcValAtt7.gridy = 12;
		this.add(valAtt7, gbcValAtt7);
	
		JLabel attribut8Name = new JLabel("Attribut 8 :");
		GridBagConstraints gbcAttribut8Name = new GridBagConstraints();
		gbcAttribut8Name.insets = new Insets(0, 0, 0, 5);
		gbcAttribut8Name.gridx = 0;
		gbcAttribut8Name.gridy = 13;
		this.add(attribut8Name, gbcAttribut8Name);
	
		JLabel valAtt8 = new JLabel("valeur 8");
		GridBagConstraints gbcValAtt8 = new GridBagConstraints();
		gbcValAtt8.gridx = 1;
		gbcValAtt8.gridy = 13;
		this.add(valAtt8, gbcValAtt8);
	}
}
