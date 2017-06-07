package bibliohero.ihm.consoletest;

import bibliohero.controller.EnumActionType;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

/**
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class cuiAdventure extends Observable {

    //region Singleton

    // Instance Controller
    private static cuiAdventure ourInstance;

    // Accès à l'instance Controller (+ création de l'instance si elle n'existe pas)
    public static cuiAdventure getInstance() {
        if (ourInstance == null)
            ourInstance = new cuiAdventure();
        return ourInstance;
    }

    // Constructeur
    private cuiAdventure() {

    }

    //endregion

    /**
     * Affichage "Mode Aventure" -> Paragraphe
     */
    public void displayParagraphe(String paragraphe, ArrayList<String> actionList, ArrayList<String> optionList) {

        // Variables
        int idx;            // Index pour compteurs
        int actionNumMin;   // Numéro Touche Clavier Min pour une action
        int actionNumMax;
        int optionNumMin;   // Numéro Touche Clavier Min pour une option
        int optionNumMax;

        // Test
        System.out.println("*** CUI Jeu Aventure ***");

        // (1) Affichage du texte du paragraphe
        // TODO : Retour à la ligne au bout de n caractères
        System.out.println(paragraphe);

        // (2) Affichage du/des actions
        idx=1;
        System.out.print("ACTION(S) : ");
        actionNumMin = idx;
        for (String action : actionList)
        {
            System.out.print("[" + idx + "] " + action + " - ");
            idx++;
        }
        System.out.println(""); // Retour à la ligne
        actionNumMax = idx-1;

        // TODO : (3) Affichage des options (Paramètre, Personnage, Equipement, Contexte)

        System.out.print("OPTION(S) : ");
        optionNumMin = idx;
        for (String option : optionList)
        {
            System.out.print("[" + idx + "] " + option + " - ");
            idx++;
        }
        System.out.println(""); // Retour à la ligne
        optionNumMax = idx;

        //(4) Get user choice
        // TODO : Peut être factorisé
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        // Test
        System.out.println("Vous avez saisi : " + choice);

        // (5) Notify user choice to the Adventure Engine



        // Détecter s'il s'agit d'une ACTION ou d'une OPTION

        KeyValue eventObj = new KeyValue("", "");   // Intialisation d'une variable de type Clé/Valeur

        // Définition du nom de l'écran (Info nécessaire pour le Ctrl)
        eventObj.setKey("CUI_ADVENTURE_PARAGRAPHE");

        String value = "";

        // S'il s'agit d'une action
        if (choice >= actionNumMin && choice <= actionNumMax)
        {
            //eventObj.setKey("CUI_ADVENTURE_ACTION_CHOICE");
            value += "A";
            value += ",";
            value += String.valueOf(choice);
        }

        // S'il s'agit d'une option
        if (choice >= optionNumMin && choice <= optionNumMax)
        {
            //eventObj.setKey("CUI_ADVENTURE_OPTION_CHOICE");
            value += "O";
            value += ",";
            value += String.valueOf(choice - (optionNumMin - 1));
        }

        // Association de la valeur (Choix de l'utilisateur)
        eventObj.setValue(value);

        // Notification du choix de l'utilisateur au moteur d'aventure (Event)
        setChanged();
        notifyObservers(eventObj);
    }

}
