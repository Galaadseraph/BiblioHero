package bibliohero.model.pers_;

public class TypeGenre
{
	private int idTypeGenre;
	private String codeGenre;
	private String nomGenre;

	
	
	@Override
	public String toString() {
		return "TypeGenre [idTypeGenre=" + idTypeGenre + ", codeGenre=" + codeGenre + ", nomGenre=" + nomGenre + "]";
	}
	
	public int getIdTypeGenre() {
		return idTypeGenre;
	}
	public void setIdTypeGenre(int idTypeGenre) {
		this.idTypeGenre = idTypeGenre;
	}
	public String getCodeGenre() { return codeGenre; }
	public String getNomGenre() { return nomGenre; }

	public void setCodeGenre(String codeGenre) { this.codeGenre = codeGenre; }
	public void setNomGenre(String nomGenre) { this.nomGenre = nomGenre; }
}
