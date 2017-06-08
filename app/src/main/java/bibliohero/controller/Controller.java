package bibliohero.controller;

/**
 * Actuellement non utilisé (Template)
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class Controller {

    //region Singleton

    // Instance Controller
    private static Controller ourInstance;

    // Accès à l'instance Controller (+ création de l'instance si elle n'existe pas)
    public static Controller getInstance() {
        if (ourInstance == null)
            ourInstance = new Controller();
        return ourInstance;
    }

    // Constructeur
    private Controller() {

        // Mode Test
        this.testMode = true;
        // INIT
        this.init();
    }

    //endregion

    //region Attributs

    private boolean testMode;       // Test

    //endregion

    //region Méthodes

    /**
     * Intialisation
     */
    private void init()
    {

    }
    //endregion

}
