package bibliohero.model;

public class PJPCTemporaire {

	
	private int idpersonnage;
	private double richesse;
	private double experience;
	private int pv;
	private int force;
	private int dexterite;
	private int endurance;
	private int intelligence;
	private int moral;
	private String background;
	
	
	
	@Override
	public String toString() {
		return "PJPCTemporaire [idpersonnage=" + idpersonnage + ", richesse=" + richesse + ", experience=" + experience
				+ ", pv=" + pv + ", force=" + force + ", dexterite=" + dexterite + ", endurance=" + endurance
				+ ", intelligence=" + intelligence + ", moral=" + moral + ", background=" + background + "]";
	}
	
	public int getIdpersonnage() {
		return idpersonnage;
	}
	public void setIdpersonnage(int idpersonnage) {
		this.idpersonnage = idpersonnage;
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
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getDexterite() {
		return dexterite;
	}
	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getMoral() {
		return moral;
	}
	public void setMoral(int moral) {
		this.moral = moral;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	
	
	
}
