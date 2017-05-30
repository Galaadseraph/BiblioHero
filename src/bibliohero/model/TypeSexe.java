package bibliohero.model;

public class TypeSexe
{
	private int idTypeSexe;
	private String codeSexe;
	private String nomSexe;

	
	
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
