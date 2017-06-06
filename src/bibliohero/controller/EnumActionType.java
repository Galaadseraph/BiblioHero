package bibliohero.controller;

/**
 * Liste des types d'action
 * Ces informations sont NORMALEMENT issues de la base de données
 * Cet ENUM est utilisé pour les test (Alpha Version)
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public enum EnumActionType {

    // Enum Values
    paraSuivant         ("0", "Paragraphe suivant"),
    testPassageSnippet  ("1", "Test de passage snippet"),
    combat              ("2", "Combat"),
    todo                ("3", "ToDo"),
    template            ("4", "Template (comming soon)"),
    ajoutObj            ("5", "Ajout objet"),
    avtFille            ("6", "Accès aventure fille"),
    avtMere             ("7", "Accès aventure mère");

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
    EnumActionType(String code, String nom){
        this.code = code;
        this.nom = nom;
    }

}
