package bibliohero.model.pers_;

public class InventaireEquipement {
		
		private int idInventaireEquipement;
		private int idInventaire;
		private int idEquipement;
		
		
		
		
		@Override
		public String toString() {
			return "InventaireEquipement [idInventaireEquipement=" + idInventaireEquipement + ", idInventaire="
					+ idInventaire + ", idEquipement=" + idEquipement + "]";
		}
		public int getIdInventaireEquipement() {
			return idInventaireEquipement;
		}
		public void setIdInventaireEquipement(int idInventaireEquipement) {
			this.idInventaireEquipement = idInventaireEquipement;
		}
		public int getIdInventaire() {
			return idInventaire;
		}
		public void setIdInventaire(int idInventaire) {
			this.idInventaire = idInventaire;
		}
		public int getIdEquipement() {
			return idEquipement;
		}
		public void setIdEquipement(int idEquipement) {
			this.idEquipement = idEquipement;
		}
		
		
		
}
