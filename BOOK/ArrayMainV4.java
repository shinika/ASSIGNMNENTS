package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;

public class ArrayMainV4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookUtil bookUtil = new BookUtil(100);
		Book books[] = null;
		Book book;
		int bookId;
		String name;
		double price;
		int bookChoice;
		boolean result;
		int numberOfBooks;
		String continueChoice;

		do {
			books = bookUtil.getAllBooks();
			for (Book bookTemp : books) {
				if (bookTemp != null) {
					System.out.println(bookTemp.getBookId() + "\t" + bookTemp.getName() + "\t" + bookTemp.getPrice());
				}
			}
			System.out.println("Menu");
			System.out.println("1. Add Single Book	");
			System.out.println("2. Add Multiple Books");
			System.out.println("3. Update Existing Book");
			System.out.println("4. Delete Existing Book");
			System.out.println("5. Print Single Book Details");
			System.out.println("6. Exit");

			System.out.println("Enter your choice");
			bookChoice = scanner.nextInt();
			switch (bookChoice) {
			case 1:
				System.out.println("Enter BookId");
				bookId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Book Name");
				name = scanner.nextLine();
				System.out.println("Book Price");
				price = scanner.nextDouble();

				book = new Book(bookId, name, price);
				result = bookUtil.addNewBook(book);
				if (result)
					System.out.println("Book is added successfully !!");
				else
					System.out.println("Fail to add book");
				break;
			case 2:
				System.out.println("How many books do you want to add ?");
				numberOfBooks = scanner.nextInt();
				if (numberOfBooks < (bookUtil.getMaxIndex() - bookUtil.getNextIndex())) {
					books = new Book[numberOfBooks];
					for (int i = 0; i < numberOfBooks; i++) {
						System.out.println("Enter BookId");
						bookId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Book Name");
						name = scanner.nextLine();
						System.out.println("Book Price");
						price = scanner.nextDouble();

						book = new Book(bookId, name, price);
						books[i] = book;
					}
					bookUtil.addAllBooks(books);
					System.out.println("Books are added !!");
				} else
					System.out.println("No space available !!");
				break;
			case 3:
				System.out.println("Enter BookId");
				bookId = scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {
					System.out.println(book);
					System.out.println("Book New Name");
					name = scanner.nextLine();
					System.out.println("Book New Price");
					price = scanner.nextDouble();

					result = bookUtil.updateBook(bookId, name, price);
					if (result)
						System.out.println("Book details are updated successfully !!");
					else
						System.out.println("Failed to update book details");
				} else
					System.out.println("No Book Found !!");
				break;

			case 4:
				System.out.println("Enter BookId");
				bookId = scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {
					result = bookUtil.deleteBook(bookId);
					if (result)
						System.out.println("Book deleted successfully ");
					else
						System.out.println("Failed to delete book");
				} else
					System.out.println("No Book Found !!");
				break;
			case 5:
				System.out.println("Enter BookId");
				bookId = scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {
					System.out.println(book);
				} else
					System.out.println("No Book Found !!");
				break;
			case 6:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue yes- no ??");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));
		System.out.println("Thank you");
	}
}