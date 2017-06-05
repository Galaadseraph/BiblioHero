package bibliohero.controller.AdventureEngineObj;

import bibliohero.model.pers_.*;

import java.util.ArrayList;

/**
 * Le personnage du joueur qui est utilisé dans l'aventure
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public class PJoueurObj extends Personnage {

    //region Attributes

    // Attributs complémentaires (déjà définit dans la classe de base)
    //private Equipe equipe;              // Equipe dont fait partie le personnage

    //private TypeGenre genre;            // Genre du personnage
    //private TypeSexe sexe;              // Sexe du personnage

    //private TypeRace race;              // Race du personnage
    //private TypeClasse classe;          // Classe du personnage

    // Attributs modifiables pendant la vie du personnage
    private PJPCTemporaire perso_tmp;   // utilisé pour stocker les paramètres variables du personnage (issue de la classe Personnage)
    private ArrayList<Inventaire> listeInventaire;  // Liste des inventaires du personnage.

    //endregion

    //region Getter/Setter

    public PJPCTemporaire getPerso_tmp() {
        return perso_tmp;
    }

    public void setPerso_tmp(PJPCTemporaire perso_tmp) {
        this.perso_tmp = perso_tmp;
    }

    public ArrayList<Inventaire> getListeInventaire() {
        return listeInventaire;
    }

    public void setListeInventaire(ArrayList<Inventaire> listeInventaire) {
        this.listeInventaire = listeInventaire;
    }
//endregion

}
