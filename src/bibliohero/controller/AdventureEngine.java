package bibliohero.controller;

/**
 * Moteur du jeu d'aventure
 * Gestion du séquencement des paragraphes de l'histoire, des règles de gestion, des évenments de l'interface utilisateur,
 * et des combats
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class AdventureEngine {

    //region Singleton

    // Instance Controller
    private static AdventureEngine ourInstance;

    // Accès à l'instance Controller (+ création de l'instance si elle n'existe pas)
    public static AdventureEngine getInstance() {
        if (ourInstance == null)
            ourInstance = new AdventureEngine();
        return ourInstance;
    }

    // Constructeur
    private AdventureEngine() {

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

    /**
     * execution du moteur de jeu ()
     */
    protected void run()
    {
        //TODO : Gestion du moteur d'aventure

        // TODO : Chargement des Beans à partir de la base de donnée
        // Chargement du joueur (table pers_pjpctempo)
        //load();
        // Chargement de l'aventure sélectionnée
        loadAdventure();

    }

    protected void loadAdventure()
    {
        //TODO Appel du service
        // On récupère le background à partir de PJPCtempo


    }

}
