package bibliohero.model.pers_;

public class TypeInventaire {

		private int idTypeInventaire;
		private String code;
		private String nom;
		
		
		@Override
		public String toString() {
			return "TypeInventaire [idTypeInventaire=" + idTypeInventaire + ", code=" + code + ", nom=" + nom + "]";
		}
		
		public int getIdTypeInventaire() {
			return idTypeInventaire;
		}
		public void setIdTypeInventaire(int idTypeInventaire) {
			this.idTypeInventaire = idTypeInventaire;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
}
