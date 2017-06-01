package bibliohero.ihm.consoletest;

import java.util.Observable;
import java.util.Scanner;

/**
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class cuiTest extends Observable {

    //region Singleton

    // Instance Controller
    private static cuiTest ourInstance;

    // Accès à l'instance Controller (+ création de l'instance si elle n'existe pas)
    public static cuiTest getInstance() {
        if (ourInstance == null)
            ourInstance = new cuiTest();
        return ourInstance;
    }

    // Constructeur
    private cuiTest() {

    }

    //endregion


    /**
     * Affichage du menu principal
     */
    public void displayMainMenu()
    {
        // Test
        System.out.println("Bonjour à tous");
        // TODO : (1) Display Menu
        System.out.println("MENU PRINCIPAL");
        System.out.println("(1) JOUER");
        System.out.println("(2) CONTINUER");
        System.out.println("(3) GERER PERSONNAGES");
        System.out.println("(4) SAUVEGARDER");
        System.out.println("(5) IMPORTER");

        // TODO : (2) Get user choice
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        // Test
        System.out.println("Vous avez saisi : " + choice);

        // TODO : (3) Notify user choice to the game Engine
        KeyValue eventObj = new KeyValue("CUI_MAINMENU_CHOICE" , String.valueOf(choice));
        setChanged();
        notifyObservers(eventObj);

    }

}
