package bibliohero.model.avt_;

public class TypeRaceEnnemi {

		private int idTypeRace;
		private String codeRace;
		private String nom;
		
		
		@Override
		public String toString() {
			return "TypeRaceEnnemi [idTypeRace=" + idTypeRace + ", codeRace=" + codeRace + ", nom=" + nom + "]";
		}
		
		public int getIdTypeRace() {
			return idTypeRace;
		}
		public void setIdTypeRace(int idTypeRace) {
			this.idTypeRace = idTypeRace;
		}
		public String getCodeRace() {
			return codeRace;
		}
		public void setCodeRace(String codeRace) {
			this.codeRace = codeRace;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
}
