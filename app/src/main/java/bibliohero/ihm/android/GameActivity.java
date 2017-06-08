package bibliohero.ihm.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import bibliohero.dao.request.avt_.ActionDao;
import bibliohero.dao.request.avt_.ParagrapheDao;
import bibliohero.dao.request.pers_.PersonnageDao;
import bibliohero.model.avt_.Action;
import bibliohero.model.avt_.Paragraphe;
import bibliohero.model.pers_.Personnage;

public class GameActivity extends AppCompatActivity {

    private Personnage joueur;
    private PersonnageDao persodao;

    private Paragraphe parag;
    private ParagrapheDao paragdao;
    private ActionDao adao;
    private Action[] actions;

    //Tab aventure
    private TextView descrip;
    private Button btnEvent1;
    private Button btnEvent2;
    private Button btnEvent3;
    private Button btnEvent4;
    private Button btnEvent5;
    private Button btnEvent6;

    //tab perso
    private TextView nomPerso;
    private TextView racePerso;
    private TextView classePerso;
    private TextView sexePerso;
    private TextView genrePerso;
    private TextView attr1Perso;
    private TextView attr2Perso;
    private TextView attr3Perso;
    private TextView attr4Perso;
    private TextView attr5Perso;
    private TextView attr6Perso;
    private TextView attr7Perso;
    private TextView niveauPerso;
    private TextView expPerso;
    private ProgressBar barreVie;
    private TextView barreVieText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);

        //TabHistoire
        descrip = (TextView)findViewById(R.id.descrip);
        btnEvent1 = (Button) findViewById(R.id.event1);
        btnEvent2 = (Button) findViewById(R.id.event2);
        btnEvent3 = (Button) findViewById(R.id.event3);
        btnEvent4 = (Button) findViewById(R.id.event4);
        btnEvent5 = (Button) findViewById(R.id.event5);
        btnEvent6 = (Button) findViewById(R.id.event6);

        //tabPerso
        nomPerso = (TextView) findViewById(R.id.nomPerso);
        niveauPerso = (TextView) findViewById(R.id.NiveauPerso);
        expPerso = (TextView) findViewById(R.id.ExpPerso);
        racePerso = (TextView) findViewById(R.id.RacePerso);
        classePerso = (TextView) findViewById(R.id.ClassePerso);
        sexePerso = (TextView) findViewById(R.id.SexePerso);
        genrePerso = (TextView) findViewById(R.id.GenrePerso);
        attr1Perso = (TextView) findViewById(R.id.ForcePerso);
        attr2Perso = (TextView) findViewById(R.id.DexteritePerso);
        attr3Perso = (TextView) findViewById(R.id.EndurancePerso);
        attr4Perso = (TextView) findViewById(R.id.IntelligencePerso);
        attr5Perso = (TextView) findViewById(R.id.MoralPerso);
        barreVie = (ProgressBar) findViewById(R.id.barreVie);
        barreVieText = (TextView) findViewById(R.id.barreVieText);

        //tabequipement


    }

    public void btnPersoClick(View v)
    {
        Button b = (Button)this.findViewById(R.id.buttonperso);
        if (b.getText()=="Personnage")
        {
            b.setText("Histoire");
            this.findViewById(R.id.TabPersonnage).setVisibility(View.VISIBLE);
            this.findViewById(R.id.TabHistoire).setVisibility(View.GONE);
            this.findViewById(R.id.TabEquip).setVisibility(View.GONE);
        }
        else
        {
            b.setText("Personnage");
            this.findViewById(R.id.TabPersonnage).setVisibility(View.GONE);
            this.findViewById(R.id.TabHistoire).setVisibility(View.VISIBLE);
            this.findViewById(R.id.TabEquip).setVisibility(View.GONE);
        }
    }

    public void btnEquipementClick(View v)
    {
        Button b = (Button)this.findViewById(R.id.buttonObjets);
        if (b.getText()=="Equipement")
        {
            b.setText("Histoire");
            this.findViewById(R.id.TabPersonnage).setVisibility(View.GONE);
            this.findViewById(R.id.TabHistoire).setVisibility(View.GONE);
            this.findViewById(R.id.TabEquip).setVisibility(View.VISIBLE);
        }
        else
        {
            b.setText("Equipement");
            this.findViewById(R.id.TabPersonnage).setVisibility(View.GONE);
            this.findViewById(R.id.TabHistoire).setVisibility(View.VISIBLE);
            this.findViewById(R.id.TabEquip).setVisibility(View.GONE);
        }
    }

    //Affiche les infos du personnage dans l'onglet personnage
    public void initPerso()
    {
        nomPerso.setText(Globales.pj.getNom());
        niveauPerso.setText(Globales.pj.getNiveau());
        expPerso.setText(Globales.pj.getExperience() + " exp");
        racePerso.setText(Globales.pj.getRace());
        classePerso.setText(Globales.pj.getClasse());
        sexePerso.setText(Globales.pj.getSexe());
        genrePerso.setText(Globales.pj.getGenre());
        attr1Perso.setText(Globales.pj.getForce());
        attr2Perso.setText(Globales.pj.getDexterite());
        attr3Perso.setText(Globales.pj.getEndurance());
        attr4Perso.setText(Globales.pj.getIntelligence());
        attr5Perso.setText(Globales.pj.getMoral());
        barreVie.setMax(Globales.pj.getPvMAx());
        barreVie.setProgress(Globales.pj.getPvActu());
        barreVieText.setText(Globales.pj.getPvActu() + " / " + Globales.pj.getPvMAx());
        //repeindre la fenettre si besoin
    }

    //Affiche les infos du paragraphe dans l'onglet histoire
    public void InitAventure()
    {
        
    }
}
