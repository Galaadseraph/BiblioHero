package bibliohero.model;

public class Inventaire {

		private int idInventaire;
		private String typeInventaire;
		private String nom;
		private int nbEmplacement;
		private int idPersonnage;
		
		
		public int getIdInventaire() {
			return idInventaire;
		}
		public void setIdInventaire(int idInventaire) {
			this.idInventaire = idInventaire;
		}
		public String getTypeInventaire() {
			return typeInventaire;
		}
		public void setTypeInventaire(String typeInventaire) {
			this.typeInventaire = typeInventaire;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getNbEmplacement() {
			return nbEmplacement;
		}
		public void setNbEmplacement(int nbEmplacement) {
			this.nbEmplacement = nbEmplacement;
		}
		public int getIdPersonnage() {
			return idPersonnage;
		}
		public void setIdPersonnage(int idPersonnage) {
			this.idPersonnage = idPersonnage;
		}
		
		
}
