package bibliohero.controller;

import bibliohero.ihm.consoletest.KeyValue;
import bibliohero.ihm.consoletest.cuiAdventure;
import bibliohero.ihm.consoletest.cuiGame;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Moteur du jeu d'aventure
 * Gestion du séquencement des paragraphes de l'histoire, des règles de gestion, des évenments de l'interface utilisateur,
 * et des combats
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class AdventureEngine  implements Observer {

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

        // TODO : Pour le test Seulement
        ArrayList<String> actionList = new ArrayList<>();
        actionList.add("Combattre le Gobelin");
        actionList.add("Manger tranquillement");
        actionList.add("Refaitre ses lacets");
        ArrayList<String> optionList = new ArrayList<>();
        optionList.add("Paramètres");
        optionList.add("Personnage");
        optionList.add("Equipement");
        optionList.add("Contexte");

        // Affichage de l'écran d'aventure
        cuiAdventure.getInstance().displayGame("Ceci est le premier paragraphe", actionList, optionList);

    }


    //region Evt from UI

    // On écoute les événements issus de l'interface utilisateur (via Observable)

    @Override
    public void update(Observable observable, Object o) {
        // Events provenants de la UI
        // Test
        System.out.println("Event reçu de la UI (Aventure)");

        if(observable instanceof cuiAdventure){
            // On vérifie qu'il s'agisse bien d'un objet KeyValue qui est transmit.
            if (o instanceof KeyValue) {
                // TODO : Créer un Enum pour lister tous les types d'écran.
                // On vérifie la provenance de source (Ecran)
                switch (((KeyValue<String, String>) o).getKey()) {
                    case "CUI_ADVENTURE_ACTION_CHOICE":
                        System.out.println("Event reçu de la UI (Aventure) : " + ((KeyValue) o).getValue());
                        // TODO :

                        // On "switch" d'écran
                        // TODO : Utiliser des ENUM
                        switch (((KeyValue<String, String>) o).getValue()) {
                            // -> JOUER
                            case "1":
                                System.out.println(" -> JOUER");
                                // On lance le moteur d'aventure
                                AdventureEngine.getInstance().run();
                                break;
                            // -> CONTINUER
                            case "2":
                                System.out.println(" -> JOUER");
                                break;
                            // -> GESTION
                            case "3":
                                System.out.println(" -> GESTION");
                                break;
                            // -> SAUVEGARDER
                            case "4":
                                System.out.println(" -> SAUVEGARDER");
                                break;
                            // -> IMPORTER
                            case "5":
                                System.out.println(" -> IMPORTER");
                                break;
                            // -> PARAMETRES
                            case "6":
                                System.out.println(" -> PARAMETRES");
                                break;
                        }

                        break;
                    case "CUI_ADVENTURE_OPTION_CHOICE":
                        System.out.println("Event reçu de la UI (Aventure) : " + ((KeyValue) o).getValue());
                        break;
                }

            }
        }
    }

    //endregion
}
