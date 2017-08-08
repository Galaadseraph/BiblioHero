package bibliohero.controller;

/**
 * Les différents types d'interface utilisateur
 * Created by Guillaume J. on 08/08/17.
 */
public enum EnumUISource {

    // Enum Values
    DESKTOP_CUI     ("Client lourd Desktop - CUI"),
    DESKTOP_GUI     ("Client lourd Desktop - GUI"),
    MOBILE_GUI      ("Client lourd Mobile - GUI");

    // Attributes

    private String description;

    // Constructor

    EnumUISource (String description)
    {
        this.description = description;
    }

}
