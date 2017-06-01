package bibliohero.model.avt_;

public class Theme {

		private int idTheme;
		private String nomtheme;
		private String codetheme;
		
		
		@Override
		public String toString() {
			return "Theme [idTheme=" + idTheme + ", nomtheme=" + nomtheme + ", codetheme=" + codetheme + "]";
		}
		
		public int getIdTheme() {
			return idTheme;
		}
		public void setIdTheme(int idTheme) {
			this.idTheme = idTheme;
		}
		public String getNomtheme() {
			return nomtheme;
		}
		public void setNomtheme(String nomtheme) {
			this.nomtheme = nomtheme;
		}
		public String getCodetheme() {
			return codetheme;
		}
		public void setCodetheme(String codetheme) {
			this.codetheme = codetheme;
		}
		
		
}
