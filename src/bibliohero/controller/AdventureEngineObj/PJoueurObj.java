package bibliohero.controller.AdventureEngineObj;

import bibliohero.model.pers_.*;

/**
 * Le personnage du joueur qui est utilisé dans l'aventure
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public class PJoueurObj extends Personnage {

    //region Attributes

    // Attributs complémentaires
    private Equipe equipe;              // Equipe dont fait partie le personnage

    private TypeGenre genre;            // Genre du personnage
    private TypeSexe sexe;              // Sexe du personnage

    private TypeRace race;              // Race du personnage
    private TypeClasse classe;          // Classe du personnage

    // Attributs modifiables pendant la vie du personnage
    private PJPCTemporaire perso_tmp;   // utilisé pour stocker les paramètres variables du personnage (issue de la classe Personnage)

    //endregion

}
