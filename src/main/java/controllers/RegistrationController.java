package controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.voting.registre.RegistreApplication;

import domain.User;
import domain.UserAccount;
import services.RegistrationService;

@ComponentScan({"controllers", "domain","repositories","services"})
@Controller
public class RegistrationController {
	
	private static final Logger log = LoggerFactory.getLogger(RegistreApplication.class);

	
	@Autowired
	private RegistrationService registrationService;
	
	public RegistrationController() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	@RequestMapping("/registration")
    public String registration() {
        return "registration";
    }
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
    public String save(@ModelAttribute("userForm") User user) {
		
		log.info("registering---------------------");
		
		User aux = null;
		UserAccount temp = null;
		
		temp.setUsername(user.getEmail());
		//temp.setPassword(user.ge);
		aux.setName(user.getName());
		aux.setAdress(user.getAdress());
		aux.setEmail(user.getEmail());
		aux.setPhone(user.getPhone());
		aux.setSurname(user.getSurname());
		aux.setUserAccount(temp);
		
		registrationService.create(user);
		
        return "registration";
    }
}