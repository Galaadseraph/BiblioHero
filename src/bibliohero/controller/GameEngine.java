package bibliohero.controller;

import bibliohero.ihm.consoletest.cuiTest;
import bibliohero.ihm.consoletest.KeyValue;

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

    //endregion

    //region Méthodes

    /**
     * Intialisation
     */
    private void init()
    {

        // Permettre au moteur du jeu d'écouter les event provenant de l'interface Utilisateur
        // TODO : Remplacer cuiTest par la CUI ou la GUI
        // Test de passage
        System.out.println("init - GameEngine Class");

        cuiTest.getInstance().addObserver(this);
        // TODO : Tester si 1er démarrage ou non

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
        AdventureEngine.getInstance().run();

    }

    protected void displayMainMenu()
    {
        // TODO : Affichage du menu en mode console
        cuiTest.getInstance().displayMainMenu();
    }

    //region Evt GUI

    // On écoute les événements issus de l'interface utilisateur (via Observable)

    @Override
    public void update(Observable observable, Object o) {
        // Events provenants de la CUI
        if(observable instanceof cuiTest){
            // On vérifie qu'il s'agisse bien d'un objet KeyValue qui est transmit.
            if (o instanceof KeyValue) {
                // Détection de l'écran CUI qui génère l'event
                // TODO : Créer un Enum pour lister tous les types d'écran.
                System.out.println("Event reçu de la CUI : " + ((KeyValue) o).getValue());
            }
        }
    }

    //endregion

}
