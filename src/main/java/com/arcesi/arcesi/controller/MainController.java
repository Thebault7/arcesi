//package com.arcesi.arcesi.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.arcesi.arcesi.form.PersonForm;
//import com.arcesi.arcesi.model.Person;
//import com.arcesi.arcesi.repository.IPersonRepository;
// 
//@Controller
//public class MainController {
//	
//	@Autowired
//	private IPersonRepository ipr;
// 
//    private static List<Person> persons = new ArrayList<Person>();
// 
//    // Injectez (inject) via application.properties.
//    @Value("${welcome.message}")
//    private String message;
// 
//    @Value("${error.message}")
//    private String errorMessage;
// 
//    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//    public String index(Model model) {
//    	
//		  ipr.saveAndFlush(new Person("Bill", "Gates"));
//		  ipr.saveAndFlush(new Person("Steve", "Jobs"));
//        ipr.saveAndFlush(new Person("Fred", "Thébault"));
// 
//        model.addAttribute("message", message);
// 
//        return "index";
//    }
// 
//    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
//    public String personList(Model model) {
// 
//    	persons = ipr.findAll();
//    	System.out.println(persons.get(0).toString());
//        model.addAttribute("persons", persons);
// 
//        return "personList";
//    }
// 
//    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
//    public String showAddPersonPage(Model model) {
// 
//        PersonForm personForm = new PersonForm();
//        model.addAttribute("personForm", personForm);
// 
//        return "addPerson";
//    }
// 
//    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
//    public String savePerson(Model model, //
//            @ModelAttribute("personForm") PersonForm personForm) {
// 
//        String firstName = personForm.getFirstName();
//        String lastName = personForm.getLastName();
// 
//        if (firstName != null && firstName.length() > 0 //
//                && lastName != null && lastName.length() > 0) {
//            Person newPerson = new Person(firstName, lastName);
//            persons.add(newPerson);
// 
//            return "redirect:/personList";
//        }
// 
//        model.addAttribute("errorMessage", errorMessage);
//        return "addPerson";
//    }
// 
//}