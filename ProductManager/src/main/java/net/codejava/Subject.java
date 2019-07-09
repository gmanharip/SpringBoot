package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	private long subject_id;
	private String subtitle;
    private int duration_in_hours;
    
    public Subject(){
    	
    }
    
    Subject(long subject_id, String subtitle, int duration_in_hours){
    	super();
    	this.subject_id = subject_id;
    	this.subtitle = subtitle;
    	this.duration_in_hours = duration_in_hours;
    }
    
	@Id
	@Column(name = "subject_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}

	public int getDuration_in_hours() {
		return duration_in_hours;
	}

	public void setDuration_in_hours(int duration_in_hours) {
		this.duration_in_hours = duration_in_hours;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	@Override
	public  String toString() {
		return "subject_id: "+subject_id+" subtitle: +"+subtitle+" duration_in_hours: "+duration_in_hours;
		
	}
}
