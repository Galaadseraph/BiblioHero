package bibliohero.Data;

/**
 *
 * @author arnaud
 * Classe de personnage Joueurs et non joueurs
 */
public class Personnage 
{
	//Region Proprietes
    // <editor-fold defaultstate="collapsed" desc="Attributs">

    String Nom;
    String Classe;
    String Genre;
    String Race;
    enum Sexe {Male, Female, Herma, CuntB, DickG}
    short PV;
    char Niveau;
    long expA;
    long expV;
    float Fiducie;
    char[] Caracteristique = new char[8];
    char[] Modificateur = new char[8];
    long Experience;
    String Background;
    // </editor-fold>
    //EndRegion
}
