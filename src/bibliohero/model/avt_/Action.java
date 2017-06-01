package bibliohero.model.avt_;

public class Action {

	private int idAction;
	private int typeAction;
	private int paragrapheSuite;
	
	private String effet;
	private String description;
	private String codeCombat;
	
	
	@Override
	public String toString() {
		return "Action [idAction=" + idAction + ", typeAction=" + typeAction + ", paragrapheSuite=" + paragrapheSuite
				+ ", effet=" + effet + ", description=" + description + ", codeCombat=" + codeCombat + "]";
	}
	
	public int getIdAction() {
		return idAction;
	}
	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}
	public int getTypeAction() {
		return typeAction;
	}
	public void setTypeAction(int typeAction) {
		this.typeAction = typeAction;
	}
	public int getParagrapheSuite() {
		return paragrapheSuite;
	}
	public void setParagrapheSuite(int paragrapheSuite) {
		this.paragrapheSuite = paragrapheSuite;
	}
	public String getEffet() {
		return effet;
	}
	public void setEffet(String effet) {
		this.effet = effet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCodeCombat() {
		return codeCombat;
	}
	public void setCodeCombat(String codeCombat) {
		this.codeCombat = codeCombat;
	}
	
	
	
}	
