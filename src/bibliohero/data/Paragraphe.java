package bibliohero.data;

/**
 *
 * @author arnaud
 */
public class Paragraphe 
{
	//Region Proprietes
    // <editor-fold defaultstate="collapsed" desc="Propriétés">
    short identifiant;
    String Histoire;
    char NbEvent;
    Evenement[] ListeEvenenement = new Evenement[NbEvent];
    // </editor-fold>
    //EndRegion
}
