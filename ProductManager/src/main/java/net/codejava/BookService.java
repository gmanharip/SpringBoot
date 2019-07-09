package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.BookRepository;

@Service
@Transactional
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	 public List<Book> getBooks() {
	  /*List countries=new ArrayList();
	  Iterable countriesIterable=bookRepository.findAll();
	  Iterator countriesIterator=countriesIterable.iterator();
	  while(countriesIterator.hasNext())
	  {
	   countries.add(countriesIterator.next());
	  }
	  return countries;*/
		 return bookRepository.findAll();
	 }
	 
	 @Transactional
	 public Book addBook(Book book) {
		 return bookRepository.save(book);
	 }
	 
	 @Transactional
	 public void updateCountry(Book book) {
		 bookRepository.save(book);
	 
	 }
	 
	 @Transactional
	 public void deleteBook(long id) {
		 bookRepository.deleteById(id);//.delete(id);
	 }
}
