package bibliohero;

/**
 *
 * @author arnaud
 */
public class BiblioHero 
{
    static byte Erreur = 0;//permet la gestion des erreurs.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Erreur = MenuPrincipal();
        if (Erreur != 0)
        { //Afficher l'erreur du programme
        }
        //Le programme ce termine proprement
    }
    
    public static byte MenuPrincipal()
    {
        //afficher selon le paramètre définie une IHM ou la console.
        
        //si affichage IHM prédéfini et baterie faible alors passer console
        
        
        //fin du programme
        return Erreur;
    }
    
}
