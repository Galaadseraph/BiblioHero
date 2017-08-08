package bibliohero.controller;

/**
 * Liste des Ecrans de l'Interface Utilisateur (UI)
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public enum EnumCuiScreenType {

    // Code (Lettre 1) : [C]UI, [S]WING, [A]NDROID
    // Code (Lettre 2) : [G]ame, [A]dventure
    // Code (Lettre 3/4) : TBD

    /* (1) CUI */

    CUI_GAME_MAINMENU_CHOICE    ("CG_MM", "CUI - Jeu - Menu Principal - Choix"),
    CUI_GAME_TODO_CHOICE        ("CG_", ""),

    CUI_ADVENTURE_PARAGRAPHE        ("CA_P", "CUI - Aventure - Ecran Paragraphe"),
    CUI_ADVENTURE_ACTION_CHOICE ("CA_A", "CUI - Aventure - Action - Choix"),
    CUI_ADVENTURE_OPTION_PARAM      ("CA_O", "CUI - Aventure - Option - Paramètres"),
    CUI_ADVENTURE_OPTION_CHAR       ("CA_O", "CUI - Aventure - Option - Personnage"),
    CUI_ADVENTURE_OPTION_EQUIPMENT  ("CA_O", "CUI - Aventure - Option - Equipement"),
    CUI_ADVENTURE_OPTION_CONTEXT    ("CA_O", "CUI - Aventure - Option - Contexte");

    // Attributes
    private String code = "";
    private String nom = "";

    // Getter/Setter
    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    // Constructeur
    EnumCuiScreenType(String code, String nom){
        this .code = code;
        this .nom = nom;
    }

}
