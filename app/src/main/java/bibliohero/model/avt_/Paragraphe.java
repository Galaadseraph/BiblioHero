package bibliohero.model.avt_;

public class Paragraphe {

		
	private int idParagraphe;
	private String texte;
	
	private int nbEvenement;
	private int numParagraphe;
	private int idAventure;
	
	
	
	
	@Override
	public String toString() {
		return "Paragraphe [idParagraphe=" + idParagraphe + ", texte=" + texte + ", nbEvenement=" + nbEvenement
				+ ", numParagraphe=" + numParagraphe + ", idAventure=" + idAventure + "]";
	}
	
	public int getIdParagraphe() {
		return idParagraphe;
	}
	public void setIdParagraphe(int idParagraphe) {
		this.idParagraphe = idParagraphe;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public int getNbEvenement() {
		return nbEvenement;
	}
	public void setNbEvenement(int nbEvenement) {
		this.nbEvenement = nbEvenement;
	}
	public int getNumParagraphe() {
		return numParagraphe;
	}
	public void setNumParagraphe(int numParagraphe) {
		this.numParagraphe = numParagraphe;
	}
	public int getIdAventure() {
		return idAventure;
	}
	public void setIdAventure(int idAventure) {
		this.idAventure = idAventure;
	}
	
	
	
}
