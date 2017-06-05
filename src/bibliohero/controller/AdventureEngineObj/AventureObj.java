package bibliohero.controller.AdventureEngineObj;

import bibliohero.model.avt_.Aventure;
import bibliohero.model.avt_.Paragraphe;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet Aventure associé au personnage
 * -> Utilisé par le moteur d'aventure
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public class AventureObj {

    // Attributes
    Aventure aventure;                  // Aventure
    List<ParagrapheObj> paragrapheList;    // Liste des paragraphes associés à l'aventure

    // Getter/Setter
    public Aventure getAventure() {
        return aventure;
    }

    public void setAventure(Aventure aventure) {
        this.aventure = aventure;
    }

    public List<ParagrapheObj> getParagrapheList() {
        return paragrapheList;
    }

    public void setParagrapheList(List<ParagrapheObj> paragrapheList) {
        this.paragrapheList = paragrapheList;
    }

    // Constructor
    public AventureObj(){
        // Instantiation des objets
        this.aventure = new Aventure();
        this.paragrapheList = new ArrayList<ParagrapheObj>();
    }

}
