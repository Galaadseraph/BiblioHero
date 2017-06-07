package bibliohero.model.pers_;

public class TypeClasse
{	
	private int idTypeClasse;
	private String codeClasse;
	private String nomClasse;
	
	

	@Override
	public String toString() {
		return "TypeClasse [idTypeClasse=" + idTypeClasse + ", codeClasse=" + codeClasse + ", nomClasse=" + nomClasse
				+ "]";
	}
	
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
