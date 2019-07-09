package net.codejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.SubjectRepository;

@Service("Subservice")
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	 @Transactional
	 public List getSubjects() {
	  List countries=new ArrayList();
	  Iterable countriesIterable=subjectRepository.findAll();
	  Iterator countriesIterator=countriesIterable.iterator();
	  while(countriesIterator.hasNext())
	  {
	   countries.add(countriesIterator.next());
	  }
	  return countries;
	 }
	 
	 @Transactional
	 public void addSubject(Subject sub) {
		 subjectRepository.save(sub);
	 }
	 
	 @Transactional
	 public void deleteSubject(long id) {
		 subjectRepository.deleteById(id);//delete(id);
	 }
	
	
}
