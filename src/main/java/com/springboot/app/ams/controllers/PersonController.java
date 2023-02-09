package com.springboot.app.ams.controllers;
import java.util.ArrayList ;
import java.util.List;
import com.springboot.app.ams.entites.person;
import com.springboot.app.ams.forms.PersonForm;
import com.springboot.app.ams.forms.PersonFormUpdate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PersonController {
  private static List<person> persons = new ArrayList<person>() ;
  static {
	  persons.add(new person("Ala","Foudhaili"));
	  persons.add(new person("Raed","Belabyedh"));
  }
  @Value("${welcome.message}")
  private String message ;
  @Value("${error.message}")
  private String errorMessage ;
  
  @RequestMapping(value = {"/index", "/person"}, method=RequestMethod.GET)
  public String index(Model model) {
	  model.addAttribute("persons", persons);
	  return "pages/person/index";
  }
  @RequestMapping(value = {"/personList"} , method=RequestMethod.GET)
  public String personList(Model model) {
	  model.addAttribute("persons",persons);
	  return "pages/person/personList";
  }
  @RequestMapping(value = {"/addPerson"}, method=RequestMethod.GET)
  public String ShowaddPersonPage(Model model) {
	  PersonForm personForm = new PersonForm();
	  model.addAttribute("personForm", personForm);
	  return "pages/person/addPerson";
  }
  @RequestMapping(value = {"/updatePerson"}, method=RequestMethod.GET)
  public String ShowUpadatePersonPage(Model model) {
	  
	  PersonFormUpdate personFormUpdate = new PersonFormUpdate();
	  model.addAttribute("personFormUpdate", personFormUpdate);
	  return "pages/person/updatePerson";
  }
  
  @RequestMapping(value ={"/updatePerson"}, method=RequestMethod.PUT)
  public String UpdatePerson(Model model  ,  @ModelAttribute("personFormUpdate") PersonFormUpdate personFormUpdate) {
	  String firstName = personFormUpdate.getFirstName();
	  String lastName = personFormUpdate.getLastName();
	  System.out.println(firstName);
	  if (firstName != null && firstName.length()>0 && lastName != null && lastName.length()>0) {
		  person newPersonUpdate = new person(firstName ,lastName);
		  persons.add(newPersonUpdate);
		  return "redirect:/personList";
	  }
	  model.addAttribute("errorMessage",errorMessage);
	  return "pages/person/addPerson";
  }


  
  @RequestMapping(value ={"/addPerson"}, method=RequestMethod.POST)
  public String savePerson(Model model  ,  @ModelAttribute("personForm") PersonForm personForm) {
	  String firstName = personForm.getFirstName();
	  String lastName = personForm.getLastName();
	  System.out.println(firstName);
	  if (firstName != null && firstName.length()>0 && lastName != null && lastName.length()>0) {
		  person newPerson = new person(firstName ,lastName);
		  persons.add(newPerson);
		  return "redirect:/personList";
	  }
	  model.addAttribute("errorMessage",errorMessage);
	  return "pages/person/addPerson";
  }
}
