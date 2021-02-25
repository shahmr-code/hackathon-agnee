package com.db.hackathon.onlineBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.datastore.repository.config.EnableDatastoreRepositories;

@EnableDatastoreRepositories
@SpringBootApplication
public class OnlineBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingApplication.class, args);
	}
	/*
	 * @ShellMethod("Saves a Customer to Cloud Datastore: save-customer <firstName> <lastName> <age> <gender> <address>"
	 * ) public String saveBook(String title, String author, int year) {
	 * CustomerDetails savedBook = this.bookRepository.save(new Book(title, author,
	 * year)); return savedBook.toString(); }
	 * 
	 * @ShellMethod("Loads all customers") public String findAllBooks() {
	 * Iterable<Book> books = this.bookRepository.findAll(); List<Book> bookList =
	 * new ArrayList<>(); books.forEach(bookList::add); return books.toString(); }
	 * 
	 * @ShellMethod("Loads customers by name: find-by-name <fname>") public String
	 * findByAuthor(String author) { List<Book> books =
	 * this.bookRepository.findByAuthor(author); return books.toString(); }
	 * 
	 * @ShellMethod("Loads customers by age: find-by-age-greater-than <age>") public
	 * String findByYearGreaterThan(int year) { List<Book> books =
	 * this.bookRepository.findByYearGreaterThan(year); return books.toString(); }
	 * 
	 * @ShellMethod("Loads customers by disability and gender: find-by-disability-gender <disability> <gender>"
	 * ) public String findByAuthorYear(String author, int year) { List<Book> books
	 * = this.bookRepository.findByAuthorAndYear(author, year); return
	 * books.toString(); }
	 * 
	 * @ShellMethod("Removes all customers") public void removeAllBooks() {
	 * this.bookRepository.deleteAll(); }
	 */

}
