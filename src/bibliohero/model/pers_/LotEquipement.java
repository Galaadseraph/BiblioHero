package bibliohero.model.pers_;

public class LotEquipement {

		private int idlotequipement;
		private String codeLot;
		private String nom;
		
		
		
		@Override
		public String toString() {
			return "LotEquipement [idlotequipement=" + idlotequipement + ", codeLot=" + codeLot + ", nom=" + nom + "]";
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
