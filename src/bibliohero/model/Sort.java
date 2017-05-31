package bibliohero.model;

public class Sort {

	private int idSort;
	private int duree;
	private String nomSort;
	private String capacite;
	private String ecoleDeMagie;
	private String description;
	private String codeLot;
	
	
	
	public int getIdSort() {
		return idSort;
	}
	public void setIdSort(int idSort) {
		this.idSort = idSort;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getNomSort() {
		return nomSort;
	}
	public void setNomSort(String nomSort) {
		this.nomSort = nomSort;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public String getEcoleDeMagie() {
		return ecoleDeMagie;
	}
	public void setEcoleDeMagie(String ecoleDeMagie) {
		this.ecoleDeMagie = ecoleDeMagie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCodeLot() {
		return codeLot;
	}
	public void setCodeLot(String codeLot) {
		this.codeLot = codeLot;
	}
	
	@Override
	public String toString() {
		return "Sort [idSort=" + idSort + ", duree=" + duree + ", nomSort=" + nomSort + ", capacite=" + capacite
				+ ", ecoleDeMagie=" + ecoleDeMagie + ", description=" + description + ", codeLot=" + codeLot + "]";
	}
	
	
}
