package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;


@Controller
@RequestMapping("/employee-module")
public class EmployeeController 
{
	@Autowired
	EmployeeManager manager;
	
	
	@Autowired
	BookService service;
	
	@Autowired
	SubjectService subService;
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("book", new Book());
		return "book";
	}*/

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Model model)
	{
		model.addAttribute("employees", manager.getAllEmployees());
		return "employeesListDisplay";
	}
	
	/*@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	public List<Book> getBooks()
	{
		//List listOfCountries = countryService.getAllCountries();
		
		//List<Book> vv = bkmanager.getBooks();
		//for(Book bb: vv){
			//System.out.println(bb.getTitle());
		//}
		//return bkmanager.getBooks();
		return service.getAllCountries();
	}*/
	
	@RequestMapping(value = "/frame1", method = RequestMethod.GET)
	public String frame1(Model model)
	{
		//model.addAttribute("employees", manager.getAllEmployees());
		return "navg2";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String BookMeth(Model model)
	{
		
		List<Book> vv = service.getBooks();//bkmanager.getBooks();
		System.out.println("vv::"+vv.size());
		String json = new Gson().toJson(vv);
		model.addAttribute("bookForm", new Book());
		model.addAttribute("book", json);
		
		//model.addAttribute("bookId", book.getBookId());
		//model.addAttribute("title", book.getTitle());
		return "book";
	}
	
	@RequestMapping(value = "/bookAdd", method = RequestMethod.POST)
	public String AddBookMeth(@ModelAttribute("book")Book book, 
		      BindingResult result, ModelMap model)
	{
		//if (result.hasErrors()) {
	      //  return "error";
	    //}
		System.out.println(book.getPrice());
		model.addAttribute("bookForm", new Book());
		service.addBook(book);
		List<Book> vv = service.getBooks();
		String json = new Gson().toJson(vv);
		model.addAttribute("bookForm", new Book());
		model.addAttribute("book", json);
		return "book";
	}
	
	@RequestMapping(value = "/bookDelete")
	public String DeleteBookMeth(@RequestParam("id") String aa, ModelMap model)
	{
		System.out.println("inside book::"+aa);
		//model.addAttribute("bookForm", new Book());
		
		service.deleteBook(Long.valueOf(aa));
		List<Book> vv = service.getBooks();
		String json = new Gson().toJson(vv);
		model.addAttribute("bookForm", new Book());
		model.addAttribute("book", json);
		return "book";
	}
	
	
	@RequestMapping(value = "/subject", method = RequestMethod.GET)
	public String SubjectMeth(Model model)
	{
		List<Subject> vv = subService.getSubjects();
		String json = new Gson().toJson(vv);
		model.addAttribute("subjectForm", new Subject());
		model.addAttribute("subject", json);
		return "subject";
	}
	
	@RequestMapping(value = "/subjectAdd", method = RequestMethod.POST)
	public String AddSubjectMeth(@ModelAttribute("subject")Subject subject, 
		      BindingResult result, ModelMap model)
	{
		//if (result.hasErrors()) {
	      //  return "error";
	    //}
		model.addAttribute("subjectForm", new Subject());
		subService.addSubject(subject);
		List<Subject> vv = subService.getSubjects();
		String json = new Gson().toJson(vv);
		model.addAttribute("subjectForm", new Subject());
		model.addAttribute("subject", json);
		return "subject";
	}
	
	@RequestMapping(value = "/subjectDelete")
	public String DeleteSubjectMeth(@RequestParam("subid") String aa, ModelMap model)
	{
		System.out.println("inside book "+aa);
		//model.addAttribute("bookForm", new Book());
		subService.deleteSubject(Long.valueOf(aa));
		List<Subject> vv = subService.getSubjects();
		String json = new Gson().toJson(vv);
		model.addAttribute("subjectForm", new Book());
		model.addAttribute("subject", json);
		return "subject";
	}
}