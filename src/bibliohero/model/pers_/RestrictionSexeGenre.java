package bibliohero.model.pers_;

public class RestrictionSexeGenre {

		private int codeGenre;
		private int codeSexe;
		
		
		
		@Override
		public String toString() {
			return "RestrictionSexeGenre [codeGenre=" + codeGenre + ", codeSexe=" + codeSexe + "]";
		}
		
		public int getCodeGenre() {
			return codeGenre;
		}
		public void setCodeGenre(int codeGenre) {
			this.codeGenre = codeGenre;
		}
		public int getCodeSexe() {
			return codeSexe;
		}
		public void setCodeSexe(int codeSexe) {
			this.codeSexe = codeSexe;
		}
		
		
		
}
