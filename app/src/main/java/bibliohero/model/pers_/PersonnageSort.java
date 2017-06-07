package bibliohero.model.pers_;

public class PersonnageSort {

		
		private int idInventaire;
		private int idSort;
		
		
		
		@Override
		public String toString() {
			return "PersonnageSort [idInventaire=" + idInventaire + ", idSort=" + idSort + "]";
		}
		public int getIdInventaire() {
			return idInventaire;
		}
		public void setIdInventaire(int idInventaire) {
			this.idInventaire = idInventaire;
		}
		public int getIdSort() {
			return idSort;
		}
		public void setIdSort(int idSort) {
			this.idSort = idSort;
		}
		
		
}
