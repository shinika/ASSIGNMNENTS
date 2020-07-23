package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {
	private Book books[];
	private int nextIndex = 0;
	private int maxIndex;

	public BookUtil(int maxBookLenght) {
		books = new Book[maxBookLenght];
		maxIndex = maxBookLenght;
	}

	public int getNextIndex() {
		return nextIndex;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public boolean addNewBook(Book book) {
		if (nextIndex >= 0 && nextIndex < maxIndex) {
			books[nextIndex] = book;
			nextIndex++;
			return true;
		}
		return false;
	}

	public boolean addAllBooks(Book books[]) {
		for (Book book : books) {
			addNewBook(book);
		}
		return true;
	}

	public boolean updateBook(int bookId, String newName, double newPrice) {
		for (Book book : books) {
			if (book.getBookId() == bookId) {
				book.setName(newName);
				book.setPrice(newPrice);
				return true;
			}
		}
		return false;
	}

	public boolean deleteBook(int bookId) {
		for (int i = 0; i < books.length; i++) {
			if (books[i].getBookId() == bookId) {
				books[i] = null;
				return true;
			}
		}
		return false;
	}

	public Book getBookByBookId(int bookId) {
		for (Book book : books) {
			if (book != null) {
				if (book.getBookId() == bookId)
					return book;
			}

		}
		return null;

	}

	public Book[] getAllBooks() {
		return books;
	}

}
