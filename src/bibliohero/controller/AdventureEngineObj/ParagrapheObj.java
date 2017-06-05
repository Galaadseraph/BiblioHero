package bibliohero.controller.AdventureEngineObj;

import bibliohero.model.avt_.Action;
import bibliohero.model.avt_.Paragraphe;

import java.util.ArrayList;

/**
 * Objet Paragraphe associé à l'aventure
 * -> Utilisé par le moteur d'aventure
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public class ParagrapheObj extends Paragraphe {

    // Attributes
    ArrayList<Action> actionList;   // Liste des actions liées au paragraphe

    // Getter/Setter

    public ArrayList<Action> getActionList() {
        return actionList;
    }

    public void setActionList(ArrayList<Action> actionList) {
        this.actionList = actionList;
    }

    // Constructor
    public ParagrapheObj()
    {
        // Instantiation des objets
        this.actionList = new ArrayList<Action>();
    }

}
