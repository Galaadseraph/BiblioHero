package bibliohero.model.avt_;

public class ParametreAventure {

	
	private int idParametreAventure;
	private String nomVariable;
	private String valeur;
	
	
	@Override
	public String toString() {
		return "ParametreAventure [idParametreAventure=" + idParametreAventure + ", nomVariable=" + nomVariable
				+ ", valeur=" + valeur + "]";
	}
	
	public int getIdParametreAventure() {
		return idParametreAventure;
	}
	public void setIdParametreAventure(int idParametreAventure) {
		this.idParametreAventure = idParametreAventure;
	}
	public String getNomVariable() {
		return nomVariable;
	}
	public void setNomVariable(String nomVariable) {
		this.nomVariable = nomVariable;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	
}
