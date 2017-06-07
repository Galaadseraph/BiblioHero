package bibliohero.model.lot_;

public class LotEquipementReserve {

	private int idlotequipement;
	private String codeLot;
	private String nom;
	
	
	
	@Override
	public String toString() {
		return "LotEquipementReserve [idlotequipement=" + idlotequipement + ", codeLot=" + codeLot + ", nom=" + nom + "]";
	}
	public int getIdlotequipement() {
		return idlotequipement;
	}
	public void setIdlotequipement(int idlotequipement) {
		this.idlotequipement = idlotequipement;
	}
	public String getCodeLot() {
		return codeLot;
	}
	public void setCodeLot(String codeLot) {
		this.codeLot = codeLot;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
