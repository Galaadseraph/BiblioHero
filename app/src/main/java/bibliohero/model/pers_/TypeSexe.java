package bibliohero.model.pers_;

public class TypeSexe
{
	private int idTypeSexe;
	private String codeSexe;
	private String nomSexe;

	
	
	@Override
	public String toString() {
		return "TypeSexe [idTypeSexe=" + idTypeSexe + ", codeSexe=" + codeSexe + ", nomSexe=" + nomSexe + "]";
	}
	
	
	public int getIdTypeSexe() {
		return idTypeSexe;
	}
	public void setIdTypeSexe(int idTypeSexe) {
		this.idTypeSexe = idTypeSexe;
	}
	public String getCodeSexe() { return codeSexe; }
	public String getNomSexe() { return nomSexe; }

	public void setCodeSexe(String codeSexe) { this.codeSexe = codeSexe; }
	public void setNomSexe(String nomSexe) { this.nomSexe = nomSexe; }
}
