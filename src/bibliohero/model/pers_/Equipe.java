package bibliohero.model.pers_;

public class Equipe
{
	private int idEquipe;
	private String nomEquipe;
	private String codeEquipe;

	
	
	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", codeEquipe=" + codeEquipe + "]";
	}
	public int getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() { return nomEquipe; }
	public String getCodeEquipe() { return codeEquipe; }

	public void setNomEquipe(String nomEquipe) { this.nomEquipe = nomEquipe; }
	public void setCodeEquipe(String codeEquipe) { this.codeEquipe = codeEquipe; }
}
