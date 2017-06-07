package bibliohero.controller;

/**
 * Liste des options disponibles à l'écran pendant l'aventure
 * -> Utilisé dans le moteur d'aventure
 * Created by jiolle.cdi04 on 02/06/2017.
 */
public enum EnumAdventureOptions {

    // Enum Values
    Parametre         ("1", "Paramètres", "Paramètres"),
    Personnage        ("2", "Personnage", "Personnage"),
    Equipement        ("3", "Equipement", "Equipement"),
    Contexte          ("4", "Contexte", "Menu Contextuel");

    // Attributes
    private String code = "";
    private String nom = "";
    private String description = "";

    // Getter/Setter
    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    // Constructeur
    EnumAdventureOptions(String code, String nom, String description){
        this.code = code;
        this.nom = nom;
        this.description = description;
    }

}
