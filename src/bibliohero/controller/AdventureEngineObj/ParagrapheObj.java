package bibliohero.controller.AdventureEngineObj;

import bibliohero.model.avt_.Action;
import bibliohero.model.avt_.Paragraphe;

import java.util.ArrayList;

/**
 * Objet Paragraphe associé à l'aventure
 * -> Utilisé par le moteur d'aventure
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public class ParagrapheObj {

    // Attributes
    Paragraphe paragraphe;          // Paragraphe (Classe de base)

    ArrayList<Action> actionList;   // Liste des actions liées au paragraphe

    // Getter/Setter

    public Paragraphe getParagraphe() {
        return paragraphe;
    }

    public void setParagraphe(Paragraphe paragraphe) {
        this.paragraphe = paragraphe;
    }

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
        this.paragraphe = new Paragraphe();
        this.actionList = new ArrayList<Action>();
    }

    public ParagrapheObj(Paragraphe paragraphe)
    {
        // Instantiation des objets
        super();
        this.paragraphe = paragraphe;
    }

}
