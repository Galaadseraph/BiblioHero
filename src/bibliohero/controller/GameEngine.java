package bibliohero.controller;

import bibliohero.ihm.consoletest.cuiAdventure;
import bibliohero.ihm.consoletest.cuiGame;
import bibliohero.ihm.consoletest.KeyValue;
import bibliohero.service.SrvGame;

import java.util.Observable;
import java.util.Observer;

/**
 * Moteur du jeu principal
 * Gestion des paramètres, des personnages, des équipements, des aventures, des sauvegardes, etc.
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class GameEngine implements Observer {

    //region Singleton

    // Instance Controller
    private static GameEngine ourInstance;

    // Accès à l'instance Controller (+ création de l'instance si elle n'existe pas)
    public static GameEngine getInstance() {
        if (ourInstance == null)
            ourInstance = new GameEngine();
        return ourInstance;
    }

    // Constructeur
    private GameEngine() {

        // Mode Test
        this.testMode = true;
        // INIT
        this.init();
    }

    //endregion

    //region Attributs

    private boolean testMode;       // Test

    private String nomJoueurSelectionne;       // Nom du joueur qui a été sélectionné par l'utilisateur (via JOUER ou CONTINUER)

    //endregion

    //region Méthodes

    /**
     * Intialisation
     */
    private void init()
    {

        // Permettre au moteur du jeu d'écouter les event provenant de l'interface Utilisateur
        // TODO : Remplacer cuiGame par la CUI ou la GUI
        // Test de passage
        System.out.println("DEBUG - init - GameEngine Class");

        // Le moteur de jeu est à l'écoute des events provenant de la CUI Moteur de jeu (Principal)
        cuiGame.getInstance().addObserver(this);
        // Le moteur de l'aventure est à l'écoute des events provenant de la CUI Moteur de l'aventure
        cuiAdventure.getInstance().addObserver(AdventureEngine.getInstance());

        // TODO : Tester si 1er démarrage ou non

        // TODO : Charger les informations concernant le joueur (Dernier joueur qui a joué)

    }
    //endregion

    /**
     * execution du moteur de jeu ()
     */
    protected void run()
    {
        //TODO : Gestion du moteur de jeu

        // Tâches à réaliser
        // Affichage du Menu Principal
        displayMainMenu();
        // Si premier démarrage -> Création du joueur

        //TEST : Lancement du moteur de l'aventure
        //AdventureEngine.getInstance().run();

    }

    /**
     * Affichage du Menu principal
     */
    protected void displayMainMenu()
    {
        // TODO : Affichage du menu en mode console / Switch avec le mode Android/Swing
        cuiGame.getInstance().displayMainMenu();
    }

    //region Evt from UI

    // On écoute les événements issus de l'interface utilisateur (via Observable)

    @Override
    public void update(Observable observable, Object o) {
        // Events provenants de la UI
        // Test
        //System.out.println("Event reçu de la UI (Jeu)");

        if(observable instanceof cuiGame){
            // On vérifie qu'il s'agisse bien d'un objet KeyValue qui est transmit.
            if (o instanceof KeyValue) {
                // TODO Détection de l'écran CUI qui génère l'event
                // TODO : Créer un Enum pour lister tous les types d'écran.
                // On vérifie la provenance de source (Ecran)
                switch (((KeyValue<String, String>) o).getKey()) {
                    case "CUI_GAME_MAINMENU_CHOICE":
                        // Test
                        //System.out.println("Event reçu de la UI (Jeu) : " + ((KeyValue) o).getKey() + ((KeyValue) o).getValue());
                        // On "switch" d'écran
                        // TODO : Utiliser des ENUM
                        switch (((KeyValue<String, String>) o).getValue()) {
                            // -> JOUER
                            case "1":
                                System.out.println(" -> JOUER");
                                // Création d'un nouveau personnage + aventure mère

                                // Affectation du personnage au moteur d'aventure

                                // (2) On lance le moteur d'aventure
                                AdventureEngine.getInstance().run();
                                break;
                            // -> CONTINUER
                            case "2":
                                System.out.println(" -> CONTINUER");
                                // (1) Sélection d'un joueur parmi une liste
                                cuiGame.getInstance().displayCharList(SrvGame.getCharacterList());
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
                    case "CUI_GAME_CHAR_LIST":      // Liste des Personnages
                        // Choix du personnage pour l'aventure

                        // Test
                        System.out.println("Event reçu de la UI (Jeu) : " + ((KeyValue) o).getKey() + ((KeyValue) o).getValue());

                        // TODO : Affecter le personnage choisit au moteur d'aventure;
                        // La valeur choisit dans l'IU sert d'index pour récupérer le personnage dans la liste.
                        // Remarque : On fait appel au service 2 fois (On suppose que la liste des personnages n'a pas changé entre temps)
                        // Voir si plus judicieux de charger la liste des personnages dans le moteur de Jeu.
                        this.nomJoueurSelectionne = SrvGame.getCharacterList().get(((KeyValue<String, Integer>) o).getValue()-1).getNom();

                        // Affectation du personnage préalablement sélectionné au moteur d'aventure
                        AdventureEngine.getInstance().setNomJoueur(this.nomJoueurSelectionne);

                        // (2) On lance le moteur d'aventure
                        AdventureEngine.getInstance().run();

                }

            }
        }
    }

    //endregion

}
