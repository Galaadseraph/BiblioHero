package bibliohero.model.avt_;

public class Des {
		
	private int idDes;
	private int nbDeFaces;
	private String nom;
	
	
	
	@Override
	public String toString() {
		return "Des [idDes=" + idDes + ", nbDeFaces=" + nbDeFaces + ", nom=" + nom + "]";
	}
	
	public int getIdDes() {
		return idDes;
	}
	public void setIdDes(int idDes) {
		this.idDes = idDes;
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
