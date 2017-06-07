package bibliohero.model.avt_;

public class TypeClasseEnnemi {

	private int idTypeClasseEnnemi;
	private String codeClasse;
	private String nomClasse;
	
	
	@Override
	public String toString() {
		return "TypeClasseEnnemi [idTypeClasseEnnemi=" + idTypeClasseEnnemi + ", codeClasse=" + codeClasse
				+ ", nomClasse=" + nomClasse + "]";
	}
	
	public int getIdTypeClasseEnnemi() {
		return idTypeClasseEnnemi;
	}
	public void setIdTypeClasseEnnemi(int idTypeClasseEnnemi) {
		this.idTypeClasseEnnemi = idTypeClasseEnnemi;
	}
	public String getCodeClasse() {
		return codeClasse;
	}
	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}
	public String getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	
	
}	
