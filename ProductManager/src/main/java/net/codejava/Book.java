package net.codejava;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

	private long book_id;
	private String title;
	private double price;
	private int volume;
	private Date publish_date;
	
	public Book(){
		
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	@Override
	public  String toString() {
		return "book_id: "+book_id+" title: "+title+" price: "+price+" volume: "+volume+" publish_date: "+publish_date;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getBook_id() {
		return book_id;
	}

	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}



	public Date getPublish_date() {
		return publish_date;
	}



	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	
}