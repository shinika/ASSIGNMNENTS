package assign.mon.main;

import assign1.mon.Book;
import java.util.Scanner;

public class Bookmain {

	public static void main(String[] args) {
		
				Book book = new Book();
				Scanner scanner = new Scanner(System.in);
				int N;
				
				
				
				book.setBookno(12);
				book.getBookno();
				
				book.setBooktitle("shin");
				book.getBooktitle();
				
				book.setPrice(10);
				book.getPrice();
				
				
				
				System.out.println(" bookno: "+book.getBookno());
				System.out.println("booktitle: "+book.getBooktitle());
				System.out.println("bookprice: "+book.getPrice());
				
				System.out.println("Enter number of copies: ");
				N= scanner.nextInt();
				
					
				
				if(book.PURCHASE(N)) {

					System.out.println("--------------");
				}
				else {System.out.println("-------------- ");}
				
				System.out.println("TOTAL PRICE: "+book.getPrice());
				
	}


}
