package bibliohero.model.avt_;

public class Combat {

	private int idCombat;
	private String codeCombat;
	
	
	@Override
	public String toString() {
		return "Combat [idCombat=" + idCombat + ", codeCombat=" + codeCombat + "]";
	}
	
	public int getIdCombat() {
		return idCombat;
	}
	public void setIdCombat(int idCombat) {
		this.idCombat = idCombat;
	}
	public String getCodeCombat() {
		return codeCombat;
	}
	public void setCodeCombat(String codeCombat) {
		this.codeCombat = codeCombat;
	}
	
	
	
}
