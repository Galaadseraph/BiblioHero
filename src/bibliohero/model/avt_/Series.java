package bibliohero.model.avt_;

public class Series {

	private int idSeries;
	private String isbnSerie;
	private String nomSerie;
	
	
	
	@Override
	public String toString() {
		return "Series [idSeries=" + idSeries + ", isbnSerie=" + isbnSerie + ", nomSerie=" + nomSerie + "]";
	}
	
	public int getIdSeries() {
		return idSeries;
	}
	public void setIdSeries(int idSeries) {
		this.idSeries = idSeries;
	}
	public String getIsbnSerie() {
		return isbnSerie;
	}
	public void setIsbnSerie(String isbnSerie) {
		this.isbnSerie = isbnSerie;
	}
	public String getNomSerie() {
		return nomSerie;
	}
	public void setNomSerie(String nomSerie) {
		this.nomSerie = nomSerie;
	}
	
	
}
