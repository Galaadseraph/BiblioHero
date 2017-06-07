package bibliohero.model.lot_;

public class TypeEquipementReserve {
		
	private int idTypeEquipement;
	private String codeEquipement;
	private String nom;
	
	
	@Override
	public String toString() {
		return "TypeEquipement [idTypeEquipement=" + idTypeEquipement + ", codeEquipement=" + codeEquipement
				+ ", nom=" + nom + "]";
	}
	
	public int getIdTypeEquipement() {
		return idTypeEquipement;
	}
	public void setIdTypeEquipement(int idTypeEquipement) {
		this.idTypeEquipement = idTypeEquipement;
	}
	public String getCodeEquipement() {
		return codeEquipement;
	}
	public void setCodeEquipement(String codeEquipement) {
		this.codeEquipement = codeEquipement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
