package assign1.mon;

public class Book {

	
		private int BOOK_NO;
		private String BOOKTITLE;
		private double PRICE;
		
		
			
			public int getBookno() {
			return BOOK_NO;
		}



		public void setBookno(int BOOK_NO) {
			this.BOOK_NO = BOOK_NO;
		}



		public String getBooktitle() {
			return BOOKTITLE;
		}



		public void setBooktitle(String BOOKTITLE) {
			this.BOOKTITLE = BOOKTITLE;
		}



		public double getPrice() {
			return PRICE;
		}



		public void setPrice(double PRICE) {
			this.PRICE = PRICE;
		}
		
		
		
		public boolean PURCHASE(int N){
			if( N > 0) {
				PRICE = N * PRICE;
				return true;
			}
			else {return false;}
			
		}
		
		private boolean TOTAL_COST(double N){
			if( N > 0) {
				PRICE = PRICE * N;
				
				return true;
			}
			else {return false;}
			
		}


		

}
