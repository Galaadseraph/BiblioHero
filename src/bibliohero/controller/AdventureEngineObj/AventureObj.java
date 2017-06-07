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
public class AventureObj extends Aventure {

    // Attributes
    List<ParagrapheObj> paragrapheList;    // Liste des paragraphes associés à l'aventure

    // Getter/Setter
    public List<ParagrapheObj> getParagrapheList() {
        return paragrapheList;
    }

    public void setParagrapheList(List<ParagrapheObj> paragrapheList) {
        this.paragrapheList = paragrapheList;
    }

    // Constructor
    public AventureObj(){
        // Instantiation des objets
        this.paragrapheList = new ArrayList<ParagrapheObj>();
    }

}
