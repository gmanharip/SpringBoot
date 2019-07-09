package net.codejava;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import net.codejava.Book;
import net.codejava.BookRepository;
import net.codejava.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookService bookservice;
	
	@MockBean
	private BookRepository bookRepo;
	
	 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testgetBooks(){
		try {
		Book bk = new Book();
		bk.setBook_id(1);
		bk.setPrice(12);
		bk.setVolume(12);
		bk.setTitle("book1");
		String as= "1988-01-02";
		Date dt = new SimpleDateFormat("yyyy-mm-dd").parse(as);
		bk.setPublish_date(dt);
		List<Book> lsbk = new ArrayList<Book>();
		lsbk.add(bk);
		Mockito.when(bookRepo.findAll()).thenReturn(lsbk);
		Assertions.assertThat(bookservice.getBooks()).isEqualTo(lsbk);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaddBook(){
		try {
			Book bk = new Book();
			bk.setBook_id(1);
			bk.setPrice(12);
			bk.setVolume(12);
			bk.setTitle("book1");
			String as= "1988-01-02";
			Date dt = new SimpleDateFormat("yyyy-mm-dd").parse(as);
			bk.setPublish_date(dt);
			Mockito.when(bookRepo.save(bk)).thenReturn(bk);
			Assertions.assertThat(bookservice.addBook(bk)).isEqualTo(bk);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testupdateCountry(){
		try {
			Book bk = new Book();
			bk.setBook_id(1);
			bk.setPrice(12);
			bk.setVolume(12);
			bk.setTitle("book1");
			String as= "1988-01-02";
			Date dt = new SimpleDateFormat("yyyy-mm-dd").parse(as);
			bk.setPublish_date(dt);
			Mockito.when(bookRepo.save(bk)).thenReturn(bk);
			Assertions.assertThat(bookservice.addBook(bk)).isEqualTo(bk);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void testdeleteBook(){
		Book bk = new Book();
		bk.setBook_id(1);
		bk.setPrice(12);
		bk.setVolume(12);
		bk.setTitle("book1");
		String as= "1988-01-02";
		Date dt = new SimpleDateFormat("yyyy-mm-dd").parse(as);
		bk.setPublish_date(dt);
		Mockito.when(bookRepo.findOne(1)).thenReturn(ticket);
	    Mockito.when(bookRepo.exists(ticket.getTicketId())).thenReturn(false);
	    assertFalse(bookRepo.exists(ticket.getTicketId()));
	}*/

}