package bibliohero.model.avt_;

public class Action {

	private int idAction;
	private int paragrapheSuite;
	
	private String codeTypeAction; //Terme adéquat : codeTypeAction
	private String effet;
	private String description;
	private String codeCombat;
	
	
	@Override
	public String toString() {
		return "Action [idAction=" + idAction + ", typeAction=" + codeTypeAction + ", paragrapheSuite=" + paragrapheSuite
				+ ", effet=" + effet + ", description=" + description + ", codeCombat=" + codeCombat + "]";
	}
	
	public int getIdAction() {
		return idAction;
	}
	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}
	public String getCodeTypeAction() {
		return codeTypeAction;
	}

	public void setCodeAction(String codeAction) {
		this.codeTypeAction = codeAction;
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
