package bibliohero.model.pers_;

public class Equipement {


	private int idEquipement;
	private String nomEquipement;
	private String classeEquipement;
	private String description;
	private String classeRequise;
	private String attribut1;
	private String attribut2;
	private String attribut3;
	private String codeLot;
	private String codeEquipement;
	private int niveau;
	
	
	
	@Override
	public String toString() {
		return "Equipement [idEquipement=" + idEquipement + ", nomEquipement=" + nomEquipement + ", classeEquipement="
				+ classeEquipement + ", description=" + description + ", classeRequise=" + classeRequise
				+ ", attribut1=" + attribut1 + ", attribut2=" + attribut2 + ", attribut3=" + attribut3 + ", codeLot="
				+ codeLot + ", codeEquipement=" + codeEquipement + ", niveau=" + niveau + "]";
	}
	public String getCodeEquipement() {
		return codeEquipement;
	}
	public void setCodeEquipement(String codeEquipement) {
		this.codeEquipement = codeEquipement;
	}
	public int getIdEquipement() {
		return idEquipement;
	}
	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}
	public String getNomEquipement() {
		return nomEquipement;
	}
	public void setNomEquipement(String nomEquipement) {
		this.nomEquipement = nomEquipement;
	}
	public String getClasseEquipement() {
		return classeEquipement;
	}
	public void setClasseEquipement(String classeEquipement) {
		this.classeEquipement = classeEquipement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClasseRequise() {
		return classeRequise;
	}
	public void setClasseRequise(String classeRequise) {
		this.classeRequise = classeRequise;
	}
	public String getAttribut1() {
		return attribut1;
	}
	public void setAttribut1(String attribut1) {
		this.attribut1 = attribut1;
	}
	public String getAttribut2() {
		return attribut2;
	}
	public void setAttribut2(String attribut2) {
		this.attribut2 = attribut2;
	}
	public String getAttribut3() {
		return attribut3;
	}
	public void setAttribut3(String attribut3) {
		this.attribut3 = attribut3;
	}
	public String getCodeLot() {
		return codeLot;
	}
	public void setCodeLot(String codeLot) {
		this.codeLot = codeLot;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	
}
