package bibliohero.model;

public class Personnage {

	//Liste des attributs de la classe personnage
	
	int idPersonnage;
    boolean permadeath = false;
    boolean hommedefer = false;
    boolean estJoueur = false;
    boolean estActif = false;
    String nom;
    String race;
    String classe;
    String sexe;
    String genre;
    String equipe;
    double richesse;
    double experience;
    byte niveau;
    short pv;
    short force;
    short dexterite;
    short endurance;
    short intelligence;
    short moral;
    
    
    
    
	@Override
	public String toString() {
		return "Personnage [idPersonnage=" + idPersonnage + ", permadeath=" + permadeath + ", hommedefer=" + hommedefer
				+ ", estJoueur=" + estJoueur + ", estActif=" + estActif + ", nom=" + nom + ", race=" + race
				+ ", classe=" + classe + ", sexe=" + sexe + ", genre=" + genre + ", equipe=" + equipe + ", richesse="
				+ richesse + ", experience=" + experience + ", niveau=" + niveau + ", pv=" + pv + ", force=" + force
				+ ", dexterite=" + dexterite + ", endurance=" + endurance + ", intelligence=" + intelligence
				+ ", moral=" + moral + "]";
	}
	
	public int getIdPersonnage() {
		return idPersonnage;
	}
	public void setIdPersonnage(int idPersonnage) {
		this.idPersonnage = idPersonnage;
	}
	public boolean isPermadeath() {
		return permadeath;
	}
	public void setPermadeath(boolean permadeath) {
		this.permadeath = permadeath;
	}
	public boolean isHommedefer() {
		return hommedefer;
	}
	public void setHommedefer(boolean hommedefer) {
		this.hommedefer = hommedefer;
	}
	public boolean isEstActif() {
		return estActif;
	}
	public void setEstActif(boolean estActif) {
		this.estActif = estActif;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isEstJoueur() {
		return estJoueur;
	}
	public void setEstJoueur(boolean estJoueur) {
		this.estJoueur = estJoueur;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRichesse() {
		return richesse;
	}
	public void setRichesse(double richesse) {
		this.richesse = richesse;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public byte getNiveau() {
		return niveau;
	}
	public void setNiveau(byte niveau) {
		this.niveau = niveau;
	}
	public short getPv() {
		return pv;
	}
	public void setPv(short pv) {
		this.pv = pv;
	}
	public short getForce() {
		return force;
	}
	public void setForce(short force) {
		this.force = force;
	}
	public short getDexterite() {
		return dexterite;
	}
	public void setDexterite(short dexterite) {
		this.dexterite = dexterite;
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
	public short getMoral() {
		return moral;
	}
	public void setMoral(short moral) {
		this.moral = moral;
	}
    
    
}
