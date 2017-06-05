package bibliohero.controller;

import bibliohero.controller.AdventureEngineObj.AventureObj;
import bibliohero.controller.AdventureEngineObj.PJoueurObj;
import bibliohero.ihm.consoletest.KeyValue;
import bibliohero.ihm.consoletest.cuiAdventure;
import bibliohero.ihm.consoletest.cuiGame;
import bibliohero.service.SrvAdventure;

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

    // todo : Ajout du nom du joueur et de l'isbn aventure

    //endregion

    //region Attributs

    private boolean testMode;       // Test

    private String nomJoueur;       // Nom du joueur (renseigné par le moteur du jeu)
    private String isbnAventure;    // "Code" de l'aventure (renseigné par le moteur du jeu)

    private PJoueurObj joueur;      // Objet Joueur + infos temporaires + liste des inventaires.
    private AventureObj aventure;   // Objet Aventure + Paragraphes et actions associées

    private int numParagrapheEnCours;    // Numéro du paragraphe courant

    //endregion

    //region Méthodes

    /**
     * Méthode appelée dans le constructeur
     * -> initialisation
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
        // Gestion du moteur d'aventure

        // TODO : Chargement des Beans à partir de la base de donnée

        // (1) Chargement du joueur (table pers_personnage + pers_pjpctempo)
        this.joueur = loadPlayer(this.nomJoueur);

        // (2) Chargement de l'aventure sélectionnée (à partir de l'identifiant)
        // Récupération de l'identifiant de l'aventure
        this.isbnAventure = getAdventureIsbnFromBackground();
        // Chargement de l'aventure
        this.aventure = loadAdventure(this.isbnAventure);

        // (3) Lancement de l'aventure
        // Récupération du paragraphe en cours
        this.numParagrapheEnCours = getLastParagrapheFromBackground();
        // Démarrage de l'aventure
        runAdventure(this.numParagrapheEnCours);

    }

    /**
     * Chargement du joueur de l'aventure à partir de son nom
     */
    protected PJoueurObj loadPlayer(String nomJoueur) {

        // Fait appel au service pour récupérer le joueur en base de données.
        return SrvAdventure.loadPlayer(nomJoueur);
    }

    /**
     * Récupère l'identifiant de l'aventure
     */
    protected String getAdventureIsbnFromBackground() {

        // TODO : get from joueur
        //this.isbnAventure = ;
        return "isbn_nbr";

    }

    /**
     * Récupère le numéro du dernier paragraphe de l'aventure
     */
    protected int getLastParagrapheFromBackground() {

        // TODO : get from joueur
        //this.numParagrapheEnCours = ;
        return 0;

    }

    /**
     * Chargement de l'aventure
     * @param isbnAventure
     * @return
     */
    protected AventureObj loadAdventure(String isbnAventure)
    {
        //TODO Appel du service
        // On récupère le background à partir de PJPCtempo
        // Le Background permet de récupérer le numéro d'aventure et le numéro du dernier paragraphe

        // à partir du background
        // TODO : (1) Chargement de l'aventure

        // TODO : (2) Chargement des paragraphes associés à l'aventure

        // TODO : (3) Chargement des actions associées à chaque paragraphe

        // Fait appel au service pour récupérer le joueur en base de données.
        return SrvAdventure.loadAdventure(isbnAventure);

    }

    /**
     * Lancement de l'aventure
     * @param numParagrapheEnCours
     */
    protected void runAdventure(int numParagrapheEnCours) {

        // TODO : Pour le test Seulement (paragraphe et liste d'actions en dur)

        // (1) Paragraphe
        String paragraphe = "Ceci est le premier paragraphe";
        // TODO : Get Paragraphe String

        // (2) Liste d'actions.
        ArrayList<String> actionList = new ArrayList<>();
        actionList.add("Combattre le Gobelin");
        actionList.add("Manger tranquillement");
        actionList.add("Refaire ses lacets");
        // TODO : Get Paragraphe Actions

        // (3) Chargement de la liste d'options affichées à l'écran.
        ArrayList<String> optionList = new ArrayList<>();
        /*optionList.add("Paramètres");
        optionList.add("Personnage");
        optionList.add("Equipement");
        optionList.add("Contexte");*/

        for (EnumAdventureOptions option : EnumAdventureOptions.values()) {
            // Ajout de chaque option dans la liste
            optionList.add(option.getNom());
        }

        // (4) Affichage de l'écran d'aventure (Paragraphe + liste d'actions + liste d'options)
        cuiAdventure.getInstance().displayGame(paragraphe, actionList, optionList);

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
