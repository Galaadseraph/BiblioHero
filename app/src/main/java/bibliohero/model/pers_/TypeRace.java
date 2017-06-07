package bibliohero.model.pers_;

public class TypeRace
{
	private int idTypeRace;
	private String codeRace;
	private String nomRace;
	
	
	
	
	@Override
	public String toString() {
		return "TypeRace [idTypeRace=" + idTypeRace + ", codeRace=" + codeRace + ", nomRace=" + nomRace + "]";
	}
	
	public int getIdTypeRace() {
		return idTypeRace;
	}
	public void setIdTypeRace(int idTypeRace) {
		this.idTypeRace = idTypeRace;
	}
	public String getCodeRace() {
		return codeRace;
	}
	public void setCodeRace(String codeRace) {
		this.codeRace = codeRace;
	}
	public String getNomRace() {
		return nomRace;
	}
	public void setNomRace(String nomRace) {
		this.nomRace = nomRace;
	}

	
}
