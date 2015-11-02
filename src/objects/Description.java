package objects;

public class Description {
		private int pNo;
		private long langCode;
		private String text;
		
		
		public Description (){
			pNo= 0;
			langCode = 0;
			text = "";
		}
		
		public Description (int numb, long code, String descr){
			pNo = numb;
			langCode = code;
			text = descr;
		}

		public int getpNo() {
			return pNo;
		}

		public void setpNo(int pNo) {
			this.pNo = pNo;
		}

		public long getLangCode() {
			return langCode;
		}

		public void setLangCode(long langCode) {
			this.langCode = langCode;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
}
