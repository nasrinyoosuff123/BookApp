package com.wisdom.bookApp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private BookshopService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Book> listBooks = service.listAll();
		model.addAttribute("listBooks", listBooks);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewBook(Model model) {
		Book book = new Book();
		model.addAttribute("book",book);
		return "new_book";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("book") Book book){
		service.save(book);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditBook (@PathVariable(name="id") int id) {
		ModelAndView mv = new ModelAndView("edit_book");
		Book book = service.get(id);
		mv.addObject("book",book);
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
}
