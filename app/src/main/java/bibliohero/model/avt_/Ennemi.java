package bibliohero.model.avt_;

public class Ennemi {

		private int idennemi;
		
		private String race;
		private String classe;
		private int niveau;
		private short pv;
		private short forcep;
		private short dexteritep;
		private short endurance;
		private short intelligence;
		
		
		@Override
		public String toString() {
			return "Ennemi [idennemi=" + idennemi + ", race=" + race + ", classe=" + classe + ", niveau=" + niveau
					+ ", pv=" + pv + ", forcep=" + forcep + ", dexteritep=" + dexteritep + ", endurance=" + endurance
					+ ", intelligence=" + intelligence + "]";
		}
		
		public int getIdennemi() {
			return idennemi;
		}
		public void setIdennemi(int idennemi) {
			this.idennemi = idennemi;
		}
	
		public String getRace() {
			return race;
		}

		public void setRace(String race) {
			this.race = race;
		}

		public String getClasse() {
			return classe;
		}

		public void setClasse(String classe) {
			this.classe = classe;
		}

		public int getNiveau() {
			return niveau;
		}
		public void setNiveau(int niveau) {
			this.niveau = niveau;
		}
		public short getPv() {
			return pv;
		}
		public void setPv(short pv) {
			this.pv = pv;
		}
		public short getForcep() {
			return forcep;
		}
		public void setForcep(short forcep) {
			this.forcep = forcep;
		}
		public short getDexteritep() {
			return dexteritep;
		}
		public void setDexteritep(short dexteritep) {
			this.dexteritep = dexteritep;
		}
		public short getEndurance() {
			return endurance;
		}
		public void setEndurance(short endurance) {
			this.endurance = endurance;
		}
		public short getIntelligence() {
			return intelligence;
		}
		public void setIntelligence(short intelligence) {
			this.intelligence = intelligence;
		}
		
		
		
		
}
