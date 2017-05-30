package bibliohero.model;

public class TypeClasse
{	
	private int idTypeClasse;
	private String codeClasse;
	private String nomClasse;
	
	

	public int getIdTypeClasse() {
		return idTypeClasse;
	}
	public void setIdTypeClasse(int idTypeClasse) {
		this.idTypeClasse = idTypeClasse;
	}
	
	public String getCodeClasse() { return codeClasse; }
	public String getNomClasse() { return nomClasse; }

	public void setCodeClasse(String codeClasse) { this.codeClasse = codeClasse; }
	public void setNomClasse(String nomClasse) { this.nomClasse = nomClasse; }
}
