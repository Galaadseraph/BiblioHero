package bibliohero.ihm.consoletest;

import java.util.Observable;
import java.util.Scanner;

/**
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class cuiGame extends Observable {

    //region Singleton

    // Instance Controller
    private static cuiGame ourInstance;

    // Accès à l'instance Controller (+ création de l'instance si elle n'existe pas)
    public static cuiGame getInstance() {
        if (ourInstance == null)
            ourInstance = new cuiGame();
        return ourInstance;
    }

    // Constructeur
    private cuiGame() {

    }

    //endregion

    /**
     * Affichage du menu principal
     */
    public void displayMainMenu()
    {
        // Test
        // System.out.println("Bonjour à tous");
        // TODO : (1) Display Menu
        System.out.println("MENU PRINCIPAL");
        System.out.println("(1) JOUER");
        System.out.println("(2) CONTINUER");
        System.out.println("(3) GESTION");
        System.out.println("(4) SAUVEGARDER");
        System.out.println("(5) IMPORTER");
        System.out.println("(6) PARAMETRES");

        // TODO : (2) Get user choice
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        // Test
        System.out.println("Vous avez saisi : " + choice);

        // TODO : (3) Notify user choice to the game Engine
        KeyValue eventObj = new KeyValue("CUI_GAME_MAINMENU_CHOICE" , String.valueOf(choice));
        setChanged();
        notifyObservers(eventObj);

    }

}
