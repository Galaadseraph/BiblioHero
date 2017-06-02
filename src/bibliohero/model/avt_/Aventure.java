package bibliohero.model.avt_;

public class Aventure {

	private int idaventure;
	private String nom;
	private String auteur;
	private String isbnseries;
	private String synopsis;
	private String classeRequise;
	private String version;
	private String theme;
	private String isbnAventure;
	private int nbParagraphe;
	private int nvRequis;
	
	private boolean dictionnaire;

	
	@Override
	public String toString() {
		return "Aventure [idaventure=" + idaventure + ", nom=" + nom + ", auteur=" + auteur + ", isbnseries="
				+ isbnseries + ", synopsis=" + synopsis + ", classeRequise=" + classeRequise + ", version=" + version
				+ ", codeTheme=" + theme + ", isbnAventure=" + isbnAventure + ", nbParagraphe=" + nbParagraphe
				+ ", nvRequis=" + nvRequis + ", dictionnaire=" + dictionnaire + "]";
	}

	public int getIdaventure() {
		return idaventure;
	}

	public void setIdaventure(int idaventure) {
		this.idaventure = idaventure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbnseries() {
		return isbnseries;
	}

	public void setIsbnseries(String isbnseries) {
		this.isbnseries = isbnseries;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getClasseRequise() {
		return classeRequise;
	}

	public void setClasseRequise(String classeRequise) {
		this.classeRequise = classeRequise;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTheme() {
		return theme;
	}

	public void setCodeTheme(String theme) {
		this.theme = theme;
	}

	public String getIsbnAventure() {
		return isbnAventure;
	}

	public void setIsbnAventure(String isbnAventure) {
		this.isbnAventure = isbnAventure;
	}

	public int getNbParagraphe() {
		return nbParagraphe;
	}

	public void setNbParagraphe(int nbParagraphe) {
		this.nbParagraphe = nbParagraphe;
	}

	public int getNvRequis() {
		return nvRequis;
	}

	public void setNvRequis(int nvRequis) {
		this.nvRequis = nvRequis;
	}

	public boolean isDictionnaire() {
		return dictionnaire;
	}

	public void setDictionnaire(boolean dictionnaire) {
		this.dictionnaire = dictionnaire;
	}
	
	
	
		
}
