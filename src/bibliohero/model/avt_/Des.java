package bibliohero.model.avt_;

public class Des {
		
	private int iddes;
	private int nbDeFaces;
	private String nom;
	
	
	@Override
	public String toString() {
		return "Des [iddes=" + iddes + ", nbDeFaces=" + nbDeFaces + ", nom=" + nom + "]";
	}
	
	public int getIddes() {
		return iddes;
	}
	public void setIddes(int iddes) {
		this.iddes = iddes;
	}
	public int getNbDeFaces() {
		return nbDeFaces;
	}
	public void setNbDeFaces(int nbDeFaces) {
		this.nbDeFaces = nbDeFaces;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
