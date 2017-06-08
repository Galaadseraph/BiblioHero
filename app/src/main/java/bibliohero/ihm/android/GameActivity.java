package bibliohero.ihm.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private TextView descrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);

        descrip = (TextView)findViewById(R.id.descrip);
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

    }

    //Affiche les infos du paragraphe dans l'onglet histoire
    public void InitAventure()
    {
        
    }
}
