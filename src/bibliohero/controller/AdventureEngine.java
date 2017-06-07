package bibliohero.controller;

import bibliohero.controller.AdventureEngineObj.AventureObj;
import bibliohero.controller.AdventureEngineObj.PJoueurObj;
import bibliohero.controller.AdventureEngineObj.ParagrapheObj;
import bibliohero.ihm.consoletest.KeyValue;
import bibliohero.ihm.consoletest.cuiAdventure;
import bibliohero.model.avt_.Action;
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

    private int numParagrapheEnCours;           // Numéro du paragraphe courant
    private ParagrapheObj paragrapheEnCours;    // Paragraphe courant

    private Action actionEnCours;               // Action en cours
    private EnumActionType typeActionEnCours;   // Type de l'action en cours

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
        return SrvAdventure.getPlayer(nomJoueur);
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

        // Fait appel au service pour récupérer l'aventure en base de données.
        return SrvAdventure.getAdventure(isbnAventure);

    }

    /**
     * Lancement de l'aventure
     * @param numParagrapheEnCours
     */
    protected void runAdventure(int numParagrapheEnCours) {

        // (1) Paragraphe (Récupération du texte à afficher)

        // Récupération du paragraphe en cours à partir de l'aventure
        for (ParagrapheObj paragrapheObj : this.aventure.getParagrapheList()) {
            if ( paragrapheObj.getNumParagraphe() == numParagrapheEnCours )
            {
                this.paragrapheEnCours = paragrapheObj;
            }
        }

        // Récupération du texte du paragraphe
        String texteParagraphe = this.paragrapheEnCours.getTexte();
        // TODO : pour Test seulement (Exemple) (paragraphe et liste d'actions en dur)
        texteParagraphe = "Ceci est le premier paragraphe";


        // (2) Liste d'actions. (Récupération de la liste des actions à afficher)

        ArrayList<Action> actionList = new ArrayList<>();
        actionList = this.paragrapheEnCours.getActionList();
        // (2.a) Liste d'actions (Texte)
        ArrayList<String> actionListText = new ArrayList<>();
        // On récupère la liste des noms d'action (Champ description en base)
        for (Action action :actionList) {
            actionListText.add(action.getDescription());
        }
        // TODO : pour Test seulement (Exemple) (paragraphe et liste d'actions en dur)
        actionListText.add("Combattre le Gobelin");
        actionListText.add("Manger tranquillement");
        actionListText.add("Refaire ses lacets");


        // (3) Chargement de la liste d'options à afficher à l'écran.

        ArrayList<String> optionList = new ArrayList<>();
        // Récupération de la liste à partir d'un enum (codé en dur Aie Aie Aie -> vue avec Arnaud)
        for (EnumAdventureOptions option : EnumAdventureOptions.values()) {
            // Ajout de chaque option dans la liste
            optionList.add(option.getNom());
        }

        // (4) Affichage de l'écran d'aventure (Paragraphe + liste d'actions + liste d'options)
        // TODO : switch case en fonction du type d'affichage (CUI/SWING/Android)
        // CUI pour le test
        cuiAdventure.getInstance().displayParagraphe(texteParagraphe, actionListText, optionList);

    }

    //region Evt from UI

    // On écoute les événements issus de l'interface utilisateur (via Observable)

    @Override
    public void update(Observable observable, Object o) {
        // Events provenants de la UI
        // Test
        System.out.println("Event reçu de la UI (Aventure)");

        // Si c'est la CUI Aventure qui renvoie l'info (Choixutilisateur)
        if(observable instanceof cuiAdventure){
            // On vérifie qu'il s'agisse bien d'un objet KeyValue qui est transmit.
            if (o instanceof KeyValue) {
                // TODO : Créer un Enum pour lister tous les types d'écran.
                // On vérifie la provenance de source (Ecran)
                switch (((KeyValue<String, String>) o).getKey()) {
                    // -> Ecran PARAGRAPHE
                    case "CUI_ADVENTURE_PARAGRAPHE":

                        System.out.println("Event reçu de la UI : " + ((KeyValue<String, String>) o).getKey() + ((KeyValue) o).getValue());

                        // TODO (1) : Détermination du type de choix (Action ou Option)
                        // TODO -> utiliser des enums
                        String value = ((KeyValue<String, String>) o).getValue();

                        /* Formatage de la valeur issue d'un paragraphe : Char n°1 ([A]ction/[O]ption) + "," + Char n°2 */
                        /* ATTENTION : Une seule lettre pour le type de choix + un chiffre (Max 9) pour sa valeur */
                        /* Exemple 1 : A,1-> Choix de type Action n°1  */
                        /* Exemple 2 : O,4-> Choix de type Option n°4 (Contexte)  */

                        // Cas d'une action
                        if (value.charAt(0) == 'A')
                        {
                            // Il s'agit d'une action
                            // TODO Action : Détermination du type d'action (à partir de la liste d'action)
                            String action = value.substring(2);
                            // Action Choisit
                            this.actionEnCours = this.paragrapheEnCours.getActionList().get(Integer.parseInt(action));  // TODO Vérifier si début index = 0 (action -1)
                            // Type de l'action choisit
                            this.typeActionEnCours = EnumActionType.values()[Integer.parseInt(this.actionEnCours.getCodeAction())]; // TODO : vérifier la correspondance

                            // On "switch" d'écran en fonction du type d'action et de l'action
                            // TODO : Utiliser des ENUM
                            switch (this.typeActionEnCours) {
                                // -> paraSuivant
                                case paraSuivant:
                                    System.out.println(" -> paraSuivant");
                                    //
                                    break;
                                // -> testPassageSnippet
                                case testPassageSnippet:
                                    System.out.println(" -> testPassageSnippet");
                                    break;
                                // -> COMBAT
                                case combat:
                                    System.out.println(" -> combat");
                                    break;
                                // -> TODO
                                case todo:
                                    System.out.println(" -> todo");
                                    break;
                                // -> TEMPLATE
                                case template:
                                    System.out.println(" -> template");
                                    break;
                                // -> ajoutObj
                                case ajoutObj:
                                    System.out.println(" -> ajoutObj");
                                    break;
                                // -> avtFille
                                case avtFille:
                                    System.out.println(" -> avtFille");
                                    break;
                                // -> avtMere
                                case avtMere:
                                    System.out.println(" -> avtMere");
                                    break;
                            }

                        }

                        // Cas d'une option
                        if (value.charAt(0) == 'O')
                        {
                            // Il s'agit d'une option
                            // TODO : Détermination de l'option
                            String option = value.substring(2);

                            // On "switch" d'écran
                            // TODO : Utiliser des ENUM
                            switch (option) {
                                // -> PARAMETRE
                                case "1":
                                    System.out.println(" -> PARAMETRE");
                                    //
                                    break;
                                // -> PERSONNAGE
                                case "2":
                                    System.out.println(" -> PERSONNAGE");
                                    break;
                                // -> EQUIPEMENT
                                case "3":
                                    System.out.println(" -> EQUIPEMENT");
                                    break;
                                // -> CONTEXTE
                                case "4":
                                    System.out.println(" -> CONTEXTE");
                                    break;
                            }
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
