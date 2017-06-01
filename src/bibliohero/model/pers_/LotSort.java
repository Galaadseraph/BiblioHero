package bibliohero.model.pers_;

public class LotSort {
		
	private int idLotSort;
	private String codeLot;
	private String nom;
	
	
	
	@Override
	public String toString() {
		return "LotSort [idLotSort=" + idLotSort + ", codeLot=" + codeLot + ", nom=" + nom + "]";
	}
	public int getIdLotSort() {
		return idLotSort;
	}
	public void setIdLotSort(int idLotSort) {
		this.idLotSort = idLotSort;
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
